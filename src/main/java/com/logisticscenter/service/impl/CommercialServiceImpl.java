package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.CommercialEntity;
import com.javabean.CommercialBean;
import com.logisticscenter.mapper.CommercialDao;
import com.logisticscenter.service.CommercialService;
import org.springframework.stereotype.Component;

@Component
public class CommercialServiceImpl implements CommercialService {
	
	CommercialDao commercialDao;

	public CommercialDao getCommercialDao() {
		return commercialDao;
	}

	public void setCommercialDao(CommercialDao commercialDao) {
		this.commercialDao = commercialDao;
	}

	@Override
	public int deleteCommercial(String id) {
		int count = commercialDao.deleteCommercial(id);
		return count;
	}

	@Override
	public CommercialBean getCommercial(String id) {
		return (CommercialBean) ConvertService.convertEntityToBean(commercialDao.getCommercial(id), new CommercialBean());
	}

	/* (non-Javadoc)
	 * @see com.service.CommercialService#getCommercial(com.javabean.CommercialBean)
	 */
	@Override
	public List<CommercialBean> getCommercial(CommercialBean selectInfo) {
		List<CommercialEntity> entityList = new ArrayList<CommercialEntity>();
		CommercialEntity CommercialE = (CommercialEntity)ConvertService.convertBeanToEntity(selectInfo, new CommercialEntity());
		List<CommercialBean> beanList = new ArrayList<CommercialBean>();
		int pageSize =Integer.parseInt(CommercialE.getPageSize());
		int currentPage =Integer.parseInt(CommercialE.getCurrentPage());
		currentPage = (currentPage -1)*pageSize;
		CommercialE.setCurrentPage(currentPage+"");
		entityList = commercialDao.getCommercial(CommercialE);
		for(int i=0;i<entityList.size(); i++){
			CommercialBean commercialBean = (CommercialBean) ConvertService.convertEntityToBean(entityList.get(i), new CommercialBean());
			beanList.add(commercialBean);
		}
		return beanList;
	}
	
	/* (non-Javadoc)
	 * @see com.service.CommercialService#getCommercial(com.javabean.CommercialBean)
	 */
	@Override
	public String getCommercialCount(CommercialBean selectInfo) {
		String count = "";
		try{
			List<CommercialEntity> entityList = new ArrayList<CommercialEntity>();
			CommercialEntity CommercialE = (CommercialEntity)ConvertService.convertBeanToEntity(selectInfo, new CommercialEntity());
			List<CommercialBean> beanList = new ArrayList<CommercialBean>();
			count = commercialDao.getCommercialCount(CommercialE);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void updateCommercial(CommercialBean updateInfo) {
		CommercialEntity CommercialE = (CommercialEntity) ConvertService.convertBeanToEntity(updateInfo, new CommercialEntity());
		CommercialE.setEditDate(ConvertService.getDate());
		CommercialE.setEditTime(ConvertService.getTime());
		commercialDao.updateCommercial(CommercialE);
		
	}

	/* (non-Javadoc)
	 * @see com.service.CommercialService#insertCommercial(com.javabean.CommercialBean)
	 */
	@Override
	public int insertCommercial(CommercialBean insertInfo) {
		//插入费用类型
		CommercialEntity CommercialE = (CommercialEntity) ConvertService.convertBeanToEntity(insertInfo, new CommercialEntity());
		CommercialE.setCreateDate(ConvertService.getDate());
		CommercialE.setCreateTime(ConvertService.getTime());
		CommercialE.setEditDate(ConvertService.getDate());
		CommercialE.setEditTime(ConvertService.getTime());
		int statusFlg = commercialDao.insertCommercial(CommercialE);
		// TODO Auto-generated method stub
		return statusFlg;
	}

	/* (non-Javadoc)
	 * @see com.service.CommercialService#getWarnCommercial(int)
	 */
	@Override
	public List<CommercialBean> getWarnCommercial(String days) {
		List<CommercialBean> beanList = new ArrayList<CommercialBean>();
		List<CommercialEntity> entityList = new ArrayList<CommercialEntity>();
		entityList = commercialDao.getWarnCommercial(days);
		for(int i=0;i<entityList.size(); i++){
			CommercialBean commercialBean = (CommercialBean) ConvertService.convertEntityToBean(entityList.get(i), new CommercialBean());
			beanList.add(commercialBean);
		}
		return beanList;
	}

}
