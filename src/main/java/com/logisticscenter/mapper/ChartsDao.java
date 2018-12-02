package com.logisticscenter.mapper;

import java.util.List;

import com.javabean.ChartsBean;

public interface ChartsDao {
	
	public abstract List<ChartsBean> getClientChartsByMonth(String selectYear);
	
	public abstract List<ChartsBean> getDriverChartsByMonth(String selectYear);
	
	public abstract List<ChartsBean> getClientFeeChartsByMonth(String selectYear, String columns);
	
	public abstract List<ChartsBean> getDriverFeeChartsByMonth(String selectYear, String columns);
}
