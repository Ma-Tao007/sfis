<%@page import="com.bean.StudentBean"%>
<%@page import="com.email.MyAuthenticator"%>
<%@page import="com.bean.TeacherBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生激活页面</title>
</head>
<body>
			<%
					String tchNO=request.getParameter("tchNO");
					String email=request.getParameter("email");
					String password=request.getParameter("password"); 
					StudentBean studentBean=new StudentBean();
					boolean result=studentBean.activate(password,tchNO,email);
					if(result==true)
					{
						out.println("学生激活成功");
						MyAuthenticator my=new MyAuthenticator();
						my.sendEmail(email, "恭喜你", "激活成功，您已经成为本校的学生");
					}
					else
					{
						out.println("激活失败");
					}
			%>
</body>
</html>