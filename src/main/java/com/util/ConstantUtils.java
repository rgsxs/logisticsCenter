package com.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class ConstantUtils {
	public static final BigDecimal defaultDecimal=new BigDecimal("0");
	/**
	 * yyyyMMdd
	 */
	public static final String dateFormat1="yyyyMMdd";
	/**
	 * yyyy-MM-dd
	 */
	public static final String dateFormat2="yyyy-MM-dd";
	
	/**
	 * yyyy-MM-dd
	 */
	public static final String PROPERTIES_PATH="";
	
	
	/**
	 * 设置系统路径
	 */
	public static String propertyPath;
	
	public static String servicePath;
	
	private static String ROOT_PATH;
	
	public static String dateRegex = "^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}?";
	
	/**
	 * 启用并且非显示状态的费用类型
	 */
	public static String FEE_TYPE_COLUMNS;
	
	/**
	 * 启用并且非显示状态的费用类型名称
	 */
	public static String FEE_TYPE_NAMES;
	
	/**
     * 设置系统访问根目录 （为 ServletConfig config.getRealPath("/") + File.separatorChar）
     * 由 InitServer 获取后设置
     *
     * @param value 系统访问根目录
     */
    public static void setRootPath(String value) {
        ROOT_PATH = value;
    }
    
    /**
     * 获取系统访问根目录
     *
     * @return String 系统访问根目录
     */
    public static String getRootPath() {
        return ROOT_PATH;
    }
    
	public static String getFeeTypeColumns() {
		return FEE_TYPE_COLUMNS;
	}

	public static void setFeeTypeColumns(String FeeTypeColumns) {
		FEE_TYPE_COLUMNS = FeeTypeColumns;
	}
	
	public static String getFeeTypeNames() {
		return FEE_TYPE_NAMES;
	}

	public static void setFeeTypeNames(String FeeTypeNames) {
		FEE_TYPE_NAMES = FeeTypeNames;
	}

	/**
     * 获取系统属性文档根目录 ，为系统访问根目录下的 prop 目录 pathtoroot/prop/
     *
     * @return String 系统属性文档根目录
     */
    public static String getPropertyPath() {
		if(propertyPath==null||"".equals(propertyPath)||propertyPath.contains("null")){
		 File f = new File(ROOT_PATH + "WEB-INF" + File.separatorChar + "prop");
			if (f.exists())
				propertyPath = ROOT_PATH + "WEB-INF" + File.separatorChar + "prop" + File.separatorChar;
			else
				propertyPath = ROOT_PATH  + "prop" + File.separatorChar;
		}
		return  propertyPath;    
    }
    
    /**
     * 获取系统属性文档根目录 ，为系统访问根目录下的 prop 目录 pathtoroot/prop/
     *
     * @return String 系统属性文档根目录
     */
    public static String getServicePath() {
		if(servicePath==null||"".equals(servicePath)||servicePath.contains("null")){
		 File f = new File(ROOT_PATH + "WEB-INF" + File.separatorChar + "service");
			if (f.exists())
				servicePath = ROOT_PATH + "WEB-INF" + File.separatorChar + "service" + File.separatorChar;
			else
				servicePath = ROOT_PATH  + "service" + File.separatorChar;
		}
		return  servicePath;
    }
}
