package common.datamodel;

import java.util.ArrayList;
import java.util.List;

public class PaymentWrapper {
	
	StudentPayment studentPayment;
	StudentDO student;
	List<StudentPayment> studentPaymentList;
	public StudentPayment getStudentPayment() {
		return studentPayment;
	}

	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}

	public StudentDO getStudent() {
		return student;
	}

	public void setStudent(StudentDO student) {
		this.student = student;
	}

	public List<StudentPayment> getStudentPaymentList() {
		return studentPaymentList;
	}

	public void setStudentPaymentList(List<StudentPayment> studentPaymentList) {
		this.studentPaymentList = studentPaymentList;
	}
	
	
}
