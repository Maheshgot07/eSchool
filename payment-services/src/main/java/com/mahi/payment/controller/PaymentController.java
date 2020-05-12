package com.mahi.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.payment.service.PaymentService;

import common.datamodel.StudentPayment;
import common.datamodel.responseWrapper.RequestObejectList;
import common.datamodel.responseWrapper.StudentPaymentList;

@RestController
public class PaymentController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping(value = "studentPayment",method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StudentPayment> savePayment(@RequestBody StudentPayment studentPayment) {
		studentPayment = paymentService.savePayment(studentPayment);
		System.out.println("Calculation done");
		System.out.println("Student Saved");
		return new ResponseEntity<StudentPayment>(studentPayment,HttpStatus.OK);
	}
	
	@RequestMapping(value = "calculatedPayment",method= RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<StudentPayment> getCalculatedStudentPayment(@RequestBody StudentPayment studentPayment) {
		studentPayment = paymentService.getCalculatedStudentPayment(studentPayment);
		return new ResponseEntity<StudentPayment>(studentPayment,HttpStatus.OK);
	}
	
	@RequestMapping(value = "studentPayment/{studentId}/{academicYr}",method= RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<StudentPaymentList> getStudentPayment(@PathVariable("studentId")long studentId,@PathVariable("academicYr") String academicYr) {
		List<StudentPayment> studentPayment = paymentService.getStudentPaymentByStudentId(studentId,academicYr);
		StudentPaymentList paymentList = new StudentPaymentList(); 
		paymentList.setStudentPaymentList(studentPayment);
		if(studentPayment == null) {
			return new ResponseEntity<StudentPaymentList>(paymentList,HttpStatus.OK);
		}
		return new ResponseEntity<StudentPaymentList>(paymentList,HttpStatus.OK);
	}
	
		@RequestMapping(value = "studentPaymentList",method= RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<StudentPaymentList> getStudentPaymentByStudentIdList(@RequestBody RequestObejectList reqObj) {
			List<Long> studentIdList =reqObj.getLongList();
			List<StudentPayment> studentPayment = paymentService.getStudentPaymentByStudentIdList(studentIdList);
			StudentPaymentList paymentList = new StudentPaymentList(); 
			paymentList.setStudentPaymentList(studentPayment);
			if(studentPayment == null) {
				return new ResponseEntity<StudentPaymentList>(paymentList,HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<StudentPaymentList>(paymentList,HttpStatus.OK);
		}
}
