package com.logisticscenter.service;

import java.util.List;

import com.entity.TruckEntity;
import com.javabean.TruckBean;

public interface TruckService {
	
	public abstract int insertTruck(TruckBean insertInfo);
	
	public abstract TruckBean getTruckInfo(String id);
	
	public abstract List<TruckBean> getTruckInfo(TruckBean selectInfo);
	
	public abstract String getTruckInfoCount(TruckBean selectInfo);
	
	public abstract List<TruckBean> getAllTruck();
	
	public abstract int deleteTruck(String id);
	
	public abstract int updateTruck(TruckBean updateInfo);
	
	public abstract void updateAllTruck(TruckBean updateInfo);

}
