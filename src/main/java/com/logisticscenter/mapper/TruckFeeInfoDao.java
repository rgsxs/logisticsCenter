package com.logisticscenter.mapper;

import com.logisticscenter.model.TruckFeeInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TruckFeeInfoDao {
	
	public abstract int insertTruckFeeInfo(TruckFeeInfoEntity insertInfo);
	
	public abstract TruckFeeInfoEntity getTruckFeeInfo(String id);
	
	public abstract List<TruckFeeInfoEntity> getTruckFeeInfo(TruckFeeInfoEntity selectInfo);
	
	public abstract List<TruckFeeInfoEntity> getAllTruckFeeInfo();
	
	public abstract void deleteTruckFeeInfo(String id);
	
	public abstract void updateTruckFeeInfo(TruckFeeInfoEntity selectInfo);
	
	public abstract void updateAllTruckFeeInfo(TruckFeeInfoEntity selectInfo);
}
