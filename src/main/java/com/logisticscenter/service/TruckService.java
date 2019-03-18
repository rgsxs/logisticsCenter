package com.logisticscenter.service;

import java.util.List;
import java.util.Map;

import com.javabean.TruckBean;
import com.logisticscenter.model.TruckEntity;

public interface TruckService {
	
	public abstract int insertTruck(TruckBean insertInfo);
	
	public abstract TruckBean getTruckInfo(String id);
	
	public abstract List<TruckBean> getTruckInfo(TruckBean selectInfo);
	
	public abstract String getTruckInfoCount(TruckBean selectInfo);
	
	public abstract Map getTruck(Map params);
	
	public abstract int deleteTruck(String id);
	
	public abstract int updateTruck(TruckBean updateInfo);
	
	public abstract void updateAllTruck(TruckBean updateInfo);

	public abstract Map getAdvancedForm(Map params);


}
