package com.logisticscenter.mapper;

import java.util.List;

import com.entity.RepairTypeEntity;

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
