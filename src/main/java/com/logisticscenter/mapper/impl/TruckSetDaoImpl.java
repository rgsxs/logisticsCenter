package com.logisticscenter.mapper.impl;

import com.entity.TruckSetEntity;
import com.logisticscenter.mapper.TruckSetDao;
import org.springframework.stereotype.Component;

@Component
public class TruckSetDaoImpl implements TruckSetDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public TruckSetEntity getTruckSet() {
		TruckSetEntity truckSetE = new TruckSetEntity();
		try{
			truckSetE = (TruckSetEntity)getSqlMapClientTemplate().queryForObject("TruckSet.getTruckSet");
		}catch(Exception e){
			e.printStackTrace();
		}
		return truckSetE;
	}

	@Override
	public void updateTruckSet(TruckSetEntity truckSetEntity) {
		try{
			getSqlMapClientTemplate().update("TruckSet.updateTruckSet", truckSetEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
