package com.logisticscenter.mapper;

import com.logisticscenter.model.LoginInfoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoginInfoDao {
	
	public abstract void insertSystemInfo(LoginInfoEntity insertInfo);
	
	public abstract LoginInfoEntity getSystemInfo(String id);
	
	public abstract List<LoginInfoEntity> getSystemInfo(LoginInfoEntity selectInfo);
	
	public abstract void deleteSystemInfo(String id);
	
	public abstract void updateSystemInfo(LoginInfoEntity selectInfo);
	
	public abstract void updateAllSystemInfo(LoginInfoEntity selectInfo);
}
