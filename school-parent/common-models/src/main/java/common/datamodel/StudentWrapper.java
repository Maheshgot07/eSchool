package common.datamodel;

public class StudentWrapper {
StudentDO student;
String dob;
String admsnDt;
StudentOtherDetails otherDetail;

public StudentDO getStudent() {
	return student;
}

public void setStudent(StudentDO student) {
	try {
		this.student = student;
	}catch (Exception e) {
		e.printStackTrace();
	}
	
}

public StudentOtherDetails getOtherDetail() {
	return otherDetail;
}

public void setOtherDetail(StudentOtherDetails otherDetail) {
	this.otherDetail = otherDetail;
}

public String getDob() {
	return dob;
}

public void setDob(String dob) {
	this.dob = dob;
}

public String getAdmsnDt() {
	return admsnDt;
}

public void setAdmsnDt(String admsnDt) {
	this.admsnDt = admsnDt;
}


}
