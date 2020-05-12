package common.datamodel;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.engine.profile.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StudentPayment {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	long payment_id;
	
	@Column
	double prvs_bal;
	@Column
	double tot_amt;
	@Column
	double tot_pending_amt;
	@Column
	double discount;
	@Column
	double lastPaid_amt;
	@Column
	double tot_paid_amt;
	@Column
	double netPayableAmt;
	@Column
	Date lastPayment_dt;
	@Column
	Date due_dt;
	@Column
	String academicYr;
	@Column
	long studentPaidId;
	@Column
	String standard;
	@Transient
	List<Payment_item> paymentHistoryList ; 
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	StudentDO student;
	
	@OneToMany(mappedBy="studentPayment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	List<Payment_item> payment_item;

	public long getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(long payment_id) {
		this.payment_id = payment_id;
	}

	public double getPrvs_bal() {
		return prvs_bal;
	}

	public void setPrvs_bal(double prvs_bal) {
		this.prvs_bal = prvs_bal;
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

	public Date getLastPayment_dt() {
		return lastPayment_dt;
	}

	public void setLastPayment_dt(Date lastPayment_dt) {
		this.lastPayment_dt = lastPayment_dt;
	}

	public Date getDue_dt() {
		return due_dt;
	}

	public void setDue_dt(Date due_dt) {
		this.due_dt = due_dt;
	}
	public StudentDO getStudent() {
		return student;
	}

	public void setStudent(StudentDO student) {
		this.student = student;
	}

	public List<Payment_item> getPayment_item() {
		return payment_item;
	}

	public void setPayment_item(List<Payment_item> payment_item) {
		this.payment_item = payment_item;
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

	public String getAcademicYr() {
		return academicYr;
	}

	public void setAcademicYr(String academicYr) {
		this.academicYr = academicYr;
	}

	public long getStudentPaidId() {
		return studentPaidId;
	}

	public void setStudentPaidId(long studentPaidId) {
		this.studentPaidId = studentPaidId;
	}

	public List<Payment_item> getPaymentHistoryList() {
		return paymentHistoryList;
	}

	public void setPaymentHistoryList(List<Payment_item> paymentHistoryList) {
		this.paymentHistoryList = paymentHistoryList;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

}
