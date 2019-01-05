package com.logisticscenter.service;

import com.javabean.TruckSetBean;

import java.util.Map;

public interface TruckSetService {
	
	
	public abstract Map<String, Object> getTruckSet(Map<String, Object> params);
	
	public abstract Map<String, Object> updateTruckSet(Map<String, Object> params);
	

}
