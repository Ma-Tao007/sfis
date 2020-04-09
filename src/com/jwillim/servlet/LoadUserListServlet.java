package com.jwillim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loadUserList")
public class LoadUserListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		
		
		PrintWriter pw=response.getWriter();
		while(true)
		{
			
			List<String> userNameList=(List<String>) getServletContext().getAttribute("userNameList");
			for(String userName:userNameList)
			{
//				pw.println("<option  onclick='getValue(this)'>"+userName+"</option>");
				pw.println("<option  id='"+userName+"'  onclick='getValue(this)'>"+userName+"</option>");
			
			}
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			return;
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
