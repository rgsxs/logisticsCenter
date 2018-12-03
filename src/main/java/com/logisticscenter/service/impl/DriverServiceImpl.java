package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.entity.DriverInfoEntity;
import com.javabean.DriverInfoBean;
import com.logisticscenter.mapper.DriverInfoDao;
import com.logisticscenter.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverInfoDao driverInfoDao;

	@Override
	public int deleteDriverInfo(String id) {
		int count = driverInfoDao.deleteDriverInfo(id);
		return count;
		
	}

	@Override
	public DriverInfoBean getDriverInfo(String id) {
		return (DriverInfoBean) ConvertService.convertEntityToBean(driverInfoDao.getDriverInfo(id), new DriverInfoBean());
	}

	@Override
	public List<DriverInfoBean> getDriverInfo(DriverInfoBean selectInfo,String selectStatus) {
		List<DriverInfoBean> beanList = new ArrayList<DriverInfoBean>();
		try{
			DriverInfoEntity driverInfoE = (DriverInfoEntity)ConvertService.convertBeanToEntity(selectInfo,new DriverInfoEntity());
			List<DriverInfoEntity> entityList = new ArrayList<DriverInfoEntity>();
			int pageSize =Integer.parseInt(driverInfoE.getPageSize());
			int currentPage =Integer.parseInt(driverInfoE.getCurrentPage());
			currentPage = (currentPage -1)*pageSize;
			driverInfoE.setCurrentPage(currentPage+"");
			entityList = driverInfoDao.getDriverInfo(driverInfoE,selectStatus);
			for(int i=0;i<entityList.size(); i++){
				DriverInfoBean dirverBean = (DriverInfoBean) ConvertService.convertEntityToBean(entityList.get(i), new DriverInfoBean());
				beanList.add(dirverBean);
			}
		}catch(Exception e){e.printStackTrace();}
		return beanList;
		
	}
	
	@Override
	public String getDriverInfoCount(DriverInfoBean selectInfo,String selectStatus) {
		String count = "";
		try{
			DriverInfoEntity driverInfoE = (DriverInfoEntity)ConvertService.convertBeanToEntity(selectInfo,new DriverInfoEntity());
			
			count = driverInfoDao.getDriverInfoCount(driverInfoE,selectStatus);
		}catch(Exception e){e.printStackTrace();}
		return count;
		
	}

	@Override
	public int updateDriverInfo(DriverInfoBean updateInfo) {
		int count = 0;
		DriverInfoEntity DriverInfoE = (DriverInfoEntity)ConvertService.convertBeanToEntity(updateInfo,new DriverInfoEntity());
		DriverInfoE.setEditDate(ConvertService.getDate());
		DriverInfoE.setEditTime(ConvertService.getTime());
		count =  driverInfoDao.updateDriverInfo(DriverInfoE);
		return count;
	}
	
	@Override
	public void updateAllDriverInfo(DriverInfoBean updateInfo) {
		DriverInfoEntity DriverInfoE = new DriverInfoEntity();
		driverInfoDao.updateAllDriverInfo(DriverInfoE);
		
	}

	@Override
	public int insertDriverInfo(DriverInfoBean insertInfo) {
		
		DriverInfoEntity DriverInfoE = (DriverInfoEntity) ConvertService.convertBeanToEntity(insertInfo, new DriverInfoEntity());
		DriverInfoE.setCreateDate(ConvertService.getDate());
		DriverInfoE.setCreateTime(ConvertService.getTime());
		int statusFlg = driverInfoDao.insertDriverInfo(DriverInfoE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<DriverInfoBean> getAllDriverInfo(){
		List<DriverInfoBean> beanList = new ArrayList<DriverInfoBean>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("driverBean_CACHE");
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				beanList.add((DriverInfoBean)cacheList.get(i).getValue());
			}
		}else{
			Cache cache = null;
			Date date = new Date();
			List <Cache> beanCacheLst = new ArrayList<Cache>();
			List<DriverInfoEntity> entityList = new ArrayList<DriverInfoEntity>();
			beanList = new ArrayList<DriverInfoBean>();
			entityList = driverInfoDao.getAllDriverInfo();
			for(int i=0;i<entityList.size(); i++){
				DriverInfoBean dirverBean = (DriverInfoBean) ConvertService.convertEntityToBean(entityList.get(i), new DriverInfoBean());
				beanList.add(dirverBean);
			}
			//司机设置缓存
			for(int i = 0;i<beanList.size();i++){
				cache = new Cache();
				cache.setKey(beanList.get(i).getId()+"");
				cache.setTimeOut(date.getTime());
				cache.setValue(beanList.get(i));
				beanCacheLst.add(cache);
			}
			CacheManager.putCacheList("driverBean_CACHE", beanCacheLst);
		}
		return beanList;
	}

}
