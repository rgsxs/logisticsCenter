package com.logisticscenter.service.impl;

import java.math.BigDecimal;
import java.util.*;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.javabean.TruckBean;
import com.logisticscenter.mapper.TruckInfoDao;
import com.logisticscenter.model.TruckEntity;
import com.logisticscenter.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TruckServiceImpl implements TruckService {

	@Autowired
	TruckInfoDao truckDao;

	@Override
	public Map deleteTruck(Map<String, Object> params) {
		Map retResult = new HashMap();
		int count = truckDao.deleteTruck((String)params.get("deleteTrucks"));
		retResult.put("count",count);
		return retResult;
	}

	@Override
	public TruckBean getTruckInfo(String id) {
		TruckBean dirverBean = (TruckBean) ConvertService.convertEntityToBean(truckDao.getTruckInfo(id), new TruckBean());
		return dirverBean;
	}

	@Override
	public List<TruckBean> getTruckInfo(TruckBean selectInfo) {
		TruckEntity TruckE = (TruckEntity)ConvertService.convertBeanToEntity(selectInfo,new TruckEntity());
		List<TruckEntity> entityList = new ArrayList<TruckEntity>();
		List<TruckBean> beanList = new ArrayList<TruckBean>();
		int pageSize =Integer.parseInt(TruckE.getPageSize());
		int currentPage =Integer.parseInt(TruckE.getCurrentPage());
		currentPage = (currentPage -1)*pageSize;
		TruckE.setCurrentPage(currentPage+"");
		entityList = truckDao.getTruckInfo(TruckE);
		for(int i=0;i<entityList.size(); i++){
			TruckBean dirverBean = (TruckBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckBean());
			beanList.add(dirverBean);
		}
		return beanList;
		
	}
	
	@Override
	public Map getTruckInfoCount(Map<String, Object> params) {
		Map retResult = new HashMap();
		TruckEntity truckE = new TruckEntity();
		truckE.setId((Integer) params.get("id"));
		truckE.setTruckNumber((String)params.get("truckNumber"));
		truckE.setTruckOwner((String)params.get("truckOwner"));
		truckE.setTruckBrand((String)params.get("truckBrand"));
		truckE.setTruckName((String)params.get("truckName"));
		truckE.setContactNumber((String)params.get("contactNumber"));
		truckE.setTruckType((Integer)params.get("truckType"));
		truckE.setDriver((Integer)params.get("driver"));
		truckE.setTruckColor((String)params.get("truckColor"));
		truckE.setTruckLength((BigDecimal)params.get("truckLength"));
		truckE.setTruckWidth((BigDecimal)params.get("truckWidth"));
		truckE.setTruckHeight((BigDecimal)params.get("truckHeight"));
		truckE.setStandardWeight((BigDecimal)params.get("standardWeight"));
		truckE.setDriverLicense((String)params.get("driverLicense"));
		truckE.setEngineNumber((String)params.get("engineNumber"));
		truckE.setMadeDate((String)params.get("madeDate"));
		truckE.setBuyDate((String)params.get("buyDate"));
		truckE.setWorth((BigDecimal)params.get("worth"));
		truckE.setBuyCost((BigDecimal)params.get("buyCost"));
		truckE.setRemark((String)params.get("remark"));
		String count = truckDao.getTruckInfoCount(truckE);
		retResult.put("count",count);
		return retResult;
		
	}

	@Override
	public Map updateTruck(Map<String, Object> params) {
		Map retResult = new HashMap();
		TruckEntity truckE = new TruckEntity();
		truckE.setId((Integer) params.get("id"));
		truckE.setTruckNumber((String)params.get("truckNumber"));
		truckE.setTruckOwner((String)params.get("truckOwner"));
		truckE.setTruckBrand((String)params.get("truckBrand"));
		truckE.setTruckName((String)params.get("truckName"));
		truckE.setContactNumber((String)params.get("contactNumber"));
		truckE.setTruckType((Integer)params.get("truckType"));
		truckE.setDriver((Integer)params.get("driver"));
		truckE.setTruckColor((String)params.get("truckColor"));
		truckE.setTruckLength((BigDecimal)params.get("truckLength"));
		truckE.setTruckWidth((BigDecimal)params.get("truckWidth"));
		truckE.setTruckHeight((BigDecimal)params.get("truckHeight"));
		truckE.setStandardWeight((BigDecimal)params.get("standardWeight"));
		truckE.setDriverLicense((String)params.get("driverLicense"));
		truckE.setEngineNumber((String)params.get("engineNumber"));
		truckE.setMadeDate((String)params.get("madeDate"));
		truckE.setBuyDate((String)params.get("buyDate"));
		truckE.setWorth((BigDecimal)params.get("worth"));
		truckE.setBuyCost((BigDecimal)params.get("buyCost"));
		truckE.setRemark((String)params.get("remark"));
		truckE.setEditDate(ConvertService.getDate());
		truckE.setEditTime(ConvertService.getTime());
		int updId = truckDao.updateTruck(truckE);
		retResult.put("updId",updId);
		CacheManager.clearOnly("driverBean_CACHE");
		return retResult;
	}
	
	@Override
	public Map updateAllTruck(Map<String, Object> params) {
		Map retResult = new HashMap();
		TruckEntity truckE = new TruckEntity();
		truckE.setId((Integer) params.get("id"));
		truckE.setTruckNumber((String)params.get("truckNumber"));
		truckE.setTruckOwner((String)params.get("truckOwner"));
		truckE.setTruckBrand((String)params.get("truckBrand"));
		truckE.setTruckName((String)params.get("truckName"));
		truckE.setContactNumber((String)params.get("contactNumber"));
		truckE.setTruckType((Integer)params.get("truckType"));
		truckE.setDriver((Integer)params.get("driver"));
		truckE.setTruckColor((String)params.get("truckColor"));
		truckE.setTruckLength((BigDecimal)params.get("truckLength"));
		truckE.setTruckWidth((BigDecimal)params.get("truckWidth"));
		truckE.setTruckHeight((BigDecimal)params.get("truckHeight"));
		truckE.setStandardWeight((BigDecimal)params.get("standardWeight"));
		truckE.setDriverLicense((String)params.get("driverLicense"));
		truckE.setEngineNumber((String)params.get("engineNumber"));
		truckE.setMadeDate((String)params.get("madeDate"));
		truckE.setBuyDate((String)params.get("buyDate"));
		truckE.setWorth((BigDecimal)params.get("worth"));
		truckE.setBuyCost((BigDecimal)params.get("buyCost"));
		truckE.setRemark((String)params.get("remark"));
		truckE.setCreateDate(ConvertService.getDate());
		truckE.setCreateTime(ConvertService.getTime());
		truckDao.updateAllTruck(truckE);
		
	}

	@Override
	public int insertTruck(TruckBean insertInfo) {
		
		TruckEntity truckE = (TruckEntity) ConvertService.convertBeanToEntity(insertInfo, new TruckEntity());
		truckE.setCreateDate(ConvertService.getDate());
		truckE.setCreateTime(ConvertService.getTime());
		int statusFlg = truckDao.insertTruck(truckE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<TruckBean> getAllTruck(){
		List<TruckBean> beanList = new ArrayList<TruckBean>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("truckBean_CACHE");
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				beanList.add((TruckBean)cacheList.get(i).getValue());
			}
		}else{
			List<TruckEntity> entityList = new ArrayList<TruckEntity>();
			entityList = truckDao.getAllTruck();
			for(int i=0;i<entityList.size(); i++){
				TruckBean dirverBean = (TruckBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckBean());
				beanList.add(dirverBean);
			}
			Cache cache = null;
			Date date = new Date();
			List <Cache> beanCacheLst = new ArrayList<Cache>();
			//货物类型设置缓存
			for(int i = 0;i<beanList.size();i++){
				cache = new Cache();
				cache.setKey(beanList.get(i).getId()+"");
				cache.setTimeOut(date.getTime());
				cache.setValue(beanList.get(i));
				beanCacheLst.add(cache);
			}
			CacheManager.putCacheList("truckBean_CACHE", beanCacheLst);
		}
		
		return beanList;
	}

}
