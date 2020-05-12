package common.datamodel;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Payment_item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long payment_item_id;
	
	@Column
	String payment_desc;
	
	@Column
	double amount;
	@Column
	double amt_paid;
	@Column
	Date payment_date;
	@Column
	double discount;
	@Column
	double pending_amt;
	@Column
	double net_payable;
	
	@Column
	long feeItemid;
	
	@ManyToOne
	@JoinColumn(name="studentPayment")
	StudentPayment studentPayment;
	

	public long getPayment_item_id() {
		return payment_item_id;
	}


	public void setPayment_item_id(long payment_item_id) {
		this.payment_item_id = payment_item_id;
	}


	public String getPayment_desc() {
		return payment_desc;
	}


	public void setPayment_desc(String payment_desc) {
		this.payment_desc = payment_desc;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Date getPayment_date() {
		return payment_date;
	}


	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public double getPending_amt() {
		return pending_amt;
	}


	public void setPending_amt(double pending_amt) {
		this.pending_amt = pending_amt;
	}

	@JsonIgnore
	public StudentPayment getStudentPayment() {
		return studentPayment;
	}


	public void setStudentPayment(StudentPayment studentPayment) {
		this.studentPayment = studentPayment;
	}


	public double getAmt_paid() {
		return amt_paid;
	}


	public void setAmt_paid(double amt_paid) {
		this.amt_paid = amt_paid;
	}


	public double getNet_payable() {
		return net_payable;
	}


	public void setNet_payable(double net_payable) {
		this.net_payable = net_payable;
	}


	public long getFeeItemid() {
		return feeItemid;
	}


	public void setFeeItemid(long feeItemid) {
		this.feeItemid = feeItemid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (feeItemid ^ (feeItemid >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment_item other = (Payment_item) obj;
		if (feeItemid != other.feeItemid)
			return false;
		return true;
	}



}
