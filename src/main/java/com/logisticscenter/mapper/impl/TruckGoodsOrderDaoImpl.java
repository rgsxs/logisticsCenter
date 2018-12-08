package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;


import com.common.ConvertService;
import com.logisticscenter.mapper.TruckGoodsOrderDao;
import com.logisticscenter.model.TruckGoodsOrderDetailEntity;
import com.logisticscenter.model.TruckGoodsOrderTakerEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class TruckGoodsOrderDaoImpl {

//	/**
//	 * @param insertInfo 预录车辆信息
//	 * @return
//	 */
//	public int insertTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity insertInfo){
//		int statusFlg = 0;
//		try{
//			statusFlg = (Integer)getSqlMapClientTemplate().insert("TruckGoodsOrder.insertTruckGoodsOrderTaker", insertInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		return statusFlg;
//	}
//
//	/**
//	 * 预录车辆详细信息
//	 * @param insertInfo
//	 * @return
//	 */
//	public int insertTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity insertInfo){
//		int statusFlg = 0;
//		try{
//			statusFlg = (Integer)getSqlMapClientTemplate().insert("TruckGoodsOrder.insertTruckGoodsOrderDetail", insertInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//		return statusFlg;
//	}
//
//	/**
//	 * 获得预录车辆信息
//	 * @param selectInfo
//	 * @return
//	 */
//	public List<TruckGoodsOrderTakerEntity> getTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity selectInfo){
//		List<TruckGoodsOrderTakerEntity> retEntity = new ArrayList<TruckGoodsOrderTakerEntity>();
//		try{
//			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsOrder.getTruckGoodsOrderTaker",selectInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return retEntity;
//	}
//
//
//	/**
//	 * 获得预录车辆详细信息
//	 * @param selectInfo
//	 * @return
//	 */
//	public List<TruckGoodsOrderDetailEntity> getTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity selectInfo){
//		List<TruckGoodsOrderDetailEntity> retEntity = new ArrayList<TruckGoodsOrderDetailEntity>();
//		try{
//			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsOrder.getTruckGoodsOrderDetail",selectInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return retEntity;
//	}
//
//	/**
//	 * 分页用,获得要查询的总数
//	 * @param selectInfo
//	 * @return
//	 */
//	public String getTruckGoodsOrderByCount(TruckGoodsOrderTakerEntity selectInfo){
//		String count = "";
//		try{
//			count = (String)getSqlMapClientTemplate().queryForObject("TruckGoodsOrder.getTruckGoodsOrderByCount",selectInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	/**
//	 * 根据ID获得预录车辆信息
//	 * @param id
//	 * @return
//	 */
//	public List<TruckGoodsOrderTakerEntity> getTruckGoodsOrderTakerById(String id){
//		List<TruckGoodsOrderTakerEntity> retEntity= new ArrayList<TruckGoodsOrderTakerEntity>();
//		try{
//			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsOrder.getTruckGoodsOrderTakerById",id);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return retEntity;
//	}
//
//	/**
//	 * 根据ID获得预录车辆详细信息
//	 * @param reportId
//	 * @return
//	 */
//	public List<TruckGoodsOrderDetailEntity> getTruckGoodsOrderDetailById(String reportId){
//		List<TruckGoodsOrderDetailEntity> retEntity= new ArrayList<TruckGoodsOrderDetailEntity>();
//		try{
//			retEntity = getSqlMapClientTemplate().queryForList("TruckGoodsOrder.getTruckGoodsOrderDetailByReprotId",reportId);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return retEntity;
//	}
//
//	/**
//	 * 根据ID删除预录信息
//	 * @param id
//	 * @return
//	 */
//	public int deleteTruckGoodsOrderTaker(String id){
//		int count =0;
//		try{
//			String idsArr[] = id.split(",");
//			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
//			count = getSqlMapClientTemplate().update("TruckGoodsOrder.deleteTruckGoodsOrderTaker", idLst);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	/**
//	 * 根据ID删除预录信息
//	 * @param reportId
//	 * @return
//	 */
//	public int deleteTruckGoodsOrderDetail(String reportId){
//		int count =0;
//		try{
//			String idsArr[] = reportId.split(",");
//			ArrayList idLst = ConvertService.arrayToArrayList(idsArr);
//			count = getSqlMapClientTemplate().update("TruckGoodsOrder.deleteTruckGoodsOrderDetail", idLst);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return count;
//	}
//
//	/**
//	 * 更新预录信息
//	 * @param updateInfo
//	 */
//	public int updateTruckGoodsOrderTaker(TruckGoodsOrderTakerEntity updateInfo){
//		int updateCount = 0;
//		try{
//			updateCount = getSqlMapClientTemplate().update("TruckGoodsOrder.updateTruckGoodsOrderTaker", updateInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return updateCount;
//	}
//
//	/**
//	 * 更新预录详细信息
//	 * @param updateInfo
//	 */
//	public void updateTruckGoodsOrderDetail(TruckGoodsOrderDetailEntity updateInfo){
//		try{
//			getSqlMapClientTemplate().update("TruckGoodsOrder.updateTruckGoodsOrderDetail", updateInfo);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * @param entity
//	 */
//	public int updateTruckGoodsOrderStatus(TruckGoodsOrderTakerEntity entity){
//		int updateCount = 0;
//		try{
//			updateCount = getSqlMapClientTemplate().update("TruckGoodsOrder.updateTruckGoodsOrderStatus", entity);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return updateCount;
//	}
		
}
