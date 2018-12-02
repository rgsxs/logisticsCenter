package com.logisticscenter.Controller;

import com.cachec.CacheManager;
import com.javabean.DriverInfoBean;
import com.service.DriverService;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @卜伟领 2017
 *
 */
public class DriverController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DriverController(){
		
	}
	
	//标识ID
	private int id;
	//司机姓名
	private String name;
	//司机性别
	private String sex;
	//司机国籍
	private String nativePlace;
	//司机文化程度
	private String education;
	//司机生日日期
	private String birthday;
	//年龄
	private int age;
	//住址
	private String address;
	//联系电话
	private String contactNmuber;
	//手机号码
	private String mobile;
	//身份证号码
	private String idNumber;
	//入职时间
	private String startWorkDate;
	//驾驶证号
	private String driverLicense;
	//驾驶车辆号码
	private String truckNumber;
	//评价
	private String appraise;
	//工资标准
	private String salary;
	//备注
	private String remark;
	//职位
	private String job;
	//选择司机框
	private String selectDriverName;
	//精确查找/模糊查找
	private String checkStyle ="";
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNmuber() {
		return contactNmuber;
	}
	public void setContactNmuber(String contactNmuber) {
		this.contactNmuber = contactNmuber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getStartWorkDate() {
		return startWorkDate;
	}
	public void setStartWorkDate(String startWorkDate) {
		this.startWorkDate = startWorkDate;
	}
	public String getDriverLicense() {
		return driverLicense;
	}
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}
	public String getTruckNumber() {
		return truckNumber;
	}
	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	public String getSelectDriverName() {
		return selectDriverName;
	}
	public void setSelectDriverName(String selectDriverName) {
		this.selectDriverName = selectDriverName;
	}
	
	public String getCheckStyle() {
		return checkStyle;
	}
	public void setCheckStyle(String checkStyle) {
		this.checkStyle = checkStyle;
	}

	//返回值状态
	private boolean status;
	
	//创建日期
	private String createDate;
	//创建时间
	private String createTime;
	
	private DriverService driverService;
	
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
	
	public DriverService getDriverService() {
		return driverService;
	}
	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}
	
	
	@SuppressWarnings("unchecked")
	public String selectAllDriver(){
		HttpServletResponse response =   ServletActionContext.getResponse();
		List<DriverInfoBean> beanLst = null;
		beanLst= driverService.getAllDriverInfo();
		//systemBean = loginService.getSystemInfo(loginid);
		 //获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map result = new HashMap();
			Map retResult = new HashMap();
			Map beanMap = null;
			for(int i = 0 ; i<beanLst.size(); i++){
				beanMap = new HashMap();
				beanMap.put("id",beanLst.get(i).getId());
				beanMap.put("driverName",beanLst.get(i).getName());
				beanMap.put("sex",beanLst.get(i).getSex());
				beanMap.put("nativePlace",beanLst.get(i).getNativePlace());
				beanMap.put("education",beanLst.get(i).getEducation());
				beanMap.put("birthday",beanLst.get(i).getBirthday());
				beanMap.put("age",beanLst.get(i).getAge());
				beanMap.put("address",beanLst.get(i).getAddress());
				beanMap.put("contactNmuber",beanLst.get(i).getContactNmuber());
				beanMap.put("mobile",beanLst.get(i).getMobile());
				beanMap.put("idNumber",beanLst.get(i).getIdNumber());
				beanMap.put("startWorkDate",beanLst.get(i).getStartWorkDate());
				beanMap.put("driverLicense",beanLst.get(i).getDriverLicense());
				beanMap.put("truckNumber",beanLst.get(i).getTruckNumber());
				beanMap.put("appraise",beanLst.get(i).getAppraise());
				beanMap.put("salary",beanLst.get(i).getSalary());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("job",beanLst.get(i).getJob());
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("driver",result);
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
	
	
	public String addDriver(){
		DriverInfoBean bean = new DriverInfoBean(id,name, sex, nativePlace, education, birthday, age, address, contactNmuber, mobile, idNumber, startWorkDate, driverLicense, truckNumber, appraise, salary, remark, job);
		int maxId = driverService.insertDriverInfo(bean);
		this.status = maxId > 0?true:false;
		id = maxId;
		CacheManager.clearOnly("driverBean_CACHE");
		return "success";
	}
	public String addDriver1(){
		DriverInfoBean bean = new DriverInfoBean(id,name, sex, nativePlace, education, birthday, age, address, contactNmuber, mobile, idNumber, startWorkDate, driverLicense, truckNumber, appraise, salary, remark, job);
		int maxId = driverService.insertDriverInfo(bean);
		this.status = maxId > 0?true:false;
		id = maxId;
		CacheManager.clearOnly("driverBean_CACHE");
		return "success";
	}
	
	public String updateDriver(){
		DriverInfoBean bean = new DriverInfoBean(id,name, sex, nativePlace, education, birthday, age, address, contactNmuber, mobile, idNumber, startWorkDate, driverLicense, truckNumber, appraise, salary, remark, job);
		int maxId = driverService.updateDriverInfo(bean);
		this.status = maxId > 0?true:false;
		CacheManager.clearOnly("driverBean_CACHE");
		return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String selectDriverByName(){

		selectDriverName = request.getParameter("selectDriverName");
		checkStyle = request.getParameter("checkStyle");
		DriverInfoBean infoBean = new DriverInfoBean(selectDriverName,pageSize,currentPage);
		List<DriverInfoBean> beanLst= driverService.getDriverInfo(infoBean,checkStyle);
		int pageCount = 0;
		if("1".equals(currentPage)){
			String count = driverService.getDriverInfoCount(infoBean,checkStyle);
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
				beanMap.put("driverName",beanLst.get(i).getName());
				beanMap.put("sex",beanLst.get(i).getSex());
				beanMap.put("nativePlace",beanLst.get(i).getNativePlace());
				beanMap.put("education",beanLst.get(i).getEducation());
				beanMap.put("birthday",beanLst.get(i).getBirthday());
				beanMap.put("age",beanLst.get(i).getAge());
				beanMap.put("address",beanLst.get(i).getAddress());
				beanMap.put("contactNmuber",beanLst.get(i).getContactNmuber());
				beanMap.put("mobile",beanLst.get(i).getMobile());
				beanMap.put("idNumber",beanLst.get(i).getIdNumber());
				beanMap.put("startWorkDate",beanLst.get(i).getStartWorkDate());
				beanMap.put("driverLicense",beanLst.get(i).getDriverLicense());
				beanMap.put("truckNumber",beanLst.get(i).getTruckNumber());
				beanMap.put("appraise",beanLst.get(i).getAppraise());
				beanMap.put("salary",beanLst.get(i).getSalary());
				beanMap.put("remark",beanLst.get(i).getRemark());
				beanMap.put("job",beanLst.get(i).getJob());
				result.put(beanLst.get(i).getId(), beanMap);
			}
			retResult.put("driver",result);
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
	public String selectDriverById(){

		String idStr = request.getParameter("id");
		DriverInfoBean driverBean = driverService.getDriverInfo(idStr);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			Map beanMap = null;
			if(driverBean != null){
				beanMap = new HashMap();
				beanMap.put("id",driverBean.getId());beanMap.put("id",driverBean.getId());
				beanMap.put("name",driverBean.getName());
				beanMap.put("sex",driverBean.getSex());
				beanMap.put("nativePlace",driverBean.getNativePlace());
				beanMap.put("education",driverBean.getEducation());
				beanMap.put("birthday",driverBean.getBirthday());
				beanMap.put("age",driverBean.getAge());
				beanMap.put("address",driverBean.getAddress());
				beanMap.put("contactNmuber",driverBean.getContactNmuber());
				beanMap.put("mobile",driverBean.getMobile());
				beanMap.put("idNumber",driverBean.getIdNumber());
				beanMap.put("startWorkDate",driverBean.getStartWorkDate());
				beanMap.put("driverLicense",driverBean.getDriverLicense());
				beanMap.put("truckNumber",driverBean.getTruckNumber());
				beanMap.put("appraise",driverBean.getAppraise());
				beanMap.put("salary",driverBean.getSalary());
				beanMap.put("remark",driverBean.getRemark());
				beanMap.put("job",driverBean.getJob());
//				beanMap.put("deleteFlg",driverBean.getDeleteFlg());
				beanMap.put("createDate",driverBean.getCreateDate());
				beanMap.put("createTime",driverBean.getCreateTime());

			}
			retResult.put("client",beanMap);
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
	
	public String deleteDriver(){

		String ids = request.getParameter("deleteDrivers");
		int count = driverService.deleteDriverInfo(ids);
		//获取输出流，然后使用  
        PrintWriter out = null;
		try {
			Map retResult = new HashMap();
			if(count>0){
				retResult.put("result","1");
				CacheManager.clearOnly("driverBean");
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
		CacheManager.clearOnly("driverBean_CACHE");
		return null;
	}
	

}
