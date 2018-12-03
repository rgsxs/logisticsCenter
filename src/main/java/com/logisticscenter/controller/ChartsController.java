package com.logisticscenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.CommonTransMethod;
import com.javabean.ChartsBean;
import com.logisticscenter.service.ChartsService;
import com.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @卜伟领 2017
 *
 */
@Controller
@RestController
@RequestMapping(value = "/charts")
public class ChartsController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChartsController(){
		
	}

	@Autowired
	private ChartsService chartsService;


	@ResponseBody
	@PostMapping("/getClientChartsByMonth")
	public String getClientChartsByMonth(HttpServletRequest request){
//		Map<String, Object> apidatas = new HashMap<String, Object>();
//		try {
//			apidatas.putAll(chartsService.getClientChartsByMonth(ParamUtil.request2Map(request)));
//			apidatas.put("api_status", true);
//		} catch (Exception e) {
//			e.printStackTrace();
//			apidatas.put("api_status", false);
//			apidatas.put("api_errormsg", "catch exception : " + e.getMessage());
//		}
		String selectYear = request.getParameter("selectYear");
		List<ChartsBean> chartsBeanList = new ArrayList<ChartsBean>();
		chartsBeanList = chartsService.getClientChartsByMonth(selectYear);
		PrintWriter out = null;
		List clientNameList = new ArrayList();
		List yDetailList = new ArrayList();
		String yDetail = "";
		Map result = new HashMap();
		Map retResult = new HashMap();
		String retDetail = "";
		try{
			for(int i=0;i<chartsBeanList.size();i++){
				if(!yDetail.equals("")){
					yDetail = "";
		    	}
				clientNameList.add(CommonTransMethod.getClientName(chartsBeanList.get(i).getClient()));
				yDetail += CommonTransMethod.getClientName(chartsBeanList.get(i).getClient()) + ",";
				yDetail += chartsBeanList.get(i).getJan()
				+","+chartsBeanList.get(i).getFeb()
				+","+chartsBeanList.get(i).getMar()
				+","+chartsBeanList.get(i).getApr()
				+","+chartsBeanList.get(i).getMay()
				+","+chartsBeanList.get(i).getJun()
				+","+chartsBeanList.get(i).getJul()
				+","+chartsBeanList.get(i).getAug()
				+","+chartsBeanList.get(i).getSept()
				+","+chartsBeanList.get(i).getOct()
				+","+chartsBeanList.get(i).getNov()
				+","+chartsBeanList.get(i).getDec();
				yDetailList.add(yDetail);
			}
			retResult.put("retDetail",yDetailList);
			JSONObject  retObj = (JSONObject) JSONObject.toJSON(retResult.toString());
			return retObj.toJSONString();

		}catch(Exception e){
			
		}
		return null;
	}

	@ResponseBody
	@PostMapping("/getDriverChartsByMonth")
	public List getDriverChartsByMonth(HttpServletRequest request){

		String selectYear = request.getParameter("selectYear");
		List<ChartsBean> chartsBeanList = new ArrayList<ChartsBean>();
		chartsBeanList = chartsService.getDriverChartsByMonth(selectYear);
		PrintWriter out = null;
		List clientNameList = new ArrayList();
		List yDetailList = new ArrayList();
		String yDetail = "";
		Map result = new HashMap();
		Map retResult = new HashMap();
		String retDetail = "";
		try{
			for(int i=0;i<chartsBeanList.size();i++){
				if(!yDetail.equals("")){
					yDetail = "";
		    	}
				clientNameList.add(CommonTransMethod.getDriverName(chartsBeanList.get(i).getDriver()));
				yDetail += CommonTransMethod.getDriverName(chartsBeanList.get(i).getDriver()) + ",";
				yDetail += chartsBeanList.get(i).getJan()
				+","+chartsBeanList.get(i).getFeb()
				+","+chartsBeanList.get(i).getMar()
				+","+chartsBeanList.get(i).getApr()
				+","+chartsBeanList.get(i).getMay()
				+","+chartsBeanList.get(i).getJun()
				+","+chartsBeanList.get(i).getJul()
				+","+chartsBeanList.get(i).getAug()
				+","+chartsBeanList.get(i).getSept()
				+","+chartsBeanList.get(i).getOct()
				+","+chartsBeanList.get(i).getNov()
				+","+chartsBeanList.get(i).getDec();
				yDetailList.add(yDetail);
			}
			return yDetailList;
		}catch(Exception e){
			
		}
		return null;
	}


	@ResponseBody
	@PostMapping("/getDriverFeeChartsByMonth")
	public Map getDriverFeeChartsByMonth(HttpServletRequest request){

		String selectYear = request.getParameter("selectYear");
		String columnNames = CommonTransMethod.getAllFeeTypeColumn();
		List<ChartsBean> chartsBeanList = new ArrayList<ChartsBean>();
		chartsBeanList = chartsService.getDriverFeeChartsByMonth(selectYear,columnNames);
		PrintWriter out = null;
		List clientNameList = new ArrayList();
		List yDetailList = new ArrayList();
		String yDetail = "";
		Map retResult = new HashMap();
		try{
			for(int i=0;i<chartsBeanList.size();i++){
				if(!yDetail.equals("")){
					yDetail = "";
		    	}
				clientNameList.add(CommonTransMethod.getDriverName(chartsBeanList.get(i).getDriver()));
				yDetail += CommonTransMethod.getDriverName(chartsBeanList.get(i).getDriver()) + ",";
				yDetail += chartsBeanList.get(i).getJan()
				+","+chartsBeanList.get(i).getFeb()
				+","+chartsBeanList.get(i).getMar()
				+","+chartsBeanList.get(i).getApr()
				+","+chartsBeanList.get(i).getMay()
				+","+chartsBeanList.get(i).getJun()
				+","+chartsBeanList.get(i).getJul()
				+","+chartsBeanList.get(i).getAug()
				+","+chartsBeanList.get(i).getSept()
				+","+chartsBeanList.get(i).getOct()
				+","+chartsBeanList.get(i).getNov()
				+","+chartsBeanList.get(i).getDec();
				yDetailList.add(yDetail);
			}
			retResult.put("retDetail",yDetailList);
			return retResult;
		}catch(Exception e){
			
		}
		return null;
	}

	@ResponseBody
	@PostMapping("/getClientFeeChartsByMonth")
	public Map getClientFeeChartsByMonth(HttpServletRequest request){

		String selectYear = request.getParameter("selectYear");
		List<ChartsBean> chartsBeanList = new ArrayList<ChartsBean>();
		//获得费用字段
		String columnNames = CommonTransMethod.getAllFeeTypeColumn();
		chartsBeanList = chartsService.getClientFeeChartsByMonth(selectYear,columnNames);
		PrintWriter out = null;
		List clientNameList = new ArrayList();
		List yDetailList = new ArrayList();
		String yDetail = "";
		Map retResult = new HashMap();
		try{
			for(int i=0;i<chartsBeanList.size();i++){
				if(!yDetail.equals("")){
					yDetail = "";
		    	}
				clientNameList.add(CommonTransMethod.getClientName(chartsBeanList.get(i).getClient()));
				yDetail += CommonTransMethod.getClientName(chartsBeanList.get(i).getClient()) + ",";
				yDetail += chartsBeanList.get(i).getJan()
				+","+chartsBeanList.get(i).getFeb()
				+","+chartsBeanList.get(i).getMar()
				+","+chartsBeanList.get(i).getApr()
				+","+chartsBeanList.get(i).getMay()
				+","+chartsBeanList.get(i).getJun()
				+","+chartsBeanList.get(i).getJul()
				+","+chartsBeanList.get(i).getAug()
				+","+chartsBeanList.get(i).getSept()
				+","+chartsBeanList.get(i).getOct()
				+","+chartsBeanList.get(i).getNov()
				+","+chartsBeanList.get(i).getDec();
				yDetailList.add(yDetail);
			}
			retResult.put("retDetail",yDetailList);
			return retResult;
		}catch(Exception e){
			
		}
		return null;
	}
	
}
