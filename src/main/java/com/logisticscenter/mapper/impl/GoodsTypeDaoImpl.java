package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import com.common.ConvertService;
import com.logisticscenter.mapper.GoodsTypeDao;
import com.logisticscenter.model.GoodsTypeEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GoodsTypeDaoImpl implements GoodsTypeDao {

	@Override
	public int deleteGoodsType(String id) {
		
		int count =0;
		try{
			String idsArr[] = id.split(",");
			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
			count = getSqlMapClientTemplate().delete("GoodsType.deleteGoodsType", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public GoodsTypeEntity getGoodsType(String id) {
		return (GoodsTypeEntity)getSqlMapClientTemplate().queryForObject("GoodsType.getGoodsTypeById",id);
		
	}

	@Override
	public List<GoodsTypeEntity> getGoodsType(GoodsTypeEntity selectInfo) {
		List<GoodsTypeEntity> goodsTypeEntityList = new ArrayList<GoodsTypeEntity>();
		try{
			goodsTypeEntityList = getSqlMapClientTemplate().queryForList("GoodsType.getGoodsTypeBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodsTypeEntityList;
	}
	
	@Override
	public String getGoodsTypeCount(GoodsTypeEntity selectInfo) {
		String count="";
		try{
			count = (String)getSqlMapClientTemplate().queryForObject("GoodsType.getGoodsTypeByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<GoodsTypeEntity> getAllGoodsType() {
		return (List<GoodsTypeEntity>)getSqlMapClientTemplate().queryForList("GoodsType.getAllGoodsType");
	}

	@Override
	public void updateAllGoodsType(GoodsTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("GoodsType.updateAllGoodsType", selectInfo);
		
	}

	@Override
	public void updateGoodsType(GoodsTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("GoodsType.updateGoodsType", selectInfo);
		
	}

	@Override
	public int insertGoodsType(GoodsTypeEntity insertInfo) {
		int statusFlg = 0;
		statusFlg = (Integer)getSqlMapClientTemplate().insert("GoodsType.insertGoodsType", insertInfo);
		
		return statusFlg;
		
	}

}
