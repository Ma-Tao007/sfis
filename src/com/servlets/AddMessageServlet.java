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

import com.bean.MessageBean;
import com.entity.Message;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;

@WebServlet("/addMessage")
public class AddMessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date sendTime=new Date();
		String senderID = request.getParameter("senderID");
		String receiverID = request.getParameter("receiverID");
		if(receiverID==null || receiverID.length()==0)
		{
			out.println("该家长还未注册");
			return;
		}
		String role=request.getParameter("role");
		Message message=new Message();
		message.setTitle(title);
		message.setContent(content);
		message.setSendTime(sendTime);
		message.setSenderID(senderID);
		message.setReceiverID(receiverID);

		MessageBean messageBean=new MessageBean();
		boolean result = messageBean.save(message);
		if (result == true)
		{
			out.println("留言成功!");
			if("student".equals(role))
			{
				response.sendRedirect(request.getContextPath()+"/student/main.jsp");
			}
			if("teacher".equals(role))
			{
				response.sendRedirect(request.getContextPath()+"/teacher/main.jsp");
			}
			if("parent".equals(role))
			{
				response.sendRedirect(request.getContextPath()+"/parent/main.jsp");
			}
		}
		else
		{
			out.println("留言失败");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
