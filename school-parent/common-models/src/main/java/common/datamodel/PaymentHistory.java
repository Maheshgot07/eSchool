package common.datamodel;

import java.sql.Date;


public class PaymentHistory {
	double amount;
	double amt_paid;
	Date payment_date;
	double discount;
	double pending_amt;
	double net_payable;
	String user;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getAmt_paid() {
		return amt_paid;
	}
	public void setAmt_paid(double amt_paid) {
		this.amt_paid = amt_paid;
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
	public double getNet_payable() {
		return net_payable;
	}
	public void setNet_payable(double net_payable) {
		this.net_payable = net_payable;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
}
