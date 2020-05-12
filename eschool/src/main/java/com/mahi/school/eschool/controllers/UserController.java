package com.mahi.school.eschool.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@RequestMapping("/home.html")
	public ModelAndView menu() {
		return new ModelAndView("menu");
	}
	
	@RequestMapping(value ="/menu.jsp",method = RequestMethod.GET)
	public ModelAndView menu1() {
		return new ModelAndView("menu");
	}
	
}
