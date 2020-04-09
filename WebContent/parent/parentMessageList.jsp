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
<title>${parent.parName}发的留言</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
			<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>
			<table class="twidth" cellpadding=0 cellspacing=10 align=center  >
			<%
					String tel=request.getParameter("tel");
					MessageBean messageBean=new MessageBean();
					List<Message> parentMessageList=messageBean.parentMessageList(tel);
					request.setAttribute("parentMessageList", parentMessageList);
			%>
				<tr>
					<td>留言标题</td>
					<td>留言对象</td>
				</tr>
				<c:forEach var="message" items="${ parentMessageList}" varStatus="status">
					<tr>
						<td><a href="${pageContext.request.contextPath }/parent/replyMessage.jsp?role=${parent.role}&id=${message.id}&name=${message.teacher.tchName}&replyerID=${parent.tel}">${message.title}</a></td>
						<td>${message.teacher.tchName}</td>
					</tr>					
				</c:forEach>
			</table>
			<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
        </div>
    </div>
</body>

</body>
</html>