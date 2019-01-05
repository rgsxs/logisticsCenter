package com.logisticscenter.mapper;

import com.logisticscenter.model.ImageFileEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @author 卜
 *
 */
@Mapper
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
