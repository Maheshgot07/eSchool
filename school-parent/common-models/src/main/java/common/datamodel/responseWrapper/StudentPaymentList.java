package common.datamodel.responseWrapper;

import java.util.ArrayList;
import java.util.List;

import common.datamodel.StudentPayment;

public class StudentPaymentList {
	List<StudentPayment> studentPaymentList = new ArrayList<StudentPayment>();

	public List<StudentPayment> getStudentPaymentList() {
		return studentPaymentList;
	}

	public void setStudentPaymentList(List<StudentPayment> studentPaymentList) {
		this.studentPaymentList = studentPaymentList;
	}

}
