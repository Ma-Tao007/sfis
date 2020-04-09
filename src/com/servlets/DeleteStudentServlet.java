package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MessageBean;
import com.bean.ParentBean;
import com.bean.ReplyBean;
import com.bean.StudentBean;
import com.entity.Parent;

@WebServlet("/admin/deleteStudent")
public class DeleteStudentServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String[] ids=request.getParameterValues("id");
		StudentBean studentBean=new StudentBean();
		ParentBean parentBean=new ParentBean();
		MessageBean messageBean=new MessageBean();
		ReplyBean replyBean=new ReplyBean();
		List<Parent> parentList=parentBean.parent(ids);
		List<String> pidsList=new ArrayList<String>();
		if(parentList!=null)
		{		
			for(Parent p:parentList)
			{
				pidsList.add(p.getTel());
			}
		}
		
		boolean result=studentBean.delete(ids);
		boolean result1=parentBean.delete(ids);
		boolean result2=messageBean.deleteSM(ids);
		boolean result3=messageBean.deletePM(pidsList);
		boolean result4=replyBean.deletePM(pidsList);
		boolean result5=replyBean.deleteSM(ids);
		if(result==true&&result1==true&&result2==true&&result3==true&&result4==true&&result5==true)
		{
			out.println("<script>");
			out.println("alert('删除成功！')");
			out.println("</script>");
		}
		else
		{
			out.println("删除失败");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
