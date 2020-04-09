package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/teacher/*")
public class TeacherLoginFilter implements Filter {

	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		// place your code here
				// 1. 得到用户访问目标资源
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				String ctxPath = httpRequest.getContextPath();
				String uri = httpRequest.getRequestURI();
				// 2. 将uri中去掉ctxPath部分，获得剩余部分
				uri = uri.substring(ctxPath.length());
				// 3. 判断用户访问的资源是否需要验证
				// （首页、登录请求、注册页面、注册请求、注销请求、预览帖子）
				if (!"/".equals(uri) && !"/index.jsp".equals(uri) && !"/login.html".equals(uri)
						&& !"/activate.jsp".equals(uri) && !"/login".equals(uri)  && !"/adminLogin".equals(uri) && !"/activate".equals(uri)
						&& !uri.contains("/js") && !uri.contains("/css") && !uri.contains("/images") && !uri.contains("/img") && !uri.contains("/register.js") && !uri.contains("/register.css")
						&&!uri.contains("/activate.jsp") && !uri.contains("/login") && !uri.contains("/adminLogin") && !uri.contains("/activate") && !uri.contains("/parentActivate") && !uri.contains("/studentActivate") && !uri.contains("/teacherActivate.jsp")) 
				{
					HttpSession session = httpRequest.getSession();
					if (session.getAttribute("teacher") == null )
					{
//						String messageId = httpRequest.getParameter("messageId");
//						httpRequest.setAttribute("messageId", messageId);
						PrintWriter out=response.getWriter();
						out.println("<script>");
						out.println("alert('教师还没有登录')");
						out.println("window.location.href='"+httpRequest.getContextPath()+"/index.jsp';");
						out.println("</script>");
						out.close();
//						httpRequest.getRequestDispatcher("index.jsp").forward(httpRequest, response);
						return ;
					}
					
					
				}
				// pass the request along the filter chain
				chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
