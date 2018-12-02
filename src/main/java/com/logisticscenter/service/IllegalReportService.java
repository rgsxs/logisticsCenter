package com.logisticscenter.service;

import java.util.List;

import com.entity.IllegalReportEntity;
import com.javabean.IllegalReportBean;

public interface IllegalReportService {
	
	public abstract int insertIllegalReport(IllegalReportBean insertInfo);
	
	public abstract IllegalReportBean getIllegalReport(String id);
	
	public abstract List<IllegalReportBean> getIllegalReport(IllegalReportBean selectInfo);
	
	public abstract String getIllegalReportCount(IllegalReportBean selectInfo);
	
	public abstract List<IllegalReportBean> getAllIllegalReport();
	
	public abstract void deleteIllegalReport(String id);
	
	public abstract void updateIllegalReport(IllegalReportBean updateInfo);
	
	public abstract void updateAllIllegalReport(IllegalReportBean updateInfo);

}
