package com.logisticscenter.mapper;

import java.util.List;

import com.logisticscenter.model.ChartsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChartsDao {
	
	public abstract List<ChartsEntity> getClientChartsByMonth(String selectYear);
	
	public abstract List<ChartsEntity> getDriverChartsByMonth(String selectYear);
	
	public abstract List<ChartsEntity> getClientFeeChartsByMonth(String selectYear, String columns);
	
	public abstract List<ChartsEntity> getDriverFeeChartsByMonth(String selectYear, String columns);
}
