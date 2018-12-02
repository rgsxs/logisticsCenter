package com.logisticscenter.controller;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class OwnerController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OwnerController(){
		
	}
	
	@SuppressWarnings("unchecked")
	public String selectTruckOwner(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map ownerMap = new HashMap();
			ownerMap.put("1","程1同");
			ownerMap.put("2","程2同");
			ownerMap.put("3","程3同");
			ownerMap.put("4","程4同");
			ownerMap.put("5","程5同");
			ownerMap.put("6","程6同");
			result.put("owner", ownerMap);
			JSONObject jsonb = new JSONObject();
			response.setContentType("text/html; charset=utf-8");
			out = response.getWriter();
//			/* 设置格式为text/json    */
//            response.setContentType("text/json"); 
//            /*设置字符集为'UTF-8'*/
//            response.setCharacterEncoding("UTF-8"); 
			out.print(jsonb.parseObject(result).toString());
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return null;
	}

}
