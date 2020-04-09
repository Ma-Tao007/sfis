package com.jwillim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwillim.entity.Message;

@WebServlet("/updatePrivateMessage")
public class UpdatePrivateMessageServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		
		HttpSession session=request.getSession();
		String userName=(String) session.getAttribute("userName");
		PrintWriter pw=response.getWriter();
		
		while(true)
		{
			@SuppressWarnings("unchecked")
			List<Message> privateMessageList=(List<Message>) session.getAttribute("privateMessageList");
			if(privateMessageList!=null&&!privateMessageList.isEmpty())
			{
				Message message=privateMessageList.get(0);
				String senderName=message.getUserName();
				if(senderName.equals(userName))
				{
					pw.print("send privateMessage success");
					pw.close();
					return;
				}
				pw.print(senderName);
				pw.close();
				return;
			}
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
