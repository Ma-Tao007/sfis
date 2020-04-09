<%@page import="java.util.List"%>
<%@page import="com.entity.Reply"%>
<%@page import="com.bean.ReplyBean"%>
<%@page import="com.entity.Message"%>
<%@page import="com.bean.MessageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
		    String senderID=request.getParameter("senderID");
			String receiverID=request.getParameter("receiverID");
			String role=request.getParameter("role");
			request.setAttribute("role", role);
    %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回复</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<form action="${pageContext.request.contextPath }/replyMessage" method="post">
<table class="twidth" cellpadding=0 cellspacing=10 align=center >
<%
	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String replyerID=request.getParameter("replyerID");
	MessageBean messageBean=new MessageBean();
	Message message=messageBean.load(id);
	request.setAttribute("message", message);
%>
	<tr>
		<td>
			<c:if test="${requestScope.role=='student' }">
				<a href="${pageContext.request.contextPath }/student/main.jsp">学生首页</a>
			</c:if>
			<c:if test="${role=='teacher' }">
				<a href="${pageContext.request.contextPath }/teacher/main.jsp">教师首页</a>
			</c:if>
			<c:if test="${role=='parent' }">
				<a href="${pageContext.request.contextPath }/parent/main.jsp">家长首页</a>
			</c:if>
		</td>
	</tr>
	<tr>
			<td>1楼</td>
	</tr>
	<tr>
			<td>标题</td>
			<td>${message.title }</td>
	</tr>
	<tr>
			<td>内容</td>
			<td>${message.content }</td>
	</tr>
<!-- 	<tr> -->
<!-- 			<td>作者</td> -->
<%-- 			<td><%=name %></td> --%>
<!-- 	</tr> -->
	<tr>
			<td></td>
			<td>-----------------------------------------------</td>
	</tr>
	<jsp:include page="replyContent.jsp"></jsp:include>
<%-- 	<% --%>
<!-- 			ReplyBean replyBean=new ReplyBean(); -->
<!-- 			List<Reply> replyList=replyBean.replyList(id); -->
<!-- 			request.setAttribute("replyList", replyList); -->
<!-- 			int i=2; -->
<!-- 	%> -->
<%-- 	<c:forEach var="reply" items="${replyList}" varStatus="status"> --%>
<!-- 			<tr> -->
<%-- 				<td><%=i++ %>楼</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 					<td>回复内容</td> -->
<%-- 					<td>${reply.content}</td> --%>
<!-- 			</tr> -->
<%-- 	</c:forEach> --%>
<!-- 	<tr> -->
<!-- 			<td></td> -->
<!-- 			<td>-----------------------------------------------</td> -->
<!-- 	</tr> -->
	<tr>
		<td>回复内容</td>
		<td><textarea rows="10" cols="40" name="content"></textarea></td>
	</tr>
	<tr>
		<td><input type="hidden" name="role" value=${requestScope.role } /></td> 
		<td><input type="hidden" name="messageID" value=<%=id %> /></td>
		<td><input type="hidden" name="name" value=<%=name %>/></td>
		<td><input type="hidden" name="replyerID" value=<%=replyerID %> /></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="回复"/>&nbsp;&nbsp;<input type="reset" value="重置" /></td>
	</tr>
</table>
</form>

<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="admin/login.html"><span style="color:#FF6600">后台登录</span></a>  
        </div>
    </div>
</table>
</body>
</html>