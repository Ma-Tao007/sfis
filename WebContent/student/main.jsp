<%@page import="com.entity.Student"%>
<%@page import="com.entity.Message"%>
<%@page import="com.bean.MessageBean"%>
<%@page import="com.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.TeacherBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生首页</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<table class="twidth" cellpadding=0 cellspacing=0 align=center>
<tr align="left" valign=top >
<td width=200>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td background="images/HE2.GIF"width="191" height="25">　&nbsp;&nbsp;&nbsp;           
      学 生 信 息</td>        
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td class="lframe-m-left"></td>
	<td class="lframe-m-mid">
	
		<table width=95% align=center cellpadding=0 cellspacing=0 border=0>

		<tr><td valign=top align=center >
			<table width=100% cellpadding=3 ><tr><td align=left>
			学号：${student.stuNO}
			</td></tr><tr><td align=left>
			姓名：${student.stuName}<br>
			</td></tr><tr><td align=left>
			邮箱：${student.stuEmail}
			
			</td></tr><tr><td align=right>
			<a href="${pageContext.request.contextPath }/student/studentMessageList.jsp?stuNO=${student.stuNO }">留言记录</a>                          
			</td></tr>
			<tr><td align=center>
			</td></tr>
			</table>
		</td></tr>
		</form>
		</table>
	
	</td>
	<td class="lframe-m-right"></td>
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0 >
	<tr>
	<td class="lframe-b-left"></td>
	<td class="lframe-b-mid">　</td>
	<td class="lframe-b-right"></td>
	</tr>
	</table>

	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td background="images/HE2.GIF" width="191" height="25">　&nbsp;&nbsp;&nbsp;           
      教师列表</td>          
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td class="lframe-m-left"></td>
	<%
     	TeacherBean teacherBean=new TeacherBean();
		Student student=(Student)session.getAttribute("student");
		String stuNO="";
		if(student.getStuNO()!=null)
		{
			stuNO=student.getStuNO(); 
			List<Teacher> teacherList=teacherBean.studentList();
			request.setAttribute("teacherList", teacherList);
		}
      %>
	<c:forEach var="teacher" items="${teacherList }" varStatus="status">
		<tr>
       		<td class="lframe-m-mid" style="text-align: center;" width="50px">姓名：</td>
       		<td class="lframe-m-mid" style="text-align: center;">${teacher.tchName}</td>
       		<td class="lframe-m-mid" style="text-align: center;"><a href="${pageContext.request.contextPath }/addMessage.jsp?role=${student.role}&senderID=${student.stuNO}&receiverID=${teacher.tchNO}">留言</a>
       </tr>
    </c:forEach>
                   
	<td class="lframe-m-right"></td>
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0 >
	<tr>
	<td class="lframe-b-left"></td>
	<td class="lframe-b-mid">　</td>
	<td class="lframe-b-right"></td>
	</tr>
	</table>
	
</td>
<td>

	<table width=100% cellspacing=0 cellpadding=0>
	<tr>
	<td width="559" height="25" background="images/HE1.GIF">           
      管理员留言：~!@#$%^&*()</td>                       
	</tr>
	</table>
    <table cellspacing=0 cellpadding=0 width=100%>
	<tr><td>
		<table id="dlAll" cellspacing="0" border="0" style="border-collapse:collapse;">
	<tr>
		<td valign="Top" >
				
				<table cellspacing=0 cellpadding=0 >
				<tr>
				<td class="mframe-b-left"></td>
				<td class="mframe-b-mid">　</td>
				<td class="mframe-b-right"></td>
				</tr>
				</table>
			</td>
	</tr>
</table>
	</td></tr>
	</table>
	
	<table cellspacing=0 cellpadding=0 width=100%>
	<tr><td>
		<table id="dlAll" cellspacing="0" border="0" style="border-collapse:collapse;">
	<tr>
		<td valign="Top" >
				<table width=450 cellspacing=0 cellpadding=0>
				<tr>
				<td width="450" background="images/HE1.gif" height="25">　&nbsp;&nbsp;&nbsp;&nbsp;          
                  教 师 留 言</td>         
				</tr>
				</table>
				<table width=100% cellspacing=0 cellpadding=0>
				<tr>
				<td class="mframe-m-left"></td>
				<td class="mframe-m-mid">
					<table width=450 cellpadding=0 cellspacing=0 border=0 >
						<tr>
							<th>留言内容</th>
							<th align="center">留言人</th>
						</tr>
						<%
							MessageBean messageBean=new MessageBean();
							List<Message> messagetList=messageBean.messageList2(stuNO);
							request.setAttribute("messagetList", messagetList);
     					 %>
     					 <c:forEach var="message" items="${messagetList }" varStatus="status">
						<tr><td width="300"  class="lframe-m-mid">
         				<input type="hidden" name="id" value="${message.id}"/>
        				<c:set value="0" var="i" scope="request" />
        				<c:if test="${message.remark==0 }">
                        	<a href="${pageContext.request.contextPath }/replyMessage.jsp?role=${student.role}&id=${message.id}&name=${message.teacher.tchName}&replyerID=${student.stuNO}">${message.title}</a>
                        	&nbsp;<label style="color: red">未读</label>
                        </c:if>
                        <c:if test="${message.remark==1 }">
                        	<a href="${pageContext.request.contextPath }/replyMessage.jsp?role=${student.role}&id=${message.id}&name=${message.teacher.tchName}&replyerID=${student.stuNO}">${message.title}</a>
                        </c:if>
						</td><td width=120 align=center  class="lframe-m-mid">
                        <font color="#808080">${message.teacher.tchName}</font>
						</td></tr>
						</c:forEach>
						
					</table>
				</td>
				<td class="mframe-m-right"></td>
				</tr>
				</table>
				<table width=100% cellspacing=0 cellpadding=0 >
				<tr>
				<td class="mframe-b-left"></td>
				<td class="mframe-b-mid">　</td>
				<td class="mframe-b-right"></td>
				</tr>
				</table>
			</td>
	</tr>
</table>
	</td></tr>
	</table>
	
    
</td>
</tr>
</table>
<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
        </div>
    </div>

</body>