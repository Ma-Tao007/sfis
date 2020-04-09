<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<form action="findPassword" method="post">
<table class="twidth" cellpadding=0 cellspacing=0 align=center>
<tr align="left" valign=top >
<td width=200>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td class="lframe-m-left"></td>
	<td class="lframe-m-mid">
	
		<table width=95% align=center cellpadding=0 cellspacing=0 border=0>

		
		<tr><td valign=top align=center >
			<table width=100% cellpadding=3>
			<tr><td align=center>
			角色：<select name="loginRole">
				<option value="teacher">教师</option>
				<option value="student">学生</option>
				<option value="parent">家长</option>
				</select>
			</td></tr>
			<tr><td align=center>
			&nbsp;&nbsp;&nbsp;&nbsp;账号名：<input type=text class=inputbg name="id" size=15 maxlength=50>
			</td></tr>
			<tr><td align=center>
			<input type=submit value="找回密码" >&nbsp;         
			</td></tr>
			</table>
		</td></tr>
		</table>
	
	</td>
	<td class="lframe-m-right"></td>
	</tr>
	</table>
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