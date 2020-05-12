package com.mahi.school.eschool.controllers;

import java.net.URISyntaxException;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.school.eschool.service.PaymentService;
import com.mahi.school.eschool.service.RegistrationService;

import common.datamodel.PaymentWrapper;
import common.datamodel.SearchStudent;
import common.datamodel.SearchWrapper;
import common.datamodel.StudentDO;
import common.datamodel.StudentPayment;

@RestController
public class PaymentController {
	@Autowired
	RegistrationService registrationService;
	@Autowired
	PaymentService paymentService;
	@RequestMapping("/searchStudentForPayment.html")
	public ModelAndView initSearchForPayment(@ModelAttribute("searchWrapper")SearchWrapper searchWrapper) {
		ModelAndView mav = new ModelAndView("searchForPayment");
		mav.addObject("searchWrapper",searchWrapper);
		return mav;
	}
	
	@RequestMapping(value = "executePaymentSearch.html", method = RequestMethod.POST)
	public ModelAndView searchStudentExecute(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) throws URISyntaxException {
		 SearchStudent searchStudent = new SearchStudent();
		 searchStudent = searchWrapper.getSearchStudent();
		List<StudentDO> studentList = registrationService.searchStudent(searchStudent);
		ModelAndView mav = new ModelAndView("searchForPayment");
		searchWrapper.setStudentsList(studentList);
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}
	
	@RequestMapping("/initPayment.html")
	public ModelAndView initPayment(@RequestParam("id") long id,@ModelAttribute("paymentWrapper")PaymentWrapper paymentWrapper) {
		System.out.println("searching student for id "+id);
		ModelAndView mav = new ModelAndView("addPayment");
		StudentDO student = registrationService.getStudent(id);
		StudentPayment studentPayment = paymentService.generatePaymentItems(student);
		studentPayment.setStudent(student);
		paymentWrapper.setStudentPayment(studentPayment);
		System.out.println("studentPayment item size "+studentPayment.getPayment_item().size());
		mav.addObject("paymentWrapper",paymentWrapper);
		return mav;
	}
	
	@RequestMapping(value ="savePayment.html", method = RequestMethod.POST)
	public ModelAndView savePaymentDetails(@ModelAttribute("paymentWrapper")PaymentWrapper paymentWrapper,Principal principal) {
		StudentPayment studentPayment = paymentWrapper.getStudentPayment();
		long student_id = paymentWrapper.getStudent().getId();
		StudentDO student = registrationService.getStudent(student_id);
		//studentPayment = paymentService.calculatePayment(studentPayment);
		studentPayment.setStudent(student);
		/*
		 * Set<StudentPayment> studentPayments = new HashSet<StudentPayment>();
		 * studentPayments.add(studentPayment);
		 * student.setStudentPaymentList(studentPayments);
		 */
		//student = registrationService.saveStudent(student, null);
		studentPayment.setStudentPaidId(student_id);
		studentPayment.setAcademicYr(student.getAcademicYr());
		studentPayment.setStandard(student.getStandard());
		studentPayment = paymentService.savePayment(studentPayment);
		paymentWrapper.setStudent(student);
		paymentWrapper.setStudentPayment(studentPayment);
		ModelAndView mav = new ModelAndView("viewPaymentPaid");
		mav.addObject("paymentWrapper",paymentWrapper);
		return mav;
	}
	
	@RequestMapping(value ="viewPayment.html", method = RequestMethod.GET)
	public ModelAndView viewPaymentDetails(@RequestParam("id") long student_id,@ModelAttribute("paymentWrapper")PaymentWrapper paymentWrapper) {
		//StudentPayment studentPayment = paymentWrapper.getStudentPayment();
		//long student_id = paymentWrapper.getStudent().getId();
		StudentDO student = registrationService.getStudent(student_id);
		List<StudentPayment> studentPaymentList = paymentService.getStudentPayment(student.getId(), student.getAcademicYr());
		
		StudentPayment studentPayment = paymentService.clubStudentPayment(studentPaymentList);
		paymentWrapper.setStudent(student);
		paymentWrapper.setStudentPayment(studentPayment);
		ModelAndView mav = new ModelAndView("viewPaymentPaid");
		mav.addObject("paymentWrapper",paymentWrapper);
		return mav;
	}
	
	
	@RequestMapping("/searchStudentForViewPayment.html")
	public ModelAndView initSearchForViewPayment(@ModelAttribute("searchWrapper")SearchWrapper searchWrapper) {
		ModelAndView mav = new ModelAndView("searchForViewPayment");
		mav.addObject("searchWrapper",searchWrapper);
		return mav;
	}
	
	@RequestMapping(value = "executeViewPaymentSearch.html", method = RequestMethod.POST)
	public ModelAndView searchStudentExecuteForViewPayment(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) throws URISyntaxException {
		 SearchStudent searchStudent = new SearchStudent();
		 searchStudent = searchWrapper.getSearchStudent();
		List<StudentDO> studentList = registrationService.searchStudent(searchStudent);
		ModelAndView mav = new ModelAndView("searchForViewPayment");
		searchWrapper.setStudentsList(studentList);
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}
	
	@RequestMapping(value ="editPayment.html", method = RequestMethod.POST)
	public ModelAndView editPaymentDetails(@RequestParam("id") long student_id,@ModelAttribute("paymentWrapper")PaymentWrapper paymentWrapper) {
		StudentDO student = registrationService.getStudent(student_id);
		List<StudentPayment> studentPaymentList = paymentService.getStudentPayment(student.getId(), student.getAcademicYr());
		
		//StudentPayment studentPayment = paymentService.clubStudentPayment(studentPaymentList);
		paymentWrapper.setStudent(student);
		paymentWrapper.setStudentPaymentList(studentPaymentList);
		ModelAndView mav = new ModelAndView("editPayment");
		mav.addObject("paymentWrapper",paymentWrapper);
		return mav;
	}
	
	@RequestMapping(value ="saveEditedPayment.html", method = RequestMethod.POST)
	public ModelAndView saveEditedPaymentDetails(@ModelAttribute("paymentWrapper")PaymentWrapper paymentWrapper) {
		StudentDO student = registrationService.getStudent(paymentWrapper.getStudent().getId());
		List<StudentPayment> studentPaymentList = paymentWrapper.getStudentPaymentList();
		
		//StudentPayment studentPayment = paymentService.clubStudentPayment(studentPaymentList);
		for(StudentPayment payment: studentPaymentList) {
			payment.setStudentPaidId(student.getId());
			payment.setAcademicYr(student.getAcademicYr());
			payment.setStandard(student.getStandard());
			paymentService.savePayment(payment);
		}
		paymentWrapper.setStudent(student);
		paymentWrapper.setStudentPaymentList(studentPaymentList);
		ModelAndView mav = new ModelAndView("redirect:viewPayment.html?id="+student.getId());
		mav.addObject("paymentWrapper",paymentWrapper);
		return mav;
	}
}