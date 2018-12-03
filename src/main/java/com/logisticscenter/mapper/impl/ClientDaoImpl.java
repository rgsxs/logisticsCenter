package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.ClientEntity;
import com.logisticscenter.mapper.ClientDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Override
	public int deleteClient(String id) {
		int count =0;
		try{
			String idsArr[] = id.split(",");
			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
			count = getSqlMapClientTemplate().delete("Client.deleteClient", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public ClientEntity getClient(String id) {
		ClientEntity clientE = new ClientEntity();
		try{
			clientE = (ClientEntity)getSqlMapClientTemplate().queryForObject("Client.getClientById",id);
		}catch(Exception e){e.printStackTrace();}
		return clientE;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ClientEntity> getClient(ClientEntity selectInfo, String selectStatus) {
		List<ClientEntity> entityList = new ArrayList<ClientEntity>();
		if("0".equals(selectStatus)){
			entityList = (List<ClientEntity>)getSqlMapClientTemplate().queryForList("Client.getClientBy",selectInfo);
		}else{
			entityList = (List<ClientEntity>)getSqlMapClientTemplate().queryForList("Client.getClientBy2",selectInfo);
		}
		return entityList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getClientCount(ClientEntity selectInfo,String selectStatus) {
		String count = "";
		if("0".equals(selectStatus)){
			count = (String)getSqlMapClientTemplate().queryForObject("Client.getClientByCount",selectInfo);
		}else{
			count = (String)getSqlMapClientTemplate().queryForObject("Client.getClientBy2Count",selectInfo);
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientEntity> getAllClient() {
		List<ClientEntity> entityList = new ArrayList<ClientEntity>();
		try{
			entityList = (List<ClientEntity>)getSqlMapClientTemplate().queryForList("Client.getAllClient");
		}catch(Exception e){
			e.printStackTrace();
		}
		return entityList;
	}

	@Override
	public void updateAllClient(ClientEntity selectInfo) {
		try{
			getSqlMapClientTemplate().update("Client.updateAllClient", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int updateClient(ClientEntity selectInfo) {
		int count = 0;
		try{
			count = getSqlMapClientTemplate().update("Client.updateClient", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int insertClient(ClientEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("Client.insertClient", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return statusFlg;
		
	}

}
