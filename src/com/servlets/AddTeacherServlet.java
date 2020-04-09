package com.servlets;

/**
 * 录入学生信息
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.entity.Student;
import com.entity.Teacher;

@WebServlet("/admin/addTeacher")
public class AddTeacherServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String[] ids = request.getParameterValues("id");
		String[] tchNOs = request.getParameterValues("tchNO");
		String[] tchNames = request.getParameterValues("tchName");
		
		Teacher teacher= null;
		
		for (int i = 0; i < tchNames.length; i++)
		{
			teacher=new Teacher();
			teacher.setTchNO(tchNOs[i]);
			teacher.setTchName(tchNames[i]);
			
			TeacherBean teacherBean=new TeacherBean();
			boolean result=teacherBean.save(teacher);
			if(result==true)
  			{
				out.println("添加成功");
  			}
  			else
  			{
  				out.println("添加失败");
  			}
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
