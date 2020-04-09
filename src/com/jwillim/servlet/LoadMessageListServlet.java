package com.jwillim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jwillim.entity.Message;

@WebServlet("/loadMessageList")
public class LoadMessageListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	private static SimpleDateFormat sdf;
	
	@Override
	public void init() throws ServletException
	{
		super.init();
		sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		
		HttpSession session=request.getSession();
		
		PrintWriter pw=response.getWriter();
		
		while(true)
		{
			@SuppressWarnings("unchecked")
			List<Message> messageList=(List<Message>) session.getAttribute("messageList");
			if(messageList!=null&&messageList.isEmpty()==false)
			{
				Message message=messageList.remove(0);	
				pw.println("<div class='title'>" + message.getUserName() + "  " + sdf.format(message.getSendTime()) + "</div>");
				pw.println("<div class='cnt'>" + message.getContent()+"\n\r\n\r" + "</div>");
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
