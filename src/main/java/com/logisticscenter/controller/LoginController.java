package com.logisticscenter.controller;

import com.cachec.Cache;
import com.cachec.CacheManager;
import com.javabean.SystemInfoBean;
import com.javabean.TruckSetBean;
import com.service.LoginService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	//登录ID
	private String loginid;
	//登录密码
	private String password;
	//登录姓名
	private String lastname;
	//性别
	private int sex;
	//生日
	private String birthday;
	//国籍
	private String nationality;
	//电话号码
	private String telephone;
	//手机号码
	private String mobile;
	//email
	private String email;
	//家庭住址
	private String homeaddress;
	//有效开始日期
	private String startdate;
	//有效结束日期
	private String enddate;
	//状态
	private int status;
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(String homeaddress) {
		this.homeaddress = homeaddress;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
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
	
	private LoginService loginService;
	
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String signIn(){
		HttpServletRequest request =   ServletActionContext.getRequest();
		HttpServletResponse response =   ServletActionContext.getResponse();
		loginid = request.getParameter("loginId");
		password = request.getParameter("password");
		//获得是否可以重复登录
		
		SystemInfoBean systemBean = new SystemInfoBean(loginid,password);
		systemBean = loginService.getSystemInfo(loginid);
		Cache cache = CacheManager.getCacheInfo("truckSettingBean_CACHE");
		TruckSetBean bean=(TruckSetBean)cache.getValue();
		boolean isLogin = getIsLogin(loginid);
		if(!isLogin){
			Map <String,SystemInfoBean> systemMap = new HashMap<String,SystemInfoBean>();
			systemMap.put(loginid,systemBean);
			systemInfo.add(systemMap);
		}
		int reLogin = bean.getReLogin();
		if(reLogin == 1 && isLogin){
			
		}
		request.getSession().setAttribute("System_Info", systemBean);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			int status = 0;
			if(systemBean.getPassword().equals(password)){
				status = 0;
			}else if(!systemBean.getPassword().equals(password)){
				status = 1;
			}else if("".equals(systemBean.getPassword())){
				status = 2;
			}
//			if(reLogin == 1 && isLogin){
//				status = 3;
//			}
			result.put("status",status);
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
	
	/**
	 * @param loginId
	 * @return 是否已经登录
	 */
	private boolean getIsLogin(String loginId){
		for(int i=0;i <systemInfo.size();i++){
			Map<String,SystemInfoBean> systemMap = systemInfo.get(i);
			for(String key : systemMap.keySet()){
				if(key.equals(loginId)){
					return true;
				}
			}
		}
		return false;
	}

}
