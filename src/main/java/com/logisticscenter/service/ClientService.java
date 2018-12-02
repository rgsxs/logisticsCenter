package com.logisticscenter.service;

import java.util.List;

import com.entity.ClientEntity;
import com.javabean.ClientBean;
import com.javabean.FeeTypeBean;

public interface ClientService {
	
	public abstract int insertClient(ClientBean insertInfo);
	
	public abstract ClientBean getClient(String id);
	
	public abstract List<ClientBean> getClient(ClientBean selectInfo, String selectStatus);
	
	public abstract String getClientCount(ClientBean selectInfo, String selectStatus);
	
	public abstract List<ClientBean> getAllClient();
	
	public abstract int deleteClient(String id);
	
	public abstract int updateClient(ClientBean updateInfo);
	
	public abstract void updateAllClient(ClientBean updateInfo);

}
