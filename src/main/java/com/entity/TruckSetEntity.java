package com.entity;

public class TruckSetEntity {
	private String pageSize;
	private String commercialDate;
	private String compulsoryDate;
	//订单规则
	private String orderRule;
	//前缀
	private String preRule;
	//后缀
	private String lastRule;
	//重复登录Flag
	private int reLogin;
	
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getCommercialDate() {
		return commercialDate;
	}

	public void setCommercialDate(String commercialDate) {
		this.commercialDate = commercialDate;
	}

	public String getCompulsoryDate() {
		return compulsoryDate;
	}

	public void setCompulsoryDate(String compulsoryDate) {
		this.compulsoryDate = compulsoryDate;
	}

	public String getOrderRule() {
		return orderRule;
	}

	public void setOrderRule(String orderRule) {
		this.orderRule = orderRule;
	}

	public String getPreRule() {
		return preRule;
	}

	public void setPreRule(String preRule) {
		this.preRule = preRule;
	}

	public String getLastRule() {
		return lastRule;
	}

	public void setLastRule(String lastRule) {
		this.lastRule = lastRule;
	}

	public int getReLogin() {
		return reLogin;
	}

	public void setReLogin(int reLogin) {
		this.reLogin = reLogin;
	}
}
