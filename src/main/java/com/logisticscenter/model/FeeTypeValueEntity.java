package com.logisticscenter.model;

public class FeeTypeValueEntity {
	
	public FeeTypeValueEntity(){}
	
	//费用类型
	private String feeType;
	
	//费用value
	private String feeTypeValue;
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeTypeValue() {
		return feeTypeValue;
	}
	public void setFeeTypeValue(String feeTypeValue) {
		this.feeTypeValue = feeTypeValue;
	}

}
