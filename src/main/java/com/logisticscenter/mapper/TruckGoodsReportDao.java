package com.logisticscenter.mapper;

import java.util.List;

import com.entity.FeeTypeValueEntity;
import com.entity.TruckGoodsReportDetailEntity;
import com.entity.TruckGoodsReportEntity;
import com.javabean.TruckGoodsReportBean;

public interface TruckGoodsReportDao {
	
	public abstract int insertTruckGoodsReport(TruckGoodsReportEntity insertInfo);
	
	public abstract TruckGoodsReportEntity getTruckGoodsReport(String id);
	
	public abstract List<TruckGoodsReportEntity> getTruckGoodsReport(TruckGoodsReportEntity selectInfo);
	
	public abstract String getTruckGoodsReportByCount(TruckGoodsReportEntity selectInfo);
	
	public abstract List<TruckGoodsReportEntity> getAllTruckGoodsReport();
	
	public abstract List<TruckGoodsReportEntity> getAllTruckGoodsReport(String reportStatus);
	
	public abstract int deleteTruckGoodsReport(String id);
	
	public abstract void updateTruckGoodsReport(TruckGoodsReportEntity selectInfo);
	
	public abstract void updateAllTruckGoodsReport(TruckGoodsReportEntity selectInfo);
	
	public abstract List<FeeTypeValueEntity> getColumnValue(String reportId, String columnName);
	public abstract int updateColumn(int id, String updColumnSql);
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsReportEntity> getTruckGoodsReportImport(TruckGoodsReportEntity selectInfo);
	
	public abstract int insertTruckGoodsReportDetail(TruckGoodsReportDetailEntity insertInfo);
	
	/**
	 * 获得车辆出车货物类型分类详细
	 * @param insertInfo
	 * @return
	 */
	public abstract List<TruckGoodsReportDetailEntity> getTruckGoodsReportDetail(TruckGoodsReportDetailEntity insertInfo);
	
	/**
	 * 获得车辆出车货物类型分类详细
	 * @param truckOrders
	 * @return
	 */
	public abstract List<TruckGoodsReportDetailEntity> getTruckGoodsReportDetail(String truckOrders);
	
	/**
	 * 更新车辆出车货物类型分类详细
	 * @param insertInfo
	 * @return
	 */
	public abstract int updateTruckGoodsReportDetail(TruckGoodsReportDetailEntity insertInfo);
	
	/**
	 * 获得指定日期最大订单编号
	 * @param date 要查询日期
	 * @return
	 */
	public abstract String getMaxReportNumber(String date);

	/**
	 * @param selectInfo
	 * @return
	 */
	List<TruckGoodsReportEntity> getTruckGoodsReportExcel(
            TruckGoodsReportEntity selectInfo);
	
	public abstract int updateTruckGoodsReportExpense(TruckGoodsReportEntity updateInfo);
	
	/**
	 * 计算费用/盈利/运费的合计
	 * @param updateInfo
	 * @return
	 */
	public abstract TruckGoodsReportEntity getTruckGoodsReportSum(TruckGoodsReportEntity updateInfo);
	
	
}
