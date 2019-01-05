package com.javabean;

import java.sql.Timestamp;

public class LabelSetBean {
	
	private int id;
	
	private String type;

	private String lableName;
	
	private String URL;
	
	private int sort;
	
	private int ishow;
	
	private Timestamp createTime;
	
	private Timestamp editTime;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLableName() {
		return lableName;
	}

	public void setLableName(String lableName) {
		this.lableName = lableName;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getEditTime() {
		return editTime;
	}

	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getIshow() {
		return ishow;
	}

	public void setIshow(int ishow) {
		this.ishow = ishow;
	}

}
