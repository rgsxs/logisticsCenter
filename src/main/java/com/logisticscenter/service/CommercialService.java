package com.logisticscenter.service;

import java.util.List;

import com.javabean.CommercialBean;

public interface CommercialService {
	
	/**
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertCommercial(CommercialBean insertInfo);
	
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract List<CommercialBean> getCommercial(CommercialBean selectInfo);
	
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract String getCommercialCount(CommercialBean selectInfo);
	
	/**
	 * @param id
	 * @return
	 */
	public abstract CommercialBean getCommercial(String id);
	
	/**
	 * @param id
	 * @return
	 */
	public abstract int deleteCommercial(String id);
	
	/**
	 * @param insertInfo
	 */
	public abstract void updateCommercial(CommercialBean insertInfo);
	
	/**
	 * @param days
	 * @return
	 */
	public abstract List<CommercialBean> getWarnCommercial(String days);

}
