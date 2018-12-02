package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.TruckFeeInfoEntity;
import com.javabean.TruckFeeInfoBean;
import com.logisticscenter.mapper.TruckFeeInfoDao;
import com.logisticscenter.service.TruckFeeInfoService;
import org.springframework.stereotype.Component;

@Component
public class TruckFeeInfoServiceImpl implements TruckFeeInfoService {
	
	TruckFeeInfoDao truckFeeInfoDao;


	public TruckFeeInfoDao getTruckFeeInfoDao() {
		return truckFeeInfoDao;
	}

	public void setTruckFeeInfoDao(TruckFeeInfoDao truckFeeInfoDao) {
		this.truckFeeInfoDao = truckFeeInfoDao;
	}

	@Override
	public void deleteTruckFeeInfo(String id) {
		truckFeeInfoDao.deleteTruckFeeInfo(id);
		
	}

	@Override
	public TruckFeeInfoBean getTruckFeeInfo(String id) {
		return (TruckFeeInfoBean) ConvertService.convertEntityToBean(truckFeeInfoDao.getTruckFeeInfo(id), new TruckFeeInfoBean());
	}

	@Override
	public List<TruckFeeInfoBean> getTruckFeeInfo(TruckFeeInfoBean selectInfo) {
		TruckFeeInfoEntity TruckFeeInfoE = new TruckFeeInfoEntity();
		return (List<TruckFeeInfoBean>) ConvertService.convertEntityToBean(truckFeeInfoDao.getTruckFeeInfo(TruckFeeInfoE), new TruckFeeInfoBean());
	}

	@Override
	public void updateTruckFeeInfo(TruckFeeInfoBean updateInfo) {
		TruckFeeInfoEntity TruckFeeInfoE = new TruckFeeInfoEntity();
		truckFeeInfoDao.updateTruckFeeInfo(TruckFeeInfoE);
		
	}
	
	@Override
	public void updateAllTruckFeeInfo(TruckFeeInfoBean updateInfo) {
		TruckFeeInfoEntity TruckFeeInfoE = new TruckFeeInfoEntity();
		truckFeeInfoDao.updateAllTruckFeeInfo(TruckFeeInfoE);
		
	}

	@Override
	public int insertTruckFeeInfo(TruckFeeInfoBean insertInfo) {
		
		TruckFeeInfoEntity TruckFeeInfoE = (TruckFeeInfoEntity) ConvertService.convertBeanToEntity(insertInfo, new TruckFeeInfoEntity());
		TruckFeeInfoE.setCreateDate(ConvertService.getDate());
		TruckFeeInfoE.setCreateTime(ConvertService.getTime());
		int statusFlg = truckFeeInfoDao.insertTruckFeeInfo(TruckFeeInfoE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<TruckFeeInfoBean> getAllTruckFeeInfo(){
		List<TruckFeeInfoEntity> entityList = new ArrayList<TruckFeeInfoEntity>();
		List<TruckFeeInfoBean> beanList = new ArrayList<TruckFeeInfoBean>();
		entityList = truckFeeInfoDao.getAllTruckFeeInfo();
		for(int i=0;i<entityList.size(); i++){
			TruckFeeInfoBean dirverBean = (TruckFeeInfoBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckFeeInfoBean());
			beanList.add(dirverBean);
		}
		return beanList;
	}

}
