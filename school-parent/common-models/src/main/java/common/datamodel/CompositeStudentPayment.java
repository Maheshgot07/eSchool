package common.datamodel;

import java.util.List;

public class CompositeStudentPayment {
	int compId;
	long studentId;
	String rollNum;
	String fullName;
	String standard;
	String academicYr;
	String division;
	
	double tot_amt;
	double tot_pending_amt;
	double discount;
	double lastPaid_amt;
	double tot_paid_amt;
	double netPayableAmt;
	List<Payment_item> payment_item;
	
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getRollNum() {
		return rollNum;
	}
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public double getTot_amt() {
		return tot_amt;
	}
	public void setTot_amt(double tot_amt) {
		this.tot_amt = tot_amt;
	}
	public double getTot_pending_amt() {
		return tot_pending_amt;
	}
	public void setTot_pending_amt(double tot_pending_amt) {
		this.tot_pending_amt = tot_pending_amt;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getLastPaid_amt() {
		return lastPaid_amt;
	}
	public void setLastPaid_amt(double lastPaid_amt) {
		this.lastPaid_amt = lastPaid_amt;
	}
	public double getTot_paid_amt() {
		return tot_paid_amt;
	}
	public void setTot_paid_amt(double tot_paid_amt) {
		this.tot_paid_amt = tot_paid_amt;
	}
	public double getNetPayableAmt() {
		return netPayableAmt;
	}
	public void setNetPayableAmt(double netPayableAmt) {
		this.netPayableAmt = netPayableAmt;
	}
	public List<Payment_item> getPayment_item() {
		return payment_item;
	}
	public void setPayment_item(List<Payment_item> payment_item) {
		this.payment_item = payment_item;
	}

}
