package com.util;


import com.common.consatnt.ParamConstant;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ParamUtil {

    public static Map<String, Object> request2Map(HttpServletRequest request) {
        // 参数Map
        Map<String, String[]> properties = request.getParameterMap();
        // 返回值Map
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<Map.Entry<String, String[]>> entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        Object value = null;
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = null;
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                if (values.length == 1) {
                    value = values[0];
                } else {
                    value = values;
                }
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        //放入ip
        returnMap.put(ParamConstant.PARAM_IP, Utils.getIpAddr(request));
        returnMap.put(ParamConstant.REQUEST_HEADER_USER_AGENT,request.getHeader("user-agent"));
        return returnMap;
    }
}
