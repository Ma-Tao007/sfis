package com.jwillim.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwillim.entity.Message;
import com.jwillim.util.SQLUtil;

@WebServlet("/chat/login")
public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		String userName=request.getParameter("userName");
		
//		List<String> userNameList=(List<String>) getServletContext().getAttribute("userNameList");
//		if(userName!=null&&session_userNameList.contains(userName))
//		{
////			request.setAttribute("login_error_message", "此账号已经登陆。。。");
////			request.getRequestDispatcher("login.jsp").forward(request, response);
////			return;
//		}
	
		
		
		
		HttpSession session=request.getSession();
		String session_userName=(String) session.getAttribute("userName");
		if(session_userName!=null&&userName.equals(session_userName))
		{
			response.sendRedirect(request.getContextPath()+"/chat.jsp");
			return;
		}
		
	
		session.setAttribute("userName",userName);
		List<Message> messageList = (List<Message>) session.getAttribute("messageList");
		if (messageList == null)
		{
			messageList = new ArrayList<Message>();
			session.setAttribute("messageList", messageList);
		}
		List<Message> privateMessageList = (List<Message>) session.getAttribute("privateMessageList");
		if (privateMessageList == null)
		{
			privateMessageList = new ArrayList<Message>();
			session.setAttribute("privateMessageList", privateMessageList);
		}
		ServletContext application=getServletContext();
		List<HttpSession>sessionList=(List<HttpSession>)application.getAttribute("sessionList");
		List<String> userNameList=(List<String>) application.getAttribute("userNameList");
		sessionList.add(session);
		application.setAttribute("sessionList", sessionList);
		userNameList.add(userName);
		application.setAttribute("userNameList", userNameList);
		response.sendRedirect(request.getContextPath()+"/chat.jsp");
	}

}
