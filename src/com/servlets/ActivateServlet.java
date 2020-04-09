package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TeacherBean;
import com.entity.Teacher;

@WebServlet("/teacher/activate")
public class ActivateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		PrintWriter out=response.getWriter();
		String tchNO="";
		
		if(request.getParameter("tchNO")==null)
			return;
		
		tchNO=request.getParameter("tchNO");
		System.out.println("!!!!");
		System.out.println(tchNO);
		TeacherBean teacherBean=new TeacherBean();
		Teacher teacher=teacherBean.check(tchNO);
		if(teacher!=null)
		{
			out.println("教师姓名："+teacher.getTchName().toString());
		}
		else
		{
			out.println("教师号【"+tchNO+"】不存在");
		}
		out.close();
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
