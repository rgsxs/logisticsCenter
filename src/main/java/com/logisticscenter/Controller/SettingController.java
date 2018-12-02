package com.logisticscenter.Controller;

import com.cachec.Cache;
import com.cachec.CacheManager;
import com.javabean.TruckSetBean;
import com.service.TruckSetService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @卜伟领 2017
 *
 */
public class SettingController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SettingController(){
		
	}
	//每页显示几条记录
	private String pageSize;
	//商业险提前几天
	private String commercialDate;
	//强制险提交几天
	private String compulsoryDate;
	//订单规则
	private String orderRule;
	//前缀
	private String preRule;
	//后缀
	private String lastRule;
	//允许重复登录
	private String reLogin;
	
	private TruckSetService truckSetService;
	
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

	public String getReLogin() {
		return reLogin;
	}

	public void setReLogin(String reLogin) {
		this.reLogin = reLogin;
	}

	public TruckSetService getTruckSetService() {
		return truckSetService;
	}

	public void setTruckSetService(TruckSetService truckSetService) {
		this.truckSetService = truckSetService;
	}


	@SuppressWarnings("unchecked")
	public String selectSetting(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		TruckSetBean bean= null;
		if(CacheManager.getCacheInfo("truckSettingBean_CACHE")!=null){
			Cache cache = CacheManager.getCacheInfo("truckSettingBean_CACHE");
			bean = (TruckSetBean)cache.getValue();
		}else{
			bean= truckSetService.getTruckSet();
			Cache cache = new Cache();
			Date date = new Date();
			//设置应用设置缓存
			cache.setKey("truckSetting");
			cache.setTimeOut(date.getTime());
			cache.setValue(bean);
			CacheManager.putCache("truckSettingBean_CACHE", cache);
		}
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			result.put("pageSize",bean.getPageSize());
			result.put("commercialDate",bean.getCommercialDate());
			result.put("compulsoryDate",bean.getCompulsoryDate());
			result.put("orderRule",bean.getOrderRule());
			result.put("preRule",bean.getPreRule());
			result.put("lastRule",bean.getLastRule());
			result.put("reLogin",bean.getReLogin());
			retResult.put("truckSet",result);
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
	public String updateSetting(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		TruckSetBean bean = new TruckSetBean( pageSize,commercialDate,compulsoryDate,orderRule,preRule,lastRule,reLogin);
		truckSetService.updateTruckSet(bean);
		CacheManager.clearOnly("truckSettingBean_CACHE");
		return null;
	}
	
	

}
