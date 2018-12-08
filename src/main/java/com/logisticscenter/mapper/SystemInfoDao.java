package com.logisticscenter.mapper;

import com.logisticscenter.model.SystemInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemInfoDao {
	
	public abstract void insertSystemInfo(SystemInfoEntity insertInfo);
	
	public abstract SystemInfoEntity getSystemInfo(String id);
	
	public abstract List<SystemInfoEntity> getSystemInfo(SystemInfoEntity selectInfo);
	
	public abstract void deleteSystemInfo(String id);
	
	public abstract void updateSystemInfo(SystemInfoEntity selectInfo);
	
	public abstract void updateAllSystemInfo(SystemInfoEntity selectInfo);
}
