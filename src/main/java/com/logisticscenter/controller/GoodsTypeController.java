package com.logisticscenter.controller;

import com.cachec.CacheManager;
import com.common.ConvertService;
import com.javabean.GoodsTypeBean;
import com.service.GoodsTypeService;
import com.util.TransforUtils;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsTypeController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoodsTypeController(){
		
	}
	
	//标识ID
	private int id;
	//货物名称
	private String goodsName;
	//是否启用
	private int isUse;
	//是否删除
	private int isDelete;
	//方法
	private String method;
	//货物选择框
	private String selectGoodsName;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	private boolean  status;
	
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

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	public String getMethod() {
		return method;
	}
	
	public String getSelectGoodsName() {
		return selectGoodsName;
	}

	public void setSelectGoodsName(String selectGoodsName) {
		this.selectGoodsName = selectGoodsName;
	}

	public void setMethod(String method) {
		this.method = method;
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

	private GoodsTypeService goodsTypeService;

	public GoodsTypeService getGoodsTypeService() {
		return goodsTypeService;
	}

	public void setGoodsTypeService(GoodsTypeService goodsTypeService) {
		this.goodsTypeService = goodsTypeService;
	}

	@SuppressWarnings("unchecked")
	public String selectAllGoodsType(){

		String selectType = ConvertService.null2String(request.getParameter("selectType"));
		List<GoodsTypeBean> beanLst = null;
		beanLst= goodsTypeService.getAllGoodsType();
		//systemBean = loginService.getSystemInfo(loginid);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				if(beanLst.get(i).getIsUse() == 0 && selectType.equals("isUse")){
					continue;
				}else if(beanLst.get(i).getIsUse() == 1 && selectType.equals("notUse")){
					continue;
				}
				beanMap = new HashMap();
				beanMap.put("goodsName",beanLst.get(i).getGoodsName());
				beanMap.put("isUse",beanLst.get(i).getIsUse());
				beanMap.put("isDelete",beanLst.get(i).getIsDelete());
				beanMap.put("id",beanLst.get(i).getId());
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("typeInfo",result);
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
	
	
	public String addGoodsType(){
		int maxId = 0;
		GoodsTypeBean bean = new GoodsTypeBean( id,goodsName, isUse, isDelete,pageSize,currentPage);
		if("add".equals(method)){
			maxId = goodsTypeService.insertGoodsType(bean);
			this.status = maxId > 0?true:false;
		}else if("edit".equals(method)){
			goodsTypeService.updateGoodsType(bean);
		}
		CacheManager.clearOnly("goodsTypeBean_CACHE");
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String getGoodsTypeBy(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		selectGoodsName = request.getParameter("selectGoodsName");
		//如果查询的是按照使用情况来查看,默认已1:使用中来查看
		isUse = ConvertService.getIntValue(request.getParameter("isUse"),-1);
		HttpServletResponse response =   ServletActionContext.getResponse();
		pageSize = TransforUtils.null2o(pageSize);
		currentPage = TransforUtils.null2o(currentPage);
		GoodsTypeBean bean = new GoodsTypeBean( id,selectGoodsName,isUse,isDelete,pageSize,currentPage);
		List<GoodsTypeBean> beanLst= goodsTypeService.getGoodsType(bean);
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = goodsTypeService.getGoodsTypeCount(bean);
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
				beanMap.put("goodsName",beanLst.get(i).getGoodsName());
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
	
	public String deleteGoodsType(){

		String ids = request.getParameter("deleteGoodsTypes");
		int count = goodsTypeService.deleteGoodsType(ids);
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
		CacheManager.clearOnly("goodsTypeBean_CACHE");
		return null;
	}
	

}
