package com.javabean;

import java.math.BigDecimal;

import com.common.ConvertService;

public class TruckGoodsReportBean {
	
	public TruckGoodsReportBean(){}
	
	public TruckGoodsReportBean(int id,BigDecimal expensens,BigDecimal cost,BigDecimal profit){
		this.id = id;
		this.expensens = expensens;
		this.cost = cost;
		this.profit = profit;
	}
	//查询用
	/**
	 * @param reportStatus
	 * @param truckNumber
	 * @param startPlace
	 * @param endPlace
	 * @param beginDate
	 * @param endDate
	 * @param driver
	 * @param client
	 * @param goodsType
	 * @param carryNumber
	 * @param pageSize
	 * @param currentPage
	 */
	public TruckGoodsReportBean(int reportStatus ,String truckNumber,String startPlace,String endPlace,String beginDate,String endDate, int driver,int client,String goodsType,String carryNumber,String pageSize,String currentPage){
		this.truckNumber = truckNumber ;
		this.startPlace = startPlace ;
		this.endPlace = endPlace ;
		this.beginDate = beginDate ;
		this.endDate = endDate;
		this.driver = driver ;
		this.client = client ;
		this.goodsType = goodsType ;
		this.carryNumber = carryNumber ;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.reportStatus = reportStatus;
	}
	
	//insert用/update出车确认/出车回执用
	/**
	 * @param truckPart
	 * @param partner
	 * @param partnerPrice
	 * @param partnerCarry
	 * @param packagePrice
	 * @param invoiceFlg
	 * @param packageFlg
	 * @param truckNumber
	 * @param reportId
	 * @param startPlace
	 * @param endPlace
	 * @param beginDate
	 * @param expectedDate
	 * @param endDate
	 * @param driver
	 * @param client
	 * @param goodsType
	 * @param prepaidFlg
	 * @param prepaidExpress
	 * @param prepaidDesc
	 * @param reportStatus
	 * @param isLater
	 * @param laterReason
	 * @param realCarry
	 * @param price
	 * @param expensens
	 * @param carryNumber
	 * @param workPlace
	 * @param remark
	 * @param accessorys
	 * @param id
	 * @param feeTypecolumnSqlUpd
	 */
	public TruckGoodsReportBean(int truckPart,String partner,String partnerPrice,String partnerCarry,BigDecimal packagePrice,String invoiceFlg,String packageFlg,String truckNumber,int reportId,String startPlace,String endPlace,String beginDate,String expectedDate,String endDate,int driver,int client,String goodsType,int prepaidFlg,BigDecimal prepaidExpress,String prepaidDesc,int reportStatus,int isLater,String laterReason,BigDecimal realCarry,BigDecimal price,BigDecimal expensens,String carryNumber,String workPlace,String remark,String customerOrder,String settlement,String accessorys,String id,String feeTypecolumnSqlUpd){
		this.truckPart = truckPart;
		this.partner = partner;
		this.partnerPrice = partnerPrice;
		this.partnerCarry = partnerCarry;
		this.packagePrice = packagePrice;
		this.invoiceFlg = invoiceFlg;
		this.packageFlg = packageFlg;
		this.truckNumber = truckNumber ;
		this.reportId = reportId ;
		this.startPlace = startPlace ;
		this.endPlace = endPlace ;
		this.beginDate = beginDate ;
		this.expectedDate = expectedDate ;
		this.endDate = endDate ;
		this.driver = driver ;
		this.client = client ;
		this.goodsType = goodsType ;
		this.prepaidFlg =prepaidFlg;
		this.prepaidExpress =prepaidExpress;
		this.prepaidDesc =prepaidDesc;
		this.reportStatus = reportStatus ;
		this.isLater = isLater ;
		this.laterReason = laterReason ;
		this.realCarry = realCarry ;
		this.price = price ;
		this.expensens = expensens ;
		this.carryNumber = carryNumber ;
		this.workPlace = workPlace ;
		this.remark = remark;
		this.customerOrder = customerOrder;
		this.settlement = settlement;
		this.accessorys = accessorys;
		this.id = ConvertService.getIntValue(id,0) ;
		this.feeTypecolumnSqlUpd = feeTypecolumnSqlUpd ;


	}
	
