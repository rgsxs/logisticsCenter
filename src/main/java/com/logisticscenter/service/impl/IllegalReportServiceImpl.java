package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.IllegalReportEntity;
import com.javabean.IllegalReportBean;
import com.logisticscenter.mapper.IllegalReportDao;
import com.logisticscenter.service.IllegalReportService;
import org.springframework.stereotype.Component;

@Component
public class IllegalReportServiceImpl implements IllegalReportService {
	
	IllegalReportDao illegalReportDao;

	public IllegalReportDao getIllegalReportDao() {
		return illegalReportDao;
	}

	public void setIllegalReportDao(IllegalReportDao illegalReportDao) {
		this.illegalReportDao = illegalReportDao;
	}

	@Override
	public void deleteIllegalReport(String id) {
		illegalReportDao.deleteIllegalReport(id);
		
	}

	@Override
	public IllegalReportBean getIllegalReport(String id) {
		return (IllegalReportBean) ConvertService.convertEntityToBean(illegalReportDao.getIllegalReport(id), new IllegalReportBean());
	}

	@Override
	public List<IllegalReportBean> getIllegalReport(IllegalReportBean selectInfo) {
		List<IllegalReportBean> beanList = new ArrayList<IllegalReportBean>();
		try{
			IllegalReportEntity IllegalReportE = (IllegalReportEntity)ConvertService.convertBeanToEntity(selectInfo, new IllegalReportEntity());
			List<IllegalReportEntity> entityList = new ArrayList<IllegalReportEntity>();
			entityList = illegalReportDao.getIllegalReport(IllegalReportE);
			for(int i=0;i<entityList.size(); i++){
				IllegalReportBean illegalReportBean = (IllegalReportBean) ConvertService.convertEntityToBean(entityList.get(i), new IllegalReportBean());
				beanList.add(illegalReportBean);
			}
		}catch(Exception e){e.printStackTrace();}
		return beanList;
	}
	
	@Override
	public String getIllegalReportCount(IllegalReportBean selectInfo) {
		String count = "";
		try{
			IllegalReportEntity IllegalReportE = (IllegalReportEntity)ConvertService.convertBeanToEntity(selectInfo, new IllegalReportEntity());
			count = illegalReportDao.getIllegalReportCount(IllegalReportE);
		}catch(Exception e){e.printStackTrace();}
		
		return count;
	}

	@Override
	public void updateIllegalReport(IllegalReportBean updateInfo) {
		IllegalReportEntity IllegalReportE = new IllegalReportEntity();
		illegalReportDao.updateIllegalReport(IllegalReportE);
		
	}
	
	@Override
	public void updateAllIllegalReport(IllegalReportBean updateInfo) {
		IllegalReportEntity IllegalReportE = new IllegalReportEntity();
		illegalReportDao.updateAllIllegalReport(IllegalReportE);
		
	}

	@Override
	public int insertIllegalReport(IllegalReportBean insertInfo) {
		
		IllegalReportEntity IllegalReportE = (IllegalReportEntity) ConvertService.convertBeanToEntity(insertInfo, new IllegalReportEntity());
		IllegalReportE.setCreateDate(ConvertService.getDate());
		IllegalReportE.setCreateTime(ConvertService.getTime());
		int statusFlg = illegalReportDao.insertIllegalReport(IllegalReportE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<IllegalReportBean> getAllIllegalReport(){
		List<IllegalReportEntity> entityList = new ArrayList<IllegalReportEntity>();
		List<IllegalReportBean> beanList = new ArrayList<IllegalReportBean>();
		entityList = illegalReportDao.getAllIllegalReport();
		for(int i=0;i<entityList.size(); i++){
			IllegalReportBean dirverBean = (IllegalReportBean) ConvertService.convertEntityToBean(entityList.get(i), new IllegalReportBean());
			beanList.add(dirverBean);
		}
		return beanList;
	}

}
