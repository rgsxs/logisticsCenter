package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.entity.TruckEntity;
import com.javabean.TruckBean;
import com.logisticscenter.mapper.TruckInfoDao;
import com.logisticscenter.service.TruckService;
import org.springframework.stereotype.Component;

@Component
public class TruckServiceImpl implements TruckService {
	
	TruckInfoDao truckDao;

	public TruckInfoDao getTruckDao() {
		return truckDao;
	}

	public void setTruckDao(TruckInfoDao truckDao) {
		this.truckDao = truckDao;
	}

	@Override
	public int deleteTruck(String id) {
		int count =  truckDao.deleteTruck(id);
		return count;
		
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
	public String getTruckInfoCount(TruckBean selectInfo) {
		TruckEntity TruckE = (TruckEntity)ConvertService.convertBeanToEntity(selectInfo,new TruckEntity());
		String count = "";
		count = truckDao.getTruckInfoCount(TruckE);
		return count;
		
	}

	@Override
	public int updateTruck(TruckBean updateInfo) {
		int updId=0;
		TruckEntity truckE = (TruckEntity) ConvertService.convertBeanToEntity(updateInfo, new TruckEntity());
		truckE.setEditDate(ConvertService.getDate());
		truckE.setEditTime(ConvertService.getTime());
		updId = truckDao.updateTruck(truckE);
		return updId;
		
	}
	
	@Override
	public void updateAllTruck(TruckBean updateInfo) {
		TruckEntity truckE = (TruckEntity) ConvertService.convertBeanToEntity(updateInfo, new TruckEntity());
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
