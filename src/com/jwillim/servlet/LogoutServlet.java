package com.jwillim.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		HttpSession session=request.getSession();
		List<String>userNameList=(List<String>) getServletContext().getAttribute("userNameList");
		String userName=(String) session.getAttribute("userName");
		userNameList.remove(userName);
		session.removeAttribute("userName");
		List<HttpSession> sessionList=(List<HttpSession>) getServletContext().getAttribute("sessionList");
		sessionList.remove(session);
		response.sendRedirect("login.jsp");
	}
}
