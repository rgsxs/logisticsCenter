package com.logisticscenter.service.impl;

import com.common.ConvertService;
import com.entity.TruckSetEntity;
import com.javabean.TruckSetBean;
import com.logisticscenter.mapper.TruckSetDao;
import com.logisticscenter.service.TruckSetService;
import org.springframework.stereotype.Component;

@Component
public class TruckSetServiceImpl implements TruckSetService {
	
	TruckSetDao truckSetDao;


	public TruckSetDao getTruckSetDao() {
		return truckSetDao;
	}

	public void setTruckSetDao(TruckSetDao truckSetDao) {
		this.truckSetDao = truckSetDao;
	}


	@Override
	public TruckSetBean getTruckSet() {
		return (TruckSetBean) ConvertService.convertEntityToBean(truckSetDao.getTruckSet(), new TruckSetBean());
	}


	@Override
	public void updateTruckSet(TruckSetBean updateInfo) {
		TruckSetEntity TruckSetE = new TruckSetEntity();
		TruckSetE = (TruckSetEntity)ConvertService.convertEntityToBean(updateInfo, new TruckSetEntity());
		truckSetDao.updateTruckSet(TruckSetE);
		
	}
	

}
