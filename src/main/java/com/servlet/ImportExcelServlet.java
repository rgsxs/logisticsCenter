package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ImportExcelServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 缓冲区域
	File tempPathFile;
	// 默认路径
	String uploadTo = "D:\\";
	// 支持的文件类型
	String[] errorType = { ".xls" };
	// 格式化日期
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 取得服务器真实路径
		uploadTo = req.getSession().getServletContext().getRealPath("\\")
				+ "upload\\";
		File tempFile = new File(uploadTo);
		if (!tempFile.exists()) {
			tempFile.mkdirs();
		}
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置缓冲区大小，这里是4kb
		factory.setSizeThreshold(4096);
		// 设置缓冲区目录
		factory.setRepository(tempPathFile);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint
		// 设置最大文件尺寸，这里是4MB
		upload.setSizeMax(4 * 1024 * 1024);
		// 开始读取上传信息
		List fileItems = new ArrayList();
		try {
			fileItems = upload.parseRequest(req);
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}
		// 依次处理每个上传的文件
		Iterator iter = fileItems.iterator();
		System.out.println("fileItems的大小是" + fileItems.size());
		// 正则匹配，过滤路径取文件名
		String regExp = ".+\\\\(.+)$";
		Pattern p = Pattern.compile(regExp);
		String errMsg = "";
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();
			// 忽略其他不是文件域的所有表单信息
			System.out.println("正在处理" + item.getFieldName());
			if (!item.isFormField()) {
				String name = item.getName();
				long size = item.getSize();
				if ((name == null || name.equals("")) && size == 0)
					continue;
				Matcher m = p.matcher(name);
				boolean result = m.find();
//				if (result) {
					boolean flag = false;
//					for (int temp = 0; temp < errorType.length; temp++) {
//						if (m.group(1).endsWith(errorType[temp])) {
//							flag = true;
//						}
//					}
					int endPoint = name.lastIndexOf(".");
					for (int temp = 0; temp < errorType.length; temp++) {
					if (name.substring(endPoint).equals((errorType[temp]))) {
						flag = true;
					}
				}
					if (!flag) {
						System.out.println("上传了不支持的文件类型");
						errMsg +="上传了不支持的文件类型";
					}else{
						try {
							String fileName = uploadTo + format.format(new Date())
									+ name.substring(0,endPoint);
							item.write(new File(fileName));
							// 调用ReadExcel类进行读出excel
							ReadExcel readExcel = new ReadExcel();
							errMsg += readExcel.readExcel(fileName, resp.getWriter());
//							System.out.println(name + "\t\t" + size);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
//				}
			} else {
				// 这里添加对不是上传文件表单项的处理
				System.out.println("这是一个表单项");
				errMsg +="这是一个表单项";
			}
		}
		if(errMsg.equals("")){
			errMsg = "数据导入成功";
		}
		resp.setContentType("text/html;charset=UTF-8"); 
		PrintWriter out=resp.getWriter();
        //返回值到客户端
        out.write(errMsg);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		tempPathFile = new File("d:\\temp\\buffer\\");
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}
	}
}