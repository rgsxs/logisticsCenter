package com.logisticscenter.service.impl;

import com.common.ConvertService;
import com.entity.TruckSetEntity;
import com.javabean.TruckSetBean;
import com.logisticscenter.mapper.TruckSetDao;
import com.logisticscenter.service.TruckSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TruckSetServiceImpl implements TruckSetService {

	@Autowired
	TruckSetDao truckSetDao;

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
