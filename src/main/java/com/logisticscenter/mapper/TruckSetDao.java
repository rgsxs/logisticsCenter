package com.logisticscenter.mapper;


import com.logisticscenter.model.TruckSetEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TruckSetDao {
	
	public abstract TruckSetEntity getTruckSet();
	
	public abstract void updateTruckSet(TruckSetEntity selectInfo);
	
}
