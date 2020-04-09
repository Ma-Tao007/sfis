package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.entity.Admin;

@WebServlet("/admin/adminLogin")
public class AdminLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");
		
		Admin admin=new Admin();
		admin.setAdminName(adminName);
		admin.setPassword(password);
		
		AdminBean adminBean=new AdminBean();
		boolean result=adminBean.login(admin);
		if(result==true)
		{
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("index.jsp").forward(request, response);
//			request.getRequestDispatcher("index.html").forward(request, response);
		}
		else
		{
			out.println("登录失败！");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
