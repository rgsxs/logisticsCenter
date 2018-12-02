package com.general;

/**
 * Title:        hpsales
 * Description:  for hp sales system
 * Copyright:    Copyright (c) 2001
 * Company:      weaver
 * @author liuyu
 * @version 1.0
 */


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogMan {

    private static LogMan instance = null;


    public static synchronized LogMan getInstance() {
      if (instance == null) {
        instance = new LogMan();
      }
      return instance;
    }


    private LogMan() {

    }
    
    /**
     * @param obj
     */
    public void writeLog(Object obj)   {
        writeLog("NunClass" , obj)  ;
    }

    /**
     * @param className
     * @param obj
     */
    public void writeLog(String className, Object obj)  {
         Log log= LogFactory.getLog(className);
         log.error(obj);
      }

}