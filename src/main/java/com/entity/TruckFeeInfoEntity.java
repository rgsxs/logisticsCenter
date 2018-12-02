package com.entity;

import java.math.BigDecimal;

public class TruckFeeInfoEntity {
	
	public TruckFeeInfoEntity(){}
	
	//标识ID
	private int id;
	//托运单号
	private String carryNumber;
	//车牌号码
	private String truckNumber;
	//运费
	private BigDecimal expensens;
	//邮费
	private BigDecimal oilCost;
	//吊费
	private BigDecimal towinigCost;
	//过路费
	private BigDecimal roadCost;
	//维修费
	private BigDecimal repairCost;
	//带路费
	private BigDecimal leadWayCost;
	//轮胎费用
	private BigDecimal tireCost;
	//其他费用
	private BigDecimal otherCost;
	//补助
	private BigDecimal allowance;
	//共计费用
	private BigDecimal total;

	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
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
	
	public String getCreateDate() {
		return createDate;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCarryNumber() {
		return carryNumber;
	}

	public void setCarryNumber(String carryNumber) {
		this.carryNumber = carryNumber;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public BigDecimal getExpensens() {
		return expensens;
	}

	public void setExpensens(BigDecimal expensens) {
		this.expensens = expensens;
	}

	public BigDecimal getOilCost() {
		return oilCost;
	}

	public void setOilCost(BigDecimal oilCost) {
		this.oilCost = oilCost;
	}

	public BigDecimal getTowinigCost() {
		return towinigCost;
	}

	public void setTowinigCost(BigDecimal towinigCost) {
		this.towinigCost = towinigCost;
	}

	public BigDecimal getRoadCost() {
		return roadCost;
	}

	public void setRoadCost(BigDecimal roadCost) {
		this.roadCost = roadCost;
	}

	public BigDecimal getRepairCost() {
		return repairCost;
	}

	public void setRepairCost(BigDecimal repairCost) {
		this.repairCost = repairCost;
	}

	public BigDecimal getLeadWayCost() {
		return leadWayCost;
	}

	public void setLeadWayCost(BigDecimal leadWayCost) {
		this.leadWayCost = leadWayCost;
	}

	public BigDecimal getTireCost() {
		return tireCost;
	}

	public void setTireCost(BigDecimal tireCost) {
		this.tireCost = tireCost;
	}

	public BigDecimal getOtherCost() {
		return otherCost;
	}

	public void setOtherCost(BigDecimal otherCost) {
		this.otherCost = otherCost;
	}

	public BigDecimal getAllowance() {
		return allowance;
	}

	public void setAllowance(BigDecimal allowance) {
		this.allowance = allowance;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
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
