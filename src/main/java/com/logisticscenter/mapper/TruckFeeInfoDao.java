package com.logisticscenter.mapper;

import java.util.List;

import com.entity.TruckFeeInfoEntity;

public interface TruckFeeInfoDao {
	
	public abstract int insertTruckFeeInfo(TruckFeeInfoEntity insertInfo);
	
	public abstract TruckFeeInfoEntity getTruckFeeInfo(String id);
	
	public abstract List<TruckFeeInfoEntity> getTruckFeeInfo(TruckFeeInfoEntity selectInfo);
	
	public abstract List<TruckFeeInfoEntity> getAllTruckFeeInfo();
	
	public abstract void deleteTruckFeeInfo(String id);
	
	public abstract void updateTruckFeeInfo(TruckFeeInfoEntity selectInfo);
	
	public abstract void updateAllTruckFeeInfo(TruckFeeInfoEntity selectInfo);
}
