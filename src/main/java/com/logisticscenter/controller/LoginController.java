package com.logisticscenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.cache.Cache;
import com.cache.CacheManager;
import com.javabean.SystemInfoBean;
import com.javabean.TruckSetBean;
import com.logisticscenter.service.LoginService;
import com.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping(value = "/api/login")
public class LoginController implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static List<Map<String,SystemInfoBean>> systemInfo = new ArrayList<Map<String,SystemInfoBean>>();

	public LoginController(){

	}


	@Autowired
	private LoginService loginService;


	/**
	 * @return
	 */
	@ResponseBody
	@PostMapping("/signIn")
	public Map signIn(HttpServletRequest request , HttpServletResponse response){
		Map<String, Object> apidatas = new HashMap<String, Object>();
		try {
			apidatas.putAll(loginService.getSystemInfo(ParamUtil.request2Map(request)));
			apidatas.put("api_status", true);
		} catch (Exception e) {
			e.printStackTrace();
			apidatas.put("api_status", false);
			apidatas.put("api_errormsg", "catch exception : " + e.getMessage());
		}
		return apidatas;


//		loginid = request.getParameter("loginId");
//		password = request.getParameter("password");
//		//获得是否可以重复登录
//
//		SystemInfoBean systemBean = new SystemInfoBean(loginid,password);
//		systemBean = loginService.getSystemInfo(loginid);
//		Cache cache = CacheManager.getCacheInfo("truckSettingBean_CACHE");
//		TruckSetBean bean=(TruckSetBean)cache.getValue();
//		boolean isLogin = getIsLogin(loginid);
//		if(!isLogin){
//			Map <String,SystemInfoBean> systemMap = new HashMap<String,SystemInfoBean>();
//			systemMap.put(loginid,systemBean);
//			systemInfo.add(systemMap);
//		}
//		int reLogin = bean.getReLogin();
//		if(reLogin == 1 && isLogin){
//
//		}
//		request.getSession().setAttribute("System_Info", systemBean);
//		 //获取输出流，然后使用
//        PrintWriter out = null;
//		try {
//			Map result = new HashMap();
//			int status = 0;
//			if(systemBean.getPassword().equals(password)){
//				status = 0;
//			}else if(!systemBean.getPassword().equals(password)){
//				status = 1;
//			}else if("".equals(systemBean.getPassword())){
//				status = 2;
//			}
////			if(reLogin == 1 && isLogin){
////				status = 3;
////			}
//			result.put("status",status);
//			JSONObject jsonb = new JSONObject();
//			response.setContentType("text/html; charset=utf-8");
//			out = response.getWriter();
////			/* 设置格式为text/json    */
////            response.setContentType("text/json");
////            /*设置字符集为'UTF-8'*/
////            response.setCharacterEncoding("UTF-8");
//			out.print(jsonb.parseObject(result).toString());
//			out.flush();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//返回json对象
	}


}
