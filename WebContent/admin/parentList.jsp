<%@page import="com.entity.Parent"%>
<%@page import="com.bean.ParentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>家长列表</title>
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
    <div class="pageTitle">后台——家长列表</div>
    <div class="pageColumn">
      <div class="pageButton"></div>
      <%
		ParentBean parentBean=new ParentBean();
		List<Parent> parentList=parentBean.parentList();
		request.setAttribute("parentList", parentList);
      %>
      <table>
        <thead>
        <th width="25"><input class="select-all" name="" type="checkbox" value="" /></th>
          <th width="">家长姓名</th>
          <th width="">联系方式</th>
          <th width="">学生学号</th>
          <th width="">学生姓名</th>
          <th width="10%">操作</th>
            </thead>
        <tbody>
         <c:forEach var="parent" items="${parentList }" varStatus="status">
          <tr>
            <td class="checkBox"><input name="id"  id="id" type="checkbox" value="${student.stuNO}" /></td>
            <td>${parent.parName}</td>
            <td>${parent.tel}</td>
            <td>${parent.student.stuNO}</td>
            <td>${parent.student.stuName}</td>
            <td>　
            <a href="#"><img src="images/icon/del.png" width="16" height="16"  /></a></td>
          </tr>
          </c:forEach>
          
          
        </tbody>
      </table>
    </div>
  </div><!-- #widget -->
</div>


</body>
</html>
