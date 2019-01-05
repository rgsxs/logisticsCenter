package com.logisticscenter.service;

import java.util.List;
import java.util.Map;

import com.javabean.SystemInfoBean;

public interface LoginService {
	
	public abstract Map insertSystemInfo(Map<String, Object> params);
	
	public abstract Map getSystemInfo(Map<String, Object> params);
	
	public abstract Map deleteSystemInfo(Map<String, Object> params);
	
	public abstract Map updateSystemInfo(Map<String, Object> params);
	
	public abstract Map updateAllSystemInfo(Map<String, Object> params);

}
