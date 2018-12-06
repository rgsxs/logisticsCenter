package com.logisticscenter.mapper;

import com.logisticscenter.model.FeeTypeEntity;

import java.util.List;


public interface FeeTypeDao {
	
	public abstract int insertFeeType(FeeTypeEntity insertInfo);
	
	public abstract FeeTypeEntity getFeeType(String id);
	
	public abstract List<FeeTypeEntity> getFeeType(FeeTypeEntity selectInfo);
	
	public abstract String getFeeTypeCount(FeeTypeEntity selectInfo);
	
	public abstract List<FeeTypeEntity> getAllFeeType();
	
	public abstract int deleteFeeType(String id);
	
	public abstract void updateFeeType(FeeTypeEntity selectInfo);
	
	public abstract void updateAllFeeType(FeeTypeEntity selectInfo);
}
