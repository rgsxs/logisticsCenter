package com.logisticscenter.mapper;


import com.logisticscenter.model.TruckSetEntity;

public interface TruckSetDao {
	
	public abstract TruckSetEntity getTruckSet();
	
	public abstract void updateTruckSet(TruckSetEntity selectInfo);
	
}
