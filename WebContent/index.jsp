<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>家校互动系统</title>
<meta http-equiv="Content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>

<body>

<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>

<form action="login" method="post">
<table class="twidth" cellpadding=0 cellspacing=0 align=center>
<tr align="left" valign=top >
<td width=200>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td background="images/HE1.gif"width="191" height="25">　&nbsp;&nbsp;&nbsp;           
      用 户 登 录</td>        
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td class="lframe-m-left"></td>
	<td class="lframe-m-mid">
	
		<table width=95% align=center cellpadding=0 cellspacing=0 border=0>

		
		<tr><td valign=top align=center >
			<table width=100% cellpadding=3><tr><td align=center>
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
            <a href="${pageContext.request.contextPath }/findPassword.jsp" target=_blank>忘记密码</a>                          
			</td></tr>
			</table>
		</td></tr>
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
	<td background="images/HE1.gif"width="191" height="25">　&nbsp;&nbsp;&nbsp;           
      关 于 学 校</td>          
	</tr>
	</table>
	<table width=95% cellspacing=0 cellpadding=0>
	<tr>
	<td class="lframe-m-left"></td>
	<td class="lframe-m-mid">
   			&nbsp;&nbsp;&nbsp;&nbsp;淮阴师范学院是周恩来总理故乡的一所省属本科院校，坐落在风光秀美、人文荟萃的国家历史文化名城――江苏省淮安市。学校有50余年的高等教育办学历史。有王营、交通路两个校区，校园1800余亩，校舍55万平方米；有17个二级学院和1个民办二级学院（文通学院），57个普高本科专业，全日制普高在校生2万余人，在籍成教生6000余人。
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.hytc.edu.cn" target="blanket"><span style="color:#FF6600">了解更多</span></a></td>
		
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
	<td width="559" height="25" background="images/HE1.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                
      模 块 进 入</td>                       
	</tr>
	</table>
    <table width="100%" cellspacing="0" cellpadding="0">
    <div class="login">
      <div class="login_con">
		  <a href="#" title="家长模块" class="xxgly">学生模块</a> 
		  <a href="#" title="教师模块" class="xxls">教师模块</a> 
		  <a href="#"title="学生模块" class="jiaz">家长模块</a>    
        	</div>		  
    </div>
	</table>
	
    
</td>
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

