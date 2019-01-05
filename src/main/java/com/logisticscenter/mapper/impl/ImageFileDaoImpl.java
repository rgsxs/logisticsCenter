package com.logisticscenter.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.logisticscenter.mapper.ImageFileDao;
import com.logisticscenter.model.ImageFileEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Repository
public class ImageFileDaoImpl {


//	/**
//	 * @param id
//	 * @return
//	 */
//
//	@Override
//	public List<ImageFileEntity> getImageFileBy(String id) {
//		List<ImageFileEntity> imageFileEntityList = new ArrayList<ImageFileEntity>();
//		String ids = id;
//		try{
//			imageFileEntityList = getSqlMapClientTemplate().queryForList("ImageFile.getImageFileBy",ids);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return imageFileEntityList;
//
//	}
//
//	/* (non-Javadoc)
//	 * @see com.dao.ImageFileDao#insertImageFile(com.entity.ImageFileEntity)
//	 */
//	@Override
//	public int insertImageFile(ImageFileEntity imageFileEntity) {
//		int count = 0;
//		try{
//			count = (Integer)getSqlMapClientTemplate().insert("ImageFile.insertImageFile",imageFileEntity);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return count;
//	}
	
}
