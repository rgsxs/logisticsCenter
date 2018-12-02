package com.logisticscenter.Controller;

import com.common.CommonTransMethod;
import com.common.ConvertService;
import com.javabean.TruckGoodsOrderDetailBean;
import com.javabean.TruckGoodsOrderTakerBean;
import com.javabean.TruckGoodsReportBean;
import com.javabean.TruckGoodsReportDetailBean;
import com.service.TruckGoodsOrderService;
import com.service.TruckGoodsReportService;
import com.util.ConstantUtils;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckGoodsOrderController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TruckGoodsOrderController(){
		
	}
	
	/**
	 * 出车预录信息service
	 */
	private TruckGoodsOrderService truckGoodsOrderService;
	/**
	 * 出车详细信息
	 */
	private TruckGoodsReportService truckGoodsReportService;
	private CommonTransMethod commonTransMethod;
	
	//标识ID
	private int id;
	//出车ID
	private String reportId;
	//是否包车
	private int packageFlg;
	//包车价格
	private BigDecimal packagePrice;
	
	//发车起始地
	private String startPlace;
	//发车终点
	private String endPlace;
	//发车时间
	private String beginDate;
	//客户
	private int client;
	/**
	 * 预录状态 
	 * 0:待分配
	 * 1:已分配
	 * 2:已删除
	 * 3:全部
	 */
	private int orderStatus;
	//客户货物类型
	private String goodsType;
	//是否预支费用
	private int prepaidFlg;
	//预支费用
	private BigDecimal prepaidExpress;
	//预支费用说明
	private String prepaidDesc;
	//实际载重
	private BigDecimal realCarry;
	//单价
	private BigDecimal price;
	//区域
	private String workPlace;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	//返回值状态
	private boolean status;
	
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

	public int getPackageFlg() {
		return packageFlg;
	}

	public void setPackageFlg(int packageFlg) {
		this.packageFlg = packageFlg;
	}
	
	public BigDecimal getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(BigDecimal packagePrice) {
		this.packagePrice = packagePrice;
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

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	
	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
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

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
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

	public CommonTransMethod getCommonTransMethod() {
		return commonTransMethod;
	}

	public void setCommonTransMethod(CommonTransMethod commonTransMethod) {
		this.commonTransMethod = commonTransMethod;
	}
	
	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
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

	public TruckGoodsOrderService getTruckGoodsOrderService() {
		return truckGoodsOrderService;
	}

	public void setTruckGoodsOrderService(
			TruckGoodsOrderService truckGoodsOrderService) {
		this.truckGoodsOrderService = truckGoodsOrderService;
	}

	public TruckGoodsReportService getTruckGoodsReportService() {
		return truckGoodsReportService;
	}

	public void setTruckGoodsReportService(
			TruckGoodsReportService truckGoodsReportService) {
		this.truckGoodsReportService = truckGoodsReportService;
	}

	/**
	 * 增加预录出车信息
	 * @return 是否成功
	 */
	public String addTruckGoodsOrder(){

		goodsTypeRow= ConvertService.null2String(request.getParameter("goodsTypeRow"),"0");
		//首先增加预录信息
		TruckGoodsOrderTakerBean bean = new TruckGoodsOrderTakerBean(id,client, goodsType, packageFlg, packagePrice, beginDate,startPlace,endPlace,0,workPlace,"","");
		int insertReportId = truckGoodsOrderService.insertTruckGoodsOrderTaker(bean);
		//其次增加预录详细信息
		if(Integer.parseInt(goodsTypeRow)>0){
			try{
				int intRows = Integer.parseInt(goodsTypeRow);
				String goodsType = "";
				String goodsPrice = "";
				String goodsRealCarry = "";
				String goodsInvoiceFlg = "";
				String goodsStartPlace = "";
				String goodsEndPlace = "";
				for(int i=1;i<=intRows;i++){
					//获得货物类型,如果货物类型为空则代表没有这条数据
					if(!ConvertService.null2String(request.getParameter("goodsType_"+i)).equals("")){
						goodsType = (String)request.getParameter("goodsType_"+i);
						goodsPrice = (String)request.getParameter("price_"+i);
						goodsRealCarry = (String)request.getParameter("realCarry_"+i);
						goodsInvoiceFlg = (String)request.getParameter("invoiceFlg_"+i);
						goodsStartPlace = (String)request.getParameter("startPlace_"+i);
						goodsEndPlace = (String)request.getParameter("endPlace_"+i);
						//车辆出车记录新增
						TruckGoodsOrderDetailBean detailBean = new TruckGoodsOrderDetailBean(insertReportId,goodsType,goodsPrice,goodsRealCarry,goodsInvoiceFlg,goodsStartPlace,goodsEndPlace);
						truckGoodsOrderService.insertTruckGoodsOrderDetail(detailBean);
						
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		this.status = insertReportId > 0?true:false;
		return "success";
	}
	
	
	
	/**
	 * 预录出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public String selectTruckGoodsOrderBy(){

		beginDate = ConvertService.null2String(request.getParameter("beginDate"));
		client = ConvertService.getIntValue(request.getParameter("client"),-1);
		goodsType = ConvertService.null2String(request.getParameter("goodsType"));
		orderStatus = ConvertService.getIntValue(request.getParameter("orderStatus"),0);
		TruckGoodsOrderTakerBean infoBean = new TruckGoodsOrderTakerBean(id, client, goodsType, packageFlg, packagePrice, beginDate,startPlace,endPlace,orderStatus,workPlace,pageSize,currentPage);
		List<TruckGoodsOrderTakerBean> beanLst= truckGoodsOrderService.getTruckGoodsOrderTaker(infoBean);
		//获得分页信息,当currentPage==1的时候初始化pageCount
		int pageCount = 0;
		String count = "";
		if("1".equals(currentPage)){
			count = truckGoodsOrderService.getTruckGoodsOrderByCount(infoBean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			List resultList = new ArrayList();
			Map retResult = new HashMap();
			Map beanMap = null;
			Map orderDetailbeanMap = null;
			List detailResultList = null;
			String reportIds = "";
			for(int i = 0 ; i<beanLst.size(); i++){
				reportIds += reportIds.equals("")?beanLst.get(i).getId():","+beanLst.get(i).getId();
			}
			List<TruckGoodsOrderDetailBean> detailLst=  new ArrayList<TruckGoodsOrderDetailBean>();
			if(!reportIds.equals("")){
				detailLst= truckGoodsOrderService.getTruckGoodsOrderDetailById(reportIds);
				//查询出车辆详细信息
			}
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				int orderId = beanLst.get(i).getId();
				beanMap.put("id",orderId);
				beanMap.put("beginDate",beanLst.get(i).getBeginDate());
				beanMap.put("client",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				beanMap.put("goodsType",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				beanMap.put("packageFlg",CommonTransMethod.convertPackage(beanLst.get(i).getPackageFlg()));
				beanMap.put("packagePrice",beanLst.get(i).getPackagePrice());
				beanMap.put("startPlace",beanLst.get(i).getStartPlace());
				beanMap.put("endPlace",beanLst.get(i).getEndPlace());
				beanMap.put("orderStatus",beanLst.get(i).getOrderStatus());
				beanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("editDate",beanLst.get(i).getEditDate());
				beanMap.put("editTime",beanLst.get(i).getEditTime());
				detailResultList = new ArrayList();
				for(int j = 0 ; j<detailLst.size(); j++){
					int detailOrderId = detailLst.get(j).getReportId();
					if(detailOrderId == orderId){
						orderDetailbeanMap = new HashMap();
						orderDetailbeanMap.put("id",detailLst.get(j).getId());
						orderDetailbeanMap.put("reportId",detailOrderId);
						orderDetailbeanMap.put("goodsType",detailLst.get(j).getGoodsType()+"");
						orderDetailbeanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(detailLst.get(j).getGoodsType()+""));
						orderDetailbeanMap.put("price",detailLst.get(j).getPrice());
						orderDetailbeanMap.put("realCarry",detailLst.get(j).getRealCarry());
						orderDetailbeanMap.put("invoiceFlg",detailLst.get(j).getInvoiceFlg());
						orderDetailbeanMap.put("startPlace",detailLst.get(j).getStartPlace());
						orderDetailbeanMap.put("endPlace",detailLst.get(j).getEndPlace());
						orderDetailbeanMap.put("createDate",detailLst.get(j).getCreateDate());
						orderDetailbeanMap.put("createTime",detailLst.get(j).getCreateTime());
						orderDetailbeanMap.put("editDate",detailLst.get(j).getEditDate());
						orderDetailbeanMap.put("editTime",detailLst.get(j).getEditTime());
						detailResultList.add(orderDetailbeanMap);
					}
				}
				beanMap.put("orderDetails",detailResultList);
				resultList.add( beanMap);
			}
			retResult.put("truckGoodsOrder",resultList);
			retResult.put("pageCount",pageCount);
			retResult.put("currentPage",currentPage);
			retResult.put("count",count);
			response.setContentType("text/html; charset=utf-8");
			out = response.getWriter();
//			/* 设置格式为text/json    */
//            response.setContentType("text/json"); 
//            /*设置字符集为'UTF-8'*/
//            response.setCharacterEncoding("UTF-8"); 
			JSONObject obj = JSONObject.parseObject(retResult.toString());
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	
	/**
	 * 预录出车信息查询用
	 */
	@SuppressWarnings("unchecked")
	public String selectTruckGoodsOrderDetailById(){

		String orderId = ConvertService.null2String(request.getParameter("orderId"));
		
		List<TruckGoodsOrderTakerBean> beanLst= truckGoodsOrderService.getTruckGoodsOrderTakerById(orderId);
		List<TruckGoodsOrderDetailBean> detailLst= truckGoodsOrderService.getTruckGoodsOrderDetailById(orderId);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			List result = new ArrayList();
			Map retResult = new HashMap();
			Map orderTakerbeanMap = null;
			Map orderDetailbeanMap = null;
			//查询出车辆预录信息(只能查出唯一一条数据)
			for(int i = 0 ; i<beanLst.size(); i++){
				orderTakerbeanMap = new HashMap();
				orderTakerbeanMap.put("id",beanLst.get(i).getId());
				orderTakerbeanMap.put("beginDate",beanLst.get(i).getBeginDate());
				orderTakerbeanMap.put("client",beanLst.get(i).getClient()+"");
				orderTakerbeanMap.put("clientShow",CommonTransMethod.getClientName(beanLst.get(i).getClient()+""));
				orderTakerbeanMap.put("goodsType",beanLst.get(i).getGoodsType()+"");
				orderTakerbeanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(beanLst.get(i).getGoodsType()+""));
				orderTakerbeanMap.put("packageFlg",beanLst.get(i).getPackageFlg());
				orderTakerbeanMap.put("packagePrice",beanLst.get(i).getPackagePrice());
				orderTakerbeanMap.put("workPlace",beanLst.get(i).getWorkPlace());
				orderTakerbeanMap.put("startPlace",beanLst.get(i).getStartPlace());
				orderTakerbeanMap.put("endPlace",beanLst.get(i).getEndPlace());
				orderTakerbeanMap.put("createDate",beanLst.get(i).getCreateDate());
				orderTakerbeanMap.put("createTime",beanLst.get(i).getCreateTime());
				orderTakerbeanMap.put("editDate",beanLst.get(i).getEditDate());
				orderTakerbeanMap.put("editTime",beanLst.get(i).getEditTime());
			}
			//查询出车辆详细信息
			for(int i = 0 ; i<detailLst.size(); i++){
				orderDetailbeanMap = new HashMap();
				orderDetailbeanMap.put("id",detailLst.get(i).getId());
				orderDetailbeanMap.put("reportId",detailLst.get(i).getReportId());
				orderDetailbeanMap.put("goodsType",detailLst.get(i).getGoodsType()+"");
				orderDetailbeanMap.put("goodsTypeShow",CommonTransMethod.getGoodsTypeName(detailLst.get(i).getGoodsType()+""));
				orderDetailbeanMap.put("price",detailLst.get(i).getPrice());
				orderDetailbeanMap.put("realCarry",detailLst.get(i).getRealCarry());
				orderDetailbeanMap.put("invoiceFlg",detailLst.get(i).getInvoiceFlg());
				orderDetailbeanMap.put("startPlace",detailLst.get(i).getStartPlace());
				orderDetailbeanMap.put("endPlace",detailLst.get(i).getEndPlace());
				orderDetailbeanMap.put("createDate",detailLst.get(i).getCreateDate());
				orderDetailbeanMap.put("createTime",detailLst.get(i).getCreateTime());
				orderDetailbeanMap.put("editDate",detailLst.get(i).getEditDate());
				orderDetailbeanMap.put("editTime",detailLst.get(i).getEditTime());
				result.add( orderDetailbeanMap);
			}
			retResult.put("truckGoodsOrderTaker",orderTakerbeanMap);
			retResult.put("truckGoodsOrderDetail",result);
			response.setContentType("text/html; charset=utf-8");
			out = response.getWriter();
//			/* 设置格式为text/json    */
//            response.setContentType("text/json"); 
//            /*设置字符集为'UTF-8'*/
//            response.setCharacterEncoding("UTF-8"); 
			JSONObject obj = JSONObject.parseObject(retResult.toString());
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	/**
	 * 删除出车信息
	 */
	public String deleteTruckGoodsOrder(){

		String ids = request.getParameter("deleteTruckGoodsOrders");
		//首先删除预录出车信息
		int count = truckGoodsOrderService.deleteTruckGoodsOrderTaker(ids);
		//其次删除预录出车详细信息
		int countOrderDetail = truckGoodsOrderService.deleteTruckGoodsOrderDetail(ids);
		//获取输出流，然后使用  
        PrintWriter out = null;
        String result = "0";
		try {
			Map retResult = new HashMap();
			if(count>0){
				result = "1";
			}else{
				result = "0";
			}
			retResult.put("result", result);
			response.setContentType("text/html; charset=utf-8");
			out = response.getWriter();
//			/* 设置格式为text/json    */
//            response.setContentType("text/json"); 
//            /*设置字符集为'UTF-8'*/
//            response.setCharacterEncoding("UTF-8"); 
			JSONObject obj = JSONObject.parseObject(retResult.toString());
			out.print(obj.toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}
	
	/**更新预录信息,首先更新预录主要信息,第二步将之前的详细删除,将现在最新的详细添加
	 * @return
	 */
	public String updateTruckGoodsOrder(){

		goodsTypeRow= ConvertService.null2String(request.getParameter("goodsTypeRow"),"0");
		id = ConvertService.getIntValue((String)request.getParameter("reportId"),0);
		if(id==0){
			status = false;
			return null;
		}
		//首先增加预录信息
		TruckGoodsOrderTakerBean bean = new TruckGoodsOrderTakerBean(id,client, goodsType, packageFlg, packagePrice, beginDate,startPlace,endPlace,0,workPlace,"","");
		int updateCount = truckGoodsOrderService.updateTruckGoodsOrderTaker(bean);
		truckGoodsOrderService.deleteTruckGoodsOrderDetail(id+"");
		//其次增加预录详细信息
		if(updateCount>0){
			try{
				int intRows = Integer.parseInt(goodsTypeRow);
				String goodsType = "";
				String goodsPrice = "";
				String goodsRealCarry = "";
				String goodsInvoiceFlg = "";
				String goodsStartPlace = "";
				String goodsEndPlace = "";
				for(int i=1;i<=intRows;i++){
					//获得货物类型,如果货物类型为空则代表没有这条数据
					if(!ConvertService.null2String(request.getParameter("goodsType_"+i)).equals("")){
						goodsType = (String)request.getParameter("goodsType_"+i);
						goodsPrice = (String)request.getParameter("price_"+i);
						goodsRealCarry = (String)request.getParameter("realCarry_"+i);
						goodsInvoiceFlg = ConvertService.null2String((String)request.getParameter("invoiceFlg_"+i),"0");
						goodsStartPlace = (String)request.getParameter("startPlace_"+i);
						goodsEndPlace = (String)request.getParameter("endPlace_"+i);
						TruckGoodsOrderDetailBean detailBean = new TruckGoodsOrderDetailBean(id,goodsType,goodsPrice,goodsRealCarry,goodsInvoiceFlg,goodsStartPlace,goodsEndPlace);
						truckGoodsOrderService.insertTruckGoodsOrderDetail(detailBean);
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		this.status = updateCount > 0?true:false;
		return "success";
	}
	
	/**确认预录信息,首先更新预录主要信息,将orderStatus更新为[1],第二步将数据生成具体出车信息
	 * @return
	 */
	public String updateTruckGoodsReport(){

		goodsTypeRow= ConvertService.null2String(request.getParameter("goodsTypeRow"),"0");
		id = ConvertService.getIntValue((String)request.getParameter("reportId"),0);
		if(id==0){
			status = false;
			return null;
		}
		//首先更新预录主要信息
		int updateCount = truckGoodsOrderService.updateTruckGoodsOrderStatus(id,1);
		//其次增加预录详细信息
		if(updateCount>0){
			try{
				int intRows = Integer.parseInt(goodsTypeRow);
				int client = ConvertService.getIntValue((String)request.getParameter("client"),0);
				String beginDate = (String)request.getParameter("beginDate");
				String packageFlg = ConvertService.null2String((String)request.getParameter("packageFlg"),"0");
				BigDecimal packagePrice = ConvertService.getDecimalValue((String)request.getParameter("packagePrice"),ConstantUtils.defaultDecimal);
				String goodsType = "";
				/*--------分配的时候给truckgoodsReportDetail设置地点 价格 是否开票 ---------*/
				String startPlace = "";
				String endPlace = "";
				BigDecimal price = ConstantUtils.defaultDecimal;
				BigDecimal realCarry = ConstantUtils.defaultDecimal;
				String invoiceFlg = "";
				/*--------分配的时候不需要地点 end---------*/
				int driver = 0;
				int truckPart = 0;
				String partner = "";
				String partnerPrice = "";
				String partnerCarry = "";
				String truckNumber = "";
				for(int i=1;i<=intRows;i++){
					//获得货物类型,如果货物类型为空则代表没有这条数据
					if(!ConvertService.null2String(request.getParameter("goodsType_"+i)).equals("")){
						goodsType = ConvertService.null2String((String)request.getParameter("goodsType_"+i),"0");
						truckPart = ConvertService.getIntValue((String)request.getParameter("truckPart_"+i),0);
						if(truckPart==1){
							partner = (String)request.getParameter("partner_"+i);
							partnerPrice = (String)request.getParameter("partnerPrice_"+i);
							partnerCarry = (String)request.getParameter("partnerCarry_"+i);
						}else if(truckPart==0){
							truckNumber = (String)request.getParameter("truckNumber_"+i);
							driver = ConvertService.getIntValue(((String)request.getParameter("driver_"+i)),0);
						}
						TruckGoodsReportBean reprotBean = new TruckGoodsReportBean( truckPart,partner,partnerPrice,partnerCarry,packagePrice,"0",packageFlg,
								truckNumber, id, 
								"", "", beginDate, "", "", driver, client, goodsType,prepaidFlg,prepaidExpress,prepaidDesc, 
								1, 0, "", ConstantUtils.defaultDecimal, ConstantUtils.defaultDecimal, ConstantUtils.defaultDecimal, "", workPlace,"","","0","", "", "");
						int maxId = truckGoodsReportService.insertTruckGoodsReport(reprotBean);
						//车辆出车货物类型分类详细新增
						TruckGoodsReportDetailBean reportDetailBean = null;
						String goodsTypeArr[] = goodsType.split(",");
						if(maxId>0){
							for(int j=0;j<goodsTypeArr.length;j++){
								if(!goodsTypeArr[j].equals("") && !ConvertService.null2String(request.getParameter("goodsType_"+goodsTypeArr[j])).equals("")){
									reportDetailBean = new TruckGoodsReportDetailBean();
									startPlace = ConvertService.null2String(request.getParameter("startPlace_"+goodsTypeArr[j]));
									endPlace = ConvertService.null2String(request.getParameter("endPlace_"+goodsTypeArr[j]));
									price = ConvertService.getDecimalValue((request.getParameter("price_"+goodsTypeArr[j])),ConstantUtils.defaultDecimal);
									invoiceFlg = ConvertService.null2String(request.getParameter("invoiceFlg_"+goodsTypeArr[j]));
									reportDetailBean.setStartPlace(startPlace);
									reportDetailBean.setEndPlace(endPlace);
									reportDetailBean.setGoodsType(goodsTypeArr[j]);
									reportDetailBean.setInvoiceFlg(ConvertService.getIntValue(invoiceFlg,0));
									reportDetailBean.setPrice(price);
									reportDetailBean.setRealCarry(ConstantUtils.defaultDecimal);
									reportDetailBean.setLiftingCost(ConstantUtils.defaultDecimal);
									reportDetailBean.setTruckOrder(maxId);
									reportDetailBean.setDeleteFlg(0);
									truckGoodsReportService.insertTruckGoodsReportDetail(reportDetailBean);
								}
							}
						}
						
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		this.status = updateCount > 0?true:false;
		return "success";
	}
	
	/**
	 * 根据ID出车信息查询用
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String selectTruckGoodsReportById(){
//		HttpServletResponse response =   ServletActionContext.getResponse();
//		HttpServletRequest request =   ServletActionContext.getRequest();
//		String reportId = ConvertService.null2String(request.getParameter("reportId"));
//		TruckGoodsReportBean bean= truckGoodsOrderService.getTruckGoodsReport(reportId);
//		List<FeeTypeBean> beanLst= feeTypeService.getAllFeeType();
//		String feeColumnDiv = "";
//		String feeColumnHTML = "";
//		String feeColumnHidden = "";
//		for(int i = 0 ; i<beanLst.size(); i++){
//			if(i%3 == 0){
//				feeColumnDiv += "<div class=\"form-group\">";
//			}
//			feeColumnDiv += "<label class=\"col-sm-1 control-label\">"+beanLst.get(i).getFeeName()+"</label>";
//			feeColumnDiv +="<div class=\"col-sm-2\">";
//			feeColumnDiv += "<input class=\"form-control1\" id="+beanLst.get(i).getFeeTypeColumn()+" name="+beanLst.get(i).getFeeTypeColumn()
//			+" placeholder="+beanLst.get(i).getFeeName()
//			+" value="+getColumn(reportId,beanLst.get(i).getFeeTypeColumn())+" >";
//			feeColumnDiv += "</div>";
//			if(i%3 == 2){
//				feeColumnDiv += "</div>";
//			}
//			feeColumnHidden += "".equals(feeColumnHidden)?beanLst.get(i).getFeeTypeColumn():","+beanLst.get(i).getFeeTypeColumn();
//		}
//		if(!feeColumnDiv.endsWith("</div></div>")){
//			feeColumnDiv = feeColumnDiv+"</div>";
//		}
//		feeColumnHidden = "<input type=\"hidden\" id=\"getFeeTypeColumn\" name=\"getFeeTypeColumn\" value="+feeColumnHidden+">";
//		feeColumnHTML = feeColumnHidden + feeColumnDiv;
//		//获取输出流，然后使用  
//        PrintWriter out = null;
//		try {
//			Map retResult = new HashMap();
//			Map beanMap = null;
//			beanMap = new HashMap();
//			beanMap.put("id",bean.getId());
//			beanMap.put("truckNumber",bean.getTruckNumber());
//			beanMap.put("startPlace",bean.getStartPlace());
//			beanMap.put("endPlace",bean.getEndPlace());
//			beanMap.put("beginDate",bean.getBeginDate());
//			beanMap.put("expectedDate",bean.getExpectedDate());
//			beanMap.put("endDate",bean.getEndDate());
//			beanMap.put("driver",bean.getDriver());
//			beanMap.put("client",bean.getClient());
//			beanMap.put("goodsType",bean.getGoodsType());
//			beanMap.put("prepaidFlg",bean.getPrepaidFlg());
//			beanMap.put("prepaidExpress",bean.getPrepaidExpress());
//			beanMap.put("prepaidDesc",bean.getPrepaidDesc());
//			beanMap.put("reportStatus",bean.getReportStatus());
//			beanMap.put("isLater",bean.getIsLater());
//			beanMap.put("laterReason",bean.getLaterReason());
//			beanMap.put("realCarry",bean.getRealCarry());
//			beanMap.put("price",bean.getPrice());
//			beanMap.put("expensens",bean.getExpensens());
//			beanMap.put("carryNumber",bean.getCarryNumber());
//			beanMap.put("workPlace",bean.getWorkPlace());
//			beanMap.put("createDate",bean.getCreateDate());
//			beanMap.put("createTime",bean.getCreateTime());
//			beanMap.put("editDate",bean.getEditDate());
//			beanMap.put("editTime",bean.getEditTime());
//			beanMap.put("count","");
//			beanMap.put("feeColumnHtml",feeColumnHTML);
//			retResult.put("truckGoodsReport",beanMap);
//			response.setContentType("text/html; charset=utf-8");
//			out = response.getWriter();
////			/* 设置格式为text/json    */
////            response.setContentType("text/json"); 
////            /*设置字符集为'UTF-8'*/
////            response.setCharacterEncoding("UTF-8"); 
//			JSONObject obj = JSONObject.parseObject(retResult.toString());
//			out.print(obj.toString());
//			out.flush();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//返回json对象
		return null;
	}
	
}
