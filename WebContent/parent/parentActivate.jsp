<%@page import="com.bean.ParentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家长注册页面</title>
</head>
<body>
			<%
			String tchNO=request.getParameter("tchNO");
			String email=request.getParameter("email");
			String name=request.getParameter("name");
			String password=request.getParameter("password"); 
			ParentBean parentBean=new ParentBean();
			boolean result=parentBean.activate(email, name, password, tchNO);
			if(result==true)
			{
				out.println("家长注册成功");
			}
			else
			{
				out.println("家长注册失败");
			}
			%>
</body>
</html>