package com.javabean;

public class ClientBean {
	
	public ClientBean(){}
	
	public ClientBean(String selectName,String pageSize,
			String currentPage){
		this.clientName = selectName;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
	}
	
	public ClientBean(int id,
			String clientName,
			String contant,
			String mobile,
			String fax,
			String address,
			String products
){
		this.id = id ;
		this.clientName = clientName ;
		this.contant = contant ;
		this.mobile = mobile ;
		this.fax = fax ;
		this.address = address ;
		this.products = products ;


	}
	
	//标识ID
	private int id;
	//客户名称
	private String clientName;
	//联系方式
	private String contant;
	//手机
	private String mobile;
	//传真
	private String fax;
	//地址
	private String address;
	//货物
	private String products;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	//编辑日期
	private String editDate;
	//编辑时间
	private String editTime;
	
	//pageSize
	private String pageSize;
	
	//currentPage
	private String currentPage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContant() {
		return contant;
	}
	public void setContant(String contant) {
		this.contant = contant;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
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

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getEditTime() {
		return editTime;
	}

	public void setEditTime(String editTime) {
		this.editTime = editTime;
	}

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
	
}
