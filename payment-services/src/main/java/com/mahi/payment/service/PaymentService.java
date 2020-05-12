package com.mahi.payment.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.payment.dao.CustomPaymentRepository;
import com.mahi.payment.dao.FeeStructureDao;
import com.mahi.payment.dao.PaymentDao;

import common.datamodel.FeeItem;
import common.datamodel.FeeStructure;
import common.datamodel.Payment_item;
import common.datamodel.StudentPayment;

@Service
public class PaymentService {
	@Autowired
	FeeStructureDao feeStructureDao;
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	CustomPaymentRepository customPaymentRepository;
	public FeeStructure getFeeStructure(long id) {
		return feeStructureDao.findById(id).get();
	}
	public FeeStructure createFeeStructure(FeeStructure feeStructure) {
		// TODO Auto-generated method stub
		if(feeStructure.getFeeItems() != null) {
			for(FeeItem feeitem: feeStructure.getFeeItems() ) {
				feeitem.setFeeStructure(feeStructure);
			}

		}
		return feeStructureDao.save(feeStructure);
	}

	public List<FeeStructure> getFeeStructureForStudent(String academicYr, String standard) {
		return feeStructureDao.findByAcademicYrAndStandard(academicYr, standard);
	}

	public StudentPayment savePayment(StudentPayment studentPayment) {
		studentPayment = paymentCalculation(studentPayment);
		return paymentDao.save(studentPayment);
	}
	private StudentPayment paymentCalculation(StudentPayment studentPayment) {
		double tot_amt = 0.0d,tot_paid_amt =0.0d ,tot_pending_amt = 0.0d,net_payable =0.0d,item_pending_amt=0.0d;
		long millis= System.currentTimeMillis();
		Date today = new Date(millis);
		for(Payment_item item :studentPayment.getPayment_item()) {
			double afterDiscount =0.0;
			if(item.getDiscount()>0) {
				afterDiscount = item.getAmount() -(item.getAmount() * item.getDiscount()*0.01);
				item.setNet_payable(afterDiscount);
			}else {
				item.setNet_payable(item.getAmount());
			}
			tot_amt += item.getAmount();
			tot_paid_amt += item.getAmt_paid();
			net_payable +=item.getNet_payable();
			item_pending_amt = item.getNet_payable() - item.getAmt_paid();
			item.setPending_amt(item_pending_amt);
			item.setStudentPayment(studentPayment);
			item.setPayment_date(today);
		}
		tot_pending_amt = net_payable -tot_paid_amt;
		studentPayment.setTot_pending_amt(tot_pending_amt);
		studentPayment.setTot_amt(tot_amt);
		studentPayment.setNetPayableAmt(net_payable);
		studentPayment.setTot_paid_amt(tot_paid_amt);
		studentPayment.setLastPayment_dt(today);
		return studentPayment;
	}
	
	public StudentPayment getCalculatedStudentPayment(StudentPayment studentPayment) {
		studentPayment = paymentCalculation(studentPayment);
		return studentPayment;
	}
	
	public List<StudentPayment> getStudentPaymentByStudentId(long studentId,String academicYr) {
		return paymentDao.findByStudentPaidIdAndAcademicYr(studentId,academicYr);
	}
	public List<StudentPayment> getStudentPaymentByStudentIdList(List<Long> studentIdList) {
		String hql = "from StudentPayment where studentPaidId in (:studentIdList)";
		//customPaymentRepository.searchPaymentQuery(hql,studentIdList);
		return customPaymentRepository.searchPaymentQuery(hql,studentIdList);
	}
}
