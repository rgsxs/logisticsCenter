package com.logisticscenter.mapper;

import java.util.List;

import com.entity.TruckEntity;

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
