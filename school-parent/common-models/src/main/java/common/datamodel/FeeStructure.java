package common.datamodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class FeeStructure {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long feeStructureId;
	@Column
	String standard;
	@Column
	String academicYr;
	@Column
	String discount;
	@OneToMany(cascade=CascadeType.ALL,fetch =FetchType.LAZY)
	List<FeeItem> feeItems = new ArrayList<FeeItem>();
	
	
	public long getFeeStructureId() {
		return feeStructureId;
	}
	public void setFeeStructureId(long feeStructureId) {
		this.feeStructureId = feeStructureId;
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
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public List<FeeItem> getFeeItems() {
		return feeItems;
	}
	public void setFeeItems(List<FeeItem> feeItems) {
		this.feeItems = feeItems;
	}
	
}
