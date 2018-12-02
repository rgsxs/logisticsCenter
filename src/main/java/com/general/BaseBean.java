package com.general;

import com.file.Prop;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Properties;


public class BaseBean {

	private static Prop prop = Prop.getInstance() ;
	
	public String getPropValue(String fname , String key)  {
	    return prop.getPropValue(fname , key) ;
	  }


	  public Properties LoadTemplateProp(String fname)  {
	      return prop.loadTemplateProp(fname) ;
	  }
	
	public void writeLog(Object obj) {
		writeLog(getClass().getName(),obj);
	}

	public void writeLog(String classname , Object obj)  {
		Log log= LogFactory.getLog(classname);
		if(obj instanceof Exception)
			log.error(classname ,(Exception)obj);
		else{
			log.error(obj);
		}
  }

}
