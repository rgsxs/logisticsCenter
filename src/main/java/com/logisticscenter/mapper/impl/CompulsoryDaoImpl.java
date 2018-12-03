package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.CompulsoryEntity;
import com.logisticscenter.mapper.CompulsoryDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class CompulsoryDaoImpl implements CompulsoryDao {

	@Override
	public int deleteCompulsory(String id) {
		String idsArr[] = id.split(",");
		ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
		int count = 0;
		try{
			count = getSqlMapClientTemplate().delete("Compulsory.deleteCompulsory", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public CompulsoryEntity getCompulsory(String id) {
		return (CompulsoryEntity)getSqlMapClientTemplate().queryForObject("Compulsory.getCompulsoryById",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompulsoryEntity> getCompulsory(CompulsoryEntity selectInfo) {
		List<CompulsoryEntity> feeTypeEntityList = new ArrayList<CompulsoryEntity>();
		try{
			feeTypeEntityList = getSqlMapClientTemplate().queryForList("Compulsory.getCompulsoryBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return feeTypeEntityList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getCompulsoryCount(CompulsoryEntity selectInfo) {
		String count = "";
		try{
			count = (String)getSqlMapClientTemplate().queryForObject("Compulsory.getCompulsoryByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}
	
	/* (non-Javadoc)
	 * @see com.dao.CommercialDao#getWarnCommercial(int)
	 */
	@Override
	public List<CompulsoryEntity> getWarnCompulsory(String days) {
		List<CompulsoryEntity> feeTypeEntityList = new ArrayList<CompulsoryEntity>();
		try{
			days = "'"+days+"'";
			feeTypeEntityList = getSqlMapClientTemplate().queryForList("Compulsory.getWarnCompulsory",days);
		}catch(Exception e){
			e.printStackTrace();
		}
		return feeTypeEntityList;
	}
	
	@Override
	public void updateCompulsory(CompulsoryEntity selectInfo) {
		getSqlMapClientTemplate().update("Compulsory.updateCompulsory", selectInfo);
	}

	@Override
	public int insertCompulsory(CompulsoryEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("Compulsory.insertCompulsory", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return statusFlg;
		
	}

}
