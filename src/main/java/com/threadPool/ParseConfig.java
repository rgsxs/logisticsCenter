package com.threadPool;

/**
 * 线程配置
 */

import com.common.ConvertService;
import com.util.ConstantUtils;

import java.io.*;
import java.util.*;


public class ParseConfig {
    private static String fileName = ConstantUtils.getPropertyPath()+"ThreadPool.properties";
    private static Properties prop = null;
    static ConsumeThreadPoolPara consumeThreadPoolPara = null;
    public static String MaxPools = "MaxPools"; //最大线程
    public static String CheckThreadPeriod = "CheckThreadPeriod";//每隔几分钟检查

    public static ConsumeThreadPoolPara getConsumeThreadPoolPara(){
        if(consumeThreadPoolPara ==null){
            prop = new Properties();
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
                prop.load(fis);
                consumeThreadPoolPara = new ConsumeThreadPoolPara();
                consumeThreadPoolPara.setMaxPools(ConvertService.getIntValue(prop.getProperty(MaxPools),100));
                consumeThreadPoolPara.setCheckThreadPeriod(ConvertService.getIntValue(prop.getProperty(CheckThreadPeriod),5));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                            //do nothing
                    }
                }
            }
        }
        return consumeThreadPoolPara;
    }

}

