package com.logisticscenter.service;

import java.util.List;

import com.javabean.TruckGoodsOrderDetailBean;
import com.javabean.TruckGoodsOrderTakerBean;

public interface TruckGoodsOrderService {
	
	/**
	 * @param insertInfo 预录车辆信息
	 * @return
	 */
	public abstract int insertTruckGoodsOrderTaker(TruckGoodsOrderTakerBean insertInfo);
	
	/**
	 * 预录车辆详细信息
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertTruckGoodsOrderDetail(TruckGoodsOrderDetailBean insertInfo);
	
	/**
	 * 获得预录车辆信息
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsOrderTakerBean> getTruckGoodsOrderTaker(TruckGoodsOrderTakerBean selectInfo);
	
	
	/**
	 * 获得预录车辆详细信息
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsOrderDetailBean> getTruckGoodsOrderDetail(TruckGoodsOrderDetailBean selectInfo);
	
	/**
	 * 分页用,获得要查询的总数
	 * @param selectInfo
	 * @return
	 */
	public abstract String getTruckGoodsOrderByCount(TruckGoodsOrderTakerBean selectInfo);
	
	/**
	 * 根据ID获得预录车辆信息
	 * @param id
	 * @return
	 */
	public abstract List<TruckGoodsOrderTakerBean> getTruckGoodsOrderTakerById(String id);
	
	/**
	 * 根据ID获得预录车辆详细信息
	 * @param id
	 * @return
	 */
	public abstract List<TruckGoodsOrderDetailBean> getTruckGoodsOrderDetailById(String id);
	 
	/**
	 * 根据ID删除预录信息
	 * @param id
	 * @return
	 */
	public abstract int deleteTruckGoodsOrderTaker(String id);
	
	/**
	 * 根据ID删除预录信息
	 * @param reportId
	 * @return
	 */
	public abstract int deleteTruckGoodsOrderDetail(String reportId);
	
	/**
	 * 更新预录信息(现在不用)
	 * @param updateInfo
	 */
	public abstract int updateTruckGoodsOrderTaker(TruckGoodsOrderTakerBean updateInfo);
	
	/**
	 * 更新预录详细信息
	 * @param updateInfo
	 */
	public abstract void updateTruckGoodsOrderDetail(TruckGoodsOrderDetailBean updateInfo);

	/**
	 * @param id
	 * @param i
	 * @return
	 */
	public abstract int updateTruckGoodsOrderStatus(int id, int i);
	

}
