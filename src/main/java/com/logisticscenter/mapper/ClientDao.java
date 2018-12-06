package com.logisticscenter.mapper;

import com.logisticscenter.model.ClientEntity;

import java.util.List;


public interface ClientDao {
	
	public abstract int insertClient(ClientEntity insertInfo);
	
	public abstract ClientEntity getClient(String id);
	
	public abstract List<ClientEntity> getClient(ClientEntity selectInfo, String selectStatus);
	
	public abstract String getClientCount(ClientEntity selectInfo, String selectStatus);
	
	public abstract List<ClientEntity> getAllClient();
	
	public abstract int deleteClient(String id);
	
	public abstract int updateClient(ClientEntity selectInfo);
	
	public abstract void updateAllClient(ClientEntity selectInfo);
}
