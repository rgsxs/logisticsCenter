package com.logisticscenter.mapper;

import com.logisticscenter.model.TruckGoodsOrderDetailEntity;
import com.logisticscenter.model.TruckGoodsOrderTakerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TruckGoodsOrderDao {
	
	/**
	 * @param insertInfo 预录车辆信息
	 * @return
	 */
	public abstract int insertTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity insertInfo);
	
	/**
	 * 预录车辆详细信息
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity insertInfo);
	
	/**
	 * 获得预录车辆信息
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsOrderTakerEntity> getTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity selectInfo);
	
	
	/**
	 * 获得预录车辆详细信息
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsOrderDetailEntity> getTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity selectInfo);
	
	/**
	 * 分页用,获得要查询的总数
	 * @param selectInfo
	 * @return
	 */
	public abstract String getTruckGoodsOrderByCount(TruckGoodsOrderTakerEntity selectInfo);
	
	/**
	 * 根据ID获得预录车辆信息
	 * @param id
	 * @return
	 */
	public abstract List<TruckGoodsOrderTakerEntity> getTruckGoodsOrderTakerById(String id);
	
	/**
	 * 根据ID获得预录车辆详细信息
	 * @param id
	 * @return
	 */
	public abstract List<TruckGoodsOrderDetailEntity> getTruckGoodsOrderDetailById(String id);
	 
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
	public abstract int updateTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity updateInfo);
	
	/**
	 * 更新预录详细信息
	 * @param updateInfo
	 */
	public abstract void updateTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity updateInfo);

	/**
	 * @param entity
	 */
	public abstract int updateTruckGoodsOrderStatus(TruckGoodsOrderTakerEntity entity);
	
}
