package com.logisticscenter.mapper;

import com.logisticscenter.model.RepairTypeEntity;

import java.util.List;


public interface RepairTypeDao {
	
	public abstract int insertRepairType(RepairTypeEntity insertInfo);
	
	public abstract RepairTypeEntity getRepairType(String id);
	
	public abstract List<RepairTypeEntity> getRepairType(RepairTypeEntity selectInfo);
	
	public abstract String getRepairTypeCount(RepairTypeEntity selectInfo);
	
	public abstract List<RepairTypeEntity> getAllRepairType();
	
	public abstract void deleteRepairType(String id);
	
	public abstract void updateRepairType(RepairTypeEntity selectInfo);
	
	public abstract void updateAllRepairType(RepairTypeEntity selectInfo);
}
