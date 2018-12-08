package com.logisticscenter.service;

import java.util.List;

import com.javabean.SystemInfoBean;

public interface LoginService {
	
	public abstract SystemInfoBean insertSystemInfo(SystemInfoBean insertInfo);
	
	public abstract SystemInfoBean getSystemInfo(String id);
	
	public abstract List<SystemInfoBean> getSystemInfo(SystemInfoBean selectInfo);
	
	public abstract void deleteSystemInfo(String id);
	
	public abstract void updateSystemInfo(SystemInfoBean updateInfo);
	
	public abstract void updateAllSystemInfo(SystemInfoBean updateInfo);

}
