package com.registration.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import common.datamodel.StudentDO;

@Repository
public class CustomRepository {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<StudentDO> searchQuery(String query) {
		List<StudentDO> studentList =entityManager.createQuery(query).getResultList();
		return studentList;
	}
}
