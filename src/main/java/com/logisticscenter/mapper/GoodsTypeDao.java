package com.logisticscenter.mapper;

import com.logisticscenter.model.GoodsTypeEntity;

import java.util.List;


public interface GoodsTypeDao {
	
	public abstract int insertGoodsType(GoodsTypeEntity insertInfo);
	
	public abstract GoodsTypeEntity getGoodsType(String id);
	
	public abstract List<GoodsTypeEntity> getGoodsType(GoodsTypeEntity selectInfo);
	
	public abstract String getGoodsTypeCount(GoodsTypeEntity selectInfo);
	
	public abstract List<GoodsTypeEntity> getAllGoodsType();
	
	public abstract int deleteGoodsType(String id);
	
	public abstract void updateGoodsType(GoodsTypeEntity selectInfo);
	
	public abstract void updateAllGoodsType(GoodsTypeEntity selectInfo);
}
