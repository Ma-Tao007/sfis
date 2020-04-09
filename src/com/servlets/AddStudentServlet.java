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
import com.entity.Student;

@WebServlet("/admin/addStudent")
public class AddStudentServlet extends HttpServlet
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
		String[] stuNOs = request.getParameterValues("stuNO");
		String[] stuNames = request.getParameterValues("stuName");
		
		Student student=null;
		
		for (int i = 0; i < stuNames.length; i++)
		{
			student=new Student();
			student.setStuNO(stuNOs[i]);
			student.setStuName(stuNames[i]);
			StudentBean studentBean=new StudentBean();
			boolean result=studentBean.save(student);
			if(result==true)
  			{
				out.println("<script>");
				out.println("alert('添加成功！')");
				out.println("</script>");
				
  			}
  			else
  			{
  				out.println("添加失败");
  			}
		}
		out.close();
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
