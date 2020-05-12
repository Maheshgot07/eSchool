package com.registration.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import common.datamodel.StudentDO;
@Repository
public interface StudentDAO extends CrudRepository<StudentDO, Long> {
	public List<StudentDO> findByRollNum(String rollNum);
	
	public List<StudentDO> findByFirstNameOrLastNameOrderByRollNum(String firstName,String lastName);
	public List<StudentDO> findByStandardAndAcademicYrAndDivisionOrderByRollNum(String standard,String academicYr,String division);
	public List<StudentDO> findByStandardAndAcademicYrOrderByRollNum(String standard,String academicYr);
}
