package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.logisticscenter.mapper.DriverInfoDao;

import com.common.ConvertService;
import com.entity.DriverInfoEntity;
import org.springframework.stereotype.Repository;

@Repository
public class DriverInfoDaoImpl implements DriverInfoDao {

	@Override
	public int deleteDriverInfo(String id) {
		int count =0;
		try{
			String idsArr[] = id.split(",");
			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
			count = getSqlMapClientTemplate().delete("Driver.deleteDriver", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public DriverInfoEntity getDriverInfo(String id) {
		return (DriverInfoEntity)getSqlMapClientTemplate().queryForObject("Driver.getDriverById",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DriverInfoEntity> getDriverInfo(DriverInfoEntity selectInfo,String selectStatus) {
		if("0".equals(selectStatus)){
			return (List<DriverInfoEntity>)getSqlMapClientTemplate().queryForList("Driver.getDriverBy",selectInfo);
		}else{
			return (List<DriverInfoEntity>)getSqlMapClientTemplate().queryForList("Driver.getDriverBy2",selectInfo);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getDriverInfoCount(DriverInfoEntity selectInfo,String selectStatus) {
		String count = "";
		if("0".equals(selectStatus)){
			 count = (String)getSqlMapClientTemplate().queryForObject("Driver.getDriverByCount",selectInfo);
		}else{
			count = (String)getSqlMapClientTemplate().queryForObject("Driver.getDriverBy2Count",selectInfo);
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DriverInfoEntity> getAllDriverInfo() {
		List<DriverInfoEntity> entityList = new ArrayList<DriverInfoEntity>();
		try{
			entityList = (List<DriverInfoEntity>)getSqlMapClientTemplate().queryForList("Driver.getAllDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
		return entityList;
	}

	@Override
	public void updateAllDriverInfo(DriverInfoEntity selectInfo) {
		int count = 0;
		try{
			count = getSqlMapClientTemplate().update("Driver.updateAllDriver", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int updateDriverInfo(DriverInfoEntity selectInfo) {
		int count = 0;
		try{
			count =  getSqlMapClientTemplate().update("Driver.updateDriver", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int insertDriverInfo(DriverInfoEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("Driver.insertDriver", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return statusFlg;
		
	}

}
