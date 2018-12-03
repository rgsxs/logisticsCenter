package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.javabean.ChartsBean;
import com.logisticscenter.mapper.ChartsDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class ChartsDaoImpl  implements ChartsDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<ChartsBean> getClientChartsByMonth(String selectYear) {
		return (List<ChartsBean>)getSqlMapClientTemplate().queryForList("Charts.getClientChartsByMonth",selectYear);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChartsBean> getDriverChartsByMonth(String selectYear) {
		return (List<ChartsBean>)getSqlMapClientTemplate().queryForList("Charts.getDriverChartsByMonth",selectYear);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChartsBean> getClientFeeChartsByMonth(String selectYear,String columns) {
		List<ChartsBean> chartBeanList = new ArrayList<ChartsBean>();
		Map<String,String> getValueMap = new HashMap<String,String>();
		getValueMap.put("selectYear", selectYear);
		getValueMap.put("getFeeTypeColumn", columns);
		try{
			chartBeanList = getSqlMapClientTemplate().queryForList("Charts.getClientFeeChartsByMonth",getValueMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		return chartBeanList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChartsBean> getDriverFeeChartsByMonth(String selectYear,String columns) {
		List<ChartsBean> chartBeanList = new ArrayList<ChartsBean>();
		Map<String,String> getValueMap = new HashMap<String,String>();
		getValueMap.put("selectYear", selectYear);
		getValueMap.put("getFeeTypeColumn", columns);
		try{
			chartBeanList = getSqlMapClientTemplate().queryForList("Charts.getDriverFeeChartsByMonth",getValueMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		return chartBeanList;
	}

}
