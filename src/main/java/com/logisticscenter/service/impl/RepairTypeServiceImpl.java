package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.javabean.DriverInfoBean;
import com.javabean.RepairTypeBean;
import com.logisticscenter.mapper.RepairTypeDao;
import com.logisticscenter.model.RepairTypeEntity;
import com.logisticscenter.service.RepairTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RepairTypeServiceImpl implements RepairTypeService {

	@Autowired
	RepairTypeDao repairTypeDao;

	@Override
	public void deleteRepairType(String id) {
		repairTypeDao.deleteRepairType(id);
		
	}

	@Override
	public RepairTypeBean getRepairType(String id) {
		return (RepairTypeBean) ConvertService.convertEntityToBean(repairTypeDao.getRepairType(id), new RepairTypeBean());
	}

	@Override
	public List<RepairTypeBean> getRepairType(RepairTypeBean selectInfo) {
		List<RepairTypeBean> beanList = new ArrayList<RepairTypeBean>();
		try{
			RepairTypeEntity RepairTypeE = (RepairTypeEntity)ConvertService.convertBeanToEntity(selectInfo,new RepairTypeEntity());
			List<RepairTypeEntity> entityList = new ArrayList<RepairTypeEntity>();
			String count = "";
			int pageSize =Integer.parseInt(RepairTypeE.getPageSize());
			int currentPage =Integer.parseInt(RepairTypeE.getCurrentPage());
			currentPage = (currentPage -1)*pageSize;
			RepairTypeE.setCurrentPage(currentPage+"");
			entityList = repairTypeDao.getRepairType(RepairTypeE);
			for(int i=0;i<entityList.size(); i++){
				RepairTypeBean dirverBean = (RepairTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new DriverInfoBean());
				beanList.add(dirverBean);
			}
		}catch(Exception e){e.printStackTrace();}
		return beanList;
	}
	
	@Override
	public String getRepairTypeCount(RepairTypeBean selectInfo) {
		String count = "";
		try{
			RepairTypeEntity RepairTypeE = (RepairTypeEntity)ConvertService.convertBeanToEntity(selectInfo,new RepairTypeEntity());
			count = repairTypeDao.getRepairTypeCount(RepairTypeE);
		}catch(Exception e){e.printStackTrace();}
		return count;
		
	}

	@Override
	public void updateRepairType(RepairTypeBean updateInfo) {
		RepairTypeEntity RepairTypeE = new RepairTypeEntity();
		repairTypeDao.updateRepairType(RepairTypeE);
		
	}
	
	@Override
	public void updateAllRepairType(RepairTypeBean updateInfo) {
		RepairTypeEntity RepairTypeE = new RepairTypeEntity();
		repairTypeDao.updateAllRepairType(RepairTypeE);
		
	}

	@Override
	public int insertRepairType(RepairTypeBean insertInfo) {
		
		RepairTypeEntity RepairTypeE = (RepairTypeEntity) ConvertService.convertBeanToEntity(insertInfo, new RepairTypeEntity());
		RepairTypeE.setCreateDate(ConvertService.getDate());
		RepairTypeE.setCreateTime(ConvertService.getTime());
		int statusFlg = repairTypeDao.insertRepairType(RepairTypeE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<RepairTypeBean> getAllRepairType(){
		List<RepairTypeEntity> entityList = new ArrayList<RepairTypeEntity>();
		List<RepairTypeBean> beanList = new ArrayList<RepairTypeBean>();
		entityList = repairTypeDao.getAllRepairType();
		for(int i=0;i<entityList.size(); i++){
			RepairTypeBean dirverBean = (RepairTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new RepairTypeBean());
			beanList.add(dirverBean);
		}
		return beanList;
	}

}
