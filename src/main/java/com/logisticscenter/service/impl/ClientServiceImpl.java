package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.entity.ClientEntity;
import com.javabean.ClientBean;
import com.logisticscenter.mapper.ClientDao;
import com.logisticscenter.service.ClientService;
import org.springframework.stereotype.Component;

@Component
public class ClientServiceImpl implements ClientService {

	ClientDao clientDao;

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public int deleteClient(String id) {
		int count = clientDao.deleteClient(id);
		return count;
		
	}

	@Override
	public ClientBean getClient(String id) {
		return (ClientBean) ConvertService.convertEntityToBean(clientDao.getClient(id), new ClientBean());
	}

	@Override
	public List<ClientBean> getClient(ClientBean selectInfo,String selectStatus) {
		List<ClientBean> beanList = new ArrayList<ClientBean>();
		try{
			ClientEntity clientE = (ClientEntity)ConvertService.convertBeanToEntity(selectInfo,new ClientEntity());
			List<ClientEntity> entityList = new ArrayList<ClientEntity>();
			int pageSize =Integer.parseInt(clientE.getPageSize());
			int currentPage =Integer.parseInt(clientE.getCurrentPage());
			currentPage = (currentPage -1)*pageSize;
			clientE.setCurrentPage(currentPage+"");
			entityList = clientDao.getClient(clientE,selectStatus);
			for(int i=0;i<entityList.size(); i++){
				ClientBean dirverBean = (ClientBean) ConvertService.convertEntityToBean(entityList.get(i), new ClientBean());
				beanList.add(dirverBean);
			}
			
			
		}catch(Exception e){e.printStackTrace();}
		
		return beanList;
	}
	
	@Override
	public String getClientCount(ClientBean selectInfo,String selectStatus) {
		String count = "";
		try{
			ClientEntity clientE = (ClientEntity)ConvertService.convertBeanToEntity(selectInfo,new ClientEntity());
			List<ClientEntity> entityList = new ArrayList<ClientEntity>();
			List<ClientBean> beanList = new ArrayList<ClientBean>();
			int pageSize =Integer.parseInt(clientE.getPageSize());
			int currentPage =Integer.parseInt(clientE.getCurrentPage());
			currentPage = (currentPage -1)*pageSize;
			clientE.setCurrentPage(currentPage+"");
			count = clientDao.getClientCount(clientE,selectStatus);
		}catch(Exception e){e.printStackTrace();}
		return count;
		
	}

	@Override
	public int updateClient(ClientBean updateInfo) {
		int count=0;
		ClientEntity ClientE = (ClientEntity) ConvertService.convertBeanToEntity(updateInfo, new ClientEntity());
		ClientE.setEditDate(ConvertService.getDate());
		ClientE.setEditTime(ConvertService.getTime());
		count = clientDao.updateClient(ClientE);
		return count;
		
	}
	
	@Override
	public void updateAllClient(ClientBean updateInfo) {
		ClientEntity ClientE = new ClientEntity();
		clientDao.updateAllClient(ClientE);
		
	}

	@Override
	public int insertClient(ClientBean insertInfo) {
		ClientEntity ClientE = (ClientEntity) ConvertService.convertBeanToEntity(insertInfo, new ClientEntity());
		ClientE.setCreateDate(ConvertService.getDate());
		ClientE.setCreateTime(ConvertService.getTime());
		int statusFlg = clientDao.insertClient(ClientE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	public List<ClientBean> getAllClient(){
		List<ClientBean> beanList = new ArrayList<ClientBean>();
		List<Cache> cacheList = CacheManager.getCacheListInfo("clientBean_CACHE");
		if(cacheList!=null && cacheList.size()>0){
			for(int i =0;i<cacheList.size();i++){
				beanList.add((ClientBean)cacheList.get(i).getValue());
			}
		}else{
			List<ClientEntity> entityList = new ArrayList<ClientEntity>();
			beanList = new ArrayList<ClientBean>();
			entityList = clientDao.getAllClient();
			for(int i=0;i<entityList.size(); i++){
				ClientBean dirverBean = (ClientBean) ConvertService.convertEntityToBean(entityList.get(i), new ClientBean());
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
			CacheManager.putCacheList("clientBean_CACHE", beanCacheLst);
		}
		
		return beanList;
	}

}
