<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学生列表</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('tbody tr:odd').addClass("trLight");
		
		$(".select-all").click(function(){
			if($(this).attr("checked")){
				$(".checkBox input[type=checkbox]").each(function(){
					$(this).attr("checked", true);  
					});
				}else{
					$(".checkBox input[type=checkbox]").each(function(){
					$(this).attr("checked", false);  
					});
				}
			});
		
		})
</script>
<style type="text/css">
body {
	background:#FFF
}
</style>
</head>

<body>
<div id="contentWrap">
	<!--表格控件 -->
  <div id="widget table-widget">
    <div class="pageTitle">后台——学生列表</div>
    <div class="pageColumn">
      <div class="pageButton"></div>
      <%
     	 StudentBean studentBean=new StudentBean();
		
		List<Student> studentList=studentBean.studentList();
		request.setAttribute("studentList", studentList);
      %>
      <form action="deleteStudent" method="post">
      <table>
        <thead>
        <th width="100" style="text-align: left"><input class="select-all" name="" type="checkbox" value="" /><input type="submit" value="删除所选" /></th>
          <th width="">学生学号</th>
          <th width="">学生姓名</th>
          <th width="">激活状态</th>
          <th width="10%">操作</th>
            </thead>
        <tbody>
        <c:forEach var="student" items="${studentList }" varStatus="status">
          <tr>
            <td class="checkBox"><input name="id"  id="id" type="checkbox" value="${student.stuNO}" /></td>
            <td>${student.stuNO}</td>
            <td>${student.stuName}</td>
            <c:if test="${student.remark=='1'}">
            <td>激活</td>
            </c:if>
            <c:if test="${student.remark=='0'}">
            <td>未激活</td>
            </c:if>
            <td>　
            <a href="deleteStudent?id=${student.stuNO}"><img src="images/icon/del.png" width="16" height="16"  /></a></td>
          </tr>
          </c:forEach>
          
          <tr class=" ">
            <td colspan="7" class="checkBox"></td>
          </tr>
          
        </tbody>
      </table>
      </form>
    </div>
  </div><!-- #widget -->
</div>


</body>
</html>
