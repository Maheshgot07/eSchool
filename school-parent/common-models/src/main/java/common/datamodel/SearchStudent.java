package common.datamodel;

import common.datamodel.util.StringUtil;

public class SearchStudent {

	int id;
	String rollNum;
	String firstName;
	String lastName;
	String prnNum;
	String standard;
	String academicYr;
	String division;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPrnNum() {
		return prnNum;
	}
	public void setPrnNum(String prnNum) {
		this.prnNum = prnNum;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getAcademicYr() {
		return academicYr;
	}
	public void setAcademicYr(String academicYr) {
		this.academicYr = academicYr;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getRollNum() {
		return rollNum;
	}
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}
	
}
