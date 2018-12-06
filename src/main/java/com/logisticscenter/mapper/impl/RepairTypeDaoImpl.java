package com.logisticscenter.mapper.impl;

import java.util.List;

import com.logisticscenter.mapper.RepairTypeDao;
import com.logisticscenter.model.RepairTypeEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class RepairTypeDaoImpl implements RepairTypeDao {

	@Override
	public void deleteRepairType(String id) {
		getSqlMapClientTemplate().delete("RepairType.deleteRepairType", id);
		
	}

	@Override
	public RepairTypeEntity getRepairType(String id) {
		return (RepairTypeEntity)getSqlMapClientTemplate().queryForObject("RepairType.getRepairTypeById",id);
		
	}

	@Override
	public List<RepairTypeEntity> getRepairType(RepairTypeEntity selectInfo) {
		return (List<RepairTypeEntity>)getSqlMapClientTemplate().queryForList("RepairType.getRepairTypeByName",selectInfo);
	}
	
	@Override
	public String getRepairTypeCount(RepairTypeEntity selectInfo) {
		String count = "";
		count = (String)getSqlMapClientTemplate().queryForObject("RepairType.getRepairTypeByName",selectInfo);
		return count;
	}
	
	@Override
	public List<RepairTypeEntity> getAllRepairType() {
		return (List<RepairTypeEntity>)getSqlMapClientTemplate().queryForList("RepairType.getAllRepairType");
	}

	@Override
	public void updateAllRepairType(RepairTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("RepairType.updateAllRepairType", selectInfo);
		
	}

	@Override
	public void updateRepairType(RepairTypeEntity selectInfo) {
		getSqlMapClientTemplate().update("RepairType.updateRepairType", selectInfo);
		
	}

	@Override
	public int insertRepairType(RepairTypeEntity insertInfo) {
		int statusFlg = 0;
		statusFlg = (Integer)getSqlMapClientTemplate().insert("RepairType.insertRepairType", insertInfo);
		
		return statusFlg;
		
	}

}
