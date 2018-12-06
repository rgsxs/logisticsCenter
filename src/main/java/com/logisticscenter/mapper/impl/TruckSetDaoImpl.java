package com.logisticscenter.mapper.impl;

import com.logisticscenter.mapper.TruckSetDao;
import com.logisticscenter.model.TruckSetEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TruckSetDaoImpl implements TruckSetDao {

	
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