	//标识ID
	private int id;
	//订单编号
	private String reportNumber;
	//是否开票
	private String invoiceFlg;
	//是否包车
	private String packageFlg;
	//包车价格
	private BigDecimal packagePrice;
	//发货状态
	private int truckPart;
	//伙伴
	private String partner;
	//伙伴价格
	private String partnerPrice;
	//伙伴载重
	private String partnerCarry;
	//车牌号码
	private String truckNumber;
	//预录发货订单号
	private int reportId;
	//发车起始地
	private String startPlace;
	//发车终点
	private String endPlace;
	//发车时间
	private String beginDate;
	//预计到货时间
	private String expectedDate;
	//实际到货时间
	private String endDate;
	//司机
	private int driver;
	//客户
	private int client;
	//是否预支费用
	private int prepaidFlg;
	//预支费用
	private BigDecimal prepaidExpress;
	//预支费用说明
	private String prepaidDesc;
	//客户货物类型
	private String goodsType;
	//状态
	private int reportStatus;
	//是否迟到
	private int isLater;
	//迟到原因
	private String laterReason;
	//实际载重
	private BigDecimal realCarry;
	//单价
	private BigDecimal price;
	//运费金额
	private BigDecimal expensens;
	//盈利
	private BigDecimal profit;
	//费用总计
	private BigDecimal cost;
	//托运单号
	private String carryNumber;
	//区域
	private String workPlace;
	//附件
	private String accessorys;

	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	//修改日期
	private String editDate;
	//修改时间
	private String editTime;
	//备注
	private String remark;
	//客户订单编号
	private String customerOrder;
	//是否结算运费
	private String settlement;
	//拼接的更新费用类型SQL
	private String feeTypecolumnSqlUpd;
	
	//拼接的查询费用类型SQL
	private String getFeeTypecolumn;
	
	//所有费用类型查询映射
	private String feeTypeValue;
	
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

	public String getReportNumber() {
		return reportNumber;
	}
	
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	
	public String getInvoiceFlg() {
		return invoiceFlg;
	}
	
	public void setInvoiceFlg(String invoiceFlg) {
		this.invoiceFlg = invoiceFlg;
	}
	
	public String getPackageFlg() {
		return packageFlg;
	}
	
	public void setPackageFlg(String packageFlg) {
		this.packageFlg = packageFlg;
	}
	
	public BigDecimal getPackagePrice() {
		return packagePrice;
	}
	public void setPackagePrice(BigDecimal packagePrice) {
		this.packagePrice = packagePrice;
	}
	
	public int getTruckPart() {
		return truckPart;
	}
	public void setTruckPart(int truckPart) {
		this.truckPart = truckPart;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getPartnerPrice() {
		return partnerPrice;
	}
	public void setPartnerPrice(String partnerPrice) {
		this.partnerPrice = partnerPrice;
	}
	
	public String getPartnerCarry() {
		return partnerCarry;
	}
	public void setPartnerCarry(String partnerCarry) {
		this.partnerCarry = partnerCarry;
	}
	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
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

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getExpectedDate() {
		return expectedDate;
	}

	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getDriver() {
		return driver;
	}

	public void setDriver(int driver) {
		this.driver = driver;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	public int getPrepaidFlg() {
		return prepaidFlg;
	}

	public void setPrepaidFlg(int prepaidFlg) {
		this.prepaidFlg = prepaidFlg;
	}

	public BigDecimal getPrepaidExpress() {
		return prepaidExpress;
	}

	public void setPrepaidExpress(BigDecimal prepaidExpress) {
		this.prepaidExpress = prepaidExpress;
	}

	public String getPrepaidDesc() {
		return prepaidDesc;
	}

	public void setPrepaidDesc(String prepaidDesc) {
		this.prepaidDesc = prepaidDesc;
	}

	
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public int getReportStatus() {
		return reportStatus;
	}
	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}

	public int getIsLater() {
		return isLater;
	}

	public void setIsLater(int isLater) {
		this.isLater = isLater;
	}

	public String getLaterReason() {
		return laterReason;
	}

	public void setLaterReason(String laterReason) {
		this.laterReason = laterReason;
	}

	public BigDecimal getRealCarry() {
		return realCarry;
	}
	public void setRealCarry(BigDecimal realCarry) {
		this.realCarry = realCarry;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getExpensens() {
		return expensens;
	}

	public void setExpensens(BigDecimal expensens) {
		this.expensens = expensens;
	}

	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public String getCarryNumber() {
		return carryNumber;
	}

	public void setCarryNumber(String carryNumber) {
		this.carryNumber = carryNumber;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getAccessorys() {
		return accessorys;
	}
	public void setAccessorys(String accessorys) {
		this.accessorys = accessorys;
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
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	public String getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(String customerOrder) {
		this.customerOrder = customerOrder;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getFeeTypecolumnSqlUpd() {
		return feeTypecolumnSqlUpd;
	}
	public void setFeeTypecolumnSqlUpd(String feeTypecolumnSqlUpd) {
		this.feeTypecolumnSqlUpd = feeTypecolumnSqlUpd;
	}
	
	public String getGetFeeTypecolumn() {
		return getFeeTypecolumn;
	}
	public void setGetFeeTypecolumn(String getFeeTypecolumn) {
		this.getFeeTypecolumn = getFeeTypecolumn;
	}
	
	public String getFeeTypeValue() {
		return feeTypeValue;
	}
	public void setFeeTypeValue(String feeTypeValue) {
		this.feeTypeValue = feeTypeValue;
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
