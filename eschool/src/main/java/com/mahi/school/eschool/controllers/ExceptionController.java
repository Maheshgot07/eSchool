package com.mahi.school.eschool.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(ResourceAccessException.class)
	public ModelAndView handleResourceAccessExp(ResourceAccessException ex) {
		return new ModelAndView("resourceNotFoundError","serviceName",ex.getMessage());
	}
	

}
