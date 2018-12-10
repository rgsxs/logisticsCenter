package com.logisticscenter.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cache.Cache;
import com.cache.CacheManager;
import com.common.ConvertService;
import com.javabean.SystemInfoBean;
import com.javabean.TruckSetBean;
import com.logisticscenter.mapper.SystemInfoDao;
import com.logisticscenter.model.SystemInfoEntity;
import com.logisticscenter.service.LoginService;
import com.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	private static List<Map<String,SystemInfoEntity>> systemInfo = new ArrayList<Map<String,SystemInfoEntity>>();

	@Autowired
	SystemInfoDao systemDao;

	@Override
	public Map deleteSystemInfo(Map<String, Object> params) {
		Map retResult = new HashMap();
		String id = Utils.null2String((String)params.get("id"),"-1");
		systemDao.deleteSystemInfo(id);
		return retResult;
	}

	@Override
	public Map getSystemInfo(Map<String, Object> params) {
		Map retResult = new HashMap();
		String loginid = (String)params.get("loginId");
		String password = (String)params.get("password");
		//获得是否可以重复登录
		SystemInfoEntity systemEntity = new SystemInfoEntity();
		systemEntity.setLoginid(loginid);
		systemEntity.setPassword(password);
		Cache cache = CacheManager.getCacheInfo("truckSettingBean_CACHE");
		TruckSetBean bean=(TruckSetBean)cache.getValue();
//		boolean isLogin = getIsLogin(loginid);
		boolean isLogin = false;
		if(!isLogin){
			Map <String,SystemInfoEntity> systemMap = new HashMap<String,SystemInfoEntity>();
			systemMap.put(loginid,systemEntity);
			systemInfo.add(systemMap);
		}
		int reLogin = bean.getReLogin();
		if(reLogin == 1 && isLogin){

		}
		//获取输出流，然后使用
		PrintWriter out = null;
		try {
			SystemInfoEntity systemInfoEntity = systemDao.getSystemInfo((String)params.get("id"));
			Map result = new HashMap();
			int status = 0;
			if(systemInfoEntity.getPassword().equals(password)){
				status = 0;
			}else if(!systemInfoEntity.getPassword().equals(password)){
				status = 1;
			}else if("".equals(systemInfoEntity.getPassword())){
				status = 2;
			}
			retResult.put("status",status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//返回json对象
		return retResult;
	}


	@Override
	public Map updateSystemInfo(Map<String, Object> params) {
//		SystemInfoEntity systemE = new SystemInfoEntity();
//		systemDao.updateSystemInfo(systemE);
		return null;
	}
	
	@Override
	public Map updateAllSystemInfo(Map<String, Object> params) {
//		SystemInfoEntity systemE = new SystemInfoEntity();
//		systemDao.updateAllSystemInfo(systemE);
		return null;
	}

	@Override
	public Map insertSystemInfo(Map<String, Object> params) {
//		SystemInfoEntity systemE = (SystemInfoEntity) ConvertService.convertBeanToEntity(insertInfo, new SystemInfoEntity());
//		systemDao.insertSystemInfo(systemE);
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @param loginId
	 * @return 是否已经登录
	 */
	private Map getIsLogin(String loginid){
		return null;
//		for(int i=0;i <systemInfo.size();i++){
//			Map<String,SystemInfoBean> systemMap = systemInfo.get(i);
//			for(String key : systemMap.keySet()){
//				if(key.equals(loginId)){
//					return true;
//				}
//			}
//		}
//		return false;
	}

}
