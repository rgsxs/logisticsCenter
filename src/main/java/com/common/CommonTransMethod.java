package com.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cache.CacheManager;
import com.javabean.ClientBean;
import com.javabean.DriverInfoBean;
import com.javabean.FeeTypeBean;
import com.javabean.GoodsTypeBean;
import com.javabean.ImageFileBean;
import com.javabean.TruckBean;
import com.javabean.TruckGoodsOrderDetailBean;
import com.logisticscenter.model.TruckEntity;
import com.logisticscenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class CommonTransMethod {
	//客户service注入
	@Autowired
	public static ClientService clientService;
	//司机service注入
	@Autowired
	public static DriverService driverService;
	//费用类型service注入
	@Autowired
	public static FeeTypeService feeTypeService;
	//货物类型service注入
	@Autowired
	public static GoodsTypeService goodsTypeService;
	//违章记录service注入
	@Autowired
	public static IllegalReportService illegalReportService;
	//admin管理者service注入
	@Autowired
	public static LoginService loginService;
	//维修类型service注入
	@Autowired
	public static RepairTypeService repairTypeService;
	//车辆费用service注入
	@Autowired
	public static TruckFeeInfoService truckFeeInfoService;
	//车辆记录service注入
	@Autowired
	public static TruckGoodsReportService truckGoodsReportService;
	//车辆order记录service注入
	@Autowired
	public static TruckGoodsOrderService truckGoodsOrderService;
	//车辆service注入
	@Autowired
	public static TruckService truckService;
	//报表注入
	@Autowired
	public static ChartsService chartsService;
	//图片文件service注入
	@Autowired
	public static ImageFileService imageFileService;
	@Autowired
	public static TruckSetService truckSetService;


	/**
	 * @param id 司机ID
	 * @return 司机姓名
	 */
	public static String getDriverName(String id){
		if("".equals(id) || id == null){
			return "";
		}
		
		String retStr = "";
		List<DriverInfoBean> beanLst = null;
		try{
			beanLst= driverService.getAllDriverInfo();
			for(int i = 0;i<beanLst.size();i++){
				if(beanLst.get(i).getId() == Integer.parseInt(id)){
					retStr = beanLst.get(i).getName();
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
		
	}
	
	/**
	 * @param driverName 司机姓名
	 * @return 司机ID
	 */
	public static int getDriverId(String driverName){
		if("".equals(driverName) || driverName == null){
			return 0;
		}
		
		int retStr = 0;
		List<DriverInfoBean> beanLst = null;
		try{
			beanLst= driverService.getAllDriverInfo();
			for(int i = 0;i<beanLst.size();i++){
				if(beanLst.get(i).getName().equals(driverName)){
					retStr = beanLst.get(i).getId();
					break;
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
		
	}
	
	public static int createDriver(String driverName){
		int maxId = 0;
		DriverInfoBean bean = new DriverInfoBean(0,driverName, "1", "", "", "", 0, "", "", "", "", "", "", "", "", "", "", "");
		maxId = driverService.insertDriverInfo(bean);
		CacheManager.clearOnly("driverBean_CACHE");
		return maxId;
	}
	
	/**
	 * @param id 客户ID
	 * @return 客户名称
	 */
	public static String getClientName(String id){
		if("".equals(id) || id == null || id.equals("0")){
			return "";
		}
		String retStr = "";
		List<ClientBean> beanLst = null;
		try{
//			beanLst= clientService.getClient(new HashMap());
			for(int i = 0;i<beanLst.size();i++){
				if(beanLst.get(i).getId() == Integer.parseInt(id)){
					retStr = beanLst.get(i).getClientName();
					break;
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
	}
	
	public static int createClient(String clientName){
		int maxId = 0;
		ClientBean bean = new ClientBean(0,clientName,"","","","","");
//		maxId = clientService.insertClient(bean);
		CacheManager.clearOnly("clientBean_CACHE");
		return maxId;
	}
	
	/**
	 * @param clientName 客户名称
	 * @return 客户ID
	 */
	public static int getClientId(String clientName){
		if("".equals(clientName) || clientName == null){
			return 0;
		}
		int retStr = 0;
		List<ClientBean> beanLst = null;
		try{
//			beanLst= clientService.getAllClient();
			for(int i = 0;i<beanLst.size();i++){
				if(beanLst.get(i).getClientName().equals(clientName)){
					retStr = beanLst.get(i).getId();
					break;
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
	}
	
	
	/**
	 * @param id 货物类型ID
	 * @return 货物名称
	 */
	public static String getGoodsTypeName(String id){
		if("".equals(id) || id == null || id.equals("0")){
			return "";
		}
		String retStr = "";
		try{
			List<GoodsTypeBean> beanLst= goodsTypeService.getAllGoodsType();
			String idArr[] = id.split(",");
			for(int i=0;i<idArr.length;i++){
				if(!idArr[i].equals("")){
					for(int k = 0;k<beanLst.size();k++){
						if(beanLst.get(k).getId() == Integer.parseInt(idArr[i])){
							retStr += retStr.equals("")?beanLst.get(k).getGoodsName():","+beanLst.get(k).getGoodsName();
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
	}
	
	/**
	 * @param goodsTypeName 货物名称
	 * @return 货物类型ID
	 */
	public static int getGoodsTypeId(String goodsTypeName){
		if("".equals(goodsTypeName) || goodsTypeName == null){
			return 0;
		}
		int retStr = 0;
		try{
			List<GoodsTypeBean> beanLst= goodsTypeService.getAllGoodsType();
			for(int k = 0;k<beanLst.size();k++){
				if(beanLst.get(k).getGoodsName().equals(goodsTypeName)){
					retStr = beanLst.get(k).getId();
					break;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
	}
	
	/**
	 * @param goodsTypeName 货物名称
	 * @return 货物类型ID
	 */
	public static String getGoodsTypeIds(String goodsTypeName){
		if("".equals(goodsTypeName) || goodsTypeName == null){
			return "";
		}
		String retStr = "";
		try{
			String goodsTypeArr[] = goodsTypeName.split(",");
			for(int i=0;i<goodsTypeArr.length;i++){
				if(!goodsTypeArr[i].equals("")){
					List<GoodsTypeBean> beanLst= goodsTypeService.getAllGoodsType();
					for(int k = 0;k<beanLst.size();k++){
						if(beanLst.get(k).getGoodsName().equals(goodsTypeArr[i])){
							retStr += ","+beanLst.get(k).getId();
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!retStr.equals("")){
			retStr = retStr.substring(1);
		}
		return retStr;
	}
	
	public static int createGoodsType(String goodsName){
		int maxId = 0;
		GoodsTypeBean bean = new GoodsTypeBean( 0,goodsName, 1, 0,"","");
		maxId = goodsTypeService.insertGoodsType(bean);
		CacheManager.clearOnly("goodsTypeBean_CACHE");
		return maxId;
	}
	
	/**
	 * @param id 车牌号
	 * @return 车辆名称
	 */
	public static String getTruckNumber(String id){
		String retStr = "";
		if("".equals(id) || id == null || id.equals("0")){
			return "";
		}
		Map truckInfoMap= truckService.getTruck(new HashMap());
		List<TruckEntity> entityList = (List<TruckEntity>)truckInfoMap.get("data");
		try{
			for(int i = 0;i<entityList.size();i++){
				if(entityList.get(i).getId()== Integer.parseInt(id)){
					retStr = entityList.get(i).getTruckNumber();
					break;
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * @param truckNmuber 车辆名称
	 * @return 车牌号
	 */
	public static int getTruckId(String truckNmuber){
		int retStr = 0;
		if("".equals(truckNmuber) || truckNmuber == null ){
			return 0;
		}
		Map truckInfoMap= truckService.getTruck(new HashMap());
		List<TruckEntity> entityList = (List<TruckEntity>)truckInfoMap.get("data");
		try{
			for(int i = 0;i<entityList.size();i++){
				if(entityList.get(i).getTruckNumber().equals(truckNmuber)){
					retStr = entityList.get(i).getId();
					break;
				}
			}
			return retStr;
		}catch(Exception e){
			e.printStackTrace();
		}
		return retStr;
	}
	
	public static int createTruck(String truckNumber){
		int maxId = 0;
		TruckBean truckBean = new TruckBean(0,truckNumber,"1","","","",0,0,"","", "", "",
				"", "",
				"", "", "",
				"", "", "");
		maxId = truckService.insertTruck(truckBean);
		CacheManager.clearOnly("truckBean_CACHE");
		return maxId;
	}
	
	/**
	 * 是否包车
	 * @param flg
	 * @return 是否包车
	 */
	public static String convertPackage(int flg){
		String retStr = "否";
		if(flg == 1){
			retStr = "是";
		}else{
			retStr = "否";
		}
		return retStr;
	}
	
	/**
	 * 是否
	 * @param str flg
	 * @return 是否
	 */
	public static int convertFlg(String str){
		int retStr = 0;
		if(str.trim().equals("是")){
			retStr = 1;
		}else{
			retStr = 0;
		}
		return retStr;
	}
	
	/**
	 * 是否伙伴
	 * @param flg
	 * @return 个人/伙伴
	 */
	public static String convertTruckPart(int flg){
		String retStr = "个人";
		if(flg == 1){
			retStr = "伙伴";
		}else{
			retStr = "个人";
		}
		return retStr;
	}
	
	/**
	 * 是否包车
	 * @param flg
	 * @return 是否包车
	 */
	public static String convertShowType(int flg){
		String retStr = "";
		if(flg == 0){
			retStr = "费用";
		}else if(flg == 1){
			retStr = "奖励";
		}else{
			retStr = "显示";
		}
		return retStr;
	}
	
	/**
	 * 获得文件名称
	 * @param ids
	 * @return
	 */
	public static String getFileName(String ids){
		if(ids==null || ids.equals("") || ids.equals(",")){
			return "";
		}
		String fileNames = "";
		if(ids.startsWith(",")){
			ids = ids.substring(1);
		}
		if(ids.endsWith(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		List<ImageFileBean> imageList = getImageBean(ids);
		for(ImageFileBean bean:imageList){
			fileNames += fileNames.equals("")?bean.getImageFileName():","+bean.getImageFileName();
		}
		return fileNames;
		
	}
	
	/**
	 * 获得文件路径
	 * @param ids
	 * @return
	 */
	public static String getFullPathName(String ids){
		if(ids==null || ids.equals("") || ids.equals(",")){
			return "";
		}
		String fileNames = "";
		if(ids.startsWith(",")){
			ids = ids.substring(1);
		}
		if(ids.endsWith(",")){
			ids = ids.substring(0,ids.length()-1);
		}
		List<ImageFileBean> imageList = getImageBean(ids);
		for(ImageFileBean bean:imageList){
			fileNames += fileNames.equals("")?bean.getFilerealpath()+"\\"+bean.getImageFileName():","+bean.getFilerealpath()+"\\"+bean.getImageFileName();
		}
		return fileNames;
		
	}
	
	/**
	 * 获得文件Bean
	 * @param ids
	 * @return
	 */
	public static List<ImageFileBean> getImageBean(String ids){
		List<ImageFileBean> imageList = new ArrayList<ImageFileBean>();
		String selectIds = "";
		String idsArr[] = ids.split(",");
		for(int i=0;i<idsArr.length;i++){
			if(!idsArr[i].equals("")){
				selectIds += selectIds.equals("")?idsArr[i]:","+idsArr[i];
			}
		}
		if(ids == null || ids.equals("")){
			return imageList;
		}
		try{
			imageList = imageFileService.getImageFileBy(ids);
		}catch(Exception e){
			e.printStackTrace();
		}
		return imageList;
	}
	
	/**
	 * 根据出车ID和货物类型查询订单详细
	 * @param orderId
	 * @param goodsTypes
	 * @return
	 */
	public List<TruckGoodsOrderDetailBean> getOrderDetails(int orderId,String goodsTypes){
		List<TruckGoodsOrderDetailBean> listDetailBean = new ArrayList<TruckGoodsOrderDetailBean>();
		TruckGoodsOrderDetailBean selectInfo = new TruckGoodsOrderDetailBean();
		selectInfo.setReportId(orderId);
		selectInfo.setGoodsTypes(goodsTypes);
		listDetailBean = truckGoodsOrderService.getTruckGoodsOrderDetail(selectInfo);
		return listDetailBean;
	}
	
	
	/**
	 * @return
	 */
	public static String getAllFeeTypeName(){
		String FeeTypeNameHTML="";
		List<FeeTypeBean> feeTypeBeanLst= feeTypeService.getAllFeeType();
		for(int i = 0 ; i<feeTypeBeanLst.size(); i++){
			if(feeTypeBeanLst.get(i).getIsUse() == 0) continue;
			FeeTypeNameHTML +="<th>"+feeTypeBeanLst.get(i).getFeeName()+"</th>";
		}
		return FeeTypeNameHTML;
		 
	}
	
	/**
	 * @return
	 */
	public static String getAllFeeTypeColumn(){
		String feeTypeNameColumn="";
		List<FeeTypeBean> feeTypeBeanLst= feeTypeService.getAllFeeType();
		for(int i = 0 ; i<feeTypeBeanLst.size(); i++){
			if(feeTypeBeanLst.get(i).getIsUse() == 0) continue;
			feeTypeNameColumn+="+cast("+feeTypeBeanLst.get(i).getFeeTypeColumn()+" as int)";
		}
		if(!feeTypeNameColumn.equals("")){
			feeTypeNameColumn = feeTypeNameColumn.substring(1);
		}
		return feeTypeNameColumn;
		 
	}
	
	public static int createFeeType(String feeTypeName){
		int maxId = 0;
		FeeTypeBean bean = new FeeTypeBean( 0,feeTypeName,0,1,0,"","");
		maxId = feeTypeService.insertFeeType(bean);
		CacheManager.clearOnly("feeTypeBean_CACHE");
		return maxId;
	}
	
	/**
	 * 获得出车订单编号
	 * @param date 要查询的日期
	 * @param num 显示的个数
	 * @return
	 */
	public static synchronized int getReportNumber(String date,int num){
		String maxId = ConvertService.null2String( truckGoodsReportService.getMaxReportNumber(date),"000000000");
		//转换成后num位
		return ConvertService.getIntValue(maxId.substring(maxId.length()-num), 1)+1;
	}
	public static void main(String[] args) {
		String a = "BWL20170712351";
		int b = ConvertService.getIntValue(a.substring(a.length()-2), 1);
		System.out.println(b);
	}
	
}
