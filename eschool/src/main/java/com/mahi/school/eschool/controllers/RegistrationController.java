package com.mahi.school.eschool.controllers;

import java.security.Principal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.school.eschool.service.RegistrationService;

import common.datamodel.StudentDO;
import common.datamodel.StudentWrapper;
import common.datamodel.util.StringUtil;
@RestController
public class RegistrationController {
	@Autowired
	RegistrationService registrationService;
	

	@RequestMapping(value = "registerInit.html",method = RequestMethod.GET)
	public ModelAndView init(@ModelAttribute("studentWrapper") StudentWrapper wrapper) {
		ModelAndView mav = new ModelAndView("register");
		StudentDO student = new StudentDO();
		wrapper.setStudent(student);
		mav.addObject("studentWrapper",wrapper);
		return mav;
		
	}
@RequestMapping(value = "saveStudent.html",method = RequestMethod.POST)
	public ModelAndView saveStudent(MultipartFile file, @ModelAttribute("studentWrapper") StudentWrapper wrapper,Principal principal) {
		
		StudentDO student = wrapper.getStudent();
		if(!StringUtil.isBlankOrNull(wrapper.getDob()) && !StringUtil.isBlankOrNull(wrapper.getAdmsnDt())) {
			student.setDob(Date.valueOf(wrapper.getDob()));
			student.setAdmsnDt(Date.valueOf(wrapper.getAdmsnDt()));
		}
		student.setLastModifiedUser(principal.getName());
		student = registrationService.saveStudent(student,file);
		return new ModelAndView("redirect:viewStudent.html?id="+student.getId());
	}

	@RequestMapping(value = "/viewStudent.html")
	public ModelAndView viewsStudent(int id,@ModelAttribute("studentWrapper")StudentWrapper studentWrapper) {
		StudentDO	student = registrationService.getStudent(id);
		ModelAndView mav = new ModelAndView("viewStudent");
		studentWrapper.setStudent(student);
		mav.addObject("studentWrapper", studentWrapper);
		return mav;
	}

}
