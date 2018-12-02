package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.common.ConvertService;
import com.entity.FeeTypeEntity;
import com.logisticscenter.mapper.FeeTypeDao;
import org.springframework.stereotype.Component;

@Component
public class FeeTypeDaoImpl implements FeeTypeDao {

	@Override
	public int deleteFeeType(String id) {
		String idsArr[] = id.split(",");
		ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
		String str = ConvertService.arrayToString(idsArr,"feeType");
		int count = 0;
		try{
			count = getSqlMapClientTemplate().delete("FeeType.deleteFeeType", idLst);
			//drop表truckGoodsReport相对应的费用类型字段
			getSqlMapClientTemplate().update("FeeType.deleteTruckGoodsReportColumn", str);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public FeeTypeEntity getFeeType(String id) {
		return (FeeTypeEntity)getSqlMapClientTemplate().queryForObject("FeeType.getFeeTypeById",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeeTypeEntity> getFeeType(FeeTypeEntity selectInfo) {
		List<FeeTypeEntity> feeTypeEntityList = new ArrayList<FeeTypeEntity>();
		try{
			feeTypeEntityList = getSqlMapClientTemplate().queryForList("FeeType.getFeeTypeBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return feeTypeEntityList;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getFeeTypeCount(FeeTypeEntity selectInfo) {
		String count = "";
		try{
			count = (String)getSqlMapClientTemplate().queryForObject("FeeType.getFeeTypeByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FeeTypeEntity> getAllFeeType() {
		return (List<FeeTypeEntity>)getSqlMapClientTemplate().queryForList("FeeType.getAllFeeType");
	}

	@Override
	public void updateAllFeeType(FeeTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("FeeType.updateAllFeeType", selectInfo);
		
	}

	@Override
	public void updateFeeType(FeeTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("FeeType.updateFeeType", selectInfo);
	}

	@Override
	public int insertFeeType(FeeTypeEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("FeeType.insertFeeType", insertInfo);
			//更新费用类型字段
			if(statusFlg > 0){
				String columnName = "feeType" + statusFlg;
				Map columnMap = new HashMap();
				columnMap.put("id", statusFlg);
				columnMap.put("columnName", columnName);
				getSqlMapClientTemplate().update("FeeType.updateFeeTypeColumn", columnMap);
				//对truckGoodsReport表进行新加属性varchar(100)字段
				Map truckGoodsReportcolumnMap = new HashMap();
				truckGoodsReportcolumnMap.put("columnName", columnName);
				truckGoodsReportcolumnMap.put("columnLength", "varchar(100)");
				getSqlMapClientTemplate().update("FeeType.updateTruckGoodsReportColumn", truckGoodsReportcolumnMap);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return statusFlg;
		
	}

}
