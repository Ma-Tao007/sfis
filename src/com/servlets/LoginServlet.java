package com.servlets;

/**
 * 登录的Servlet
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ParentBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.entity.Parent;
import com.entity.Student;
import com.entity.Teacher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet
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
		
		String role=request.getParameter("loginRole");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		if("teacher".equals(role))// 判断登录用户是否为教师
		{
			TeacherBean teacherBean=new TeacherBean();
			Teacher teacher=teacherBean.login(userName, password);
			if(teacher!=null)
  			{
  				session.setAttribute("teacher", teacher);
  				response.sendRedirect(request.getContextPath()+"/teacher/main.jsp");
  				return;
//  				request.getRequestDispatcher(request.getContextPath()+"/teacher/main.jsp").forward(request, response);
  			}
  			else
  			{
  				out.println("登录失败");
  				out.println("<a href='javascript:history.back();'>重新登录</a>");
  			}
		}
		
		else if("student".equals(role))
		{
			StudentBean studentBean=new StudentBean();
			Student student=studentBean.login(userName, password);
			if(student!=null)
  			{
  				session.setAttribute("student", student);
  				response.sendRedirect(request.getContextPath()+"/student/main.jsp");
  				return ;
//  				request.getRequestDispatcher(request.getContextPath()+"/student/main.jsp").forward(request, response);
  			}
  			else
  			{
  				out.println("登录失败");
  				out.println("<a href='javascript:history.back();'>重新登录</a>");
  			}
		}
		
		else if("parent".equals(role))
		{
			ParentBean parentBean=new ParentBean();
			Parent parent=parentBean.login(userName, password);
			if(parent!=null)
  			{
  				session.setAttribute("parent", parent);
  				response.sendRedirect(request.getContextPath()+"/parent/main.jsp");
  				return ;
//  				request.getRequestDispatcher(request.getContextPath()+"/parent/main.jsp").forward(request, response);
  			}
  			else
  			{
  				out.println("登录失败");
  				out.println("<a href='javascript:history.back();'>重新登录</a>");
  			}
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
