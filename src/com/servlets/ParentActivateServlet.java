package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.entity.Student;

@WebServlet("/parent/parentActivate")
public class ParentActivateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		String stuNO="";
		
		if(request.getParameter("tchNO")==null)
			return;
		
		stuNO=request.getParameter("tchNO");
		StudentBean studentBean=new StudentBean();
		Student student=studentBean.check(stuNO);
		if(student!=null)
		{
			out.println("学生姓名："+student.getStuName().toString());
		}
		else
		{
			out.println("学生学号【"+stuNO+"】不存在");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
