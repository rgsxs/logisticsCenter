package com.logisticscenter.mapper;

import com.logisticscenter.model.IllegalReportEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IllegalReportDao {
	
	public abstract int insertIllegalReport(IllegalReportEntity insertInfo);
	
	public abstract IllegalReportEntity getIllegalReport(String id);
	
	public abstract List<IllegalReportEntity> getIllegalReport(IllegalReportEntity selectInfo);
	
	public abstract String getIllegalReportCount(IllegalReportEntity selectInfo);
	
	public abstract List<IllegalReportEntity> getAllIllegalReport();
	
	public abstract void deleteIllegalReport(String id);
	
	public abstract void updateIllegalReport(IllegalReportEntity selectInfo);
	
	public abstract void updateAllIllegalReport(IllegalReportEntity selectInfo);
}
