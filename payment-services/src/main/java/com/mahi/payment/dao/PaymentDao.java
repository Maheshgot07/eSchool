package com.mahi.payment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import common.datamodel.StudentPayment;

public interface PaymentDao extends CrudRepository<StudentPayment, Long> {
	
	public StudentPayment findByStudentPaidId(long studentId);
	public List<StudentPayment>findByStudentPaidIdAndAcademicYr(long studentId,String academicYr);
}
