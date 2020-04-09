<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>教师激活页面</title>
		<link rel="stylesheet" type="text/css" href="register.css"/>
		<script type="text/javascript" src="../teacher/register.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<link type="text/css" rel="stylesheet" href="css/login.css">
		<script type="text/javascript">
			var i = 0;
			function changeCode()
			{
				var randomCode = document.getElementById("randomCode");
				randomCode.src = "randomCode?"+(i++); // 必须赋不同的地址
			}
			function activate()
			{
				var id= document.getElementById("tchNO").value;
				$.get("activate?tchNO="+id,null,activateBack);				
			}
			
			function activateBack(data)
			{
				$("#inputtchNO").html(data);
			}
			
			$(function(){
				$("#mySelect").change(function(){
					$("#forms").children().hide();
					$("#"+$(this).val()).show();
				});
			});
		</script>
	</head>
	
	<body>
	<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>
	<div id="center">
		<table>
				<tr>
					<td width="200px"><a href="../student/activate.jsp">学生激活页面</a></td>
					<td width="200px"><h1>教师激活页面</h1></td>
					<td width="200px"><a href="../parent/activate.jsp">家长注册页面</a></td>
				</tr>
			</table>
		
			<div id="teacher" >
				<form action="teacherActivate.jsp" method="post" onsubmit="return validate();">
					<div class="textInput">
						&nbsp;&nbsp;教师号<input type="text" name="tchNO" id="tchNO" onfocus="inputTtchNO();" onblur="activate();"/><label style="color: red" id="inputtchNO"></label>
					</div>
					
					<div class="textInput">
						&nbsp;&nbsp;&nbsp;&nbsp;邮箱<input type="text" name="email" id="email" onfocus="inputemail();" onblur="inputmail();"/><label id="inputmail"></label>
					</div>
						
					<div class="textInput">
						&nbsp;&nbsp;&nbsp;&nbsp;密码<input type="password" name="password" id="password" onfocus="passwordfocus();" onblur="passwordblur();"/><label id="myPassword"></label>
					</div>
					
					<div class="textInput">
						确认密码<input type="password" name="cpassword" id="cpassword" onfocus="cpasswordfocus();" onblur="cpasswordblur();" /><label id="confirmpassword"></label>
					</div>
					
<!-- 					<div class="check"> -->
<!-- 						&nbsp;&nbsp;验证码<input type="text"/>&nbsp; -->
<!-- 						<img id="randomCode" src="randomCode" /> <a href="javascript:changeCode();">看不清？换一张</a> <br/> -->
<!-- 					</div> -->
					
					<div id="center">
						<input type="submit" name="register" value="激活" />
					</div>
				</form>
			</div>
		</div>
	<br/>
	<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="admin/login.html"><span style="color:#FF6600">后台登录</span></a>  
        </div>
    </div>
	</body>
</html>