package com.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.util.ConstantUtils;
import com.util.Utils;

public class ConvertService {
	
	public static Object convertBeanToEntity(Object obj,Object entity){
		Class beanClass = obj.getClass();
		
		System.out.println("Class:" + beanClass.getName()); 
		
		//通过默认的构造函数创建一个新的对象  
		try {

			//获得对象的所有属性  
			Field fields[] = beanClass.getDeclaredFields(); 
			
			Method m = null;
			for(int i = 0; i < fields.length; i++) {
				Field field = fields[i];
				String fieldName = field.getName();
				// 将属性的首字符大写，方便构造get，set方法
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				//获得get方法
				String getMethodName = "get" + firstLetter + fieldName.substring(1);
				//获得set方法
				String setMethodName = "set" + firstLetter + fieldName.substring(1);
				//获取属性的类型
				String type = field.getGenericType().toString();
				System.out.println(type);
				if(type.equals("class java.lang.String")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					String value = ConvertService.null2String(((String) getMethod.invoke(obj)));
					
					m = entity.getClass().getMethod(setMethodName,String.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.lang.Integer")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Integer value = Utils.getIntValue((Integer) getMethod.invoke(obj)+"");
					
					m = entity.getClass().getMethod(setMethodName,Integer.class);
					m.invoke(entity, value);
				}else if(type.equals("int")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					int value = Utils.getIntValue((Integer) getMethod.invoke(obj)+"");;
					
					m = entity.getClass().getMethod(setMethodName,int.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.math.BigDecimal")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					BigDecimal value = (BigDecimal) getMethod.invoke(obj);
					if(value == null){
						value=ConstantUtils.defaultDecimal;
					}
					m = entity.getClass().getMethod(setMethodName,BigDecimal.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.lang.Boolean")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Boolean value = (Boolean) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,Boolean.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.util.Date")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Date value = (Date) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,Date.class);
					m.invoke(entity, value);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	public static Object convertEntityToBean(Object obj,Object entity){
		Class beanClass = obj.getClass();
		
		System.out.println("Class:" + beanClass.getName()); 
		
		//通过默认的构造函数创建一个新的对象  
		try {

			//获得对象的所有属性  
			Field fields[] = beanClass.getDeclaredFields(); 
			
			Method m = null;
			for(int i = 0; i < fields.length; i++) {  
				Field field = fields[i];
				String fieldName = field.getName();
				// 将属性的首字符大写，方便构造get，set方法
				String firstLetter = fieldName.substring(0, 1).toUpperCase();
				//获得get方法
				String getMethodName = "get" + firstLetter + fieldName.substring(1);
				//获得set方法
				String setMethodName = "set" + firstLetter + fieldName.substring(1);
				//获取属性的类型
				String type = field.getGenericType().toString();
				System.out.println(type);
				if(type.equals("class java.lang.String")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					String value = ConvertService.null2String((String) getMethod.invoke(obj));
					
					m = entity.getClass().getMethod(setMethodName,String.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.lang.Integer")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Integer value = (Integer) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,Integer.class);
					m.invoke(entity, value);
				}else if(type.equals("int")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Object value = getMethod.invoke(obj);
					if(value == null){
						value=ConstantUtils.defaultDecimal;
					}
					m = entity.getClass().getMethod(setMethodName,int.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.math.BigDecimal")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					BigDecimal value = (BigDecimal) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,BigDecimal.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.lang.Boolean")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Boolean value = (Boolean) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,Boolean.class);
					m.invoke(entity, value);
				}else if(type.equals("class java.util.Date")){
					// 获得和属性对应的get方法
					Method getMethod = beanClass.getMethod(getMethodName,new Class[] {});
					// 调用getter方法获取属性值
					Date value = (Date) getMethod.invoke(obj);
					
					m = entity.getClass().getMethod(setMethodName,Date.class);
					m.invoke(entity, value);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	/**
	 * @return YYYYMMDD
	 */
	public static String getDate(String format){
		String dateStr = "";
		try{
			SimpleDateFormat sf1 = new SimpleDateFormat(format);
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			dateStr = sf1.format(date);
		}catch(Exception e){
			
		}
		return dateStr;
	}
	
	/**
	 * @return YYYY-MM-DD
	 */
	public static String getDate(){
		Calendar cal = Calendar.getInstance();
		String currentdate = ConvertService.add0(cal.get(Calendar.YEAR), 4) + "-" +
		ConvertService.add0(cal.get(Calendar.MONTH) + 1, 2) + "-" +
		ConvertService.add0(cal.get(Calendar.DAY_OF_MONTH), 2) ;
		return currentdate;
	}
	
	/**
	 * @return HH:MM
	 */
	public static String getTime(){
		Calendar cal = Calendar.getInstance();
		String currenttime = ConvertService.add0(cal.get(Calendar.HOUR_OF_DAY), 2) + ":" +
		ConvertService.add0(cal.get(Calendar.MINUTE), 2);
		return currenttime;
		
	}
	
	/**
	 * @param days
	 * @return
	 */
	public static String getDate(int days){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, days);
		String currentdate = ConvertService.add0(cal.get(Calendar.YEAR), 4) + "-" +
		ConvertService.add0(cal.get(Calendar.MONTH) + 1, 2) + "-" +
		ConvertService.add0(cal.get(Calendar.DAY_OF_MONTH), 2) ;
		return currentdate;
		
	}
	
	public static String add0(int paramInt1, int len)
	  {
	    long l = (long) Math.pow(10.0D, len);
	    return String.valueOf(l + paramInt1).substring(1);
	  }
	
	public static ArrayList arrayToArrayList(Object aobj[])
	{
		ArrayList arraylist = new ArrayList();
		if (aobj == null)
			return arraylist;
		for (int i = 0; i < aobj.length; i++)
			arraylist.add(aobj[i]);

		return arraylist;
	}
	
	/**
	 * @param aobj 数组
	 * @param msg 拼接字符串
	 * @return obj+msg
	 */
	public static ArrayList arrayToArrayList(Object aobj[],String msg)
	{
		ArrayList arraylist = new ArrayList();
		if (aobj == null)
			return arraylist;
		for (int i = 0; i < aobj.length; i++)
			arraylist.add(msg + aobj[i]);

		return arraylist;
	}
	
	/**
	 * @param aobj 数组
	 * @param msg 拼接字符串
	 * @return msg+obj
	 */
	public static String arrayToString(Object aobj[],String msg)
	{
		String str = "";
		if (aobj == null)
			return str;
		for (int i = 0; i < aobj.length; i++)
			str += str.equals("")?msg+aobj[i]:","+msg+aobj[i];

		return str;
	}
	
	/**
	 * @param s
	 * @param i
	 * @return
	 */
	public static int getIntValue(String s, int i)
	{
		try{
			return Integer.parseInt(s);
		}catch(Exception e){
			return i;
		}
	}
	
	public static int getIntValue(String s)
	{
		try{
			return Integer.parseInt(s);
		}catch(Exception e){
			return -1;
		}
	}
	
	public static BigDecimal getDecimalValue(String s, BigDecimal i)
	{
		try{
			BigDecimal bd=new BigDecimal(s);
			return bd;
		}catch(Exception e){
			return i;
		}
	}
	
	public static String null2String(String s)
	{
		return s != null ? s : "";
	}
	
	public static String null2String(String s, String def)
	{
		return s != null ? s : def;
	}
	
	public static String getWarn(String s, String msg)
	{
		try{
			if("".equals(s) && s!=null){
				return s;
			}else{
				return msg;
			}
		}catch(Exception e){
			return msg;
		}
	}
	
	/**
	 * @param sou
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String StringReplace(String sou, String s1, String s2) {
        sou = null2String(sou);
        s1 = null2String(s1);
        s2 = null2String(s2);
        try{
            sou = sou.replace(s1, s2);
        }catch(Exception e){
        }
        return sou; 
    }
	
	
	public static float getFloatValue(String s)
	{
		return getFloatValue(s, -1F);
	}

	public static float getFloatValue(String s, float f)
	{
		if(s==null || s.equals("")){
			return 0f;
		}
		return Float.parseFloat(s);
	}

	public static double getDoubleValue(String s)
	{
		return getDoubleValue(s, -1D);
	}

	public static double getDoubleValue(String s, double d)
	{
		return Double.parseDouble(s);
	}
	
	public static String getPointValue(String s)
	{
		return getPointValue(s, 2);
	}
	
	public static String getPointValue(String s, int i)
	{
		return getPointValue(s, 2, "-1");
	}
	
	public static String getPointValue(String s, int i, String s1)
	{
		if(s.equals("") || s==null || s.equals("null")){
			return "0.00";
		}
		String s2;
		Double.parseDouble(s);
		s2 = s;
		if (s.indexOf("E") != -1)
			s2 = getfloatToString(s);
		if (s2.indexOf(".") == -1)
		{
			s2 = (new StringBuilder()).append(s2).append(".").toString();
			for (int j = 0; j < i; j++)
				s2 = (new StringBuilder()).append(s2).append("0").toString();

		} else
		if (s2.length() - s2.lastIndexOf(".") <= i)
		{
			for (int k = 0; k < (i - s2.length()) + s2.lastIndexOf(".") + 1; k++)
				s2 = (new StringBuilder()).append(s2).append("0").toString();

		} else
		{
			s2 = s2.substring(0, s2.lastIndexOf(".") + i + 1);
		}
		return s2;
	}
	
	public static String getfloatToString(String s)
	{
		boolean flag = false;
		if (s.indexOf("-") != -1)
		{
			flag = true;
			s = s.substring(1, s.length());
		}
		int i = s.indexOf("E");
		if (i == -1)
			return s;
		int j = Integer.parseInt(s.substring(i + 1, s.length()));
		s = s.substring(0, i);
		i = s.indexOf(".");
		s = (new StringBuilder()).append(s.substring(0, i)).append(s.substring(i + 1, s.length())).toString();
		String s1 = s;
		if (s.length() <= j)
		{
			for (int k = 0; k < (j - s.length()) + 1; k++)
				s1 = (new StringBuilder()).append(s1).append("0").toString();

		} else
		{
			s1 = (new StringBuilder()).append(s1.substring(0, j + 1)).append(".").append(s1.substring(j + 1)).append("0").toString();
		}
		if (flag)
			s1 = (new StringBuilder()).append("-").append(s1).toString();
		return s1;
	}

	public static String getIntValues(String s)
	{
		String s1 = s;
		if (s.indexOf(".") == -1)
			s1 = s;
		else
			s1 = s.substring(0, s.indexOf("."));
		return s1;
	}
	
	public static void main(String[] args) throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		System.out.println(getDate(5));;
	}

}
