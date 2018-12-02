package com.javabean;

import java.math.BigDecimal;

import com.common.ConvertService;
import com.util.ConstantUtils;

public class TruckGoodsReportDetailBean {
	
	public TruckGoodsReportDetailBean(){}
	//标识ID
	private int id;
	//对应预录车辆信息中的reportId
	private int truckOrder;
	//客户货物类型
	private String goodsType;
	//单价
	private BigDecimal price;
	//是否删除
	private int deleteFlg;
	//载重
	private BigDecimal realCarry;
	//是否开票
	private int invoiceFlg;
	//吊费
	private BigDecimal liftingCost;
	//始发地
	private String startPlace;
	//目的地
	private String endPlace;
	//区域
	private String workPlace;

	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	//修改日期
	private String editDate;
	//修改时间
	private String editTime;
	
	//检索用
	private String goodsTypes;
	
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
	
	public int getTruckOrder() {
		return truckOrder;
	}
	public void setTruckOrder(int truckOrder) {
		this.truckOrder = truckOrder;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getRealCarry() {
		return realCarry;
	}
	public void setRealCarry(BigDecimal realCarry) {
		this.realCarry = realCarry;
	}
	public int getInvoiceFlg() {
		return invoiceFlg;
	}
	public void setInvoiceFlg(int invoiceFlg) {
		this.invoiceFlg = invoiceFlg;
	}
	
	public BigDecimal getLiftingCost() {
		return liftingCost;
	}
	public void setLiftingCost(BigDecimal liftingCost) {
		this.liftingCost = liftingCost;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
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
	public int getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	public String getGoodsTypes() {
		return goodsTypes;
	}
	public void setGoodsTypes(String goodsTypes) {
		this.goodsTypes = goodsTypes;
	}
	
}
