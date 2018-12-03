package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.entity.GoodsTypeEntity;
import com.javabean.GoodsTypeBean;
import com.logisticscenter.mapper.GoodsTypeDao;
import com.logisticscenter.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

	@Autowired
	GoodsTypeDao goodsTypeDao;

	@Override
	public int deleteGoodsType(String id) {
		int count = goodsTypeDao.deleteGoodsType(id);
		return count;
	}

	@Override
	public GoodsTypeBean getGoodsType(String id) {
		return (GoodsTypeBean) ConvertService.convertEntityToBean(goodsTypeDao.getGoodsType(id), new GoodsTypeBean());
	}

	@Override
	public List<GoodsTypeBean> getGoodsType(GoodsTypeBean selectInfo) {
		List<GoodsTypeBean> beanList = new ArrayList<GoodsTypeBean>();
		try{
			GoodsTypeEntity GoodsTypeE = (GoodsTypeEntity)ConvertService.convertBeanToEntity(selectInfo, new GoodsTypeEntity());
			List<GoodsTypeEntity> entityList = new ArrayList<GoodsTypeEntity>();
			if(!"".equals(GoodsTypeE.getPageSize())){
				int pageSize =Integer.parseInt(GoodsTypeE.getPageSize());
				int currentPage =Integer.parseInt(GoodsTypeE.getCurrentPage());
				currentPage = (currentPage -1)*pageSize;
				GoodsTypeE.setCurrentPage(currentPage+"");
			}
			entityList = goodsTypeDao.getGoodsType(GoodsTypeE);
			for(int i=0;i<entityList.size(); i++){
				GoodsTypeBean dirverBean = (GoodsTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new GoodsTypeBean());
				beanList.add(dirverBean);
			}
		}catch(Exception e){e.printStackTrace();}
		return beanList;
	}
	
	@Override
	public String getGoodsTypeCount(GoodsTypeBean selectInfo) {
		String count = "";
		try{
			GoodsTypeEntity GoodsTypeE = (GoodsTypeEntity)ConvertService.convertBeanToEntity(selectInfo, new GoodsTypeEntity());
			count = goodsTypeDao.getGoodsTypeCount(GoodsTypeE);
		}catch(Exception e){e.printStackTrace();}
		return count;
	}

	@Override
	public void updateGoodsType(GoodsTypeBean updateInfo) {
		GoodsTypeEntity GoodsTypeE = (GoodsTypeEntity) ConvertService.convertBeanToEntity(updateInfo, new GoodsTypeEntity());
		goodsTypeDao.updateGoodsType(GoodsTypeE);
		
	}
	
	@Override
	public void updateAllGoodsType(GoodsTypeBean updateInfo) {
		GoodsTypeEntity GoodsTypeE = new GoodsTypeEntity();
		goodsTypeDao.updateAllGoodsType(GoodsTypeE);
		
	}

	@Override
	public int insertGoodsType(GoodsTypeBean insertInfo) {
		GoodsTypeEntity GoodsTypeE = (GoodsTypeEntity) ConvertService.convertBeanToEntity(insertInfo, new GoodsTypeEntity());
		GoodsTypeE.setCreateDate(ConvertService.getDate());
		GoodsTypeE.setCreateTime(ConvertService.getTime());
		int statusFlg = goodsTypeDao.insertGoodsType(GoodsTypeE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<GoodsTypeBean> getAllGoodsType(){
		
		List<GoodsTypeBean> beanList = new ArrayList<GoodsTypeBean>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("goodsTypeBean_CACHE");
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				beanList.add((GoodsTypeBean)cacheList.get(i).getValue());
			}
		}else{
			List<GoodsTypeEntity> entityList = new ArrayList<GoodsTypeEntity>();
			beanList = new ArrayList<GoodsTypeBean>();
			entityList = goodsTypeDao.getAllGoodsType();
			for(int i=0;i<entityList.size(); i++){
				GoodsTypeBean dirverBean = (GoodsTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new GoodsTypeBean());
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
			CacheManager.putCacheList("goodsTypeBean_CACHE", beanCacheLst);
		}
		
		return beanList;
	}

}
