package com.mahi.school.eschool.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import com.mahi.school.eschool.filestore.MyFileNotFoundException;

import common.datamodel.CompositeStudentPayment;
import common.datamodel.SearchWrapper;
import common.datamodel.StudentDO;
import common.datamodel.StudentPayment;

@Service
public class ExportService {
	@Autowired
	PaymentService paymentService;

	public String exportStudents(List<StudentDO> studentList, SearchWrapper searchWrapper) {

		if (studentList != null && !studentList.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet spreadsheet = workbook.createSheet("Result Info ");
			XSSFRow row;
			int rowid = 0;
			int cellid = 0;
			String standard = searchWrapper.getSearchStudent().getStandard() == null ? ""
					: searchWrapper.getSearchStudent().getStandard();
			String academicYr = searchWrapper.getSearchStudent().getAcademicYr() == null ? ""
					: searchWrapper.getSearchStudent().getAcademicYr();
			String division = searchWrapper.getSearchStudent().getDivision() == null ? ""
					: searchWrapper.getSearchStudent().getDivision();

			row = spreadsheet.createRow(rowid++);
			row.createCell(cellid++).setCellValue("Academic Year - " + academicYr);
			row.createCell(cellid++).setCellValue("Standard - " + standard + " ," + division);
			cellid = 0;
			row = spreadsheet.createRow(rowid++);
			row.createCell(cellid++).setCellValue("Registration_Id");
			row.createCell(cellid++).setCellValue("Roll Number");
			row.createCell(cellid++).setCellValue("Student Name");
			row.createCell(cellid++).setCellValue("Standard");
			row.createCell(cellid++).setCellValue("Academic Year");
			row.createCell(cellid++).setCellValue("Division");
			row.createCell(cellid++).setCellValue("Birth Date");
			row.createCell(cellid++).setCellValue("Gender");
			row.createCell(cellid++).setCellValue("Mobile Number");
			row.createCell(cellid++).setCellValue("Status");

			for (StudentDO student : studentList) {
				row = spreadsheet.createRow(rowid++);
				cellid = 0;
				row.createCell(cellid++).setCellValue(student.getId());
				row.createCell(cellid++).setCellValue(student.getRollNum());
				row.createCell(cellid++).setCellValue(
						student.getLastName() + " " + student.getFirstName() + " " + student.getMiddleName());
				row.createCell(cellid++).setCellValue(student.getStandard());
				row.createCell(cellid++).setCellValue(student.getAcademicYr());
				row.createCell(cellid++).setCellValue(student.getDivision());
				if (student.getDob() != null) {
					row.createCell(cellid++).setCellValue(student.getDob().toString());
				} else {
					row.createCell(cellid++).setCellValue("");
				}
				row.createCell(cellid++).setCellValue(student.getGender());
				row.createCell(cellid++).setCellValue(student.getMobilNum());
				row.createCell(cellid++).setCellValue(student.getStatus());
			}

			FileOutputStream out;
			String filePath = "F://My Practice//UploadDirectory//StudentList_" + academicYr + "_" + standard + "_"
					+ division + ".xlsx";
			try {
				out = new FileOutputStream(new File(filePath));
				workbook.write(out);
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return filePath;
		}
		return "";
	}

	public String exportStudentPayment(List<StudentDO> studentList, SearchWrapper searchWrapper) {
		if (studentList != null) {
			List<Long> studentIdList = new ArrayList<Long>();
			HashMap<Long, StudentDO> studentMap = new HashMap<Long, StudentDO>();
			for (StudentDO student : studentList) {
				studentIdList.add(student.getId());
				studentMap.put(student.getId(), student);
			}
			
			List<StudentPayment> paymentsList = paymentService.getStudentPaymentByStudentList(studentIdList);
			List<CompositeStudentPayment> compositeList = paymentService.getExportablePaymentDeatils(studentList,paymentsList);
			
			if (compositeList != null && !compositeList.isEmpty()) {
				XSSFWorkbook workbook = new XSSFWorkbook();
				XSSFSheet spreadsheet = workbook.createSheet("Result Info ");
				XSSFRow row;
				int rowid = 0;
				int cellid = 0;
				
				String standard = searchWrapper.getSearchStudent().getStandard() == null ? ""
						: searchWrapper.getSearchStudent().getStandard();
				String academicYr = searchWrapper.getSearchStudent().getAcademicYr() == null ? ""
						: searchWrapper.getSearchStudent().getAcademicYr();
				String division = searchWrapper.getSearchStudent().getDivision() == null ? ""
						: searchWrapper.getSearchStudent().getDivision();

				row = spreadsheet.createRow(rowid++);
				row.createCell(cellid++).setCellValue("Academic Year - " + academicYr);
				row.createCell(cellid++).setCellValue("Standard - " + standard + " ," + division);
				cellid = 0;
				
				row = spreadsheet.createRow(rowid++);
				row.createCell(cellid++).setCellValue("Registration_Id");
				row.createCell(cellid++).setCellValue("Roll Number");
				row.createCell(cellid++).setCellValue("Student Name");
				row.createCell(cellid++).setCellValue("Standard");
				row.createCell(cellid++).setCellValue("Academic Year");
				row.createCell(cellid++).setCellValue("Division");
				row.createCell(cellid++).setCellValue("Tot Amount");
				row.createCell(cellid++).setCellValue("Tot Paid amount");
				row.createCell(cellid++).setCellValue("Tot Pending Amt");
				row.createCell(cellid++).setCellValue("Net Payable");
				
				for (CompositeStudentPayment composite : compositeList) {
					cellid = 0;
					row = spreadsheet.createRow(rowid++);
					row.createCell(cellid++).setCellValue(composite.getStudentId());
					row.createCell(cellid++).setCellValue(composite.getRollNum());
					row.createCell(cellid++).setCellValue(composite.getFullName());
					row.createCell(cellid++).setCellValue(composite.getStandard());
					row.createCell(cellid++).setCellValue(composite.getAcademicYr());
					row.createCell(cellid++).setCellValue(composite.getDivision());
					row.createCell(cellid++).setCellValue(composite.getTot_amt());
					row.createCell(cellid++).setCellValue(composite.getTot_paid_amt());
					row.createCell(cellid++).setCellValue(composite.getTot_pending_amt());
					row.createCell(cellid++).setCellValue(composite.getNetPayableAmt());
				}
				
				FileOutputStream out;
				String filePath = "F://My Practice//UploadDirectory//PaymentList_" + academicYr + "_" + standard + "_"
						+ division + ".xlsx";
				try {
					out = new FileOutputStream(new File(filePath));
					workbook.write(out);
					out.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return filePath;
			}
			
			
			return "";
		}
		return null;
	}

}
