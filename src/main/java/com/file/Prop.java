package com.file;

/**
 * Title:        hpsales
 * Description:  for hp sales system
 * Copyright:    Copyright (c) 2001
 * Company:      weaver
 * @author liuyu
 * @version 1.0
 */

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Properties;

import com.general.LogMan;
import com.util.ConstantUtils;

public class Prop {

    private static Prop instance = null;
    private static String PROP_ROOT = null; // SERVER_ROOT + prop
    private static java.util.concurrent.ConcurrentHashMap htmlfileHash = new java.util.concurrent.ConcurrentHashMap();
    private static java.util.concurrent.ConcurrentHashMap<String, Long> htmlfileTime = new java.util.concurrent.ConcurrentHashMap<String, Long>();
    private static java.util.concurrent.ConcurrentHashMap<String, Long> htmlfileTime2 = new java.util.concurrent.ConcurrentHashMap<String, Long>();
    private static final long DETA = 1000;

    private static Object lock = new Object();

    public static Prop getInstance() {

        if (instance == null)
            instance = new Prop();

        return instance;
    }

    private Prop() {
        PROP_ROOT = ConstantUtils.getPropertyPath();

    }

    /**
     * @param fname
     * @return
     */
    public static Properties loadTemplateProp2(String fname) {

        // for the timestamp
        try {
            PROP_ROOT = ConstantUtils.getPropertyPath();
            Properties prop = null;

            File f = new File(PROP_ROOT + fname + ".properties");
            if (!f.exists())
                return null;

            long ftime = f.lastModified();
            Long hftime = (Long) htmlfileTime.get(fname);

            if (hftime == null || hftime.longValue() != ftime) {

                prop = new Properties();
                InputStream is = new BufferedInputStream(new FileInputStream(f));
                prop.load(is);
                is.close();
                htmlfileHash.put(fname, prop);
                htmlfileTime.put(fname, new Long(ftime));
            }

            return (Properties) htmlfileHash.get(fname);

        } catch (Exception e) {

            LogMan log = LogMan.getInstance();
            log.writeLog("Prop.class", e);
            log.writeLog("root path is : " + PROP_ROOT);
            return null;
        }

    }

    /**
     * @param fname
     * @return
     */
    private static Properties loadProp(String fname) {
        synchronized (lock) {
            if (htmlfileHash.containsKey(fname)) {
                return (Properties) htmlfileHash.get(fname);
            } else {
                try {
                    PROP_ROOT = ConstantUtils.getPropertyPath();
                    Properties prop = null;

                    File f = new File(PROP_ROOT + fname + ".properties");
                    if (!f.exists())
                        return null;
                    prop = new Properties();
                    InputStream is = new BufferedInputStream(new FileInputStream(f));
                    prop.load(is);
                    htmlfileHash.put(fname, prop);
                    htmlfileTime.put(fname, f.lastModified());
                    htmlfileTime2.put(fname, System.currentTimeMillis());
                    is.close();
                    return prop;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogMan log = LogMan.getInstance();
                    log.writeLog("Prop.class", e);
                    log.writeLog("root path is : " + PROP_ROOT);
                    return null;
                }
            }
        }

    }

    /**
     * @param fname
     * @return
     */
    public static Properties loadTemplateProp(String fname) {

    	// 如果已经读取过一次，就直接从缓存中读取
        if (htmlfileHash.containsKey(fname)) {
            if (System.currentTimeMillis() - htmlfileTime2.get(fname) > DETA) {
                PROP_ROOT = ConstantUtils.getPropertyPath();
                File f = new File(PROP_ROOT + fname + ".properties");
                if (htmlfileTime.get(fname) == f.lastModified()) {
                    return (Properties) htmlfileHash.get(fname);
                } else {
                    htmlfileHash.remove(fname);
                    return loadProp(fname);
                }
            } else {
                return (Properties) htmlfileHash.get(fname);
            }
        } else {

            return loadProp(fname);

        }

    }

    /**
     * @param fname
     * @param key
     * @return
     */
    public static String getPropValue(String fname, String key) {

        Properties newprop = loadTemplateProp(fname);

        // if(newprop.getProperty(key) != null ) return
        // newprop.getProperty(key).trim() ;
        // else return "" ;
        if (newprop != null && newprop.getProperty(key) != null) {
            return newprop.getProperty(key).trim();
        } else {
            return "";
        }

    }
    /**
     * @param fname
     * @param key
     * @param value
     * @return
     */
    public static boolean setPropValue(String fname, String key, String value) {
        Properties newprop = loadTemplateProp(fname);
        if (newprop != null && newprop.getProperty(key) != null) {
            try {
                File oFile = new File(PROP_ROOT + fname + ".properties");
                oFile.delete();
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(oFile)));
                newprop.setProperty(key, value);
                Enumeration enumeration = newprop.propertyNames();
                String stringtemp = "";
                while (enumeration.hasMoreElements()) {
                    stringtemp = (String) enumeration.nextElement().toString();
                    stringtemp += " = " + newprop.getProperty(stringtemp);
                    
                    out.write(stringtemp);
                    out.write("\r\n");
                }
                out.flush();
                out.close();

            } catch (Exception e) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

}