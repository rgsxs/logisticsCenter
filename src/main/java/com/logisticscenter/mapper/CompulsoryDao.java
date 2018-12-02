package com.logisticscenter.mapper;

import java.util.List;

import com.entity.CommercialEntity;
import com.entity.CompulsoryEntity;

/**
 * @author 卜
 *
 */
public interface CompulsoryDao {

	/**
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertCompulsory(CompulsoryEntity insertInfo);
	
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract List<CompulsoryEntity> getCompulsory(CompulsoryEntity selectInfo);
	
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract String getCompulsoryCount(CompulsoryEntity selectInfo);
	
	/**
	 * @param id
	 * @return
	 */
	public abstract CompulsoryEntity getCompulsory(String id);
	
	/**
	 * @param id
	 * @return
	 */
	public abstract int deleteCompulsory(String id);
	
	/**
	 * @param insertInfo
	 */
	public abstract void updateCompulsory(CompulsoryEntity insertInfo);
	
	/**
	 * @param days
	 * @return
	 */
	public abstract List<CompulsoryEntity> getWarnCompulsory(String days);
}
