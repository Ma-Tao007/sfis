package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.entity.Student;

@WebServlet("/studentList")
public class StudentListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		// 调用JavaBean对象的方法，获取数据，选择JSP页面显示结果
		StudentBean studentBean=new StudentBean();
		
		List<Student> studentList=studentBean.studentList();
		System.out.println("*************");
		System.out.println(studentList);
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("admin/studentList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
