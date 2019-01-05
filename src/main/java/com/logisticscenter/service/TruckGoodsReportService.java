package com.logisticscenter.service;

import java.util.List;

import com.javabean.FeeTypeValueBean;
import com.javabean.TruckGoodsReportBean;
import com.javabean.TruckGoodsReportDetailBean;

public interface TruckGoodsReportService {
	
	public abstract int insertTruckGoodsReport(TruckGoodsReportBean insertInfo);
	
	public abstract TruckGoodsReportBean getTruckGoodsReport(String id);
	
	public abstract List<TruckGoodsReportBean> getTruckGoodsReport(TruckGoodsReportBean selectInfo);
	
	/**
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsReportBean> getTruckGoodsReportImport(TruckGoodsReportBean selectInfo);
	
	public abstract String getTruckGoodsReportByCount(TruckGoodsReportBean selectInfo);
	
	public abstract List<TruckGoodsReportBean> getAllTruckGoodsReport();
	
	public abstract List<TruckGoodsReportBean> getAllTruckGoodsReport(String reportStatus);
	
	public abstract int deleteTruckGoodsReport(String id);
	
	public abstract void updateTruckGoodsReport(TruckGoodsReportBean updateInfo);
	
	public abstract void updateAllTruckGoodsReport(TruckGoodsReportBean updateInfo);
	
	public abstract int updateColumn(int id, String updColumnSql);
	
	/**
	 * 获得指定字段自定数据的值
	 * @param reportId
	 * @param columnName
	 */
	public abstract List<FeeTypeValueBean> getColumnValue(String reportId, String columnName);
	
	/**
	 *
	 *
	 * 插入车辆出车货物类型分类详细
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertTruckGoodsReportDetail(TruckGoodsReportDetailBean insertInfo);
	
	/**
	 * 获得车辆出车货物类型分类详细
	 * @param selectInfo
	 * @return
	 */
	public abstract List<TruckGoodsReportDetailBean> getTruckGoodsReportDetail(TruckGoodsReportDetailBean selectInfo);
	
	/**
	 * 获得车辆出车货物类型分类详细
	 * @param truckOrders
	 * @return
	 */
	public abstract List<TruckGoodsReportDetailBean> getTruckGoodsReportDetail(String truckOrders);
	
	/**
	 * 更新出车货物类型分类详细
	 * @param updateInfo
	 * @return
	 */
	public abstract int updateTruckGoodsReportDetail(TruckGoodsReportDetailBean updateInfo);
	
	/**
	 * 更新出车货物类型分类详细
	 * @param date
	 * @return
	 */
	public abstract String getMaxReportNumber(String date);

	/**
	 * @param selectInfo
	 * @return
	 */
	List<TruckGoodsReportBean> getTruckGoodsReportExcel(
            TruckGoodsReportBean selectInfo);
	
	/**
	 * @param updateInfo
	 * @return
	 */
	public abstract int updateTruckGoodsReportExpense(TruckGoodsReportBean updateInfo);
	
	/**
	 * 计算费用/盈利/运费的合计
	 * @param selectInfo
	 * @return
	 */
	public abstract TruckGoodsReportBean getTruckGoodsReportSum(TruckGoodsReportBean selectInfo);

}
