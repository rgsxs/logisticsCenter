package com.logisticscenter.service;

import java.util.List;

import com.javabean.GoodsTypeBean;

public interface GoodsTypeService {
	
	public abstract int insertGoodsType(GoodsTypeBean insertInfo);
	
	public abstract GoodsTypeBean getGoodsType(String id);
	
	public abstract List<GoodsTypeBean> getGoodsType(GoodsTypeBean selectInfo);
	
	public abstract String getGoodsTypeCount(GoodsTypeBean selectInfo);
	
	public abstract List<GoodsTypeBean> getAllGoodsType();
	
	public abstract int deleteGoodsType(String id);
	
	public abstract void updateGoodsType(GoodsTypeBean updateInfo);
	
	public abstract void updateAllGoodsType(GoodsTypeBean updateInfo);

}
