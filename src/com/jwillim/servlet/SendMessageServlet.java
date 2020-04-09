package com.jwillim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwillim.entity.Message;

@WebServlet("/sendMessage")
public class SendMessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		PrintWriter pw=response.getWriter();
		if(userName==null)
		{
			request.setAttribute("login_error_message","连接超时。。。。" );
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String content=request.getParameter("messageContent");
		if(content.isEmpty()||content==null)
			return;
		Message message=new Message();
		message.setUserName(userName);
		message.setContent(content);
		message.setSendTime(new Date());
		
		
		ServletContext application=getServletContext();
		List<HttpSession> sessionList=(List<HttpSession>)application.getAttribute("sessionList");
		int size=sessionList.size();
		if(size<=0)
		{
			pw.print("error");
			return;
		}
		for(int i=size-1;i>=0;i--)
		{
			HttpSession s = sessionList.get(i);
			
			try
			{
				List<Message> messageList = (List<Message>) s.getAttribute("messageList");
				messageList.add(message);
			}
			catch (java.lang.IllegalStateException e)
			{
				sessionList.remove(s);
				e.printStackTrace();
			}
		}
		
		pw.print("success");
		pw.close();
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
