	<%@page import="com.entity.Reply"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.ReplyBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
			String id=request.getParameter("id");
			ReplyBean replyBean=new ReplyBean();
			List<Reply> replyList=replyBean.replyList(id);
			request.setAttribute("replyList", replyList);
			int i=2;
	%>
	<c:forEach var="reply" items="${replyList}" varStatus="status">
			<tr>
				<td><%=i++ %>楼</td>
			</tr>
			<tr>
					<td>回复内容</td>
					<td>${reply.content}</td>
			</tr>
	</c:forEach>
	<tr>
			<td></td>
			<td>-----------------------------------------------</td>
	</tr>