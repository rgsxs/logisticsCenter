package com.general;

import com.common.ConvertService;
import com.util.ConstantUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 系统升级信息
 */
public class SysUpgradeCominfo extends BaseBean {
    private OrderProperties prop = new OrderProperties();
    private static String UPGRADEPROPFILE = ConstantUtils.getPropertyPath()+"Upgrade.properties";
    public static String UPGRADESTATUS = "STATUS"; //升级状态
    public static String UPGRADELOGPATH = "ERRORLOG";//升级错误日志
    public static String UPGRADEPAGE = "PAGESTATUS";
    public static String OPERATIONDATE = "OPERATIONDATE";
    private int UpgradeStatus=0;
    private String UpgradeLogPath="";
    private int pagestatus = 0;
    private int errorline = 0;
    private String errorfile = "";
    private String opdate = "";
    public static boolean continueFlag = false;
    //filecheckfilter使用  防止每次登录读取文件占用线程
    public static int pStatus=999;
    public static int status=999;
    public static int upgradetype=999;
    

    public SysUpgradeCominfo() {
    }
    /**
     * 更改升级属性文件
     * @param upgreadStatus 0:正常   1:升级过程中执行脚本错误    2:正在升级(或异常中止)   3:程序异常错误
     * @param logpath 错误日志路径
     * @param pagestatus 0：未进行升级跳包检查  1：正常升级未跳包 2：跳包 3：脚本执行完成  
     */
    public void ChangeProp(String upgreadStatus,String logpath,int pagestatus, int errorline, String errorfile, String opdate) {
        try{

            UpgradeStatus=ConvertService.getIntValue(upgreadStatus);
            UpgradeLogPath=logpath;
            
            prop = new OrderProperties();
            
            prop.load(UPGRADEPROPFILE);
            prop.put("STATUS",upgreadStatus);
            prop.put("PAGESTATUS",""+pagestatus);
            prop.put("ERRORLOG",logpath);
            if(errorline != 0) {
                prop.put("ERRORFILE",errorfile);
                prop.put("ERRORLINE",""+errorline);
            } else {
                prop.remove("ERRORFILE");
                prop.remove("ERRORLINE");
            }
            
            if(opdate != null && !"".equals(opdate)) {
            	prop.put("OPERATIONDATE",opdate);
            } else {
            	prop.remove("OPERATIONDATE");
            }
            
            prop.store(prop,UPGRADEPROPFILE);
        	//filecheckfilter使用  防止每次登录读取文件占用线程
        	pStatus = pagestatus;
        	status = ConvertService.getIntValue(upgreadStatus);
        	
        }catch(Exception e) {
          writeLog(e) ;
        }
    }

    /**
     * 获得属性文件中状态和错误日志路径
     *
     */
    private void getProp(){
        FileInputStream fis = null;
        try {
                prop = new OrderProperties();
                
                prop.load(UPGRADEPROPFILE);
                
                UpgradeStatus=ConvertService.getIntValue(prop.getProperty(UPGRADESTATUS),3);
                UpgradeLogPath=ConvertService.null2String(prop.getProperty(UPGRADELOGPATH));
                errorline = ConvertService.getIntValue(prop.getProperty("ERRORLINE"),0);
                errorfile = ConvertService.null2String(prop.getProperty("ERRORFILE"));
                pagestatus = ConvertService.getIntValue(prop.getProperty(UPGRADEPAGE),0);//未跳包的状态
                opdate = ConvertService.null2String(prop.getProperty(OPERATIONDATE));//
                
            	//filecheckfilter使用  防止每次登录读取文件占用线程
            	pStatus = pagestatus;
            	status = UpgradeStatus;
            	
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

    /**
     * 获得升级状态    0:正常   1:升级过程中执行脚本错误    2:正在升级(或异常中止)   3:程序异常错误
     * @return 升级状态
     */
    public int getUpgreadStatus2() {
        getProp();
        return UpgradeStatus;
    }
    /**
     * 屏蔽之前的方法 使得Login.jsp页面不受控制
     */
    public int getUpgreadStatus() {
        
        return 0;
    }
    /**
     * 获得升级错误日志路径
     * @return 错误日志路径
     */
    public String getUpgreadLogPath() {
        getProp();
        return UpgradeLogPath;
    }
    
    public int getErrorLine(){
    	 getProp();
         return errorline;
    }
    public String getErrorFile(){
   	 	getProp();
        return errorfile;
   }
    
   public int getPagestatus() {
	   getProp();
	   return pagestatus;
   }
   
    public String getOpdate() {
    	getProp();
	   return opdate;
	}
    public void setOpdate(String opdate) {
    	getProp();
		this.opdate = opdate;
    }
   
   public class OrderProperties {



		/** Keys*/
		private List<String> keys = new ArrayList<String>();

		/** ValueMap*/
		private Map<String, String> valueMap = new HashMap<String, String>();

		public String getProperty(String key) {
			return valueMap.get(key);
		}
		public void put(String key, String value)
		{
			if (keys.contains(key))
			{
				keys.remove(key);
			}
			keys.add((String)key);
			valueMap.put((String)key, (String)value);
		}
		public boolean containsKey(String key)
		{
			return keys.contains(key);
		}
		public String get(String key)
		{
			return ConvertService.null2String(valueMap.get(key));
		}
		public void remove(String key)
		{
			keys.remove(key);
			valueMap.remove(key);
		}
		public List<String> getKeys(String keyPattern) {
			Pattern pat = Pattern.compile(keyPattern);
			List<String> kl = new ArrayList<String>();
			for (String k : keys) {
				if (pat.matcher(k).matches()) {
					kl.add(k);
				}
			}
			return kl;
		}

		/** 
		 * 加载Properties文件 
		 * @param filepath
		 */
		public synchronized void load(String filepath){
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(filepath);

		        InputStreamReader insreader = new InputStreamReader(fis, "GBK");  
		        BufferedReader bin = new BufferedReader(insreader);  
		        List<String> lines = new ArrayList<String>();  
		        String line;  
		        while ((line = bin.readLine()) != null) {  
		            lines.add(line);  
		        }  
		        bin.close();  
		        insreader.close();  
		        
				// parse key-value  
				for (String l : lines) {
					if (l.trim().startsWith("#")) {
						keys.add(l);
					} else {
						if (l.indexOf("=") > -1) {
							String k = l.substring(0, l.indexOf("=")).trim();
							String v = l.substring(l.indexOf("=") + 1).trim();
							keys.add(k);
							valueMap.put(k, v);
						} else {
							keys.add(l);
						}
					}
				}
			} catch (Exception e) {

			}
		}
		
		public synchronized void store(OrderProperties props,String filepath)
		{
			BufferedWriter out = null;
			try
			{
				if(null==props)
				{
					return;
				}
				List em = props.keys;
				File fout = new File(filepath);
				out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fout)));
				for(int i = 0;i<em.size();i++)
				{
					String tempname = ConvertService.null2String((String)em.get(i));
					String tempstring = tempname;
					if(!"".equals(tempname)&&!tempname.startsWith("#"))
						tempstring += "=" + ConvertService.null2String((String)props.valueMap.get(tempname));
					out.write(tempstring);
					out.newLine();
				}
				out.flush();
			}
			catch (Exception e)
			{
				//e.printStackTrace();
			}
			finally
			{
				if (out != null)
				{
					try
					{
						out.close();
					}
					catch (IOException e)
					{
						
					}
				}
			}
		}
		public List<String> getKeys() {
			return keys;
		}

		@Override
		public String toString() {
			return valueMap.toString();
		}
   }
}
