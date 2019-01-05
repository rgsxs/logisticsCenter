package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        // 登陆url
        String loginUrl = httpRequest.getContextPath() + "/user/sign-in.jsp";
        String url = httpRequest.getRequestURI();
        String path = url.substring(url.lastIndexOf("/"));
        // 超时处理，ajax请求超时设置超时状态，页面请求超时则返回提示并重定向
        if (path.indexOf(".jsp") != -1
                && session.getAttribute("System_Info") == null ) {
            // 判断是否为ajax请求
            if (httpRequest.getHeader("x-requested-with") != null
                    && httpRequest.getHeader("x-requested-with")
                            .equalsIgnoreCase("XMLHttpRequest")) {
                httpResponse.addHeader("sessionstatus", "timeOut");
                httpResponse.addHeader("loginPath", loginUrl);
                chain.doFilter(request, response);// 不可少，否则请求会出错
            } else {
                if(path.indexOf("sign-in.jsp") != -1){
                	chain.doFilter(request, response);
                }else{
	                response.setContentType("text/html;charset=UTF-8");// 解决中文乱码
	                PrintWriter out = response.getWriter();  
	                out.println("<html>");      
	                out.println("<script>");      
	                out.println("window.open ('"+httpRequest.getContextPath()+"/user/sign-in.jsp','_top')");
	                out.println("</script>");      
	                out.println("</html>");   
                }
            }
        } else {
            chain.doFilter(request, response);
        }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
