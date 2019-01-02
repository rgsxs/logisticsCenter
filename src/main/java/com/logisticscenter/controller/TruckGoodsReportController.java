package com.logisticscenter.controller;

import com.common.CommonTransMethod;
import com.common.ConvertService;
import com.general.BaseBean;
import com.idgenerate.DefaultIdGenerator;
import com.javabean.*;
import com.logisticscenter.service.FeeTypeService;
import com.logisticscenter.service.ImageFileService;
import com.logisticscenter.service.TruckGoodsOrderService;
import com.logisticscenter.service.TruckGoodsReportService;
import com.util.ConstantUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping(value = "/api/truckGoodsReport")
public class TruckGoodsReportController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TruckGoodsReportController(){
		
	}
	
	private TruckGoodsReportService truckGoodsReportService;
	
	/**
	 * 出车预录信息service
	 */
	private TruckGoodsOrderService truckGoodsOrderService;
	
	private ImageFileService imageFileService;
	
	private CommonTransMethod commonTransMethod;
	
	//注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
    private File file[];
    
    //提交过来的file的名字
    private String fileFileName[];
    
    //提交过来的file的MIME类型
    private String fileContentType[];
	
	
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
	//客户货物类型
	private String goodsType;
	//是否预支费用
	private int prepaidFlg;
	//预支费用
	private BigDecimal prepaidExpress;
	//预支费用说明
	private String prepaidDesc;
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
	//返回值状态
	private boolean status;
	//备注
	private String remark;
	//客户订单编号
	private String customerOrder;
	//是否结算运费
	private String settlement;
	//获得所有费用类型
	private String getFeeTypeColumn;
	//拼接的更新费用类型SQL
	private String feeTypecolumnSqlUpd;

	//预录新增页面多条增加货物类型用
	private String goodsTypeRow;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public String getGetFeeTypeColumn() {
		return getFeeTypeColumn;
	}

	public void setGetFeeTypeColumn(String getFeeTypeColumn) {
		this.getFeeTypeColumn = getFeeTypeColumn;
	}

	public String getFeeTypecolumnSqlUpd() {
		return feeTypecolumnSqlUpd;
	}

	public void setFeeTypecolumnSqlUpd(String feeTypecolumnSqlUpd) {
		this.feeTypecolumnSqlUpd = feeTypecolumnSqlUpd;
	}

	public TruckGoodsReportService getTruckGoodsReportService() {
		return truckGoodsReportService;
	}

	public void setTruckGoodsReportService(
			TruckGoodsReportService truckGoodsReportService) {
		this.truckGoodsReportService = truckGoodsReportService;
	}
	
	public CommonTransMethod getCommonTransMethod() {
		return commonTransMethod;
	}

	public void setCommonTransMethod(CommonTransMethod commonTransMethod) {
		this.commonTransMethod = commonTransMethod;
	}
	
	//获得费用类型字段用
	private FeeTypeService feeTypeService;

	public FeeTypeService getFeeTypeService() {
		return feeTypeService;
	}

	public void setFeeTypeService(FeeTypeService feeTypeService) {
		this.feeTypeService = feeTypeService;
	}
	
	

	public TruckGoodsOrderService getTruckGoodsOrderService() {
		return truckGoodsOrderService;
	}

	public void setTruckGoodsOrderService(
			TruckGoodsOrderService truckGoodsOrderService) {
		this.truckGoodsOrderService = truckGoodsOrderService;
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

	public String getGoodsTypeRow() {
		return goodsTypeRow;
	}

	public void setGoodsTypeRow(String goodsTypeRow) {
		this.goodsTypeRow = goodsTypeRow;
	}
	
	public File[] getFile() {
		return file;
	}

	public void setFile(File[] file) {
		this.file = file;
	}

	public String[] getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String[] fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String[] getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String[] fileContentType) {
		this.fileContentType = fileContentType;
	}

	public ImageFileService getImageFileService() {
		return imageFileService;
	}

	public void setImageFileService(ImageFileService imageFileService) {
		this.imageFileService = imageFileService;
	}
	/**
	 * 增加出车信息
	 */
	public String addTruckGoodsReport(){
		TruckGoodsReportBean bean = new TruckGoodsReportBean( truckPart,partner,partnerPrice,partnerCarry,packagePrice,invoiceFlg,packageFlg,truckNumber, reportId, startPlace, endPlace, beginDate, expectedDate, endDate, driver, client, goodsType,prepaidFlg,prepaidExpress,prepaidDesc, reportStatus, isLater, laterReason, realCarry, price, expensens, carryNumber, workPlace,remark,customerOrder,settlement, "","", "");
		int maxId = truckGoodsReportService.insertTruckGoodsReport(bean);
		this.status = maxId > 0?true:false;
		return "success";
	}
	
	/**
	 * 模态框增加信息用
	 */
	public String addTruckGoodsReport1(HttpServletRequest request){
		TruckGoodsReportBean bean = new TruckGoodsReportBean( truckPart,partner,partnerPrice,partnerCarry,packagePrice,invoiceFlg,packageFlg,truckNumber, reportId, startPlace, endPlace, beginDate, expectedDate, endDate, driver, client, goodsType,prepaidFlg,prepaidExpress,prepaidDesc, reportStatus, isLater, laterReason, realCarry, price, expensens, carryNumber, workPlace,remark,customerOrder,settlement,"", "", "");
		int maxId = truckGoodsReportService.insertTruckGoodsReport(bean);
		int rows = ConvertService.getIntValue(goodsTypeRow,0);
		if(rows>0){
			for(int i=1;i<rows;i++){
				if(null !=request.getParameter("goodsType_"+i)){
					System.out.println("rows===="+i);
				}
			}
			
		}
		this.status = maxId > 0?true:false;
		return "success";
	}
	
	/**
	 * 出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public Map selectAllTruckGoodsReport(HttpServletRequest request){

		//根据状态获得出车信息:0:预录,1:确认,2:全部出车车辆
		String reportStatus = ConvertService.null2String(request.getParameter("reportStatus"),"0");
		List<TruckGoodsReportBean> beanLst= truckGoodsReportService.getAllTruckGoodsReport(reportStatus);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("truckNumber",CommonTransMethod.getTruckNumber(beanLst.get(i).getTruckNumber()));
				beanMap.put("startPlace",beanLst.get(i).getStartPlace());
				beanMap.put("endPlace",beanLst.get(i).getEndPlace());
				beanMap.put("beginDate",beanLst.get(i).getBeginDate());
				beanMap.put("expectedDate",beanLst.get(i).getExpectedDate());
				beanMap.put("endDate",beanLst.get(i).getEndDate());
				beanMap.put("driver",CommonTransMethod.getDriverName(beanLst.get(i).getDriver()+""));
				beanMap.put("client",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				beanMap.put("goodsType",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				beanMap.put("prepaidFlg",beanLst.get(i).getPrepaidFlg());
				beanMap.put("prepaidExpress",beanLst.get(i).getPrepaidExpress());
				beanMap.put("prepaidDesc",beanLst.get(i).getPrepaidDesc());
				beanMap.put("reportStatus",beanLst.get(i).getReportStatus());
				beanMap.put("isLater",beanLst.get(i).getIsLater());
				beanMap.put("laterReason",beanLst.get(i).getLaterReason());
				beanMap.put("realCarry",beanLst.get(i).getRealCarry());
				beanMap.put("price",beanLst.get(i).getPrice());
				beanMap.put("expensens",beanLst.get(i).getExpensens());
				beanMap.put("cost",beanLst.get(i).getCost());
				beanMap.put("profit",beanLst.get(i).getProfit());
				beanMap.put("carryNumber",beanLst.get(i).getCarryNumber());
				beanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("editDate",beanLst.get(i).getEditDate());
				beanMap.put("editTime",beanLst.get(i).getEditTime());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("customerOrder",beanLst.get(i).getCustomerOrder());
				beanMap.put("settlement",beanLst.get(i).getSettlement());
				beanMap.put("count",getCount(beanLst.get(i).getRealCarry(),beanLst.get(i).getPrice()));
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("truckGoodsReport",result);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	/**
	 * 出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public Map selectTruckGoodsReportBy(HttpServletRequest request){

		truckNumber = ConvertService.null2String(request.getParameter("truckNumber"));
		reportStatus = ConvertService.getIntValue(request.getParameter("reportStatus"),-1);
		startPlace = ConvertService.null2String(request.getParameter("startPlace"));
		endPlace = ConvertService.null2String(request.getParameter("endPlace"));
		beginDate = ConvertService.null2String(request.getParameter("beginDate"));
		endDate = ConvertService.null2String(request.getParameter("endDate"));
		driver = ConvertService.getIntValue(request.getParameter("driver"),-1);
		client = ConvertService.getIntValue(request.getParameter("client"),-1);
		goodsType = ConvertService.null2String(request.getParameter("goodsType"),"0");
		carryNumber = ConvertService.null2String(request.getParameter("carryNumber"));
		
		TruckGoodsReportBean infoBean = new TruckGoodsReportBean( reportStatus,truckNumber, startPlace, endPlace, beginDate,endDate, driver, client, goodsType, carryNumber,pageSize,currentPage);
		infoBean.setGetFeeTypecolumn("");
		List<TruckGoodsReportBean> beanLst= truckGoodsReportService.getTruckGoodsReport(infoBean);
		//计算费用/盈利/运费的合计
		//合计费用
		BigDecimal totalCost = ConstantUtils.defaultDecimal;
		//合计盈利
		BigDecimal totalProfit = ConstantUtils.defaultDecimal;
		//合计运费
		BigDecimal totalExpensens = ConstantUtils.defaultDecimal;
		TruckGoodsReportBean beanSum= truckGoodsReportService.getTruckGoodsReportSum(infoBean);
		totalCost = beanSum.getCost();
		totalProfit = beanSum.getProfit();
		totalExpensens = beanSum.getExpensens();
		//获得分页信息,当currentPage==1的时候初始化pageCount
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = truckGoodsReportService.getTruckGoodsReportByCount(infoBean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			List result = new ArrayList();
			Map retResult = new HashMap();
			Map beanMap = null;
			Map detailbeanMap = null;
			List detailResultList = null;
			String truckOrders = "";
			for(int i = 0 ; i<beanLst.size(); i++){
				truckOrders += truckOrders.equals("")?beanLst.get(i).getId():","+beanLst.get(i).getId();
			}
			List<TruckGoodsReportDetailBean> detailLst =  new ArrayList<TruckGoodsReportDetailBean>();
			if(!truckOrders.equals("")){
				detailLst = truckGoodsReportService.getTruckGoodsReportDetail(truckOrders);
				//查询出车辆详细信息
			}
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				int reportId = beanLst.get(i).getId();
				int packageFlgExchange = Integer.parseInt(beanLst.get(i).getPackageFlg());
				int truckPartExchange = beanLst.get(i).getTruckPart();
				beanMap.put("id",reportId);
				beanMap.put("truckNumber",CommonTransMethod.getTruckNumber(beanLst.get(i).getTruckNumber()));
				beanMap.put("packageFlg",packageFlgExchange);
				beanMap.put("packageFlgShow",CommonTransMethod.convertPackage(packageFlgExchange));
				beanMap.put("packagePrice",ConvertService.getPointValue(beanLst.get(i).getPackagePrice()+"",2));
				beanMap.put("reportNumber",ConvertService.null2String(beanLst.get(i).getReportNumber()));
				beanMap.put("truckPart",beanLst.get(i).getTruckPart());
				beanMap.put("partner",beanLst.get(i).getPartner());
				beanMap.put("partnerPrice",ConvertService.getPointValue(beanLst.get(i).getPartnerPrice(),2));
				beanMap.put("partnerCarry",ConvertService.getPointValue(beanLst.get(i).getPartnerCarry(),2));
				beanMap.put("startPlace",beanLst.get(i).getStartPlace());
				beanMap.put("endPlace",beanLst.get(i).getEndPlace());
				beanMap.put("beginDate",beanLst.get(i).getBeginDate());
				beanMap.put("expectedDate",beanLst.get(i).getExpectedDate());
				beanMap.put("endDate",beanLst.get(i).getEndDate());
				beanMap.put("driver",CommonTransMethod.getDriverName(beanLst.get(i).getDriver()+""));
				beanMap.put("client",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				beanMap.put("goodsType",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				beanMap.put("prepaidFlg",beanLst.get(i).getPrepaidFlg());
				beanMap.put("prepaidExpress",beanLst.get(i).getPrepaidExpress());
				beanMap.put("prepaidDesc",beanLst.get(i).getPrepaidDesc());
				beanMap.put("reportStatus",beanLst.get(i).getReportStatus());
				beanMap.put("isLater",beanLst.get(i).getIsLater());
				beanMap.put("laterReason",beanLst.get(i).getLaterReason());
				beanMap.put("realCarry",beanLst.get(i).getRealCarry());
				beanMap.put("price",beanLst.get(i).getPrice());
				beanMap.put("carryNumber",beanLst.get(i).getCarryNumber());
				beanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("editDate",beanLst.get(i).getEditDate());
				beanMap.put("editTime",beanLst.get(i).getEditTime());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("customerOrder",beanLst.get(i).getCustomerOrder());
				beanMap.put("settlement",beanLst.get(i).getSettlement());
				
				//包车情况下,直接计算包车价格作为盈利
				//非包车情况下,要计算单价*重量
				beanMap.put("expensens",ConvertService.getPointValue(beanLst.get(i).getExpensens()+"",2));
				beanMap.put("cost",ConvertService.getPointValue(beanLst.get(i).getCost()+"",2));
				beanMap.put("profit",ConvertService.getPointValue(beanLst.get(i).getProfit()+"",2));
				beanMap.put("feeTypeTitle",getFeeTypeTitle(beanLst.get(i).getId()+""));
				//查询出车辆详细信息
				detailResultList = new ArrayList();
				for(int j = 0 ; j<detailLst.size(); j++){
					int detailReportId = detailLst.get(j).getTruckOrder();
					if(detailReportId == reportId){
						detailbeanMap = new HashMap();
						//注释掉的信息防止IO占用内容太大,
//						detailbeanMap.put("id",detailLst.get(j).getId());
//						detailbeanMap.put("reportId",detailLst.get(j).getTruckOrder());
						detailbeanMap.put("goodsType",detailLst.get(j).getGoodsType()+"");
						detailbeanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(detailLst.get(j).getGoodsType()+""));
						detailbeanMap.put("price",detailLst.get(j).getPrice());
						detailbeanMap.put("realCarry",detailLst.get(j).getRealCarry());
//						detailbeanMap.put("invoiceFlg",detailLst.get(j).getInvoiceFlg());
//						detailbeanMap.put("liftingCost",detailLst.get(j).getLiftingCost());
						detailbeanMap.put("startPlace",detailLst.get(j).getStartPlace());
						detailbeanMap.put("endPlace",detailLst.get(j).getEndPlace());
//						detailbeanMap.put("createDate",detailLst.get(j).getCreateDate());
//						detailbeanMap.put("createTime",detailLst.get(j).getCreateTime());
//						detailbeanMap.put("editDate",detailLst.get(j).getEditDate());
//						detailbeanMap.put("editTime",detailLst.get(j).getEditTime());
						detailResultList.add(detailbeanMap);
					}
				}
				beanMap.put("reportDetails",detailResultList);
				result.add( beanMap);
			}
			//设置总共合计
			retResult.put("totalCost",totalCost);
			retResult.put("totalProfit",totalProfit);
			retResult.put("totalExpensens",totalExpensens);
			retResult.put("truckGoodsReport",result);
			retResult.put("pageCount",pageCount);
			retResult.put("currentPage",currentPage);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	
	/**
	 * 出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public Map selectTruckGoodsFeeTypeBy(HttpServletRequest request){

		truckNumber = ConvertService.null2String(request.getParameter("truckNumber"));
		reportStatus = ConvertService.getIntValue(request.getParameter("reportStatus"),-1);
		startPlace = ConvertService.null2String(request.getParameter("startPlace"));
		endPlace = ConvertService.null2String(request.getParameter("endPlace"));
		beginDate = ConvertService.null2String(request.getParameter("beginDate"));
		endDate = ConvertService.null2String(request.getParameter("endDate"));
		driver = ConvertService.getIntValue(request.getParameter("driver"),-1);
		client = ConvertService.getIntValue(request.getParameter("client"),-1);
		goodsType = ConvertService.null2String(request.getParameter("goodsType"),"0");
		carryNumber = ConvertService.null2String(request.getParameter("carryNumber"));
		
		TruckGoodsReportBean infoBean = new TruckGoodsReportBean( reportStatus,truckNumber, startPlace, endPlace, beginDate,endDate, driver, client, goodsType, carryNumber,pageSize,currentPage);
		
		//获得费用的 对应关系  start
		int countFeeType=0;
		List<FeeTypeBean> feeTypeBeanLst= feeTypeService.getAllFeeType();
		String getFeeTypeColumn = "";
		String getFeeTypeColumnName = "";
		for(int i = 0 ; i<feeTypeBeanLst.size(); i++){
			if(feeTypeBeanLst.get(i).getIsUse() == 0) continue;
			getFeeTypeColumn +="+','+isnull("+feeTypeBeanLst.get(i).getFeeTypeColumn()+",0)";
			getFeeTypeColumnName +=","+feeTypeBeanLst.get(i).getFeeName();
			countFeeType++;
		}
		if(!getFeeTypeColumn.equals("")){
			getFeeTypeColumn = getFeeTypeColumn.substring(5,getFeeTypeColumn.length());
			getFeeTypeColumnName = getFeeTypeColumnName.substring(1,getFeeTypeColumnName.length());
		}
		infoBean.setGetFeeTypecolumn(getFeeTypeColumn);
		
		//获得费用的 对应关系  end
		List<TruckGoodsReportBean> beanLst= truckGoodsReportService.getTruckGoodsReport(infoBean);
		//获得分页信息,当currentPage==1的时候初始化pageCount
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = truckGoodsReportService.getTruckGoodsReportByCount(infoBean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			List result = new ArrayList();
			Map retResult = new HashMap();
			Map beanMap = null;
			List feeTypeSumValueList = new ArrayList();
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				int packageFlgExchange = Integer.parseInt(beanLst.get(i).getPackageFlg());
				int truckPartExchange = beanLst.get(i).getTruckPart();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("truckNumber",CommonTransMethod.getTruckNumber(beanLst.get(i).getTruckNumber()));
				beanMap.put("packageFlg",packageFlgExchange);
				beanMap.put("packageFlgShow",CommonTransMethod.convertPackage(packageFlgExchange));
				beanMap.put("packagePrice",ConvertService.getPointValue(beanLst.get(i).getPackagePrice()+"",2));
				beanMap.put("reportNumber",ConvertService.null2String(beanLst.get(i).getReportNumber()));
				beanMap.put("truckPart",beanLst.get(i).getTruckPart());
				beanMap.put("partner",beanLst.get(i).getPartner());
				beanMap.put("partnerPrice",ConvertService.getPointValue(beanLst.get(i).getPartnerPrice(),2));
				beanMap.put("partnerCarry",ConvertService.getPointValue(beanLst.get(i).getPartnerCarry(),2));
				beanMap.put("startPlace",beanLst.get(i).getStartPlace());
				beanMap.put("endPlace",beanLst.get(i).getEndPlace());
				beanMap.put("beginDate",beanLst.get(i).getBeginDate());
				beanMap.put("expectedDate",beanLst.get(i).getExpectedDate());
				beanMap.put("endDate",beanLst.get(i).getEndDate());
				beanMap.put("driver",CommonTransMethod.getDriverName(beanLst.get(i).getDriver()+""));
				beanMap.put("client",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				beanMap.put("goodsType",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				beanMap.put("prepaidFlg",beanLst.get(i).getPrepaidFlg());
				beanMap.put("prepaidExpress",beanLst.get(i).getPrepaidExpress());
				beanMap.put("prepaidDesc",beanLst.get(i).getPrepaidDesc());
				beanMap.put("reportStatus",beanLst.get(i).getReportStatus());
				beanMap.put("isLater",beanLst.get(i).getIsLater());
				beanMap.put("laterReason",beanLst.get(i).getLaterReason());
				beanMap.put("realCarry",beanLst.get(i).getRealCarry());
				beanMap.put("price",beanLst.get(i).getPrice());
				beanMap.put("carryNumber",beanLst.get(i).getCarryNumber());
				beanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("editDate",beanLst.get(i).getEditDate());
				beanMap.put("editTime",beanLst.get(i).getEditTime());
				beanMap.put("remark",beanLst.get(i).getRemark());
				//包车情况下,直接计算包车价格作为盈利
				//非包车情况下,要计算单价*重量
				beanMap.put("expensens",ConvertService.getPointValue(beanLst.get(i).getExpensens()+"",2));
				if(packageFlgExchange == 0){
					beanMap.put("cost",ConvertService.getPointValue(beanLst.get(i).getCost()+"",2));
				}else{
					beanMap.put("cost",ConvertService.getPointValue(beanLst.get(i).getPackagePrice()+"",2));
				}
				if(truckPartExchange==1){
					beanMap.put("cost",getTruckPartnerCount(beanLst.get(i).getId()+"",beanMap.get("partnerPrice")+""));
				}
				beanMap.put("profit",ConvertService.getPointValue(beanLst.get(i).getProfit()+"",2));
				result.add( beanMap);
			}
			retResult.put("truckGoodsReport",result);
			retResult.put("pageCount",pageCount);
			retResult.put("currentPage",currentPage);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	
	/**
	 * 出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public Map selectTruckGoodsAssetBy(HttpServletRequest request){

		truckNumber = ConvertService.null2String(request.getParameter("truckNumber"));
		reportStatus = ConvertService.getIntValue(request.getParameter("reportStatus"),-1);
		startPlace = ConvertService.null2String(request.getParameter("startPlace"));
		endPlace = ConvertService.null2String(request.getParameter("endPlace"));
		beginDate = ConvertService.null2String(request.getParameter("beginDate"));
		endDate = ConvertService.null2String(request.getParameter("endDate"));
		driver = ConvertService.getIntValue(request.getParameter("driver"),-1);
		client = ConvertService.getIntValue(request.getParameter("client"),-1);
		goodsType = ConvertService.null2String(request.getParameter("goodsType"),"0");
		carryNumber = ConvertService.null2String(request.getParameter("carryNumber"));
		
		TruckGoodsReportBean infoBean = new TruckGoodsReportBean( reportStatus,truckNumber, startPlace, endPlace, beginDate,endDate, driver, client, goodsType, carryNumber,pageSize,currentPage);
		
		//获得费用的 对应关系  start
		int countFeeType=0;
		List<FeeTypeBean> feeTypeBeanLst= feeTypeService.getAllFeeType();
		String getFeeTypeColumn = "";
		String getFeeTypeColumnName = "";
		for(int i = 0 ; i<feeTypeBeanLst.size(); i++){
			if(feeTypeBeanLst.get(i).getIsUse() == 0) continue;
			getFeeTypeColumn +="+','+isnull("+feeTypeBeanLst.get(i).getFeeTypeColumn()+",0)";
			getFeeTypeColumnName +=","+feeTypeBeanLst.get(i).getFeeName();
			countFeeType++;
		}
		if(!getFeeTypeColumn.equals("")){
			getFeeTypeColumn = getFeeTypeColumn.substring(5,getFeeTypeColumn.length());
			getFeeTypeColumnName = getFeeTypeColumnName.substring(1,getFeeTypeColumnName.length());
		}
		infoBean.setGetFeeTypecolumn(getFeeTypeColumn);
		
		//获得费用的 对应关系  end
		List<TruckGoodsReportBean> beanLst= truckGoodsReportService.getTruckGoodsReport(infoBean);
		//获得分页信息,当currentPage==1的时候初始化pageCount
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = truckGoodsReportService.getTruckGoodsReportByCount(infoBean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			List result = new ArrayList();
			Map retResult = new HashMap();
			Map beanMap = null;
			List feeTypeSumValueList = new ArrayList();
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				int packageFlgExchange = Integer.parseInt(beanLst.get(i).getPackageFlg());
				int truckPartExchange = beanLst.get(i).getTruckPart();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("truckNumber",CommonTransMethod.getTruckNumber(beanLst.get(i).getTruckNumber()));
				beanMap.put("packageFlg",packageFlgExchange);
				beanMap.put("packageFlgShow",CommonTransMethod.convertPackage(packageFlgExchange));
				beanMap.put("packagePrice",ConvertService.getPointValue(beanLst.get(i).getPackagePrice()+"",2));
				beanMap.put("reportNumber",ConvertService.null2String(beanLst.get(i).getReportNumber()));
				beanMap.put("truckPart",beanLst.get(i).getTruckPart());
				beanMap.put("partner",beanLst.get(i).getPartner());
				beanMap.put("partnerPrice",ConvertService.getPointValue(beanLst.get(i).getPartnerPrice(),2));
				beanMap.put("partnerCarry",ConvertService.getPointValue(beanLst.get(i).getPartnerCarry(),2));
				beanMap.put("startPlace",beanLst.get(i).getStartPlace());
				beanMap.put("endPlace",beanLst.get(i).getEndPlace());
				beanMap.put("beginDate",beanLst.get(i).getBeginDate());
				beanMap.put("expectedDate",beanLst.get(i).getExpectedDate());
				beanMap.put("endDate",beanLst.get(i).getEndDate());
				beanMap.put("driver",CommonTransMethod.getDriverName(beanLst.get(i).getDriver()+""));
				beanMap.put("client",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				beanMap.put("goodsType",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				beanMap.put("prepaidFlg",beanLst.get(i).getPrepaidFlg());
				beanMap.put("prepaidExpress",beanLst.get(i).getPrepaidExpress());
				beanMap.put("prepaidDesc",beanLst.get(i).getPrepaidDesc());
				beanMap.put("reportStatus",beanLst.get(i).getReportStatus());
				beanMap.put("isLater",beanLst.get(i).getIsLater());
				beanMap.put("laterReason",beanLst.get(i).getLaterReason());
				beanMap.put("realCarry",beanLst.get(i).getRealCarry());
				beanMap.put("price",beanLst.get(i).getPrice());
				beanMap.put("expensens",getAllFee(beanLst.get(i).getId()+""));
				beanMap.put("carryNumber",beanLst.get(i).getCarryNumber());
				beanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("editDate",beanLst.get(i).getEditDate());
				beanMap.put("editTime",beanLst.get(i).getEditTime());
				beanMap.put("remark",beanLst.get(i).getRemark());
				//包车情况下,直接计算包车价格作为盈利
				//非包车情况下,要计算单价*重量
				beanMap.put("expensens",ConvertService.getPointValue(beanLst.get(i).getExpensens()+"",2));
				beanMap.put("cost",ConvertService.getPointValue(beanLst.get(i).getCost()+"",2));
				beanMap.put("profit",ConvertService.getPointValue(beanLst.get(i).getProfit()+"",2));
				result.add( beanMap);
			}
			retResult.put("truckGoodsReport",result);
			retResult.put("feeTypeSumValue",feeTypeSumValue(feeTypeSumValueList,countFeeType));
			retResult.put("pageCount",pageCount);
			retResult.put("currentPage",currentPage);
			retResult.put("feeCount",countFeeType);
			
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	
	/**
	 * 删除出车信息
	 */
	public Map deleteTruckGoodsReport(HttpServletRequest request){

		String ids = request.getParameter("truckGoodsReports");
		int count = truckGoodsReportService.deleteTruckGoodsReport(ids);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			if(count>0){
				retResult.put("result","1");
			}else{
				retResult.put("result","0");
			}
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	
	/**
	 * 出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public Map selectTruckGoodsReportById(HttpServletRequest request){

		id = ConvertService.getIntValue((request.getParameter("reportId")),0);
		TruckGoodsReportBean bean= truckGoodsReportService.getTruckGoodsReport(id+"");
		List<FeeTypeBean> beanLst= feeTypeService.getAllFeeType();
		//设置reportStatus,通过jsp取得reportStatus来判断是否有保存.提交按钮还是查看按钮
		reportStatus = bean.getReportStatus();
		String feeColumnDiv = "";
		String feeColumnHTML = "";
		String feeColumnHidden = "";
		for(int i = 0 ; i<beanLst.size(); i++){
			if(beanLst.get(i).getIsUse() == 0) continue;
			String column = beanLst.get(i).getFeeTypeColumn();
			Map<String,String> feeTypeValueMap = getColumn(id+"",column);
			String feeTypeValue = ConvertService.null2String(feeTypeValueMap.get(column), "0");
			if(i%4 == 0){
				feeColumnDiv += "<div class=\"form-group\">";
			}
			feeColumnDiv += "<label class=\"col-sm-1 control-label\">"+beanLst.get(i).getFeeName()+"</label>";
			feeColumnDiv +="<div class=\"col-sm-2\">";
			feeColumnDiv += "<input class=\"form-control1\" dataType=\"feeType\" id="+beanLst.get(i).getFeeTypeColumn()+" name="+beanLst.get(i).getFeeTypeColumn()
			+" placeholder="+beanLst.get(i).getFeeName()
			+" value="+feeTypeValue+" onblur=\"countFee()\">";
			feeColumnDiv += "</div>";
			if(i%4 == 3){
				feeColumnDiv += "</div>";
			}
			feeColumnHidden += "".equals(feeColumnHidden)?beanLst.get(i).getFeeTypeColumn():","+beanLst.get(i).getFeeTypeColumn();
		}
		if(!feeColumnDiv.endsWith("</div></div>")){
			feeColumnDiv = feeColumnDiv+"</div>";
		}
		feeColumnHidden = "<input type=\"hidden\" id=\"getFeeTypeColumn\" name=\"getFeeTypeColumn\" value="+feeColumnHidden+">";
		feeColumnHTML = feeColumnHidden + feeColumnDiv;
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			List result = new ArrayList();
			Map beanMap = null;
			beanMap = new HashMap();
			//设置订单详细信息
			beanMap.put("id",bean.getId());
			beanMap.put("truckNumberShow",CommonTransMethod.getTruckNumber(bean.getTruckNumber()));
			beanMap.put("truckNumber",bean.getTruckNumber());
			beanMap.put("reportNumber",bean.getReportNumber());
			beanMap.put("reportId",bean.getReportId());
			beanMap.put("packageFlg",bean.getPackageFlg());
			beanMap.put("packagePrice",ConvertService.null2String(bean.getPackagePrice()+""));
			beanMap.put("invoiceFlg",bean.getInvoiceFlg());
			beanMap.put("truckPart",bean.getTruckPart());
			beanMap.put("partner",bean.getPartner());
			beanMap.put("partnerPrice",bean.getPartnerPrice());
			beanMap.put("partnerCarry",bean.getPartnerCarry());
			beanMap.put("startPlace",bean.getStartPlace());
			beanMap.put("endPlace",bean.getEndPlace());
			beanMap.put("beginDate",bean.getBeginDate());
			beanMap.put("expectedDate",bean.getExpectedDate());
			beanMap.put("endDate",bean.getEndDate());
			beanMap.put("driver",bean.getDriver());
			beanMap.put("driverShow",CommonTransMethod.getDriverName(bean.getDriver()+""));
			beanMap.put("client",bean.getClient());
			beanMap.put("clientShow",CommonTransMethod.getClientName(bean.getClient()+""));
			beanMap.put("goodsType",bean.getGoodsType());
			beanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(bean.getGoodsType()+""));
			beanMap.put("prepaidFlg",bean.getPrepaidFlg());
			beanMap.put("prepaidExpress",bean.getPrepaidExpress());
			beanMap.put("prepaidDesc",bean.getPrepaidDesc());
			beanMap.put("reportStatus",bean.getReportStatus());
			beanMap.put("isLater",bean.getIsLater());
			beanMap.put("laterReason",bean.getLaterReason());
			beanMap.put("realCarry",bean.getRealCarry());
			beanMap.put("price",bean.getPrice());
			beanMap.put("expensens",bean.getExpensens());
			beanMap.put("cost",bean.getCost());
			beanMap.put("profit",bean.getProfit());
			beanMap.put("carryNumber",bean.getCarryNumber());
			beanMap.put("workPlace",bean.getWorkPlace());
			beanMap.put("accessorys",bean.getAccessorys());
			beanMap.put("fileNames",CommonTransMethod.getFileName(bean.getAccessorys()));
			beanMap.put("createDate",bean.getCreateDate());
			beanMap.put("createTime",bean.getCreateTime());
			beanMap.put("editDate",bean.getEditDate());
			beanMap.put("editTime",bean.getEditTime());
			beanMap.put("remark",bean.getRemark());
			beanMap.put("customerOrder",bean.getCustomerOrder());
			beanMap.put("settlement",bean.getSettlement());
			beanMap.put("count",getCount(bean.getRealCarry(),bean.getPrice()));
			beanMap.put("feeColumnHtml",feeColumnHTML);
			retResult.put("truckGoodsReport",beanMap);
			//设置订单中货物类型详细信息
			TruckGoodsReportDetailBean selectInfo = new TruckGoodsReportDetailBean();
			selectInfo.setTruckOrder(bean.getId());
			//TruckGoodsOrderDetailBean中需要新建一个select用goodsType,selectGoodsTypes字段用于检索
			List<TruckGoodsReportDetailBean> detailLst = truckGoodsReportService.getTruckGoodsReportDetail(selectInfo);
			Map orderDetailbeanMap = null;
			//查询出车辆详细信息
			for(int i = 0 ; i<detailLst.size(); i++){
				orderDetailbeanMap = new HashMap();
				orderDetailbeanMap.put("id",detailLst.get(i).getId());
				orderDetailbeanMap.put("reportId",detailLst.get(i).getTruckOrder());
				orderDetailbeanMap.put("goodsType",detailLst.get(i).getGoodsType()+"");
				orderDetailbeanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(detailLst.get(i).getGoodsType()+""));
				orderDetailbeanMap.put("price",detailLst.get(i).getPrice());
				orderDetailbeanMap.put("realCarry",detailLst.get(i).getRealCarry());
				orderDetailbeanMap.put("invoiceFlg",detailLst.get(i).getInvoiceFlg());
				orderDetailbeanMap.put("liftingCost",detailLst.get(i).getLiftingCost());
				orderDetailbeanMap.put("startPlace",detailLst.get(i).getStartPlace());
				orderDetailbeanMap.put("endPlace",detailLst.get(i).getEndPlace());
				orderDetailbeanMap.put("createDate",detailLst.get(i).getCreateDate());
				orderDetailbeanMap.put("createTime",detailLst.get(i).getCreateTime());
				orderDetailbeanMap.put("editDate",detailLst.get(i).getEditDate());
				orderDetailbeanMap.put("editTime",detailLst.get(i).getEditTime());
				result.add( orderDetailbeanMap);
			}
			retResult.put("truckGoodsOrderDetail",result);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	/**
	 * @return 通过出车回执页面更新出车信息
	 */
	public String updateApproveReportById(HttpServletRequest request){

		id = ConvertService.getIntValue((request.getParameter("reportId")),0);
		String columnsArr[] = getFeeTypeColumn.split(",");
		String columnId = "";
		String columnName = "";
		reportStatus = ConvertService.getIntValue((String)request.getParameter("reportStatus"),0);
		StringBuffer updateSqlSb = new StringBuffer();
		//初始化cost,profit,expensens
//		cost = ConstantUtils.defaultDecimal;
//		profit = ConstantUtils.defaultDecimal;
//		expensens = ConstantUtils.defaultDecimal;
		for(int i = 0;i < columnsArr.length;i++){
			columnId = columnsArr[i];
			columnName = ConvertService.null2String(request.getParameter(columnId));
			if(columnName.equals("")){
				columnName = "''";
			}
			updateSqlSb.append(columnId).append("=").append(columnName).append(",");
//			cost = ConvertService.getDecimalValue(columnName, ConstantUtils.defaultDecimal).add(cost);
		}
		feeTypecolumnSqlUpd = updateSqlSb.toString();
		if(feeTypecolumnSqlUpd.endsWith(",")){
			feeTypecolumnSqlUpd = feeTypecolumnSqlUpd.substring(0,feeTypecolumnSqlUpd.length()-1);
		}
		//上传附件
		String accessoryIds =ConvertService.null2String(accessorys);
//		String uploadIds = uploadFile(request);
//		if(!uploadIds.equals("")){
//			if(accessoryIds.equals("")){
//				accessoryIds = uploadFile(request);
//			}else{
//				accessoryIds +=  ","+uploadFile(request);
//			}
//		}
		
		TruckGoodsReportBean bean = new TruckGoodsReportBean( truckPart,partner,partnerPrice,partnerCarry,packagePrice,invoiceFlg,packageFlg,truckNumber, reportId, 
				startPlace, endPlace, beginDate, expectedDate, endDate, driver, client, goodsType,prepaidFlg,prepaidExpress,prepaidDesc, reportStatus, 
				isLater, laterReason, realCarry, price, expensens, carryNumber, workPlace,remark,customerOrder,settlement, accessoryIds,id+"", feeTypecolumnSqlUpd);
		truckGoodsReportService.updateTruckGoodsReport(bean);
		status=true;
		//更新出车货物详细重量,吊费
		String ids = ConvertService.null2String(request.getParameter("ids"));
		if(ids.equals("")){
			//记录日志,说明要更新的货物详细错误
		}
		String idsArr[] = ids.split(",");
		BigDecimal realCarry=ConstantUtils.defaultDecimal;
		BigDecimal price=ConstantUtils.defaultDecimal;
		BigDecimal liftingCost=ConstantUtils.defaultDecimal;
		for(int i=0;i<idsArr.length;i++){
			if(!ids.equals("")){
				price = ConvertService.getDecimalValue(request.getParameter("price_"+idsArr[i]), ConstantUtils.defaultDecimal);
				realCarry = ConvertService.getDecimalValue(request.getParameter("realCarry_"+idsArr[i]), ConstantUtils.defaultDecimal);
				liftingCost = ConvertService.getDecimalValue(request.getParameter("liftingCost_"+idsArr[i]), ConstantUtils.defaultDecimal);
				TruckGoodsReportDetailBean detailBean = new TruckGoodsReportDetailBean();
				detailBean.setRealCarry(realCarry);
				detailBean.setId(ConvertService.getIntValue(idsArr[i],0));
				detailBean.setLiftingCost(liftingCost);
				truckGoodsReportService.updateTruckGoodsReportDetail(detailBean);
//				expensens = (price.multiply(realCarry)).add(expensens);
			}
		}
//		profit = expensens.subtract(cost);
		//专门更新运费/费用/盈利
		TruckGoodsReportBean bean1 = new TruckGoodsReportBean(id,expensens,cost,profit);
		truckGoodsReportService.updateTruckGoodsReportExpense(bean1);
		return "success";
	}
	
	/**
	 * @param carry 载重
	 * @param price 单价
	 * @return 出车费用
	 */
	public String getCount(BigDecimal carry,BigDecimal price){
		
		String count="异常";
		try{
			count = carry.multiply(price).doubleValue() +"";
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}
	
	public Map getColumn(String reportId,String columnName){
		String columnValue = "";
		Map feeTypeValue = new HashMap();
		FeeTypeValueBean typeBean = new FeeTypeValueBean();
		List<FeeTypeValueBean> feeTypeValueList = new ArrayList<FeeTypeValueBean>();
		feeTypeValueList = truckGoodsReportService.getColumnValue(reportId,columnName);
		for(int i=0;i<feeTypeValueList.size();i++){
			typeBean = feeTypeValueList.get(i);
			feeTypeValue.put(typeBean.getFeeType(), typeBean.getFeeTypeValue());
		}
		return feeTypeValue;
		
	}
	
	public String feeTypeSumValue(List feeTypeSumList,int countFeeType){
		BigDecimal sumValueHTMLAr[] = new BigDecimal[countFeeType];
		String sumValueHTML="";
		for(int i=0;i<feeTypeSumList.size();i++){
			if(!feeTypeSumList.get(i).equals("")){
				String arr1[] = ((String) feeTypeSumList.get(i)).split(",");
				if(arr1.length == countFeeType){
					for(int j=0;j<countFeeType;j++){
						sumValueHTMLAr[j] = ConvertService.getDecimalValue(sumValueHTMLAr[j]+"",ConstantUtils.defaultDecimal).add(ConvertService.getDecimalValue(arr1[j],ConstantUtils.defaultDecimal));
					}
					
				}
			}
		}
		for(int i=0;i<sumValueHTMLAr.length;i++){
			sumValueHTML+="<td>"+sumValueHTMLAr[i]+"</td>";
		}
		return sumValueHTML;
		
	}
	
	public String getFeeTypeTitle(String id){
		//获得费用的title
		List<FeeTypeBean> beanLst= feeTypeService.getAllFeeType();
		String feeTypeTitle = "";
		String feeName = "";
		String columnName="";
		String br = "\n";
		if(beanLst!=null){
			String feeTypeColumns = ConstantUtils.getFeeTypeColumns();
			if(feeTypeColumns.equals("")){
				return "";
			}
			Map<String,String> feeTypeValue = getColumn(id,feeTypeColumns);
			for(int i = 0 ; i<beanLst.size(); i++){
				if(beanLst.get(i).getIsUse() == 0 || beanLst.get(i).getShowType() == 3) continue;
				feeName = beanLst.get(i).getFeeName();
				columnName = beanLst.get(i).getFeeTypeColumn();
				feeTypeColumns+=beanLst.get(i).getFeeTypeColumn();
				feeTypeTitle+=feeName+" : "+ConvertService.null2String((String)feeTypeValue.get(columnName),"0")+br;
			}
		}
		return feeTypeTitle;
	}
	
	public String getAllFee(String id){
		//获得费用的title
		List<FeeTypeBean> beanLst= feeTypeService.getAllFeeType();
		float allFee = 0F;
		if(beanLst!=null){
			String feeTypeColumns = ConstantUtils.getFeeTypeColumns();
			if(feeTypeColumns.equals("")){
				return "";
			}
			Map<String,String> feeTypeValue = getColumn(id,feeTypeColumns);
			for(String key: feeTypeValue.keySet()){
				allFee+=ConvertService.getFloatValue(feeTypeValue.get(key),0f);
			}
			
		}
		return ConvertService.getPointValue(allFee+"");
	}
	
	public String getAllFeeValue(String columnIds,String columnValues){
		BaseBean bs = new BaseBean();
		String feeValueHtml = "";
		if(columnIds.equals("")){
			feeValueHtml = "";
		}else{
			String arr1[] = columnIds.split(",");
			String arr2[] = columnValues.split(",");
			if(arr1.length != arr2.length){
				bs.writeLog("-----取得费用值错误日志----- 取得的feeColumn和返回feeColumnValue不匹配");
				feeValueHtml = "";
			}else{
				for(int i=0;i<arr1.length;i++){
					feeValueHtml+="<td>"+arr2[i]+"</td>";
				}
			}
			
		}
		
		return feeValueHtml;
	}
	
	/**
	 * @param id
	 * @return
	 */
	public String getAllCount(String id){
		float allCount = 0F;
		//设置订单中货物类型详细信息
		TruckGoodsReportDetailBean selectInfo = new TruckGoodsReportDetailBean();
		selectInfo.setTruckOrder(Integer.parseInt(id));
		//TruckGoodsOrderDetailBean中需要新建一个select用goodsType,selectGoodsTypes字段用于检索
		List<TruckGoodsReportDetailBean> detailLst = truckGoodsReportService.getTruckGoodsReportDetail(selectInfo);
		//查询出车辆详细信息
		for(int i = 0 ; i<detailLst.size(); i++){
			allCount += detailLst.get(i).getRealCarry().multiply(detailLst.get(i).getPrice()).doubleValue();
		}
		return ConvertService.getPointValue(allCount+"");
	}
	
	/**
	 * @param id
	 * @param partnerPrice
	 * @return
	 */
	public String getTruckPartnerCount(String id,String partnerPrice){
		float allCount = 0F;
		//设置订单中货物类型详细信息
		TruckGoodsReportDetailBean selectInfo = new TruckGoodsReportDetailBean();
		selectInfo.setTruckOrder(Integer.parseInt(id));
		//TruckGoodsOrderDetailBean中需要新建一个select用goodsType,selectGoodsTypes字段用于检索
		List<TruckGoodsReportDetailBean> detailLst = truckGoodsReportService.getTruckGoodsReportDetail(selectInfo);
		//首先计算接货价格和给伙伴的价格差
		BigDecimal b1 = new BigDecimal(partnerPrice);
		//查询出车辆详细信息
		for(int i = 0 ; i<detailLst.size(); i++){
			BigDecimal b2 = detailLst.get(i).getPrice().subtract(b1);
			allCount += detailLst.get(i).getRealCarry().multiply(b2).doubleValue();
		}
		return ConvertService.getPointValue(allCount+"");
	}
	
	
	public Map uploadFile(HttpServletRequest request){
		String ids = "";
		String retId = "";
		Map retResult = new HashMap();
		try{
			//设置目录
			String dateTemp=ConvertService.getDate();;
			String root = "D:\\temp\\"+dateTemp+"\\"+reportNumber;
			if(!new File(root).isDirectory()){
				new File(root).mkdirs();
			}
			DefaultIdGenerator idGenerator = new DefaultIdGenerator();
			if(file==null){
				return retResult;
			}
			for(int i = 0;i<file.length;i++){
				//获得唯一序列号
				InputStream is = new FileInputStream(file[i]);
				String fileArr[] = fileFileName[i].split("\\.");
				String fileName = fileArr[0];
				String suffix = fileArr[1];
				String contentType = fileContentType[i];
				String realName = idGenerator.next();
				OutputStream os = new FileOutputStream(new File(root, realName+"."+suffix));
				
				System.out.println("fileFileName: " + fileFileName);
				
				//因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
				System.out.println("file: " + file[i].getName());
				System.out.println("file: " + file[i].getPath());
				
				byte[] buffer = new byte[500];
				int length = 0;
				
				while(-1 != (length = is.read(buffer, 0, buffer.length)))
				{
					os.write(buffer);
				}
				
				os.close();
				is.close();
				ImageFileBean insertInfo = new ImageFileBean();
				insertInfo.setImageFileName(realName+"."+suffix);
				insertInfo.setFilerealpath(root);
				insertInfo.setImagefiletype(contentType);
				insertInfo.setDownloads(0);
				insertInfo.setImagefileused(0);
				insertInfo.setIszip("");
				retId = imageFileService.insertImageFile(insertInfo)+"";
				ids += ids.equals("")?retId:","+retId;
			}
			retResult.put("ids",ids);
			return retResult;
			}catch(Exception e){
				e.printStackTrace();
				status = false;
			}
		return null;
	}
	
	/**
	 *	 
	 * @param cell 一个单元格的对象
	 * @return 返回该单元格相应的类型的值
	 */
	public static Object getRightTypeCell(Cell cell){
	  Object object = null;
	  switch(cell.getCellType())
	  {
	    case Cell.CELL_TYPE_STRING :
	    {
	      object=cell.getStringCellValue();
	      break;
	    }
	    case Cell.CELL_TYPE_NUMERIC :
	    {
	      cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	      object=cell.getNumericCellValue();
	      break;
	    }
	    case Cell.CELL_TYPE_FORMULA :
	    {
	      cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	      object=cell.getNumericCellValue();
	      break;
	    }
	    case Cell.CELL_TYPE_BLANK :
	    {
	      cell.setCellType(Cell.CELL_TYPE_BLANK);
	      object=cell.getStringCellValue();
	      break;
	    }
	  }
	  return object;
	}
	
	
	/**
	   * 读取出filePath中的所有数据信息
	   * @param filePath excel文件的绝对路径
	   * 
	   */
	  public static void getDataFromExcel(String filePath)
	  {
	    filePath = "E:\\123.xls";
	    //判断是否为excel类型文件
	    if(!filePath.endsWith(".xls"))
	    {
	      System.out.println("文件不是excel类型");
	    }
	    FileInputStream fis =null;
	    Workbook wookbook = null;
	    int flag = 0;
	    try
	    {
	      //获取一个绝对地址的流
	        fis = new FileInputStream(filePath);
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    try 
	    {
	      //2003版本的excel，用.xls结尾
	      wookbook = new HSSFWorkbook(fis);//得到工作簿
	       
	    } 
	    catch (Exception ex) 
	    {
	        ex.printStackTrace();
	    }
	    //得到一个工作表
	    Sheet sheet = wookbook.getSheetAt(0);
	    //获得表头
	    Row rowHead = sheet.getRow(0);
	    //根据不同的data放置不同的表头
	    Map<Object,Integer> headMap = new HashMap<Object, Integer>();
	    //判断表头是否合格  ------------------------这里看你有多少列
	    if(rowHead.getPhysicalNumberOfCells() != 2)
	    {
	      System.out.println("表头列数与要导入的数据库不对应");
	    }
	    try
	    {
	      //----------------这里根据你的表格有多少列
	      while (flag < 2)
	      {
	        Cell cell = rowHead.getCell(flag);
	        if (getRightTypeCell(cell).toString().equals("基站名"))
	        {
	          headMap.put("jizhan", flag);
	        }
	        if (getRightTypeCell(cell).toString().equals("经纬度"))
	        {
	          headMap.put("jingweidu", flag);
	        }
	        flag++;
	      }
	    } catch (Exception e)
	    {
	      e.printStackTrace();
	      System.out.println("表头不合规范，请修改后重新导入");
	    }
	    //获得数据的总行数
	    int totalRowNum = sheet.getLastRowNum();
	    //要获得属性
	    String name = "";
	    double latitude = 0;
	    if(0 == totalRowNum)
	    {
	      System.out.println("Excel内没有数据！");
	    }
	    Cell cell_1 = null,cell_2 = null;
	     //获得所有数据
	    for(int i = 1 ; i <= totalRowNum ; i++)
	    {
	      //获得第i行对象
	      Row row = sheet.getRow(i);
	      try
	      {
	        cell_1 = row.getCell(headMap.get("jizhan"));
	        cell_2 = row.getCell(headMap.get("jingweidu"));
	      } catch (Exception e)
	      {
	        e.printStackTrace();
	        System.out.println("获取单元格错误");
	      }
	      try
	      {
	        //基站
	        name = (String) getRightTypeCell(cell_1);
	        //经纬度
	        latitude = (Double) getRightTypeCell(cell_2);
	      } catch (ClassCastException e)
	      {
	        e.printStackTrace();
	        System.out.println("数据不全是数字或全部是文字!");
	      }
	      System.out.println("名字："+name+",经纬度："+latitude);
	    }
	  }
	
	  public static void main(String[] args) {
		  getDataFromExcel("");
	}

}
