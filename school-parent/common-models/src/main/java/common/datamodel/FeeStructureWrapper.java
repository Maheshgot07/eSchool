package common.datamodel;

import java.util.ArrayList;
import java.util.List;

public class FeeStructureWrapper {

	FeeStructure feeStructure;
	List<FeeItem> feeItems; 
	public FeeStructure getFeeStructure() {
		return feeStructure;
	}

	public void setFeeStructure(FeeStructure feeStructure) {
		this.feeStructure = feeStructure;
	}

	public List<FeeItem> getFeeItems() {
		return feeItems;
	}

	public void setFeeItems(List<FeeItem> feeItems) {
		this.feeItems = feeItems;
	}
	
}
