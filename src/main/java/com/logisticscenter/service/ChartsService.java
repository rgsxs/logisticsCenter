package com.logisticscenter.service;

import java.util.List;
import java.util.Map;

import com.javabean.ChartsBean;

public interface ChartsService {
	
	
	public abstract Map<String, Object> getClientChartsByMonth(Map<String, Object> params);
	
	public abstract Map<String, Object> getDriverChartsByMonth(Map<String, Object> params);
	
	public abstract Map<String, Object> getClientFeeChartsByMonth(Map<String, Object> params);
	
	public abstract Map<String, Object> getDriverFeeChartsByMonth(Map<String, Object> params);
	

}
