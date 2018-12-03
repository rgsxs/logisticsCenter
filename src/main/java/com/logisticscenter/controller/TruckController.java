package com.logisticscenter.controller;

import com.cachec.CacheManager;
import com.common.CommonTransMethod;
import com.common.ConvertService;
import com.javabean.TruckBean;
import com.service.TruckService;
import com.util.Util;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TruckController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TruckService truckService;
	
	private CommonTransMethod commonTransMethod;
	
	//id
	private int id;
	
	//车牌号码
	private String  truckNumber ;
	
	//户主
	private String  truckOwner ;
	
	//车牌型号
	private String  truckBrand ;
	
	//车辆名称
	private String  truckName ;
	
	//司机联系方式
	private String  contactNumber ;
	
	//车辆类型
	private int  truckType ;
	
	//司机
	private int  driver ;
	
	//车辆颜色
	private String  truckColor ;
	
	//车辆长度
	private String  trucklength ;
	
	//车辆宽度
	private String  truckWidth ;
	
	//车辆高度
	private String  truckHeight ;
	
	//标准载重
	private String  standardWeight ;
	
	//驾驶证号
	private String  driverLicense ;
	
	//发动机号
	private String  engineNumber ;
	
	//生产日期
	private String  madeDate ;
	
	//买进日期
	private String  buyDate ;
	
	//原值
	private String  worth ;
	
	//买进价格
	private String  buyCost ;
	
	//备注
	private String  remark ;
	
	//查询用买进时间段(开始时间)
	private String buyStartDate;
	
	//查询用买进时间段(开始时间)
	private String buyEndDate;
	
	private boolean status ;
	
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
	public String getTruckOwner() {
		return truckOwner;
	}
	public void setTruckOwner(String truckOwner) {
		this.truckOwner = truckOwner;
	}
	public String getTruckBrand() {
		return truckBrand;
	}
	public void setTruckBrand(String truckBrand) {
		this.truckBrand = truckBrand;
	}
	public String getTruckName() {
		return truckName;
	}
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getTruckType() {
		return truckType;
	}
	public void setTruckType(int truckType) {
		this.truckType = truckType;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	public String getTruckColor() {
		return truckColor;
	}
	public void setTruckColor(String truckColor) {
		this.truckColor = truckColor;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	public String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public String getMadeDate() {
		return madeDate;
	}
	public void setMadeDate(String madeDate) {
		this.madeDate = madeDate;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public TruckService getTruckService() {
		return truckService;
	}
	
	public String getTrucklength() {
		return trucklength;
	}
	public void setTrucklength(String trucklength) {
		this.trucklength = trucklength;
	}
	public String getTruckWidth() {
		return truckWidth;
	}
	public void setTruckWidth(String truckWidth) {
		this.truckWidth = truckWidth;
	}
	public String getTruckHeight() {
		return truckHeight;
	}
	public void setTruckHeight(String truckHeight) {
		this.truckHeight = truckHeight;
	}
	public String getStandardWeight() {
		return standardWeight;
	}
	public void setStandardWeight(String standardWeight) {
		this.standardWeight = standardWeight;
	}
	public String getWorth() {
		return worth;
	}
	public void setWorth(String worth) {
		this.worth = worth;
	}
	public String getBuyCost() {
		return buyCost;
	}
	public void setBuyCost(String buyCost) {
		this.buyCost = buyCost;
	}
	
	public String getBuyStartDate() {
		return buyStartDate;
	}
	public void setBuyStartDate(String buyStartDate) {
		this.buyStartDate = buyStartDate;
	}
	public String getBuyEndDate() {
		return buyEndDate;
	}
	public void setBuyEndDate(String buyEndDate) {
		this.buyEndDate = buyEndDate;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setTruckService(TruckService truckService) {
		this.truckService = truckService;
	}
	
	public CommonTransMethod getCommonTransMethod() {
		return commonTransMethod;
	}
	public void setCommonTransMethod(CommonTransMethod commonTransMethod) {
		this.commonTransMethod = commonTransMethod;
	}
	public TruckController(){
		
	}
	
	public String addTruck(){
		TruckBean truckBean = new TruckBean(id,truckNumber,truckOwner,truckBrand,truckName,contactNumber,truckType,driver,truckColor,trucklength,truckWidth,truckHeight,standardWeight,driverLicense,engineNumber,madeDate,buyDate,worth,buyCost,remark);
		int maxId = truckService.insertTruck(truckBean);
		id = maxId;
		this.status = maxId>0?true:false;
		CacheManager.clearOnly("truckBean_CACHE");
		return "success";
	}
	
	public String addTruck1(){
		TruckBean truckBean = new TruckBean(id,truckNumber,truckOwner,truckBrand,truckName,contactNumber,truckType,driver,truckColor,trucklength,truckWidth,truckHeight,standardWeight,driverLicense,engineNumber,madeDate,buyDate,worth,buyCost,remark);
		int maxId = truckService.insertTruck(truckBean);
		id = maxId;
		this.status = maxId>0?true:false;
		CacheManager.clearOnly("truckBean_CACHE");
		return "success";
	}
	
	public String selectAllTruck(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		List<TruckBean> beanLst= truckService.getAllTruck();
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("truckNumber",beanLst.get(i).getTruckNumber());
				beanMap.put("truckOwner",beanLst.get(i).getTruckOwner());
				beanMap.put("truckOwnerName",beanLst.get(i).getTruckOwner());
				beanMap.put("truckBrand",beanLst.get(i).getTruckBrand());
				beanMap.put("truckName",beanLst.get(i).getTruckName());
				beanMap.put("contactNumber",beanLst.get(i).getContactNumber());
				beanMap.put("truckType",beanLst.get(i).getTruckType());
				beanMap.put("driver",commonTransMethod.getDriverName(beanLst.get(i).getDriver()+ "") );
				beanMap.put("truckColor",beanLst.get(i).getTruckColor());
				beanMap.put("truckLength",beanLst.get(i).getTruckLength());
				beanMap.put("truckWidth",beanLst.get(i).getTruckWidth());
				beanMap.put("truckHeight",beanLst.get(i).getTruckHeight());
				beanMap.put("standardWeight",beanLst.get(i).getStandardWeight());
				beanMap.put("driverLicense",beanLst.get(i).getDriverLicense());
				beanMap.put("engineNumber",beanLst.get(i).getEngineNumber());
				beanMap.put("madeDate",beanLst.get(i).getMadeDate());
				beanMap.put("buyDate",beanLst.get(i).getBuyDate());
				beanMap.put("worth",beanLst.get(i).getWorth());
				beanMap.put("buyCost",beanLst.get(i).getBuyCost());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("createDate",beanLst.get(i).getCreateTime());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("commercialDate",ConvertService.getWarn(beanLst.get(i).getCommercialDate(),"未提交"));
				beanMap.put("compulsoryDate",ConvertService.getWarn(beanLst.get(i).getCompulsoryDate(),"未提交"));
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("truck",result);
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
	
	@SuppressWarnings("unchecked")
	public String getTruckBy(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		truckNumber = Util.null2String(request.getParameter("truckNumber"));
		truckBrand = Util.null2String(request.getParameter("truckBrand"));
		driver = ConvertService.getIntValue((request.getParameter("driver")), 0);
		engineNumber = Util.null2String(request.getParameter("engineNumber"));
		buyStartDate = Util.null2String(request.getParameter("buyStartDate"));
		buyEndDate = Util.null2String(request.getParameter("buyEndDate"));
		TruckBean truckBean = new TruckBean(truckNumber,truckBrand,driver,engineNumber,buyStartDate,buyEndDate,pageSize,currentPage);
		HttpServletResponse response =   ServletActionContext.getResponse();
		List<TruckBean> beanLst= truckService.getTruckInfo(truckBean);
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = truckService.getTruckInfoCount(truckBean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("truckNumber",beanLst.get(i).getTruckNumber());
				beanMap.put("truckOwner",beanLst.get(i).getTruckOwner());
				beanMap.put("truckOwnerName",beanLst.get(i).getTruckOwner());
				beanMap.put("truckBrand",beanLst.get(i).getTruckBrand());
				beanMap.put("truckName",beanLst.get(i).getTruckName());
				beanMap.put("contactNumber",beanLst.get(i).getContactNumber());
				beanMap.put("truckType",beanLst.get(i).getTruckType());
				beanMap.put("driver",commonTransMethod.getDriverName(beanLst.get(i).getDriver()+ "") );
				beanMap.put("truckColor",beanLst.get(i).getTruckColor());
				beanMap.put("truckLength",beanLst.get(i).getTruckLength());
				beanMap.put("truckWidth",beanLst.get(i).getTruckWidth());
				beanMap.put("truckHeight",beanLst.get(i).getTruckHeight());
				beanMap.put("standardWeight",beanLst.get(i).getStandardWeight());
				beanMap.put("driverLicense",beanLst.get(i).getDriverLicense());
				beanMap.put("engineNumber",beanLst.get(i).getEngineNumber());
				beanMap.put("madeDate",beanLst.get(i).getMadeDate());
				beanMap.put("buyDate",beanLst.get(i).getBuyDate());
				beanMap.put("worth",beanLst.get(i).getWorth());
				beanMap.put("buyCost",beanLst.get(i).getBuyCost());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				beanMap.put("commercialDate",ConvertService.getWarn(beanLst.get(i).getCommercialDate(),"未提交"));
				beanMap.put("compulsoryDate",ConvertService.getWarn(beanLst.get(i).getCompulsoryDate(),"未提交"));
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("truck",result);
			retResult.put("pageCount",pageCount);
			retResult.put("currentPage",currentPage);
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
	
	@SuppressWarnings("unchecked")
	public String getTruckById(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		id = Util.getIntValue(request.getParameter("id"),0);
		HttpServletResponse response =   ServletActionContext.getResponse();
		TruckBean truckBean= truckService.getTruckInfo(id+"");
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			if(truckBean != null){
				beanMap = new HashMap();
				beanMap.put("id",truckBean.getId());
				beanMap.put("truckNumber",truckBean.getTruckNumber());
				beanMap.put("truckOwner",truckBean.getTruckOwner());
				beanMap.put("truckBrand",truckBean.getTruckBrand());
				beanMap.put("truckName",truckBean.getTruckName());
				beanMap.put("contactNumber",truckBean.getContactNumber());
				beanMap.put("truckType",truckBean.getTruckType());
				beanMap.put("driver",truckBean.getDriver()+ "" );
				beanMap.put("truckColor",truckBean.getTruckColor());
				beanMap.put("truckLength",truckBean.getTruckLength());
				beanMap.put("truckWidth",truckBean.getTruckWidth());
				beanMap.put("truckHeight",truckBean.getTruckHeight());
				beanMap.put("standardWeight",truckBean.getStandardWeight());
				beanMap.put("driverLicense",truckBean.getDriverLicense());
				beanMap.put("engineNumber",truckBean.getEngineNumber());
				beanMap.put("madeDate",truckBean.getMadeDate());
				beanMap.put("buyDate",truckBean.getBuyDate());
				beanMap.put("worth",truckBean.getWorth());
				beanMap.put("buyCost",truckBean.getBuyCost());
				beanMap.put("remark",truckBean.getRemark());
				beanMap.put("createDate",truckBean.getCreateTime());
				beanMap.put("createTime",truckBean.getCreateTime());
			}
			retResult.put("truck",beanMap);
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
	
	public String updateTruck(){
		TruckBean truckBean = new TruckBean(id,truckNumber,truckOwner,truckBrand,truckName,contactNumber,truckType,driver,truckColor,trucklength,truckWidth,truckHeight,standardWeight,driverLicense,engineNumber,madeDate,buyDate,worth,buyCost,remark);
		int maxId = truckService.updateTruck(truckBean);
		this.status = maxId > 0?true:false;
		CacheManager.clearOnly("driverBean_CACHE");
		return "success";
	}
	
	public String deleteTruck(){

		String ids = request.getParameter("deleteTrucks");
		int count = truckService.deleteTruck(ids);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			if(count>0){
				retResult.put("result","1");
			}else{
				retResult.put("result","0");
			}
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
		CacheManager.clearOnly("truckBean_CACHE");
		return null;
	}

}

