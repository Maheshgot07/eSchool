package common.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class FeeItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int feeItemId;
	@Column
	String itemName;
	@Column
	double totAmt;
	@Column
	double discount;
	@Column
	boolean isMandatory;
	@ManyToOne
	@JoinColumn(name="feeStructure_id",nullable=false)
	FeeStructure feeStructure;
	
	public FeeItem(){
		
	}
	
	public FeeItem(String itemName, double totAmt, double discount, boolean isMandatory) {
		super();
		this.itemName = itemName;
		this.totAmt = totAmt;
		this.discount = discount;
		this.isMandatory = isMandatory;
	}

	public int getFeeItemId() {
		return feeItemId;
	}
	public void setFeeItemId(int feeItemId) {
		this.feeItemId = feeItemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getTotAmt() {
		return totAmt;
	}
	public void setTotAmt(double totAmt) {
		this.totAmt = totAmt;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public boolean isMandatory() {
		return isMandatory;
	}
	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}
	@JsonIgnore
	public FeeStructure getFeeStructure() {
		return feeStructure;
	}
	public void setFeeStructure(FeeStructure feeStructure) {
		this.feeStructure = feeStructure;
	}

	
}
