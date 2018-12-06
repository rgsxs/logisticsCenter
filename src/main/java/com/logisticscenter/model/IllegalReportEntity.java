package com.logisticscenter.model;

public class IllegalReportEntity {
	//标识ID
	private int id;
	//车牌号码
	private String truckNumber;
	//事故单号
	private String illegalNumber;
	//事故性质
	private int illegalType;
	//金额
	private String illegalCost;
	//司机
	private int driver;
	//违章日期
	private String illegalDate;
	//违章原因
	private String illegalReason;
	//保险金额
	private String insuranceCost;
	//处理结果
	private String result;
	//违章说明
	private String illegalRemind;
	//备注
	private String remark;
	
	//pageSize
	private String pageSize;
	
	//currentPage
	private String currentPage;
	
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getIllegalNumber() {
		return illegalNumber;
	}
	public void setIllegalNumber(String illegalNumber) {
		this.illegalNumber = illegalNumber;
	}
	public int getIllegalType() {
		return illegalType;
	}
	public void setIllegalType(int illegalType) {
		this.illegalType = illegalType;
	}
	public String getIllegalCost() {
		return illegalCost;
	}
	public void setIllegalCost(String illegalCost) {
		this.illegalCost = illegalCost;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public String getIllegalDate() {
		return illegalDate;
	}
	public void setIllegalDate(String illegalDate) {
		this.illegalDate = illegalDate;
	}
	public String getIllegalReason() {
		return illegalReason;
	}
	public void setIllegalReason(String illegalReason) {
		this.illegalReason = illegalReason;
	}
	public String getInsuranceCost() {
		return insuranceCost;
	}
	public void setInsuranceCost(String insuranceCost) {
		this.insuranceCost = insuranceCost;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getIllegalRemind() {
		return illegalRemind;
	}
	public void setIllegalRemind(String illegalRemind) {
		this.illegalRemind = illegalRemind;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
