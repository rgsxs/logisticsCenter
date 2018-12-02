package com.logisticscenter.service;

import java.util.List;

import com.javabean.ImageFileBean;

public interface ImageFileService {
	
	
	/**
	 * @param selectFileIds
	 * @return
	 */
	public abstract List<ImageFileBean> getImageFileBy(String selectFileIds);
	
	/**
	 * @param insertInfo
	 * @return
	 */
	public abstract int insertImageFile(ImageFileBean insertInfo);
	
}
