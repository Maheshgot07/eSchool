package com.mahi.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.payment.service.PaymentService;

import common.datamodel.FeeStructure;

@RestController
public class PaymentConfigController {
	@Autowired
	PaymentService paymentService;
	
	@RequestMapping("/feeStucture/{id}")
	public ResponseEntity<FeeStructure> getFeeStructure(@PathVariable("id")long id) {
		FeeStructure feeStructure = paymentService.getFeeStructure(id);
		if (feeStructure == null)
			return new ResponseEntity<FeeStructure>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<FeeStructure>(feeStructure, HttpStatus.OK);
	}
	@RequestMapping(value ="/feeStucture",method = RequestMethod.POST)
	public ResponseEntity<FeeStructure> createFeeStructure(@RequestBody FeeStructure feeStructure ) {
		 feeStructure =paymentService.createFeeStructure(feeStructure);
		 return new ResponseEntity<FeeStructure>(feeStructure, HttpStatus.CREATED);
	}
	
	@RequestMapping("/feeStucture/{academicYr}/{standard}")
	public ResponseEntity<FeeStructure> getFeeStructureForStudent(@PathVariable("academicYr")String academicYr, @PathVariable("standard") String standard) {
		System.out.println(" getFeeStructureForStudent called");
		List<FeeStructure> feeStructureList = paymentService.getFeeStructureForStudent(academicYr,standard);
		System.out.println("Fee Structure list size "+feeStructureList.size());
		if (feeStructureList != null && !feeStructureList.isEmpty() )
			return new ResponseEntity<FeeStructure>(feeStructureList.get(0), HttpStatus.OK);
		return new ResponseEntity<FeeStructure>(HttpStatus.NOT_FOUND);
	}
	
}
