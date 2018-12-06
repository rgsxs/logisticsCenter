package com.logisticscenter.mapper;

import com.logisticscenter.model.TruckEntity;

import java.util.List;



public interface TruckInfoDao {
	
	public abstract int insertTruck(TruckEntity insertInfo);
	
	public abstract TruckEntity getTruckInfo(String id);
	
	public abstract List<TruckEntity> getTruckInfo(TruckEntity selectInfo);
	
	public abstract String getTruckInfoCount(TruckEntity selectInfo);
	
	public abstract List<TruckEntity> getAllTruck();
	
	public abstract int deleteTruck(String id);
	
	public abstract int updateTruck(TruckEntity selectInfo);
	
	public abstract void updateAllTruck(TruckEntity selectInfo);
}
