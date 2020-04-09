<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<form action="login" method="post">
<table width=95% align=center cellpadding=0 cellspacing=0 border=0>

		
		<tr><td valign=top align=center >
			<table width=100% cellpadding=3>
			<tr><td>${messageId}</td></tr>
			<tr><td align=center>
			账号名：<input type=text class=inputbg name="userName" size=15 maxlength=50>
			</td></tr><tr><td align=center>
			密　码：<input type=password class=inputbg name="password" size=15 maxlength=50><br>
			</td></tr><tr><td align=center>
			登录角色：<select name="loginRole">
				<option value="teacher">教师</option>
				<option value="student">学生</option>
				<option value="parent">家长</option>
				</select>
			</td></tr><tr><td align=center>
			<input type=submit value="登陆" onClick="return checkForm();">&nbsp;         
            <input type=button onClick="window.location='student/activate.jsp'" value="激活/注册">                       
			</td></tr>
			<tr><td align=center>
            <a href="http://www.richiecn.com/" target=_blank>忘记密码</a>                          
			</td></tr>
			</table>
		</td></tr>
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