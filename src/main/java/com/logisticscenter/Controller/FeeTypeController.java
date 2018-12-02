package com.logisticscenter.Controller;

import com.cachec.CacheManager;
import com.common.CommonTransMethod;
import com.common.ConvertService;
import com.javabean.FeeTypeBean;
import com.service.FeeTypeService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeeTypeController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FeeTypeController(){
		
	}
	
	//标识ID
	private int id;
	//费用名称
	private String feeName;
	//显示类型
	private int showType;
	//是否启用
	private int isUse;
	//是否删除
	private int isDelete;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	private boolean  status;
	
	//page
	private String page;
	
	//pageSize
	private String pageSize;
	
	//currentPage
	private String currentPage;
	
	//方法
	private String method;
	//费用选择框
	private String selectFeeName;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}

	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
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


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getSelectFeeName() {
		return selectFeeName;
	}

	public void setSelectFeeName(String selectFeeName) {
		this.selectFeeName = selectFeeName;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
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

	private FeeTypeService feeTypeService;

	public FeeTypeService getFeeTypeService() {
		return feeTypeService;
	}

	public void setFeeTypeService(FeeTypeService feeTypeService) {
		this.feeTypeService = feeTypeService;
	}

	@SuppressWarnings("unchecked")
	public String selectAllFeeType(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		List<FeeTypeBean> beanLst= null;
		beanLst= feeTypeService.getAllFeeType();
		//systemBean = loginService.getSystemInfo(loginid);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("feeName",beanLst.get(i).getFeeName());
				beanMap.put("isUse",beanLst.get(i).getIsUse());
				beanMap.put("isDelete",beanLst.get(i).getIsDelete());
				beanMap.put("showType",beanLst.get(i).getShowType());
				beanMap.put("id",beanLst.get(i).getId());
				
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("typeInfo",result);
			retResult.put("pageCount","50");
			retResult.put("currentPage","2");
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
	
	
	public String addFeeType(){
		int maxId = 0;
		FeeTypeBean bean = new FeeTypeBean( id,feeName,showType,isUse,isDelete,pageSize,currentPage);
		if("add".equals(method)){
			maxId = feeTypeService.insertFeeType(bean);
			this.status = maxId > 0?true:false;
		}else if("edit".equals(method)){
			feeTypeService.updateFeeType(bean);
		}
		CacheManager.clearOnly("feeTypeBean_CACHE");
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String getFeeTypeBy(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		selectFeeName = ConvertService.null2String(request.getParameter("selectFeeName"));
		//如果查询的是按照使用情况来查看,默认已1:使用中来查看
		isUse = ConvertService.getIntValue(request.getParameter("isUse"),-1);
		HttpServletResponse response =   ServletActionContext.getResponse();
		FeeTypeBean bean = new FeeTypeBean( id,selectFeeName,showType,isUse,isDelete,pageSize,currentPage);
		List<FeeTypeBean> beanLst= feeTypeService.getFeeType(bean);
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = feeTypeService.getFeeTypeCount(bean);
			pageCount = Integer.parseInt(count)%Integer.parseInt(pageSize) == 0?(Integer.parseInt(count)/Integer.parseInt(pageSize)):(Integer.parseInt(count)/Integer.parseInt(pageSize) + 1);
		}
		//systemBean = loginService.getSystemInfo(loginid);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("feeName",beanLst.get(i).getFeeName());
				beanMap.put("showTypeShow",CommonTransMethod.convertShowType(beanLst.get(i).getShowType()));
				beanMap.put("showType",beanLst.get(i).getShowType());
				beanMap.put("isUse",beanLst.get(i).getIsUse());
				beanMap.put("isDelete",beanLst.get(i).getIsDelete());
				beanMap.put("id",beanLst.get(i).getId());
				
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("typeInfo",result);
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
	
	public String deleteFeeType(){

		String ids = request.getParameter("deleteFeeTypes");
		int count = feeTypeService.deleteFeeType(ids);
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
	

}
