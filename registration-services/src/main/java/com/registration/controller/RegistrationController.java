package com.registration.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.registration.services.StudentService;

import common.datamodel.SearchStudent;
import common.datamodel.StudentDO;


@RestController
public class RegistrationController {
	
	  @Autowired StudentService studentService;
	 
	@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	public StudentDO saveStudent(@RequestBody StudentDO student) {
		System.out.println(student.getFirstName());
		return studentService.saveStudent(student);
	}
	
	@RequestMapping(value = "/students",method = RequestMethod.GET)
	@ResponseBody
	public List<StudentDO> getAllStudents() {
		return studentService.findAllStudents();
	}
	@RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
	public ResponseEntity<StudentDO> getStudent(@PathVariable("id")long id) {
		StudentDO student = studentService.findStudent(id);
		return  new ResponseEntity<StudentDO>(student,HttpStatus.OK);
	}
	public String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	
	@RequestMapping(value = "/student/search",method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<StudentDO>> searchStudents(@RequestBody SearchStudent searchStudent) {
		List<StudentDO> studentList =studentService.searchStudents(searchStudent);
		return new ResponseEntity<List<StudentDO>>(studentList,HttpStatus.OK);
	}
}
