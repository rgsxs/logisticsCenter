package com.logisticscenter.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.common.ConvertService;
import com.entity.ImageFileEntity;
import com.javabean.ImageFileBean;
import com.logisticscenter.mapper.ImageFileDao;
import com.logisticscenter.service.ImageFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ImageFileServiceImpl implements ImageFileService {

	@Autowired
	ImageFileDao imageFileDao;

	/* (non-Javadoc)
	 * @see com.service.ImageFileService#getImageFileBy(java.lang.String)
	 */
	@Override
	public List<ImageFileBean> getImageFileBy(String id) {
		List<ImageFileEntity> entityList = new ArrayList<ImageFileEntity>();
		List<ImageFileBean> beanList = new ArrayList<ImageFileBean>();
		entityList = imageFileDao.getImageFileBy(id);
		for(int i=0;i<entityList.size(); i++){
			ImageFileBean imageFileBean = (ImageFileBean) ConvertService.convertEntityToBean(entityList.get(i), new ImageFileBean());
			beanList.add(imageFileBean);
		}
		return beanList;
	}

	/* (non-Javadoc)
	 * @see com.service.ImageFileService#insertImageFile(com.javabean.ImageFileBean)
	 */
	@Override
	public int insertImageFile(ImageFileBean insertInfo) {
		ImageFileEntity imageFileEntity = (ImageFileEntity) ConvertService.convertEntityToBean(insertInfo, new ImageFileEntity());
		imageFileEntity.setCreateDate(ConvertService.getDate());
		imageFileEntity.setCreateTime(ConvertService.getTime());
		int count = 0;
		count = imageFileDao.insertImageFile(imageFileEntity);
		return count;
	}

}
