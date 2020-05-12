package com.mahi.school.eschool.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import common.datamodel.SearchStudent;
import common.datamodel.StudentDO;

@Service
public class RegistrationService {
	@Autowired
	private FileStorageService fileStorageService;

	public StudentDO saveStudent(StudentDO student, MultipartFile file) {
		String imageId = null;
		final String uri = "http://localhost:8085/register/saveStudent";
		if (file != null && file.getName() != null && !file.isEmpty() && file.getSize()>0)
			imageId = getUpoladFileName(file);
		student.setImageId(imageId);
		RestTemplate restTemplate = new RestTemplate();
		try {
			student = restTemplate.postForObject(uri, student, StudentDO.class);
			if (file != null && imageId != null) {
				fileStorageService.storeFile(file, imageId);
			}
			System.out.println("Student saved " + student);
		} catch (ResourceAccessException e) {
			throw new ResourceAccessException("Registration Service");
		}

		return student;
	}

	public String getUpoladFileName(MultipartFile file) {
		String ext = "";
		String fileName = "";
		String OriginfileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (null != file && null != OriginfileName && OriginfileName.length() > 0) {

			System.out.println(OriginfileName);
			int index = OriginfileName.lastIndexOf(".");
			ext = OriginfileName.substring(index);
			System.out.println("ext " + ext);
			fileName = generateUUID() + ext;
		}

		return fileName;
	}

	public String generateUUID() {
		return UUID.randomUUID().toString();
	}

	public StudentDO getStudent(long id) {
		final String uri = "http://localhost:8085/register/student/" + id;
		RestTemplate restTemplate = new RestTemplate();
		StudentDO student = new StudentDO();
		try {
			student = restTemplate.getForObject(uri, StudentDO.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return student;
	}

	public List<StudentDO> searchStudent(SearchStudent searchStudent) throws URISyntaxException {
		final String uri = "http://localhost:8085/register/student/search";
		RestTemplate restTemplate = new RestTemplate();
		List<StudentDO> students = new ArrayList<StudentDO>();

		RequestEntity<SearchStudent> request = RequestEntity.post(new URI(uri)).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).body(searchStudent);
		try {
			ResponseEntity<List<StudentDO>> response = restTemplate.exchange(uri, HttpMethod.POST, request,
					new ParameterizedTypeReference<List<StudentDO>>() {
					});
			students = response.getBody();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for (StudentDO st : students) {
			System.out.println(st);
		}
		return students;
	}
}
