package com.logisticscenter.mapper.impl;

import java.util.List;
import com.entity.SystemInfoEntity;
import com.logisticscenter.mapper.SystemInfoDao;
import org.springframework.stereotype.Component;

@Component
public class SystemInfoDaoImpl implements SystemInfoDao {

	@Override
	public void deleteSystemInfo(String id) {
		getSqlMapClientTemplate().delete("Login.deleteSystemInfo", id);
		
	}

	@Override
	public SystemInfoEntity getSystemInfo(String id) {
		return (SystemInfoEntity)getSqlMapClientTemplate().queryForObject("Login.getSystemById",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SystemInfoEntity> getSystemInfo(SystemInfoEntity selectInfo) {
		return (List<SystemInfoEntity>)getSqlMapClientTemplate().queryForObject("Login.getUsersByName",selectInfo);
	}

	@Override
	public void updateAllSystemInfo(SystemInfoEntity selectInfo) {
		getSqlMapClientTemplate().update("Login.updateUsers", selectInfo);
		
	}

	@Override
	public void updateSystemInfo(SystemInfoEntity selectInfo) {
		getSqlMapClientTemplate().update("Login.updateUsers", selectInfo);
		
	}

	@Override
	public void insertSystemInfo(SystemInfoEntity insertInfo) {
		getSqlMapClientTemplate().insert("SystemInfo.insertSystemInfo", insertInfo);
		
	}

}
