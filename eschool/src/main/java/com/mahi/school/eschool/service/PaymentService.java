package com.mahi.school.eschool.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import common.datamodel.CompositeStudentPayment;
import common.datamodel.FeeItem;
import common.datamodel.FeeStructure;
import common.datamodel.Payment_item;
import common.datamodel.StudentDO;
import common.datamodel.StudentPayment;
import common.datamodel.responseWrapper.RequestObejectList;
import common.datamodel.responseWrapper.StudentPaymentList;

@Service
public class PaymentService {

	public FeeStructure createFeeStructure(FeeStructure feeStructure) {
		final String uri = "http://localhost:8082/payment/feeStucture";
		RestTemplate restTemplate = new RestTemplate();
		try {
			feeStructure = restTemplate.postForObject(uri, feeStructure, FeeStructure.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		
		return feeStructure;
	}
	
	public FeeStructure getFreeStructureForStudent(StudentDO student) {
		final String uri = "http://localhost:8082/payment/feeStucture/"+student.getAcademicYr()+"/"+student.getStandard();
		RestTemplate restTemplate = new RestTemplate();
		FeeStructure feeStructure = new FeeStructure();
		System.out.println("sending request "+uri);
		try {
			feeStructure = restTemplate.getForObject(uri, FeeStructure.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		System.out.println("Response Received "+feeStructure.getFeeItems().size());
		return feeStructure;
	}

	public StudentPayment generatePaymentItems(StudentDO student) {
		boolean isIncluded = false;
		StudentPayment studentPayment = new StudentPayment();
		FeeStructure feeStructure = getFreeStructureForStudent(student);
		List<StudentPayment> existingPayments = getStudentPayment(student.getId(),student.getAcademicYr());
		List<Payment_item> paymentItems = new ArrayList<Payment_item>();
		List<Payment_item> paymentHistoryList =new ArrayList<Payment_item>();
		/*
		 * double hist_tot_payment = 0.0d; double hist_tot_netPayable = 0.0d; double
		 * hist_tot_paidAmt = 0.0d;
		 */
		
		Map<Long, Payment_item> historyMap = new HashMap<Long, Payment_item>();
		for(StudentPayment existingPayment:existingPayments) {
			for(Payment_item historyItem : existingPayment.getPayment_item()) {
				Payment_item existingItem;
				if((existingItem=historyMap.putIfAbsent(historyItem.getFeeItemid(), historyItem))!=null) {
					existingItem.setAmt_paid(existingItem.getAmt_paid()+historyItem.getAmt_paid());
					//existingItem.setNet_payable(existingItem.getNet_payable()+historyItem.getNet_payable());
				}
				
				/*
				 * hist_tot_payment += historyItem.getAmount(); hist_tot_netPayable +=
				 * historyItem.getNet_payable(); hist_tot_paidAmt += historyItem.getAmt_paid();
				 */
				  paymentHistoryList.add(historyItem);
				 
			}
		}
		
		if(feeStructure != null && feeStructure.getFeeItems() != null && !feeStructure.getFeeItems().isEmpty()) {
			for(FeeItem feeItem :feeStructure.getFeeItems()) {
						if(historyMap.containsKey(Long.valueOf(feeItem.getFeeItemId()))) {
							Payment_item exItem = historyMap.get(Long.valueOf(feeItem.getFeeItemId()));
							//paymentHistoryList.add(exItem);
							isIncluded =true;
							if(exItem.getAmt_paid()<exItem.getNet_payable()) {
								Payment_item pendgingItem = new Payment_item();
								pendgingItem.setAmount(exItem.getNet_payable()-exItem.getAmt_paid());
								pendgingItem.setAmt_paid(0.0d);
								pendgingItem.setDiscount(0.0d);
								pendgingItem.setNet_payable(exItem.getNet_payable()-exItem.getAmt_paid());
								pendgingItem.setPayment_desc(exItem.getPayment_desc());
								pendgingItem.setFeeItemid(exItem.getFeeItemid());
								paymentItems.add(pendgingItem);
							}
							continue;
						}
				if(!isIncluded) {
					double netPayable ;
					double tot_amt = feeItem.getTotAmt();
					Payment_item paymentItem = new Payment_item();
					paymentItem.setAmount(tot_amt);
					paymentItem.setPayment_desc(feeItem.getItemName());
					paymentItem.setDiscount(feeItem.getDiscount());
					paymentItem.setFeeItemid(feeItem.getFeeItemId());
					netPayable = tot_amt - (tot_amt*feeItem.getDiscount()*0.01);
					paymentItem.setNet_payable(netPayable);
					paymentItems.add(paymentItem);
				}
			}
		}
		
		studentPayment.setPayment_item(paymentItems);
		studentPayment.setPaymentHistoryList(paymentHistoryList);
		return studentPayment;
	}

	public StudentPayment savePayment(StudentPayment studentPayment) {
		final String uri = "http://localhost:8082/payment/studentPayment";
		RestTemplate restTemplate = new RestTemplate();
		try {
			studentPayment = restTemplate.postForObject(uri, studentPayment, StudentPayment.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		return studentPayment;
	}
	
	public StudentPayment calculatePayment(StudentPayment studentPayment) {
		final String uri = "http://localhost:8082/payment/calculatedPayment";
		RestTemplate restTemplate = new RestTemplate();
		try {
			studentPayment = restTemplate.postForObject(uri, studentPayment, StudentPayment.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		return studentPayment;
	}
	
	public List<StudentPayment> getStudentPayment(long studentId,String academicYr) {
		final String uri = "http://localhost:8082/payment/studentPayment/"+studentId+"/"+academicYr;
		RestTemplate restTemplate = new RestTemplate();
		StudentPaymentList studentPaymentList;
		try {
			studentPaymentList = restTemplate.getForObject(uri, StudentPaymentList.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		return studentPaymentList.getStudentPaymentList();
	}
	
	public StudentPayment clubStudentPayment( List<StudentPayment> paymentList) {
		StudentPayment studentPayment =new StudentPayment();
		Map<Long,Payment_item> localPaymentMap = new LinkedHashMap<Long,Payment_item>();
		List<Payment_item> localPaymentList = new ArrayList<Payment_item>();
		for(StudentPayment payment: paymentList) {
			boolean isPendingItem = false;
			studentPayment.setAcademicYr(payment.getAcademicYr());
			studentPayment.setDiscount(payment.getDiscount());
			
			//localPaymentList.addAll(payment.getPayment_item());
			
			if(payment.getPayment_item() != null) {
				for(Payment_item item :payment.getPayment_item() ) {
					Payment_item localItem;
					if((localItem= localPaymentMap.putIfAbsent(item.getFeeItemid(), item)) != null) {
						localItem.setAmt_paid(item.getAmt_paid()+localItem.getAmt_paid());
						localItem.setPending_amt(localItem.getNet_payable()-localItem.getAmt_paid());
						isPendingItem =true;
					}
				}
			}
			if(isPendingItem) {
				studentPayment.setTot_paid_amt(studentPayment.getTot_paid_amt()+payment.getTot_paid_amt());
				studentPayment.setTot_pending_amt(studentPayment.getNetPayableAmt()-studentPayment.getTot_paid_amt());
			}
			else {
				studentPayment.setPrvs_bal(studentPayment.getPrvs_bal()+payment.getPrvs_bal());
				studentPayment.setTot_amt(studentPayment.getTot_amt()+payment.getTot_amt());
				studentPayment.setTot_paid_amt(studentPayment.getTot_paid_amt()+payment.getTot_paid_amt());
				studentPayment.setTot_pending_amt(studentPayment.getTot_pending_amt()+payment.getTot_pending_amt());
				studentPayment.setNetPayableAmt(studentPayment.getNetPayableAmt()+payment.getNetPayableAmt());
			}
			
		}
		localPaymentList.addAll(localPaymentMap.values());
		studentPayment.setPayment_item(localPaymentList);
		return studentPayment;
		
	}

	public List<StudentPayment> getStudentPaymentByStudentList(List<Long> studentIdList) {
		final String uri = "http://localhost:8082/payment/studentPaymentList";
		RestTemplate restTemplate = new RestTemplate();
		RequestObejectList requstObj = new RequestObejectList();
		requstObj.setLongList(studentIdList);
		StudentPaymentList studentPaymentList;
		try {
			studentPaymentList = restTemplate.postForObject(uri,requstObj, StudentPaymentList.class);
		}catch (ResourceAccessException e) {
			throw new ResourceAccessException("Payment Service");
		}
		return studentPaymentList.getStudentPaymentList();
	}

	public List<CompositeStudentPayment> getExportablePaymentDeatils(List<StudentDO> studentList, List<StudentPayment> paymentsList) {
		List<CompositeStudentPayment> compositeList = new ArrayList<CompositeStudentPayment>();
		Map<Long, StudentDO> stMap = new HashMap<Long, StudentDO>();
		Map<Long, StudentPayment> payMap = new HashMap<Long, StudentPayment>();
		for(StudentDO student :studentList) {
			stMap.put(student.getId(),student);
		}
		
		if(null != paymentsList)
		for(StudentPayment payment:paymentsList) {
			
			StudentPayment existingPay = payMap.putIfAbsent(payment.getStudentPaidId(), payment);
			if(existingPay != null) {
				StudentPayment clubbed;
				List<StudentPayment> tempList = new ArrayList<StudentPayment>();
				tempList.add(existingPay);
				tempList.add(payment);
				clubbed = clubStudentPayment(tempList);
				payMap.put(payment.getStudentPaidId(), clubbed);
			}
		}
		
		for(Long stId:stMap.keySet()) {
			
			StudentDO localStudent = stMap.get(stId);
			StudentPayment localPay = payMap.get(stId);
			CompositeStudentPayment composite = new CompositeStudentPayment();
			composite.setStudentId(localStudent.getId());
			composite.setRollNum(localStudent.getRollNum());
			composite.setFullName(localStudent.getLastName()+" "+localStudent.getFirstName()+" "+localStudent.getMiddleName());
			composite.setStandard(localStudent.getStandard());
			composite.setAcademicYr(localStudent.getAcademicYr());
			composite.setDivision(localStudent.getDivision());
			if(localPay != null) {
				composite.setTot_amt(localPay.getTot_amt());
				composite.setTot_paid_amt(localPay.getTot_paid_amt());
				composite.setTot_pending_amt(localPay.getTot_pending_amt());
				composite.setPayment_item(localPay.getPayment_item());
			}
			
			compositeList.add(composite);
		}
		return compositeList;
	}
}
