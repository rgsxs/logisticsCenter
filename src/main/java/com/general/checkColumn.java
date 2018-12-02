package com.general;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.common.ConvertService;
import com.util.ConstantUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class checkColumn {
	
	//xml缓存合区
	private static java.util.concurrent.ConcurrentHashMap xmlfileHash = new java.util.concurrent.ConcurrentHashMap();
	
	//xml对应修改时间缓存集合
    private static java.util.concurrent.ConcurrentHashMap<String, Long> xmlfileTime = new java.util.concurrent.ConcurrentHashMap<String, Long>();
    
    //xml存储时的时间集合
    private static java.util.concurrent.ConcurrentHashMap<String, Long> xmlfileTime2 = new java.util.concurrent.ConcurrentHashMap<String, Long>();
    
    private static final long DETA = 1000;
    
	private static Map<String,Map<String,Map<String,Map<String,String>>>> pageColumnMap = new HashMap<String,Map<String,Map<String,Map<String,String>>>>();
	
	private static Map<String,Map<String,String>> pageColumnDetail = new HashMap<String,Map<String,String>>();

	
	public String getCheckMessage(String inputArr){
		String retMessage = "";
		Map<String,Object> retMap = readJson(inputArr);
		String page = retMap.get("pageid")+"";;
		List<Map> columnDetail = new ArrayList<Map>();
		columnDetail = (List<Map>)retMap.get("columns");
		Map<String,Map<String,Map<String,String>>> pageColumn = getPageColumns(page);
		if(pageColumn == null || pageColumn.size()<0){
			return "";
		}
		for(int i =0;i<columnDetail.size();i++){
			if(!retMessage.equals("")){
				break;
			}
			Map columnMap = columnDetail.get(i);
			String column = columnMap.get("columnid")+"";
			String input = columnMap.get("columnval")+"";
			//如果使用的是*号的模糊查询就需要重新计算
			String[] columnArr = column.split("_");
			if(columnArr.length == 2){
				if(columnArr[1].equals("0")){
					continue;
				}else{
					column = columnArr[0];
				}
			}
			Map<String,Map<String,String>> columnsMap = getColumns(column,pageColumn);
			if(columnsMap == null || columnsMap.size()<0){
				continue;
			}
			Map<String ,String> columnNameMap = pageColumnDetail.get(page);
			String columnName = columnNameMap.get(column);
			if(columnName == null){
				continue;
			}
			for(String key : columnsMap.keySet()){
				Map<String,String> checkDetail = columnsMap.get(key);
				String message = checkDetail.get("message").replace("$(name)", columnName);
				//判断必须输入
				if(key.equals("required")){
					if(input.equals("") || input.equals("null") || input == null ){
						retMessage += message+"<br>";
						break;
					}
				//判断日期格式
				}else if(key.equals("date")){
					try{
						String format = checkDetail.get("format");
						SimpleDateFormat format1 = new SimpleDateFormat(format);
						format1.parse(input);
					}catch(Exception e){
						retMessage += message+"<br>";
						break;
					}
				//判断正整数
				}else if(key.equals("number")){
					for (int j=0;j<input.length();j++) {
					     char ch = input.charAt(j);
					     if(!Character.isDigit(ch)){
					    	 retMessage += message+"<br>";
					    	 break;
					     }
					     //System.out.println(ch + " is digit? " + (ch >= '0' && ch <= '9'));
					}
				}else if(key.equals("maxlength")){
					String maxLength = ConvertService.null2String(checkDetail.get("maxlength"),"0");
					if(maxLength.equals("0")){
						continue;
					}
					if(input.length() > Integer.parseInt(maxLength)){
						retMessage += message.replace("$(maxlength)",maxLength)+"<br>";
						break;
					}
				}else if(key.equals("minlength")){
					String minlength = ConvertService.null2String(checkDetail.get("minlength"),"0");
					if(minlength.equals("0")){
						continue;
					}
					if(input.length() < Integer.parseInt(minlength)){
						retMessage += message.replace("$(minlength)",minlength)+"<br>";
						break;
					}
				}else if(key.equals("rangelength")){
					int max=ConvertService.getIntValue(checkDetail.get("max"),0);
					int min=ConvertService.getIntValue(checkDetail.get("min"),0);
					try{
						int inputChangeInt = Integer.parseInt(input);
						if(min>0 && inputChangeInt<min){
							retMessage += message.replace("$(min)",min+"").replace("$(max)",max+"")+"<br>";
						}
						if(max>0 && inputChangeInt>max){
							retMessage += message.replace("$(min)",min+"").replace("$(max)",max+"")+"<br>";
						}
					}catch(Exception e){
						retMessage += columnName+": 请输入数字"+"<br>";
					}
				}else if(key.equals("pattern")){
					String patternStr = checkDetail.get("pattern");
					Pattern pattern = Pattern.compile(patternStr);
					Matcher matcher = pattern.matcher(input);
					if(!matcher.matches()){
						retMessage += message+"<br>";			
					}
				}
			}
		}
		System.out.println(retMessage);
		return retMessage;
	}
	
	/**
	 * 设置页面对应check缓存
	 * @param fileName 文件名称
	 */
	public void setPageColumns(String fileName){
		Document doc = loadXML(fileName);
		if(doc == null){
			return;
		}
		Element rootNodeElement = doc.getRootElement();;
		Element pageNodeElement = rootNodeElement.getChild("page");
		String name = pageNodeElement.getAttributeValue("name");
		List<Element> secElement = pageNodeElement.getChildren("data");
		Map<String,String> columnMap = null;
		Map<String,String> columnDetail = new HashMap<String,String>();
		Map<String,Map<String,String>> secondMap = null;
		Map<String,Map<String,Map<String,String>>> columnDetailMap = new HashMap<String,Map<String,Map<String,String>>>();
		for(int i =0;i<secElement.size();i++){
			Element  elementChild = secElement.get(i);
			String columnId = elementChild.getAttributeValue("columnId");
			if(columnId.endsWith("*")){
				columnId=columnId.substring(0,columnId.length()-1);
			}
			String columnName = elementChild.getAttributeValue("columnName");
			columnDetail.put(columnId, columnName);
			Element columnsCheckSElement = elementChild.getChild("columnChecks");
			List<Element> columns = columnsCheckSElement.getChildren("columnCheck");
			secondMap = new HashMap<String,Map<String,String>>();
			for(int j=0;j<columns.size();j++){
				columnMap = new HashMap<String,String>();
				String checkPart = columns.get(j).getAttributeValue("checkPart");
				String pattern = columns.get(j).getAttributeValue("pattern");
				String format = columns.get(j).getAttributeValue("format");
				String maxlength = columns.get(j).getAttributeValue("maxlength");
				String minlength = columns.get(j).getAttributeValue("minlength");
				String max = columns.get(j).getAttributeValue("max");
				String min = columns.get(j).getAttributeValue("min");
				String message = columns.get(j).getAttributeValue("message");
				columnMap.put("checkPart", checkPart);
				columnMap.put("pattern", pattern);
				columnMap.put("format", format);
				columnMap.put("maxlength", maxlength);
				columnMap.put("minlength", minlength);
				columnMap.put("max", max);
				columnMap.put("min", min);
				columnMap.put("message", message);
				secondMap.put(checkPart,columnMap);
			}
			columnDetailMap.put(columnId, secondMap);
		}
		pageColumnMap.put(name, columnDetailMap);
		pageColumnDetail.put(name, columnDetail);
		xmlfileHash.put(fileName, doc);
	}
	
	/**filename 和 存储的pageid是一个意思
	 * @param filename
	 * @return
	 */
	public Document loadXML(String filename){
		Document doc = null;
	        if(filename.equals("")) return doc;
	        if (xmlfileHash.containsKey(filename)) {
                return (Document) xmlfileHash.get(filename);
            } else {
            	try{
    	            SAXBuilder builder = new SAXBuilder();//解析xml
    	            String filepath = ConstantUtils.getServicePath()+File.separatorChar+filename+".xml";//绝对路径
    	            //System.out.println("filepath=="+filepath);
    	            File infile = new File(filepath);
    	            if (!infile.exists())
                        return null;
    	            doc = builder.build(infile);
    	            xmlfileHash.put(filename, doc);
                    xmlfileTime.put(filename, infile.lastModified());
                    xmlfileTime2.put(filename, System.currentTimeMillis());
    	        }catch(Exception e){
    	            e.printStackTrace();
    	       	}
            }
	        return doc;
	    }
	
	/**
	 * 获得对应页面id的column缓存集合
	 * @param pageId
	 * @return Map<String,Map<String,Map<String,String>>>
	 */
	public Map<String,Map<String,Map<String,String>>> getPageColumns(String pageId){
		Map<String,Map<String,Map<String,String>>> pageColumnCheckMap = null;
		if(xmlfileHash.containsKey(pageId)){
			 if (System.currentTimeMillis() - xmlfileTime2.get(pageId) > DETA) {
				 File f = new File(ConstantUtils.getServicePath() + File.separator+pageId + ".xml");
				 if(xmlfileTime.get(pageId) != f.lastModified()){
					 pageColumnMap.remove(pageId);
					 xmlfileHash.remove(pageId);
					 setPageColumns(pageId);
				 }
			 }else{
				 pageColumnMap.remove(pageId);
				 xmlfileHash.remove(pageId);
				 setPageColumns(pageId);
			 }
		}else{
			setPageColumns(pageId);
		}
		 for (String key : pageColumnMap.keySet()) {
			   if(key.equals(pageId)){
				   pageColumnCheckMap = new HashMap<String,Map<String,Map<String,String>>>();
				   pageColumnCheckMap = pageColumnMap.get(key);
			   }
			}
		return pageColumnCheckMap;
	}
	
	/**
	 * 获得column详细集合
	 * @param columnId
	 * @param columnCheckMap
	 * @return Map<String,Map<String,String>>
	 */
	public Map<String,Map<String,String>> getColumns(String columnId,Map<String,Map<String,Map<String,String>>> columnCheckMap){
		Map<String,Map<String,String>> columnCheckDetailMap = null;
		for (String key : columnCheckMap.keySet()) {
			if(key.endsWith("*")){
				if(columnId.startsWith(key.substring(0,key.length()-1))){
					columnCheckDetailMap = new HashMap<String,Map<String,String>>();
					columnCheckDetailMap = columnCheckMap.get(key);
				}
			}else{
				if(key.equalsIgnoreCase(columnId)){
					columnCheckDetailMap = new HashMap<String,Map<String,String>>();
					columnCheckDetailMap = columnCheckMap.get(key);
				}
			}
		}
		return columnCheckDetailMap;
	}
	
	/**
	 * json格式转换 <br>
	 * {'a':'1','b':'2'}
	 * @param json
	 * @return
	 */
	private Map<String,Object> readJson(String json) {
	    Map<String,Object> elememtMap = new HashMap<String,Object>();
		if(json!=null&&!"".equals(json)){
			try{
				JSONObject jsonObj = JSONObject.parseObject(json);

				elememtMap = JSONObject.parseObject(jsonObj.toJSONString(), new TypeReference<Map<String, Object>>(){});
			}catch(Exception e){e.printStackTrace();}
		}
        return elememtMap;
	}

}
