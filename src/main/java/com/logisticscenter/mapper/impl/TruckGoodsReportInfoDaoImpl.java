package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.common.ConvertService;
import com.entity.FeeTypeValueEntity;
import com.entity.TruckGoodsReportDetailEntity;
import com.entity.TruckGoodsReportEntity;
import com.logisticscenter.mapper.TruckGoodsReportDao;
import org.springframework.stereotype.Component;

@Component
public class TruckGoodsReportInfoDaoImpl implements TruckGoodsReportDao {

	@Override
	public int deleteTruckGoodsReport(String ids) {
		
		int count =0;
		try{
			String idsArr[] = ids.split(",");
			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
			count = getSqlMapClientTemplate().delete("TruckGoodsReport.deleteTruckGoodsReport", idLst);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
		
	}

	@Override
	public TruckGoodsReportEntity getTruckGoodsReport(String id) {
		TruckGoodsReportEntity entity = new TruckGoodsReportEntity();
		try{
			entity = (TruckGoodsReportEntity)getSqlMapClientTemplate().queryForObject("TruckGoodsReport.getTruckGoodsReportById",id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruckGoodsReportEntity> getTruckGoodsReport(TruckGoodsReportEntity selectInfo) {
		List<TruckGoodsReportEntity> retEntity= new ArrayList<TruckGoodsReportEntity>();
		try{
			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsReport.getTruckGoodsReportBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TruckGoodsReportEntity> getTruckGoodsReportExcel(TruckGoodsReportEntity selectInfo) {
		List<TruckGoodsReportEntity> retEntity= new ArrayList<TruckGoodsReportEntity>();
		try{
			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsReport.getTruckGoodsReportExcelBy",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getTruckGoodsReportByCount(TruckGoodsReportEntity selectInfo) {
		String count = "";
		try{
			count = (String)getSqlMapClientTemplate().queryForObject("TruckGoodsReport.getTruckGoodsReportByCount",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TruckGoodsReportEntity> getAllTruckGoodsReport() {
		List<TruckGoodsReportEntity> retEntity = new ArrayList<TruckGoodsReportEntity>();
		try{
			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsReport.getAllTruckGoodsReport");
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}
	
	@Override
	public List<TruckGoodsReportEntity> getAllTruckGoodsReport(String stauts) {
		List<TruckGoodsReportEntity> retEntity = new ArrayList<TruckGoodsReportEntity>();
		try{
			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsReport.getAllTruckGoodsReport",stauts);
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}

	@Override
	public void updateAllTruckGoodsReport(TruckGoodsReportEntity selectInfo) {
		try{
			getSqlMapClientTemplate().update("TruckGoodsReport.updateUsers", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void updateTruckGoodsReport(TruckGoodsReportEntity selectInfo) {
		try{
			selectInfo.setExpensens(selectInfo.getPrice().multiply(selectInfo.getRealCarry()));
			getSqlMapClientTemplate().update("TruckGoodsReport.updateTruckGoodsReport", selectInfo);
			Map<String,String> updSql = new HashMap<String,String>();
			updSql.put("reportId",selectInfo.getId()+"");
			updSql.put("updSqlColumn",selectInfo.getFeeTypecolumnSqlUpd());
			getSqlMapClientTemplate().update("TruckGoodsReport.updateFeeTypeColumns",updSql );
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public int insertTruckGoodsReport(TruckGoodsReportEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("TruckGoodsReport.insertTruckGoodsReport", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return statusFlg;
		
	}

	@Override
	public List<FeeTypeValueEntity> getColumnValue(String reportId, String columnName) {
		List<FeeTypeValueEntity> retEntity = new ArrayList<FeeTypeValueEntity>();
		Map getValueMap = new HashMap();
		getValueMap.put("reportId", reportId);
		getValueMap.put("columnName", columnName);
		try{
			retEntity = (List<FeeTypeValueEntity>)getSqlMapClientTemplate().queryForList("TruckGoodsReport.getColumnValue", getValueMap);
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TruckGoodsReportEntity> getTruckGoodsReportImport(TruckGoodsReportEntity selectInfo) {
		List<TruckGoodsReportEntity> retEntity= new ArrayList<TruckGoodsReportEntity>();
		try{
			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsReport.getTruckGoodsReportByImport",selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return retEntity;
	}
	
	@Override
	public int insertTruckGoodsReportDetail(TruckGoodsReportDetailEntity insertInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().insert("TruckGoodsReport.insertTruckGoodsReportDetail", insertInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return statusFlg;
		
	}
	
	@Override
	public List<TruckGoodsReportDetailEntity> getTruckGoodsReportDetail(TruckGoodsReportDetailEntity selectInfo) {
		List<TruckGoodsReportDetailEntity> retEntity= new ArrayList<TruckGoodsReportDetailEntity>();
		try{
			retEntity = (List<TruckGoodsReportDetailEntity>)getSqlMapClientTemplate().queryForList("TruckGoodsReport.getTruckGoodsReportDetail", selectInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retEntity;
		
	}
	
	@Override
	public int updateTruckGoodsReportDetail(TruckGoodsReportDetailEntity updateInfo) {
		int statusFlg = 0;
		try{
			statusFlg = (Integer)getSqlMapClientTemplate().update("TruckGoodsReport.updateTruckGoodsReportDetail", updateInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return statusFlg;
		
	}
	
	@Override
	public String getMaxReportNumber(String date) {
		String maxReportNumber = "";
		try{
			maxReportNumber = (String)getSqlMapClientTemplate().queryForObject("TruckGoodsReport.getMaxReportNumber", date);
		}catch(Exception e){
			maxReportNumber="1";
			e.printStackTrace();
		}
		
		return maxReportNumber;
		
	}

	@Override
	public int updateColumn(int id, String updColumnSql) {
		int count=0;
		Map<String,String> updSql = new HashMap<String,String>();
		updSql.put("reportId",id+"");
		updSql.put("updSqlColumn",updColumnSql);
		try{
		count = getSqlMapClientTemplate().update("TruckGoodsReport.updateFeeTypeColumns",updSql );
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateTruckGoodsReportExpense(TruckGoodsReportEntity updateInfo) {
		int count = 0;
		try{
			count = getSqlMapClientTemplate().update("TruckGoodsReport.updateTruckGoodsReportExpense", updateInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<TruckGoodsReportDetailEntity> getTruckGoodsReportDetail(String truckOrders) {
		List<TruckGoodsReportDetailEntity> retEntity= new ArrayList<TruckGoodsReportDetailEntity>();
		try{
			retEntity = (List<TruckGoodsReportDetailEntity>)getSqlMapClientTemplate().queryForList("TruckGoodsReport.getTruckGoodsReportDetailByOrders", truckOrders);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retEntity;
	}

	/* (non-Javadoc)
	 * @see com.dao.TruckGoodsReportDao#getTruckGoodsReportSum(com.entity.TruckGoodsReportEntity)
	 */
	@Override
	public TruckGoodsReportEntity getTruckGoodsReportSum(
			TruckGoodsReportEntity updateInfo) {
		TruckGoodsReportEntity entity = new TruckGoodsReportEntity();
		try{
			entity = (TruckGoodsReportEntity)getSqlMapClientTemplate().queryForObject("TruckGoodsReport.getTruckGoodsReportSum",updateInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return entity;
	}

}
