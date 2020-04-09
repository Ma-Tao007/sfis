<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生给教师留言</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<form action="" method="post">
<table class="twidth" cellpadding=0 cellspacing=10 align=center >
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" style="width:260px"> </td>
	</tr>
	<tr>
		<td>内容</td>
		<td><textarea rows="10" cols="40" name="content"></textarea></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="留言"/>&nbsp;&nbsp;<input type="reset" value="重置" /></td>
	</tr>
</table>
</form>

<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="admin/login.html"><span style="color:#FF6600">后台登录</span></a>  
        </div>
    </div>
</body>
</html>