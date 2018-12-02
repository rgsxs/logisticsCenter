package com.logisticscenter.service;

import java.util.List;

import com.entity.FeeTypeEntity;
import com.javabean.FeeTypeBean;

public interface FeeTypeService {
	
	public abstract int insertFeeType(FeeTypeBean insertInfo);
	
	public abstract FeeTypeBean getFeeType(String id);
	
	public abstract List<FeeTypeBean> getFeeType(FeeTypeBean selectInfo);
	
	public abstract String getFeeTypeCount(FeeTypeBean selectInfo);
	
	public abstract List<FeeTypeBean> getAllFeeType();
	
	public abstract int deleteFeeType(String id);
	
	public abstract void updateFeeType(FeeTypeBean updateInfo);
	
	public abstract void updateAllFeeType(FeeTypeBean updateInfo);

}
