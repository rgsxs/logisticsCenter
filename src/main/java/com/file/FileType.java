package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.general.BaseBean;



public class FileType {
    
    public final static Map<String, String> FILE_TYPE_MAP = new ConcurrentHashMap<String, String>();     
    
    public final static List<String> FILE_TYPE_LIST = new CopyOnWriteArrayList<String>();
    
    private FileType(){}     
    static{     
        getAllFileType(); //初始化文件类型信息     
    }     
         
    /**   
     * Discription:[getAllFileType,常见文件头信息] 
     */     
    private static void getAllFileType()     
    {     
        FILE_TYPE_MAP.put("ffd8ffe000104a464946", ".jpg"); //JPEG (jpg)
        FILE_TYPE_LIST.add(".jpg");
        FILE_TYPE_MAP.put("00000100", ".ico"); //JPEG (jpg)
        FILE_TYPE_LIST.add(".ico");
        FILE_TYPE_MAP.put("FFD8FF", ".jpg"); //JPEG (jpg)   
        FILE_TYPE_MAP.put("89504e470d0a1a0a0000", ".png"); //PNG (png)   
        FILE_TYPE_MAP.put("89504E47", ".png"); //PNG (png)   
        FILE_TYPE_LIST.add(".png");
        FILE_TYPE_MAP.put("47494638396126026f01", ".gif"); //GIF (gif)    47494638396130026 
        FILE_TYPE_LIST.add(".gif");
        FILE_TYPE_MAP.put("47494638396130026e01", ".gif"); //GIF (gif)
        FILE_TYPE_MAP.put("47494638", ".gif"); //GIF (gif)
        FILE_TYPE_MAP.put("49492A00", ".tif"); //TIFF (tif)  
        FILE_TYPE_MAP.put("4D4D002A", ".tif"); //TIFF (tif)   
        FILE_TYPE_LIST.add(".tif");
        FILE_TYPE_MAP.put("424D", ".bmp"); //16色位图(bmp)     
        FILE_TYPE_MAP.put("424d8240090000000000", ".bmp"); //24位位图(bmp)     
        FILE_TYPE_MAP.put("424d8e1b030000000000", ".bmp"); //256色位图(bmp) 
        FILE_TYPE_MAP.put("424d3611080000000000", ".bmp"); //256色位图(bmp)  
        FILE_TYPE_LIST.add(".bmp");
        FILE_TYPE_MAP.put("41433130", ".dwg"); //CAD (dwg)    
        FILE_TYPE_LIST.add(".dwg");
        FILE_TYPE_MAP.put("7b5c727466315c616e73", ".rtf"); //Rich Text Format (rtf)     
        FILE_TYPE_LIST.add(".rtf");
        FILE_TYPE_MAP.put("38425053000100000000", ".psd"); //Photoshop (psd)     
        FILE_TYPE_LIST.add(".psd");
        FILE_TYPE_MAP.put("46726f6d3a203d3f6762", ".eml"); //Email [Outlook Express 6] (eml)       
        FILE_TYPE_LIST.add(".eml");
        FILE_TYPE_MAP.put("D0CF11E0", "doc"); //MS Excel 注意：word、msi 和 excel的文件头一样     
        FILE_TYPE_LIST.add(".doc");
        FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", ".vsd"); //Visio 绘图     
        FILE_TYPE_LIST.add(".vsd");
        FILE_TYPE_MAP.put("5374616E64617264204A", ".mdb"); //MS Access (mdb)     
        FILE_TYPE_LIST.add(".mdb");
        FILE_TYPE_MAP.put("252150532D41646F6265", ".ps");     
        FILE_TYPE_LIST.add(".ps");
        FILE_TYPE_MAP.put("255044462d312e350d0a", ".pdf"); //Adobe Acrobat (pdf)   
        FILE_TYPE_LIST.add(".pdf");
        FILE_TYPE_MAP.put("2E524D46", ".rmvb"); //rmvb/rm相同  
        FILE_TYPE_LIST.add(".rmvb");
        FILE_TYPE_MAP.put("464c56", ".flv"); //flv与f4v相同  
        FILE_TYPE_LIST.add(".flv");
        FILE_TYPE_MAP.put("00000018667479706d70", ".mp4"); 
        FILE_TYPE_MAP.put("00000020667479706d70", ".mp4"); 
        FILE_TYPE_LIST.add(".mp4");
        FILE_TYPE_MAP.put("494433", ".mp3"); 
        FILE_TYPE_LIST.add(".mp3");
        FILE_TYPE_MAP.put("435753", ".swf");
        FILE_TYPE_LIST.add(".swf");
        FILE_TYPE_MAP.put("000001ba210001000180", ".mpg"); //   
        FILE_TYPE_LIST.add(".mpg");
        FILE_TYPE_MAP.put("3026b2758e66cf11a6d9", ".wmv"); //wmv与asf相同    
        FILE_TYPE_LIST.add(".wmv");
        FILE_TYPE_MAP.put("57415645", ".wav"); //Wave (wav) 
        FILE_TYPE_LIST.add(".wav");
        FILE_TYPE_MAP.put("41564920", ".avi");  
        FILE_TYPE_LIST.add(".avi");
        FILE_TYPE_MAP.put("4D546864", ".mid"); //MIDI (mid)   
        FILE_TYPE_LIST.add(".mid");
        FILE_TYPE_MAP.put("504B0304", ".zip");    
        FILE_TYPE_LIST.add(".zip");
        FILE_TYPE_MAP.put("52617221", ".rar");   
        FILE_TYPE_LIST.add(".rar");
        FILE_TYPE_MAP.put("235468697320636f6e66", ".ini");   
        FILE_TYPE_LIST.add(".ini");
        FILE_TYPE_MAP.put("504b03040a0000000000", ".jar"); 
        FILE_TYPE_MAP.put("4d5a9000030000000400", ".exe");//可执行文件
        FILE_TYPE_MAP.put("3c25402070616765206c", ".jsp");//jsp文件
        FILE_TYPE_MAP.put("0d0a3c25402070616765", ".jsp");//jsp文件
        FILE_TYPE_MAP.put("4d616e69666573742d56", ".mf");//MF文件
        FILE_TYPE_LIST.add(".mf");
        FILE_TYPE_MAP.put("3c3f786d6c2076657273", ".xml");//xml文件
        FILE_TYPE_LIST.add(".xml");
        FILE_TYPE_MAP.put("494e5345525420494e54", ".sql");//xml文件
        FILE_TYPE_LIST.add(".sql");
        FILE_TYPE_MAP.put("7061636b616765207765", ".java");//java文件
        FILE_TYPE_MAP.put("406563686f206f66660d", ".bat");//bat文件
        FILE_TYPE_MAP.put("1f8b0800000000000000", ".gz");//gz文件
        FILE_TYPE_LIST.add(".gz");
        FILE_TYPE_MAP.put("6c6f67346a2e726f6f74", ".properties");//bat文件
        FILE_TYPE_LIST.add(".properties");
        FILE_TYPE_MAP.put("cafebabe0000002e0041", ".class");//bat文件
        FILE_TYPE_MAP.put("49545346030000006000", ".chm");//bat文件
        FILE_TYPE_MAP.put("04000000010000001300", ".mxp");//bat文件
        FILE_TYPE_MAP.put("504b0304140006000800", ".docx");//docx文件
        FILE_TYPE_LIST.add(".docx");
        FILE_TYPE_MAP.put("d0cf11e0a1b11ae10000", ".wps");//WPS文字wps、表格et、演示dps都是一样的
        FILE_TYPE_LIST.add(".wps");
        FILE_TYPE_MAP.put("6431303a637265617465", ".torrent");
        
          
        FILE_TYPE_MAP.put("6D6F6F76", ".mov"); //Quicktime (mov)  
        FILE_TYPE_LIST.add(".mov");
        FILE_TYPE_MAP.put("FF575043", ".wpd"); //WordPerfect (wpd)   
        FILE_TYPE_LIST.add(".wpd");
        FILE_TYPE_MAP.put("CFAD12FEC5FD746F", ".dbx"); //Outlook Express (dbx)     
        FILE_TYPE_LIST.add(".dbx");
        FILE_TYPE_MAP.put("2142444E", ".pst"); //Outlook (pst)      
        FILE_TYPE_LIST.add(".pst");
        FILE_TYPE_MAP.put("AC9EBD8F", ".qdf"); //Quicken (qdf)     
        FILE_TYPE_LIST.add(".qdf");
        FILE_TYPE_MAP.put("E3828596", ".pwl"); //Windows Password (pwl)   
        FILE_TYPE_LIST.add(".pwl");
        FILE_TYPE_MAP.put("2E7261FD", ".ram"); //Real Audio (ram)    
        FILE_TYPE_LIST.add(".ram");
        FILE_TYPE_LIST.add(".rm");
        FILE_TYPE_LIST.add(".csv");
        FILE_TYPE_LIST.add(".txt");
        FILE_TYPE_LIST.add(".license");
        FILE_TYPE_LIST.add(".ppt");
        FILE_TYPE_LIST.add(".pptx");
        FILE_TYPE_LIST.add(".pps");
        FILE_TYPE_LIST.add(".db");
        FILE_TYPE_LIST.add(".xls");
        FILE_TYPE_LIST.add(".xlsx");
        FILE_TYPE_LIST.add(".pdf");
        FILE_TYPE_LIST.add(".jpeg");
        FILE_TYPE_LIST.add(".js");
        
        BaseBean bb = new BaseBean();
        String fileTypes = bb.getPropValue("weaver_allow_file_types","filetype");
        if(fileTypes!=null&&!fileTypes.equals("")){
        	String[] fileTypeArr = fileTypes.split(",");
        	for(int i=0;i<fileTypeArr.length;i++){
        		try{
        			FILE_TYPE_LIST.add(fileTypeArr[i].toLowerCase().trim());
        		}catch(Exception e){
        			bb.writeLog(e);
        		}
        	}
        }
        
    }
    
