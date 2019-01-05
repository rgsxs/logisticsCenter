package com.logisticscenter.service.impl;

import java.util.*;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.logisticscenter.mapper.ClientDao;
import com.logisticscenter.model.ClientEntity;
import com.logisticscenter.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDao clientDao;

	public Map getClient(Map<String, Object> params){
		List<ClientEntity> entityList = new ArrayList<ClientEntity>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("clientBean_CACHE");
		Map result = new HashMap();
		Map retResult = new HashMap();
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				entityList.add((ClientEntity)cacheList.get(i).getValue());
			}
		}else{
			Cache cache = null;
			Date date = new Date();
			List <Cache> beanCacheLst = new ArrayList<Cache>();
			//货物类型设置缓存
			for(int i = 0;i<entityList.size();i++){
				cache = new Cache();
				cache.setKey(entityList.get(i).getId()+"");
				cache.setTimeOut(date.getTime());
				cache.setValue(entityList.get(i));
				beanCacheLst.add(cache);
			}
			CacheManager.putCacheList("clientBean_CACHE", beanCacheLst);
		}

		try {

			Map beanMap = null;
			for(int i = 0 ; i<entityList.size(); i++){
				beanMap = new HashMap();
				beanMap.put("id",entityList.get(i).getId());
				beanMap.put("clientName",entityList.get(i).getClientName());
				beanMap.put("contant",entityList.get(i).getContant());
				beanMap.put("mobile",entityList.get(i).getMobile());
				beanMap.put("fax",entityList.get(i).getFax());
				beanMap.put("address",entityList.get(i).getAddress());
				beanMap.put("products",entityList.get(i).getProducts());
				beanMap.put("createDate",entityList.get(i).getCreateDate());
				beanMap.put("createTime",entityList.get(i).getCreateTime());
				result.put(entityList.get(i).getId(), beanMap);
			}
			retResult.put("client",result);
			return retResult;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象

		return retResult;
	}

	@Override
	public Map insertClient(Map<String, Object> params) {
		Map retResult = new HashMap();
		ClientEntity clientE = new ClientEntity();
		clientE.setClientName((String)params.get("clientName"));
		clientE.setContant((String)params.get("contant"));
		clientE.setMobile((String)params.get("mobile"));
		clientE.setFax((String)params.get("fax"));
		clientE.setAddress((String)params.get("address"));
		clientE.setProducts((String)params.get("products"));
		clientE.setCreateDate(ConvertService.getDate());
		clientE.setCreateTime(ConvertService.getTime());
		int maxId = clientDao.insertClient(clientE);
		CacheManager.clearOnly("clientBean_CACHE");
		retResult.put("id",maxId);
		return retResult;
	}


	@Override
	public Map updateClient(Map<String, Object> params) {
		int count=0;
		Map retResult = new HashMap();
		ClientEntity clientE = new ClientEntity();
		clientE.setClientName((String)params.get("clientName"));
		clientE.setContant((String)params.get("contant"));
		clientE.setMobile((String)params.get("mobile"));
		clientE.setFax((String)params.get("fax"));
		clientE.setAddress((String)params.get("address"));
		clientE.setProducts((String)params.get("products"));
		clientE.setCreateDate(ConvertService.getDate());
		clientE.setCreateTime(ConvertService.getTime());
		count = clientDao.updateClient(clientE);
		CacheManager.clearOnly("clientBean_CACHE");
		retResult.put("count",count);
		return retResult;

	}

	@Override
	public Map deleteClient(Map<String, Object> params) {
		Map retResult = new HashMap();
		int count = clientDao.deleteClient((String)params.get("ids"));
		retResult.put("count",count);
		return retResult;
		
	}

}
