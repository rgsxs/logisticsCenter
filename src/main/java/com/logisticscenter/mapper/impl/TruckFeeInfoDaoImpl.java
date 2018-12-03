package com.logisticscenter.mapper.impl;

import java.util.List;

import com.entity.TruckFeeInfoEntity;
import com.logisticscenter.mapper.TruckFeeInfoDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TruckFeeInfoDaoImpl implements TruckFeeInfoDao {

	@Override
	public void deleteTruckFeeInfo(String id) {
		getSqlMapClientTemplate().delete("TruckFeeInfo.deleteTruckFeeInfo", id);
		
	}

	@Override
	public TruckFeeInfoEntity getTruckFeeInfo(String id) {
		return (TruckFeeInfoEntity)getSqlMapClientTemplate().queryForObject("TruckFeeInfo.getUsersByName",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruckFeeInfoEntity> getTruckFeeInfo(TruckFeeInfoEntity selectInfo) {
		return (List<TruckFeeInfoEntity>)getSqlMapClientTemplate().queryForObject("TruckFeeInfo.getUsersByName",selectInfo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TruckFeeInfoEntity> getAllTruckFeeInfo() {
		return (List<TruckFeeInfoEntity>)getSqlMapClientTemplate().queryForList("TruckFeeInfo.getAllDriver");
	}

	@Override
	public void updateAllTruckFeeInfo(TruckFeeInfoEntity selectInfo) {
		getSqlMapClientTemplate().update("TruckFeeInfo.updateUsers", selectInfo);
		
	}

	@Override
	public void updateTruckFeeInfo(TruckFeeInfoEntity selectInfo) {
		getSqlMapClientTemplate().update("TruckFeeInfo.updateDriver", selectInfo);
		
	}

	@Override
	public int insertTruckFeeInfo(TruckFeeInfoEntity insertInfo) {
		int statusFlg = 0;
		statusFlg = (Integer)getSqlMapClientTemplate().insert("TruckFeeInfo.insertDriver", insertInfo);
		
		return statusFlg;
		
	}

}
