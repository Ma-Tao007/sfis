package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ReplyBean;

@WebServlet("/admin/deleteReply")
public class DeleteReplyServlet extends HttpServlet
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
		ReplyBean replyBean=new ReplyBean();
		boolean result=replyBean.delete(ids);
		if(result==true)
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
