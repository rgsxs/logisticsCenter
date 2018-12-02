package com.logisticscenter.service;

import java.util.List;

import com.entity.RepairTypeEntity;
import com.javabean.RepairTypeBean;

public interface RepairTypeService {
	
	public abstract int insertRepairType(RepairTypeBean insertInfo);
	
	public abstract RepairTypeBean getRepairType(String id);
	
	public abstract List<RepairTypeBean> getRepairType(RepairTypeBean selectInfo);
	
	public abstract String getRepairTypeCount(RepairTypeBean selectInfo);
	
	public abstract List<RepairTypeBean> getAllRepairType();
	
	public abstract void deleteRepairType(String id);
	
	public abstract void updateRepairType(RepairTypeBean updateInfo);
	
	public abstract void updateAllRepairType(RepairTypeBean updateInfo);

}
