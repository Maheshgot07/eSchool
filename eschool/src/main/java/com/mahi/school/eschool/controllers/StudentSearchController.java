package com.mahi.school.eschool.controllers;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.school.eschool.service.RegistrationService;

import common.datamodel.SearchStudent;
import common.datamodel.SearchWrapper;
import common.datamodel.StudentDO;

@RestController
public class StudentSearchController {
	@Autowired
	RegistrationService registrationService;

	@RequestMapping(value = "initSearch.html", method = RequestMethod.GET)
	public ModelAndView searchStudentInit(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) {

		// SearchStudent searchStudent = new SearchStudent();
		// searchWrapper.setSearchStudent(searchStudent);

		ModelAndView mav = new ModelAndView("searchStudent");
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}

	@RequestMapping(value = "executeSearch.html", method = RequestMethod.POST)
	public ModelAndView searchStudentExecute(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) throws URISyntaxException {
		 SearchStudent searchStudent = new SearchStudent();
		 searchStudent = searchWrapper.getSearchStudent();
		List<StudentDO> studentList = registrationService.searchStudent(searchStudent);
		ModelAndView mav = new ModelAndView("searchStudent");
		searchWrapper.setStudentsList(studentList);
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}
}
