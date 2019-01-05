package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.javabean.CompulsoryBean;
import com.logisticscenter.mapper.CompulsoryDao;
import com.logisticscenter.model.CompulsoryEntity;
import com.logisticscenter.service.CompulsoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CompulsoryServiceImpl implements CompulsoryService {

	@Autowired
	CompulsoryDao compulsoryDao;

	@Override
	public int deleteCompulsory(String id) {
		int count = compulsoryDao.deleteCompulsory(id);
		return count;
	}

	@Override
	public CompulsoryBean getCompulsory(String id) {
		return (CompulsoryBean) ConvertService.convertEntityToBean(compulsoryDao.getCompulsory(id), new CompulsoryBean());
	}

	/* (non-Javadoc)
	 * @see com.service.CompulsoryService#getCompulsory(com.javabean.CompulsoryBean)
	 */
	@Override
	public List<CompulsoryBean> getCompulsory(CompulsoryBean selectInfo) {
		List<CompulsoryEntity> entityList = new ArrayList<CompulsoryEntity>();
		CompulsoryEntity CompulsoryE = (CompulsoryEntity)ConvertService.convertBeanToEntity(selectInfo, new CompulsoryEntity());
		List<CompulsoryBean> beanList = new ArrayList<CompulsoryBean>();
		int pageSize =Integer.parseInt(CompulsoryE.getPageSize());
		int currentPage =Integer.parseInt(CompulsoryE.getCurrentPage());
		currentPage = (currentPage -1)*pageSize;
		CompulsoryE.setCurrentPage(currentPage+"");
		entityList = compulsoryDao.getCompulsory(CompulsoryE);
		for(int i=0;i<entityList.size(); i++){
			CompulsoryBean compulsoryBean = (CompulsoryBean) ConvertService.convertEntityToBean(entityList.get(i), new CompulsoryBean());
			beanList.add(compulsoryBean);
		}
		return beanList;
	}
	
	/* (non-Javadoc)
	 * @see com.service.CompulsoryService#getCompulsory(com.javabean.CompulsoryBean)
	 */
	@Override
	public String getCompulsoryCount(CompulsoryBean selectInfo) {
		String count = "";
		try{
			List<CompulsoryEntity> entityList = new ArrayList<CompulsoryEntity>();
			CompulsoryEntity CompulsoryE = (CompulsoryEntity)ConvertService.convertBeanToEntity(selectInfo, new CompulsoryEntity());
			List<CompulsoryBean> beanList = new ArrayList<CompulsoryBean>();
			count = compulsoryDao.getCompulsoryCount(CompulsoryE);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public void updateCompulsory(CompulsoryBean updateInfo) {
		CompulsoryEntity CompulsoryE = (CompulsoryEntity) ConvertService.convertBeanToEntity(updateInfo, new CompulsoryEntity());
		CompulsoryE.setEditDate(ConvertService.getDate());
		CompulsoryE.setEditTime(ConvertService.getTime());
		compulsoryDao.updateCompulsory(CompulsoryE);
		
	}

	/* (non-Javadoc)
	 * @see com.service.CompulsoryService#insertCompulsory(com.javabean.CompulsoryBean)
	 */
	@Override
	public int insertCompulsory(CompulsoryBean insertInfo) {
		//插入费用类型
		CompulsoryEntity CompulsoryE = (CompulsoryEntity) ConvertService.convertBeanToEntity(insertInfo, new CompulsoryEntity());
		CompulsoryE.setCreateDate(ConvertService.getDate());
		CompulsoryE.setCreateTime(ConvertService.getTime());
		CompulsoryE.setEditDate(ConvertService.getDate());
		CompulsoryE.setEditTime(ConvertService.getTime());
		int statusFlg = compulsoryDao.insertCompulsory(CompulsoryE);
		// TODO Auto-generated method stub
		return statusFlg;
	}
	
	/* (non-Javadoc)
	 * @see com.service.CompulsoryService#getWarnCompulsory(int)
	 */
	@Override
	public List<CompulsoryBean> getWarnCompulsory(String days) {
		List<CompulsoryBean> beanList = new ArrayList<CompulsoryBean>();
		List<CompulsoryEntity> entityList = new ArrayList<CompulsoryEntity>();
		entityList = compulsoryDao.getWarnCompulsory(days);
		for(int i=0;i<entityList.size(); i++){
			CompulsoryBean commercialBean = (CompulsoryBean) ConvertService.convertEntityToBean(entityList.get(i), new CompulsoryBean());
			beanList.add(commercialBean);
		}
		return beanList;
	}

}
