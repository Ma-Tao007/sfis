package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.ReplyBean;
import com.entity.Message;
import com.entity.Reply;

@WebServlet("/replyMessage")
public class ReplyMessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Date replyTime=new Date();
		
		String content=request.getParameter("content");
		String messageID=request.getParameter("messageID");
		String role=request.getParameter("role");
		System.out.println("角色："+role);
		Message message=new Message();
		message.setId(Integer.parseInt(messageID));
		String replyerID=request.getParameter("replyerID");
		
		Reply reply=new Reply();
		reply.setContent(content);
		reply.setReplyTime(replyTime);
		reply.setReplyID(replyerID);
		reply.setMessage(message);
		
		ReplyBean replyBean=new ReplyBean();
		boolean result=replyBean.save(reply);
		if (result == true)
		{
			out.println("回复成功!");
			response.sendRedirect(request.getContextPath()+"/replyMessage.jsp?role="+role+"&id="+messageID);
//			request.getRequestDispatcher("replyMessage.jsp?id="+messageID).forward(request, response);
		}
		else
		{
			out.println("回复失败");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
