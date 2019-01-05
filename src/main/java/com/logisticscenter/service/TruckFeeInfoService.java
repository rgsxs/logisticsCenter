package com.logisticscenter.service;

import java.util.List;

import com.javabean.TruckFeeInfoBean;

public interface TruckFeeInfoService {
	
	public abstract int insertTruckFeeInfo(TruckFeeInfoBean insertInfo);
	
	public abstract TruckFeeInfoBean getTruckFeeInfo(String id);
	
	public abstract List<TruckFeeInfoBean> getTruckFeeInfo(TruckFeeInfoBean selectInfo);
	
	public abstract List<TruckFeeInfoBean> getAllTruckFeeInfo();
	
	public abstract void deleteTruckFeeInfo(String id);
	
	public abstract void updateTruckFeeInfo(TruckFeeInfoBean updateInfo);
	
	public abstract void updateAllTruckFeeInfo(TruckFeeInfoBean updateInfo);

}
