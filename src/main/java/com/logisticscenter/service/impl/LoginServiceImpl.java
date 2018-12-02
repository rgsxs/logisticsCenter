package com.logisticscenter.service.impl;

import java.util.List;

import com.common.ConvertService;
import com.entity.SystemInfoEntity;
import com.javabean.SystemInfoBean;
import com.logisticscenter.mapper.SystemInfoDao;
import com.logisticscenter.service.LoginService;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {
	
	SystemInfoDao systemDao;

	public SystemInfoDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(SystemInfoDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public void deleteSystemInfo(String id) {
		systemDao.deleteSystemInfo(id);
		
	}

	@Override
	public SystemInfoBean getSystemInfo(String id) {
		SystemInfoBean bean = new SystemInfoBean();
		return (SystemInfoBean) ConvertService.convertEntityToBean(systemDao.getSystemInfo(id), new SystemInfoBean());
	}

	@Override
	public List<SystemInfoBean> getSystemInfo(SystemInfoBean selectInfo) {
		SystemInfoEntity entity = (SystemInfoEntity)ConvertService.convertBeanToEntity(selectInfo, new SystemInfoEntity());
		return (List<SystemInfoBean>) ConvertService.convertEntityToBean(systemDao.getSystemInfo(entity), new SystemInfoBean());
	}

	@Override
	public void updateSystemInfo(SystemInfoBean updateInfo) {
		SystemInfoEntity systemE = new SystemInfoEntity();
		systemDao.updateSystemInfo(systemE);
		
	}
	
	@Override
	public void updateAllSystemInfo(SystemInfoBean updateInfo) {
		SystemInfoEntity systemE = new SystemInfoEntity();
		systemDao.updateAllSystemInfo(systemE);
		
	}

	@Override
	public SystemInfoBean insertSystemInfo(SystemInfoBean insertInfo) {
		SystemInfoEntity systemE = (SystemInfoEntity) ConvertService.convertBeanToEntity(insertInfo, new SystemInfoEntity());
		systemDao.insertSystemInfo(systemE);
		// TODO Auto-generated method stub
		return null;
	}

}
