package com.logisticscenter.Controller;

import com.common.CommonTransMethod;
import com.common.ConvertService;
import com.javabean.CommercialBean;
import com.javabean.TruckBean;
import com.service.CommercialService;
import com.service.TruckService;
import com.util.TimeUtil;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @卜伟领 2017
 *商业险ACTION
 */
public class CommercialController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommercialController(){
		
	}
	//标识ID
	private int id;
	//车牌号
	private String truckNumber;
	//开始日期
	private String startDate;
	//结束日期
	private String endDate;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	//时间选择
	private int timeSag;
	//修改日期
	private String editDate;
	//修改时间
	private String editTime;
	
	//pageSize
	private String pageSize;
	
	//currentPage
	private String currentPage;
	
	private CommercialService commercialService;
	//车辆服务类
	private TruckService truckService;
	//返回值状态
	private boolean status;
	
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


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public int getTimeSag() {
		return timeSag;
	}


	public void setTimeSag(int timeSag) {
		this.timeSag = timeSag;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public CommercialService getCommercialService() {
		return commercialService;
	}

	public void setCommercialService(CommercialService commercialService) {
		this.commercialService = commercialService;
	}

	public TruckService getTruckService() {
		return truckService;
	}


	public void setTruckService(TruckService truckService) {
		this.truckService = truckService;
	}


	public String addCommercial(){
		CommercialBean bean = new CommercialBean(truckNumber,startDate,endDate,pageSize,currentPage);
		int maxId = commercialService.insertCommercial(bean);
		this.status = maxId > 0?true:false;
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String selectAllCommercial(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		timeSag = ConvertService.getIntValue((request.getParameter("timeSag")),0);
		truckNumber = request.getParameter("truckNumber");
		if(timeSag > 0&&timeSag<6){
			startDate = TimeUtil.getDateByOption(""+timeSag,"0");
			endDate = TimeUtil.getDateByOption(""+timeSag,"1");
			
		}else{
			if(timeSag==6){//指定时间
				startDate = request.getParameter("startDate");
				endDate = request.getParameter("endDate");
			}
			
		}
		CommercialBean infoBean = new CommercialBean(truckNumber,startDate,endDate,pageSize,currentPage);
		List<CommercialBean> beanLst= commercialService.getCommercial(infoBean);
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = commercialService.getCommercialCount(infoBean);
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
				beanMap.put("truckNumberShow",CommonTransMethod.getTruckNumber(beanLst.get(i).getTruckNumber()));
				beanMap.put("startDate",beanLst.get(i).getStartDate());
				beanMap.put("endDate",beanLst.get(i).getEndDate());
				beanMap.put("createDate",beanLst.get(i).getCreateDate());
				beanMap.put("createTime",beanLst.get(i).getCreateTime());
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("commercial",result);
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
	public String selectCommercialById(){
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		id = ConvertService.getIntValue((request.getParameter("id")),0);
		CommercialBean bean= commercialService.getCommercial(id+"");
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			result.put("id",bean.getId());
			result.put("truckNumber",bean.getTruckNumber());
			result.put("startDate",bean.getStartDate());
			result.put("endDate",bean.getEndDate());
			result.put("createDate",bean.getCreateDate());
			result.put("createTime",bean.getCreateTime());
			retResult.put("commercial",result);
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
	
	public String deleteCommercial(){

		String ids = request.getParameter("deleteCommercials");
		int count = commercialService.deleteCommercial(ids);
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
		return null;
	}
	
	public String updateCommercial(){

		truckNumber = request.getParameter("truckNumber");
		startDate = request.getParameter("startDate");
		endDate = request.getParameter("endDate");
		CommercialBean infoBean = new CommercialBean(truckNumber,startDate,endDate,pageSize,currentPage);
		infoBean.setId(id);
		commercialService.updateCommercial(infoBean);
		
		return "success";
	}
	
	public String getWarnCommercial(){

		int days = ConvertService.getIntValue(request.getParameter("commercialDate"),0);
		String selectDays = ConvertService.getDate(days);
		List<CommercialBean> beanLst = commercialService.getWarnCommercial(selectDays);
		List<TruckBean> beanTruckLst= truckService.getAllTruck();
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			List truckRusultMap = new ArrayList();
			String status = "0";
			String msg = "";
			for(int j=0;j<beanLst.size();j++){
				truckRusultMap.add(beanLst.get(j).getTruckNumber());
			}
			for(int i=0;i<beanTruckLst.size();i++){
				int truckId = beanTruckLst.get(i).getId();
				if(truckRusultMap.contains(truckId+"")){
					continue;
				}else{
					msg +="车牌号:"+beanTruckLst.get(i).getTruckNumber()+"在"+selectDays+"没有提交商业保险,请尽快提交"+"<br>";
					status="1";
				}
				
			}
			retResult.put("status", status);
			retResult.put("msg", msg);
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
	

}