    public static boolean validateFileExt(String filename){
    	return validateFileExt(filename,FILE_TYPE_LIST);
    }
    
    public static boolean validateFileExt(String filename, List<String> allowFileTypes){
    	if(filename==null)return false;
    	if(filename.indexOf(".")==-1)return true;
    	filename = filename.replaceAll("%","");
		/*if(filename.indexOf(".")!=filename.lastIndexOf(".")){
			return false;
		}*/
		if(filename!=null && allowFileTypes!=null){
			for(int i=0;i<allowFileTypes.size();i++){
				if(filename.toLowerCase().endsWith(allowFileTypes.get(i).toLowerCase())){
					return true;
				}
			}
			return false;
		}else{
			return false;
		}
    }
    
    /**
     * 得到上传文件的文件头
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    
    /**
     * 根据制定文件的文件头判断其文件类型
     * @param byteArr
     * @return
     */
    
    public static String getFileTypeByByte(byte[] byteArr){
    	String fileCode = bytesToHexString(byteArr);  
        
        // System.out.println(fileCode);
    	String res = null;
         
         //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
         Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
         while(keyIter.hasNext()){
             String key = keyIter.next();
             if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                 res = FILE_TYPE_MAP.get(key);
                 break;
             }
         }
         return res;
    }
    
    public static String getFileType(String filePaht){
        String res = null;
        try {
            FileInputStream is = new FileInputStream(filePaht);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            return getFileTypeByByte(b);
            
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        
        String type = getFileType("D:\\Wildlife.wmv");
        System.out.println("eee.WMV : "+type);
        System.out.println(); 
        System.out.println(FILE_TYPE_LIST);
        type = getFileType("C:/test/350996.wav");
        System.out.println("350996.wav : "+type);
        System.out.println(); 
                
    }
}