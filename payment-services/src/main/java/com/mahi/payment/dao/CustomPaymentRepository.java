package com.mahi.payment.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import common.datamodel.StudentPayment;

@Repository
public class CustomPaymentRepository {
	@PersistenceContext
	EntityManager entityManager;
	public List<StudentPayment> searchPaymentQuery(String query, List<Long> studentIdList) {
		Query queryObj = entityManager.createQuery(query);
		queryObj.setParameter("studentIdList", studentIdList);
		List<StudentPayment> studentPaymentList =queryObj.getResultList();
		return studentPaymentList;
	}
}