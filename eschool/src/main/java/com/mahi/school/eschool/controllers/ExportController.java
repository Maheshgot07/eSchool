package com.mahi.school.eschool.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahi.school.eschool.service.ExportService;
import com.mahi.school.eschool.service.FileStorageService;
import com.mahi.school.eschool.service.PaymentService;
import com.mahi.school.eschool.service.RegistrationService;

import common.datamodel.SearchStudent;
import common.datamodel.SearchWrapper;
import common.datamodel.StudentDO;

@RestController
public class ExportController {

	@Autowired
	RegistrationService registrationService;
	@Autowired
	ExportService exportService;
	@Autowired
	FileStorageService fileStorageService;
	@Autowired
	PaymentService paymentService;

	@RequestMapping(value = "exportInit.html", method = RequestMethod.GET)
	public ModelAndView searchStudentInit(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) {

		// SearchStudent searchStudent = new SearchStudent();
		// searchWrapper.setSearchStudent(searchStudent);

		ModelAndView mav = new ModelAndView("exportStudent");
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}

	@RequestMapping(value = "exportStudents.html", method = RequestMethod.POST)
	public ResponseEntity<Resource> exportStudentExecute(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper,
			HttpServletRequest request) throws URISyntaxException {
		SearchStudent searchStudent = new SearchStudent();
		String fileName;
		searchStudent = searchWrapper.getSearchStudent();
		List<StudentDO> studentList = registrationService.searchStudent(searchStudent);
		fileName = exportService.exportStudents(studentList, searchWrapper);
		searchWrapper.setStudentsList(studentList);

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@RequestMapping(value = "exportPaymentInit.html", method = RequestMethod.GET)
	public ModelAndView exportPaymentDetailsInit(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper) {

		// SearchStudent searchStudent = new SearchStudent();
		// searchWrapper.setSearchStudent(searchStudent);

		ModelAndView mav = new ModelAndView("exportPaymentDetails");
		mav.addObject("searchWrapper", searchWrapper);
		return mav;
	}

	@RequestMapping(value = "exportPayments.html", method = RequestMethod.POST)
	public ResponseEntity<Resource> exportPaymentExecute(@ModelAttribute("searchWrapper") SearchWrapper searchWrapper,
			HttpServletRequest request) throws URISyntaxException {
		SearchStudent searchStudent = new SearchStudent();
		String fileName;
		searchStudent = searchWrapper.getSearchStudent();
		List<StudentDO> studentList = registrationService.searchStudent(searchStudent);
		fileName = exportService.exportStudentPayment(studentList, searchWrapper);
		searchWrapper.setStudentsList(studentList);

		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (

		IOException ex) {
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}
