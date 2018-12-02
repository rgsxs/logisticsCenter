package com.logisticscenter.mapper.impl;

import java.util.List;

import com.entity.IllegalReportEntity;
import com.logisticscenter.mapper.IllegalReportDao;
import org.springframework.stereotype.Component;

@Component
public class IllegalReportDaoImpl implements IllegalReportDao {

	@Override
	public void deleteIllegalReport(String id) {
		getSqlMapClientTemplate().delete("IllegalReport.deleteIllegalReport", id);
		
	}

	@Override
	public IllegalReportEntity getIllegalReport(String id) {
		return (IllegalReportEntity)getSqlMapClientTemplate().queryForObject("IllegalReport.getIllegalReportByName",id);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IllegalReportEntity> getIllegalReport(IllegalReportEntity selectInfo) {
		return (List<IllegalReportEntity>)getSqlMapClientTemplate().queryForList("IllegalReport.getIllegalReportByName",selectInfo);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getIllegalReportCount(IllegalReportEntity selectInfo) {
		String count = "";
		count = (String)getSqlMapClientTemplate().queryForObject("IllegalReport.getIllegalReportByNameCount",selectInfo);
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<IllegalReportEntity> getAllIllegalReport() {
		return (List<IllegalReportEntity>)getSqlMapClientTemplate().queryForList("IllegalReport.getAllIllegalReport");
	}

	@Override
	public void updateAllIllegalReport(IllegalReportEntity selectInfo) {
		getSqlMapClientTemplate().update("IllegalReport.updateIllegalReport", selectInfo);
		
	}

	@Override
	public void updateIllegalReport(IllegalReportEntity selectInfo) {
		getSqlMapClientTemplate().update("IllegalReport.updateIllegalReport", selectInfo);
		
	}

	@Override
	public int insertIllegalReport(IllegalReportEntity insertInfo) {
		int statusFlg = 0;
		statusFlg = (Integer)getSqlMapClientTemplate().insert("IllegalReport.insertIllegalReport", insertInfo);
		
		return statusFlg;
		
	}

}
