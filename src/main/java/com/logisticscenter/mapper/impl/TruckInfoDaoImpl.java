package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import com.common.ConvertService;
import com.logisticscenter.mapper.TruckInfoDao;
import com.logisticscenter.model.TruckEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TruckInfoDaoImpl implements TruckInfoDao {

	@Override
	public int deleteTruck(String id) {
		
		int count =0;
		try{
			String idsArr[] = id.split(",");
			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
			count = getSqlMapClientTemplate().delete("Truck.deleteTruck", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public TruckEntity getTruckInfo(String id) {
		return (TruckEntity)getSqlMapClientTemplate().queryForObject("Truck.getTruckById",id);
		
	}

	@Override
	public List<TruckEntity> getTruckInfo(TruckEntity selectInfo) {
		
		List<TruckEntity> entityList = new ArrayList<TruckEntity>();
		try{entityList = (List<TruckEntity>) getSqlMapClientTemplate().queryForList("Truck.getTruckBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entityList;
	}
	
	@Override
	public String getTruckInfoCount(TruckEntity selectInfo) {
		
		String count = "";
		try{
			count = (String) getSqlMapClientTemplate().queryForObject("Truck.getTruckByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<TruckEntity> getAllTruck() {
		List<TruckEntity> entityList = new ArrayList<TruckEntity>();
		try{entityList = (List<TruckEntity>) getSqlMapClientTemplate().queryForList("Truck.getAllTruck");
		}catch(Exception e){
			e.printStackTrace();
		}
		return entityList;
	}

	@Override
	public void updateAllTruck(TruckEntity selectInfo) {
		getSqlMapClientTemplate().update("Truck.updateTruck", selectInfo);
		
	}

	@Override
	public int updateTruck(TruckEntity selectInfo) {
		int updId = 0;
		try{
			updId = getSqlMapClientTemplate().update("Truck.updateTruck", selectInfo);
		}catch(Exception e){
			updId = 0;
			e.printStackTrace();
		}
		return updId;
		
	}

	@Override
	public int insertTruck(TruckEntity insertInfo) {
		int statusFlg = 0;
		statusFlg = (Integer)getSqlMapClientTemplate().insert("Truck.insertTruck", insertInfo);
		
		return statusFlg;
		
	}

}
