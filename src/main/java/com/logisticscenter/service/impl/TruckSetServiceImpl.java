package com.logisticscenter.service.impl;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.javabean.TruckSetBean;
import com.logisticscenter.mapper.TruckSetDao;
import com.logisticscenter.model.ClientEntity;
import com.logisticscenter.model.TruckSetEntity;
import com.logisticscenter.service.TruckSetService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TruckSetServiceImpl implements TruckSetService {

	@Autowired
	TruckSetDao truckSetDao;

	@Override
	public Map getTruckSet(Map<String, Object> params) {
//		return (TruckSetBean) ConvertService.convertEntityToBean(truckSetDao.getTruckSet(), new TruckSetBean());
		Map result = new HashMap();
		Map retResult = new HashMap();
		TruckSetEntity entity= null;
		if(CacheManager.getCacheInfo("truckSettingBean_CACHE")!=null){
			Cache cache = CacheManager.getCacheInfo("truckSettingBean_CACHE");
			entity = (TruckSetEntity)cache.getValue();
		}else{
			entity= truckSetDao.getTruckSet();
			Cache cache = new Cache();
			Date date = new Date();
			//设置应用设置缓存
			cache.setKey("truckSetting");
			cache.setTimeOut(date.getTime());
			cache.setValue(entity);
			CacheManager.putCache("truckSettingBean_CACHE", cache);
		}

		try {
			result.put("pageSize",entity.getPageSize());
			result.put("commercialDate",entity.getCommercialDate());
			result.put("compulsoryDate",entity.getCompulsoryDate());
			result.put("orderRule",entity.getOrderRule());
			result.put("preRule",entity.getPreRule());
			result.put("lastRule",entity.getLastRule());
			result.put("reLogin",entity.getReLogin());

			retResult.put("truckSet",result);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象

		return retResult;
	}


	@Override
	public Map updateTruckSet(Map<String, Object> params) {
		TruckSetEntity truckSetE = new TruckSetEntity();
		truckSetE.setPageSize((String)params.get("pagesize"));
		truckSetE.setCommercialDate((String)params.get("commercialdate"));
		truckSetE.setCompulsoryDate((String)params.get("compulsorydate"));
		truckSetE.setOrderRule((String)params.get("orderrule"));
		truckSetE.setPreRule((String)params.get("prerule"));
		truckSetE.setLastRule((String)params.get("lastrule"));
		truckSetE.setReLogin((Integer) params.get("relogin"));
		truckSetDao.updateTruckSet(truckSetE);
		CacheManager.clearOnly("truckSettingBean_CACHE");
		Map retResult = new HashMap();
		return retResult;
	}

}
