package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import com.common.ConvertService;
import com.logisticscenter.mapper.CommercialDao;
import com.logisticscenter.model.CommercialEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CommercialDaoImpl implements CommercialDao {

	@Override
	public int deleteCommercial(String id) {
		String idsArr[] = id.split(",");
		ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
		int count = 0;
		try{
			count = getSqlMapClientTemplate().delete("Commercial.deleteCommercial", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public CommercialEntity getCommercial(String id) {
		return (CommercialEntity)getSqlMapClientTemplate().queryForObject("Commercial.getCommercialById",id);
		
	}

	@Override
	public List<CommercialEntity> getCommercial(CommercialEntity selectInfo) {
		List<CommercialEntity> feeTypeEntityList = new ArrayList<CommercialEntity>();
		try{
			feeTypeEntityList = getSqlMapClientTemplate().queryForList("Commercial.getCommercialBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return feeTypeEntityList;
		
	}
	
	@Override
	public String getCommercialCount(CommercialEntity selectInfo) {
		String count = "";
		try{
			count = (String)getSqlMapClientTemplate().queryForObject("Commercial.getCommercialByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}
	
	@Override
	public void updateCommercial(CommercialEntity selectInfo) {
		getSqlMapClientTemplate().update("Commercial.updateCommercial", selectInfo);
	}

	@Override
	public int insertCommercial(CommercialEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("Commercial.insertCommercial", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return statusFlg;
		
	}

	/* (non-Javadoc)
	 * @see com.dao.CommercialDao#getWarnCommercial(int)
	 */
	@Override
	public List<CommercialEntity> getWarnCommercial(String days) {
		List<CommercialEntity> feeTypeEntityList = new ArrayList<CommercialEntity>();
		try{
			days = "'"+days+"'";
			feeTypeEntityList = getSqlMapClientTemplate().queryForList("Commercial.getWarnCommercial",days);
		}catch(Exception e){
			e.printStackTrace();
		}
		return feeTypeEntityList;
	}

}
