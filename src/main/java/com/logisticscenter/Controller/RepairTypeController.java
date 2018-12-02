package com.logisticscenter.Controller;

import com.javabean.RepairTypeBean;
import com.service.RepairTypeService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepairTypeController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RepairTypeController(){
		
	}
	
	//标识ID
	private int id;
	//货物名称
	private String repairName;
	//是否启用
	private int isUse;
	//是否删除
	private int isDelete;
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
		return repairName;
	}

	public void setGoodsName(String repairName) {
		this.repairName = repairName;
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

	private RepairTypeService repairTypeService;

	public RepairTypeService getRepairTypeService() {
		return repairTypeService;
	}

	public void setRepairTypeService(RepairTypeService repairTypeService) {
		this.repairTypeService = repairTypeService;
	}

	@SuppressWarnings("unchecked")
	public String selectRepairType(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		List<RepairTypeBean> beanLst= repairTypeService.getAllRepairType();
		//systemBean = loginService.getSystemInfo(loginid);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("repairName",beanLst.get(i).getGoodsName());
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
	
	
	public String addRepairType(){
		RepairTypeBean bean = new RepairTypeBean( repairName, isUse, isDelete);
		int maxId = repairTypeService.insertRepairType(bean);
		this.status = maxId > 0?true:false;
		return "success";
	}
	

}
