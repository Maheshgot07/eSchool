package com.mahi.payment.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import common.datamodel.FeeStructure;
@Repository
public interface FeeStructureDao extends CrudRepository<FeeStructure, Long> {

	public List<FeeStructure> findByAcademicYrAndStandard(String academicYr,String standard);
}
