package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.javabean.TruckGoodsOrderDetailBean;
import com.javabean.TruckGoodsOrderTakerBean;
import com.logisticscenter.mapper.TruckGoodsOrderDao;
import com.logisticscenter.model.TruckGoodsOrderDetailEntity;
import com.logisticscenter.model.TruckGoodsOrderTakerEntity;
import com.logisticscenter.service.TruckGoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TruckGoodsOrderServiceImpl implements TruckGoodsOrderService {

	@Autowired
	TruckGoodsOrderDao truckGoodsOrderDao;


	/**
	 * @param insertInfo 预录车辆信息
	 * @return
	 */
	public  int insertTruckGoodsOrderTaker(TruckGoodsOrderTakerBean insertInfo){
		TruckGoodsOrderTakerEntity TruckGoodsOrderE = (TruckGoodsOrderTakerEntity) ConvertService.convertBeanToEntity(insertInfo, new TruckGoodsOrderTakerEntity());
		TruckGoodsOrderE.setCreateDate(ConvertService.getDate());
		TruckGoodsOrderE.setCreateTime(ConvertService.getTime());
		TruckGoodsOrderE.setEditDate(ConvertService.getDate());
		TruckGoodsOrderE.setEditTime(ConvertService.getTime());
		int statusFlg = truckGoodsOrderDao.insertTruckGoodsOrderTaker(TruckGoodsOrderE);
		return statusFlg;
	}
	
	/**
	 * 预录车辆详细信息
	 * @param insertInfo
	 * @return
	 */
	public  int insertTruckGoodsOrderDetail(TruckGoodsOrderDetailBean insertInfo){
		TruckGoodsOrderDetailEntity TruckGoodsOrderE = (TruckGoodsOrderDetailEntity) ConvertService.convertBeanToEntity(insertInfo, new TruckGoodsOrderDetailEntity());
		TruckGoodsOrderE.setCreateDate(ConvertService.getDate());
		TruckGoodsOrderE.setCreateTime(ConvertService.getTime());
		TruckGoodsOrderE.setEditDate(ConvertService.getDate());
		TruckGoodsOrderE.setEditTime(ConvertService.getTime());
		int statusFlg = truckGoodsOrderDao.insertTruckGoodsOrderDetail(TruckGoodsOrderE);
		return statusFlg;
	}
	
	/**
	 * 获得预录车辆信息
	 * @param selectInfo
	 * @return
	 */
	public  List<TruckGoodsOrderTakerBean> getTruckGoodsOrderTaker(TruckGoodsOrderTakerBean selectInfo){
		TruckGoodsOrderTakerEntity truckGoodsOrderTakerE = (TruckGoodsOrderTakerEntity)ConvertService.convertBeanToEntity(selectInfo,new TruckGoodsOrderTakerEntity());
		List<TruckGoodsOrderTakerEntity> entityList = new ArrayList<TruckGoodsOrderTakerEntity>();
		List<TruckGoodsOrderTakerBean> beanList = new ArrayList<TruckGoodsOrderTakerBean>();
		int pageSize =Integer.parseInt(truckGoodsOrderTakerE.getPageSize());
		int currentPage =Integer.parseInt(truckGoodsOrderTakerE.getCurrentPage());
		currentPage = (currentPage -1)*pageSize;
		truckGoodsOrderTakerE.setCurrentPage(currentPage+"");
		entityList = truckGoodsOrderDao.getTruckGoodsOrderTaker(truckGoodsOrderTakerE);
		for(int i=0;i<entityList.size(); i++){
			TruckGoodsOrderTakerBean truckGoodsOrderTakerBean = (TruckGoodsOrderTakerBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckGoodsOrderTakerBean());
			beanList.add(truckGoodsOrderTakerBean);
		}
		return beanList;
	}
	
	/**
	 * 获得预录车辆信息
	 * @param selectInfo
	 * @return
	 */
	public  List<TruckGoodsOrderDetailBean> getTruckGoodsOrderDetail(TruckGoodsOrderDetailBean selectInfo){
		TruckGoodsOrderDetailEntity truckGoodsOrderDetailE = (TruckGoodsOrderDetailEntity)ConvertService.convertBeanToEntity(selectInfo,new TruckGoodsOrderDetailEntity());
		List<TruckGoodsOrderDetailEntity> entityList = new ArrayList<TruckGoodsOrderDetailEntity>();
		List<TruckGoodsOrderDetailBean> beanList = new ArrayList<TruckGoodsOrderDetailBean>();
		entityList = truckGoodsOrderDao.getTruckGoodsOrderDetail(truckGoodsOrderDetailE);
		for(int i=0;i<entityList.size(); i++){
			TruckGoodsOrderDetailBean truckGoodsOrderDetailBean = (TruckGoodsOrderDetailBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckGoodsOrderDetailBean());
			beanList.add(truckGoodsOrderDetailBean);
		}
		return beanList;
	}
	
	/**
	 * 分页用,获得要查询的总数
	 * @param selectInfo
	 * @return
	 */
	public  String getTruckGoodsOrderByCount(TruckGoodsOrderTakerBean selectInfo){
		String count = "";
		TruckGoodsOrderTakerEntity truckGoodsOrderTakerE = (TruckGoodsOrderTakerEntity)ConvertService.convertBeanToEntity(selectInfo,new TruckGoodsOrderTakerEntity());
		count = truckGoodsOrderDao.getTruckGoodsOrderByCount(truckGoodsOrderTakerE);
		return count;
	}
	
	/**
	 * 根据ID获得预录车辆信息
	 * @param id
	 * @return
	 */
	public  List<TruckGoodsOrderTakerBean> getTruckGoodsOrderTakerById(String id){
		List<TruckGoodsOrderTakerBean> beanList = new ArrayList<TruckGoodsOrderTakerBean>();
		List<TruckGoodsOrderTakerEntity> entityList = new ArrayList<TruckGoodsOrderTakerEntity>();
		entityList = truckGoodsOrderDao.getTruckGoodsOrderTakerById(id);
		for(int i=0;i<entityList.size(); i++){
			TruckGoodsOrderTakerBean truckGoodsOrderTakerBean = (TruckGoodsOrderTakerBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckGoodsOrderTakerBean());
			beanList.add(truckGoodsOrderTakerBean);
		}
		return beanList;
	}
	
	/**
	 * 根据ID获得预录车辆详细信息
	 * @param id
	 * @return
	 */
	public  List<TruckGoodsOrderDetailBean> getTruckGoodsOrderDetailById(String id){
		List<TruckGoodsOrderDetailBean> beanList = new ArrayList<TruckGoodsOrderDetailBean>();
		List<TruckGoodsOrderDetailEntity> entityList = new ArrayList<TruckGoodsOrderDetailEntity>();
		entityList = truckGoodsOrderDao.getTruckGoodsOrderDetailById(id);
		for(int i=0;i<entityList.size(); i++){
			TruckGoodsOrderDetailBean truckGoodsOrderDetailBean = (TruckGoodsOrderDetailBean) ConvertService.convertEntityToBean(entityList.get(i), new TruckGoodsOrderDetailBean());
			beanList.add(truckGoodsOrderDetailBean);
		}
		return beanList;
	}
	 
	/**
	 * 根据ID删除预录信息
	 * @param id
	 * @return
	 */
	public  int deleteTruckGoodsOrderTaker(String id){
		int i = -1;
		try{
			i = truckGoodsOrderDao.deleteTruckGoodsOrderTaker(id);
		}catch(Exception e){
			i=-1;
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 根据ID删除预录信息
	 * @param reportId
	 * @return
	 */
	public  int deleteTruckGoodsOrderDetail(String reportId){
		int i = -1;
		try{
			i = truckGoodsOrderDao.deleteTruckGoodsOrderDetail(reportId);
		}catch(Exception e){
			i=-1;
			e.printStackTrace();
		}
		
		return i;
	}
	
	/**
	 * 更新预录信息
	 * @param updateInfo
	 */
	public  int updateTruckGoodsOrderTaker(TruckGoodsOrderTakerBean updateInfo){
		TruckGoodsOrderTakerEntity truckGoodsOrderTakerEntity = (TruckGoodsOrderTakerEntity) ConvertService.convertEntityToBean(updateInfo, new TruckGoodsOrderTakerEntity());
		truckGoodsOrderTakerEntity.setEditDate(ConvertService.getDate());
		truckGoodsOrderTakerEntity.setEditTime(ConvertService.getTime());
		int updateCount =  truckGoodsOrderDao.updateTruckGoodsOrderTaker(truckGoodsOrderTakerEntity);
		return updateCount;
	}
	
	/**
	 * 更新预录详细信息
	 * @param updateInfo
	 */
	public  void updateTruckGoodsOrderDetail(TruckGoodsOrderDetailBean updateInfo){
		TruckGoodsOrderDetailEntity truckGoodsOrderDetailEntity = (TruckGoodsOrderDetailEntity) ConvertService.convertEntityToBean(updateInfo, new TruckGoodsOrderDetailEntity());
		truckGoodsOrderDetailEntity.setEditDate(ConvertService.getDate());
		truckGoodsOrderDetailEntity.setEditTime(ConvertService.getTime());
		truckGoodsOrderDao.updateTruckGoodsOrderDetail(truckGoodsOrderDetailEntity);
	}
	
	/**
	 * @param id
	 * @param orderStatus
	 * @return
	 */
	public int updateTruckGoodsOrderStatus(int id, int orderStatus){
		TruckGoodsOrderTakerEntity entity = new TruckGoodsOrderTakerEntity();
		entity.setId(id);
		entity.setOrderStatus(orderStatus);
		entity.setEditDate(ConvertService.getDate());
		entity.setEditTime(ConvertService.getTime());
		int updateCount = 0;
		updateCount = truckGoodsOrderDao.updateTruckGoodsOrderStatus(entity);
		return updateCount;
	};

}
