package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.javabean.ChartsBean;
import com.logisticscenter.mapper.ChartsDao;
import com.logisticscenter.service.ChartsService;
import org.springframework.stereotype.Component;

@Component
public class ChartsServiceImpl implements ChartsService {
	
	ChartsDao chartsDao;
	
	public ChartsDao getChartsDao() {
		return chartsDao;
	}

	public void setChartsDao(ChartsDao chartsDao) {
		this.chartsDao = chartsDao;
	}

	public List<ChartsBean> getClientChartsByMonth(String selectYear){
		List<ChartsBean> beanList = new ArrayList<ChartsBean>();
		try{
			beanList = chartsDao.getClientChartsByMonth(selectYear);
		}catch(Exception e){
			e.printStackTrace();
		}
		return beanList;
	}
	
	public List<ChartsBean> getDriverChartsByMonth(String selectYear){
		List<ChartsBean> beanList = new ArrayList<ChartsBean>();
		try{
			beanList = chartsDao.getDriverChartsByMonth(selectYear);
		}catch(Exception e){
			e.printStackTrace();
		}
		return beanList;
	}
	
	public List<ChartsBean> getClientFeeChartsByMonth(String selectYear,String columns){
		List<ChartsBean> beanList = new ArrayList<ChartsBean>();
		try{
			beanList = chartsDao.getClientFeeChartsByMonth(selectYear, columns);
		}catch(Exception e){
			e.printStackTrace();
		}
		return beanList;
	}
	
	public List<ChartsBean> getDriverFeeChartsByMonth(String selectYear,String columns){
		List<ChartsBean> beanList = new ArrayList<ChartsBean>();
		try{
			beanList = chartsDao.getDriverFeeChartsByMonth(selectYear,columns);
		}catch(Exception e){
			e.printStackTrace();
		}
		return beanList;
	}

}
