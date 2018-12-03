package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.entity.FeeTypeEntity;
import com.javabean.FeeTypeBean;
import com.logisticscenter.mapper.FeeTypeDao;
import com.logisticscenter.service.FeeTypeService;
import com.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class FeeTypeServiceImpl implements FeeTypeService {

	@Autowired
	FeeTypeDao feeTypeDao;

	@Override
	public int deleteFeeType(String id) {
		int count = feeTypeDao.deleteFeeType(id);
		return count;
		
	}

	@Override
	public FeeTypeBean getFeeType(String id) {
		return (FeeTypeBean) ConvertService.convertEntityToBean(feeTypeDao.getFeeType(id), new FeeTypeBean());
	}

	/* (non-Javadoc)
	 * @see com.service.FeeTypeService#getFeeType(com.javabean.FeeTypeBean)
	 */
	@Override
	public List<FeeTypeBean> getFeeType(FeeTypeBean selectInfo) {
		List<FeeTypeEntity> entityList = new ArrayList<FeeTypeEntity>();
		FeeTypeEntity FeeTypeE = (FeeTypeEntity)ConvertService.convertBeanToEntity(selectInfo, new FeeTypeEntity());
		List<FeeTypeBean> beanList = new ArrayList<FeeTypeBean>();
		int pageSize =Integer.parseInt(FeeTypeE.getPageSize());
		int currentPage =Integer.parseInt(FeeTypeE.getCurrentPage());
		currentPage = (currentPage -1)*pageSize;
		FeeTypeE.setCurrentPage(currentPage+"");
		entityList = feeTypeDao.getFeeType(FeeTypeE);
		for(int i=0;i<entityList.size(); i++){
			FeeTypeBean dirverBean = (FeeTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new FeeTypeBean());
			beanList.add(dirverBean);
		}
		return beanList;
	}
	
	/* (non-Javadoc)
	 * @see com.service.FeeTypeService#getFeeType(com.javabean.FeeTypeBean)
	 */
	@Override
	public String getFeeTypeCount(FeeTypeBean selectInfo) {
		String count = "";
		try{
			List<FeeTypeEntity> entityList = new ArrayList<FeeTypeEntity>();
			FeeTypeEntity FeeTypeE = (FeeTypeEntity)ConvertService.convertBeanToEntity(selectInfo, new FeeTypeEntity());
			List<FeeTypeBean> beanList = new ArrayList<FeeTypeBean>();
			count = feeTypeDao.getFeeTypeCount(FeeTypeE);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void updateFeeType(FeeTypeBean updateInfo) {
		FeeTypeEntity FeeTypeE = (FeeTypeEntity) ConvertService.convertBeanToEntity(updateInfo, new FeeTypeEntity());
		FeeTypeE.setEditDate(ConvertService.getDate());
		FeeTypeE.setEditTime(ConvertService.getTime());
		feeTypeDao.updateFeeType(FeeTypeE);
		
	}
	
	@Override
	public void updateAllFeeType(FeeTypeBean updateInfo) {
		FeeTypeEntity FeeTypeE = new FeeTypeEntity();
		feeTypeDao.updateAllFeeType(FeeTypeE);
		
	}

	/* (non-Javadoc)
	 * @see com.service.FeeTypeService#insertFeeType(com.javabean.FeeTypeBean)
	 */
	@Override
	public int insertFeeType(FeeTypeBean insertInfo) {
		//插入费用类型
		FeeTypeEntity FeeTypeE = (FeeTypeEntity) ConvertService.convertBeanToEntity(insertInfo, new FeeTypeEntity());
		FeeTypeE.setCreateDate(ConvertService.getDate());
		FeeTypeE.setCreateTime(ConvertService.getTime());
		int statusFlg = feeTypeDao.insertFeeType(FeeTypeE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<FeeTypeBean> getAllFeeType(){
		List<FeeTypeBean> beanList= new ArrayList<FeeTypeBean>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("feeTypeBean_CACHE");
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				beanList.add((FeeTypeBean)cacheList.get(i).getValue());
			}
		}else{
			Cache cache = null;
			Date date = new Date();
			List <Cache> beanCacheLst = new ArrayList<Cache>();
			List<FeeTypeEntity> entityList = new ArrayList<FeeTypeEntity>();
			String feeTypeColumns = "";
			String feeTypeNames = "";
			beanList = new ArrayList<FeeTypeBean>();
			entityList = feeTypeDao.getAllFeeType();
			for(int i=0;i<entityList.size(); i++){
				FeeTypeBean feeTypeBean = (FeeTypeBean) ConvertService.convertEntityToBean(entityList.get(i), new FeeTypeBean());
				beanList.add(feeTypeBean);
				//设置缓存
				cache = new Cache();
				cache.setKey(feeTypeBean.getId()+"");
				cache.setTimeOut(date.getTime());
				cache.setValue(feeTypeBean);
				beanCacheLst.add(cache);
				if(beanList.get(i).getIsUse() == 0 || beanList.get(i).getShowType() == 3) continue;
				feeTypeColumns+=","+beanList.get(i).getFeeTypeColumn();
				feeTypeNames +=","+beanList.get(i).getFeeName();
			}
			if(feeTypeColumns.length()>0){
				ConstantUtils.setFeeTypeColumns(feeTypeColumns.substring(1));
				ConstantUtils.setFeeTypeNames(feeTypeNames.substring(1));
			}
			CacheManager.putCacheList("feeTypeBean_CACHE", beanCacheLst);
		}
		return beanList;
	}

}
