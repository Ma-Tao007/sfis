package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.FindPassword;
import com.bean.ParentBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.email.MyAuthenticator;
import com.entity.Parent;
import com.entity.Student;
import com.entity.Teacher;

@WebServlet("/findPassword")
public class FindPasswordServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String role=request.getParameter("loginRole");
		String id=request.getParameter("id");
		
		String toAddress="";
		String subject="";
		String content="";
		FindPassword findPassword=new FindPassword();
		
		try
		{
			if("teacher".equals(role))// 判断登录用户是否为教师
			{
				Teacher teacher=findPassword.findTeacherPassword(id);
				if(teacher==null)
					out.println("找回密码失败，请确保您已经注册且账号输入正确!");
				
				toAddress=teacher.getTchEmail();
				subject=teacher.getTchName();
				content=teacher.getPassword();
			}
			
			else if("student".equals(role))
			{
				Student student=findPassword.findStudentPassword(id);
				if(student==null)
					out.println("找回密码失败，请确保您已经注册且账号输入正确!");
				
				toAddress=student.getStuEmail();
				subject=student.getStuName();
				content=student.getPassword();
			}
			
			else if("parent".equals(role))
			{
				
			}
			MyAuthenticator myAuthenticator=new MyAuthenticator();
			myAuthenticator.sendEmail(toAddress, subject, "您的密码："+content);
			out.println("密码已经发送到你的注册邮箱！");
		}
		catch(Exception e)
		{
			System.out.println("找回密码失败，请确保您已经注册且账号输入正确!");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
