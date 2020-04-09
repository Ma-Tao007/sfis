package com.jwillim.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns={"/init"}, loadOnStartup=1)
public class InitServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException
	{
		List<HttpSession> sessionList=new ArrayList<HttpSession>();
		getServletContext().setAttribute("sessionList", sessionList);
		List<String> userNameList=new ArrayList<String>();
		getServletContext().setAttribute("userNameList", userNameList);
	}

}
