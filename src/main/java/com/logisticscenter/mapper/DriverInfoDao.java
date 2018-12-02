package com.logisticscenter.mapper;

import java.util.List;

import com.entity.DriverInfoEntity;

public interface DriverInfoDao {
	
	public abstract int insertDriverInfo(DriverInfoEntity insertInfo);
	
	public abstract DriverInfoEntity getDriverInfo(String id);
	
	public abstract List<DriverInfoEntity> getDriverInfo(DriverInfoEntity selectInfo, String selectStatus);
	
	public abstract String getDriverInfoCount(DriverInfoEntity selectInfo, String selectStatus);
	
	public abstract List<DriverInfoEntity> getAllDriverInfo();
	
	public abstract int deleteDriverInfo(String id);
	
	public abstract int updateDriverInfo(DriverInfoEntity selectInfo);
	
	public abstract void updateAllDriverInfo(DriverInfoEntity selectInfo);
}
