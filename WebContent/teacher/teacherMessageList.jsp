<%@page import="com.entity.Message"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.MessageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${teacher.tchName}发的留言</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
			<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>
			<table class="twidth" cellpadding=0 cellspacing=10 align=center  >
			<tr>
				<th>给学生的留言</th>
			</tr>
			<%
					String tchNO=request.getParameter("tchNO");
					MessageBean messageBean=new MessageBean();
					List<Message> teacherMessageList1=messageBean.teacherMessageList1(tchNO);
					request.setAttribute("teacherMessageList1", teacherMessageList1);
			%>
				<tr>
					<td>留言标题</td>
					<td>留言对象</td>
				</tr>
				<c:forEach var="message" items="${ teacherMessageList1}" varStatus="status">
					<tr>
						<td><a href="${pageContext.request.contextPath }/teacher/replyMessage.jsp?role=${teacher.role }&id=${message.id}&name=${message.parent.parName}&replyerID=${teacher.tchNO}">${message.title}</a></td>
						<td>${message.student.stuName}</td>
					</tr>					
				</c:forEach>
				
				<tr>
					<th>给家长的留言</th>
				</tr>
				<%
					List<Message> teacherMessageList2=messageBean.teacherMessageList2(tchNO);
					request.setAttribute("teacherMessageList2", teacherMessageList2);
				%>
				<tr>
					<td>留言标题</td>
					<td>留言对象</td>
				</tr>
				<c:forEach var="message" items="${ teacherMessageList2}" varStatus="status">
					<tr>
						<td><a href="${pageContext.request.contextPath }/teacher/replyMessage.jsp?id=${message.id}&name=${message.student.stuName}&replyerID=${teacher.tchNO}">${message.title}</a></td>
						<td>${message.parent.parName}</td>
					</tr>					
				</c:forEach>
			</table>
			<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
        </div>
    </div>
</body>
</html>