package com.logisticscenter.mapper;

import com.logisticscenter.model.ImageFileEntity;

import java.util.List;


/**
 * @author 卜
 *
 */
public interface ImageFileDao {

	/**
	 * @param id
	 * @return
	 */
	public abstract List<ImageFileEntity> getImageFileBy(String id);
	
	/**
	 * @param imageFileEntity
	 * @return
	 */
	public abstract int insertImageFile(ImageFileEntity imageFileEntity);
	
}
