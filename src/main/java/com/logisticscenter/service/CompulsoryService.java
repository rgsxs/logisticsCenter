package com.logisticscenter.service;

import java.util.List;

import com.javabean.CommercialBean;
import com.javabean.CompulsoryBean;

public interface CompulsoryService {
	
	public abstract int insertCompulsory(CompulsoryBean insertInfo);
	
	public abstract List<CompulsoryBean> getCompulsory(CompulsoryBean selectInfo);
	
	public abstract String getCompulsoryCount(CompulsoryBean selectInfo);
	
	public abstract CompulsoryBean getCompulsory(String id);
	
	public abstract int deleteCompulsory(String id);
	
	public abstract void updateCompulsory(CompulsoryBean insertInfo);
	
	public abstract List<CompulsoryBean> getWarnCompulsory(String days);

}
