package com.logisticscenter.mapper;

import java.util.List;

import com.entity.ImageFileEntity;

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
