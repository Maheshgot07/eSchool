package com.registration.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.dao.CustomRepository;
import com.registration.dao.StudentDAO;

import common.datamodel.SearchStudent;
import common.datamodel.StudentDO;
import common.datamodel.util.StringUtil;

@Service
public class StudentService {

	@Autowired
	StudentDAO dao;
	@Autowired
	CustomRepository customRepository;
	public StudentDO saveStudent(StudentDO student) {
		System.out.println(student);
		return dao.save(student);
	}
	
	public List<StudentDO> findAllStudents(){
		return (List<StudentDO>) dao.findAll();
	}

	public StudentDO findStudent(long id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	public List<StudentDO> searchStudents(SearchStudent searchStudent) {
		StringBuilder criteria = new StringBuilder("from StudentDO s ");
		boolean whereClause = false;
		List<StudentDO> sList = new ArrayList<StudentDO>();
		
		if(searchStudent != null) {

			if (!StringUtil.isBlankOrNull(searchStudent.getRollNum())) {
				if(!whereClause) {
					criteria.append(" where s.rollNum = '"+searchStudent.getRollNum()+"'");
					whereClause = true;
				}
			}

			if(!StringUtil.isBlankOrNull(searchStudent.getFirstName()) ) {
				if(!whereClause) {
					criteria.append(" where");
					whereClause = true;
				}else {
					criteria.append(" and");
				}
				criteria.append(" s.firstName like '"+searchStudent.getFirstName()+"%'");
			}
			if(!StringUtil.isBlankOrNull(searchStudent.getLastName()) ) {
				if(!whereClause) {
					criteria.append(" where");
					whereClause = true;
				}else {
					criteria.append(" and");
				}
				criteria.append(" s.lastName like '"+searchStudent.getLastName()+"%'");
			}
			if(!StringUtil.isBlankOrNull(searchStudent.getStandard()) ) {
				if(!whereClause) {
					criteria.append(" where");
					whereClause = true;
				}else {
					criteria.append(" and");
				}
				criteria.append(" s.standard = '"+searchStudent.getStandard()+"'");
			}
			if(!StringUtil.isBlankOrNull(searchStudent.getAcademicYr()) ) {
				if(!whereClause) {
					criteria.append(" where");
					whereClause = true;
				}else {
					criteria.append(" and");
				}
				criteria.append(" s.academicYr = '"+searchStudent.getAcademicYr()+"'");
			}
			if(!StringUtil.isBlankOrNull(searchStudent.getDivision()) ) {
				if(!whereClause) {
					criteria.append(" where");
					whereClause = true;
				}else {
					criteria.append(" and");
				}
				criteria.append(" s.division = '"+searchStudent.getDivision()+"'");
			}
			
			System.out.println("Criteria query is- "+criteria);
			sList = customRepository.searchQuery(criteria.toString());
		}
		return sList;
	}
}
