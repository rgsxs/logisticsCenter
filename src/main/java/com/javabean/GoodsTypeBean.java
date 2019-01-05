package com.javabean;

public class GoodsTypeBean {
	
	public GoodsTypeBean(){}
	
	public GoodsTypeBean(String goodsName){
		this.goodsName = goodsName;
	}
	
	public GoodsTypeBean(int id,String goodsName,int isUse,int isDelete,String pageSize,String currentPage){
		this.id = id;
		this.goodsName = goodsName;
		this.isUse = isUse;
		this.isDelete = isDelete;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	
	//标识ID
	private int id;
	//货物名称
	private String goodsName;
	//是否启用
	private int isUse;
	//是否删除
	private int isDelete;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getIsUse() {
		return isUse;
	}

	public void setIsUse(int isUse) {
		this.isUse = isUse;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

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
