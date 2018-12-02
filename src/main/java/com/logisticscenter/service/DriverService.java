package com.logisticscenter.service;

import java.util.List;

import com.entity.DriverInfoEntity;
import com.javabean.DriverInfoBean;

public interface DriverService {
	
	public abstract int insertDriverInfo(DriverInfoBean insertInfo);
	
	public abstract DriverInfoBean getDriverInfo(String id);
	
	public abstract List<DriverInfoBean> getDriverInfo(DriverInfoBean selectInfo, String selectStatus);
	
	public abstract String getDriverInfoCount(DriverInfoBean selectInfo, String selectStatus);
	
	public abstract List<DriverInfoBean> getAllDriverInfo();
	
	public abstract int deleteDriverInfo(String id);
	
	public abstract int updateDriverInfo(DriverInfoBean updateInfo);
	
	public abstract void updateAllDriverInfo(DriverInfoBean updateInfo);

}
