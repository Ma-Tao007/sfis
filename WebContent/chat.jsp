<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css">
<link type="text/css" rel="stylesheet" href="css/login.css">
<script type="text/javascript" src="jquery-1.7.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.get("loadMessageList", null, loadCallBack, "text");
	
	$("#send").click(function(){
		$.post("sendMessage", "messageContent="+$("#content").val(), function(data){
			if(data != "success")
			{
				window.location.href = "login.jsp";
			}
			$("#chatlog").animate({scrollTop: $("#chatLog")[0].scrollHeight}, 200);

			$("#content").val("");
			$("#content").select();
		}, "text");
	});
});

function loadCallBack(data)
{
	$("#chatLog").append(data);
	$("#chatLog").animate({scrollTop: $("#chatLog")[0].scrollHeight}, 200);
	$.get("loadMessageList", null, loadCallBack, "text");
}

$(document).ready(load());
function load()
{
	$.get("loadUserList", null, loadUserCallBack, "text");
	setTimeout("load()", 1000);
};
var users=null;
function loadUserCallBack(data)
{
	if(data!=users)
	{
		users=data;
		$("#userList").html(data);
	}
}


$(document).ready(update());
function update()
{
	$.get("updatePrivateMessage", null, loadUpdateCallBack, "text");
};
function loadUpdateCallBack(data)
{
	if(data!="send privateMessage success")
	{
		document.getElementById(data).style.color="#FF0000";
	}
	$.get("updatePrivateMessage", null, loadUpdateCallBack, "text");
};




function getValue(e)
{
	window.open("privateChat.jsp?chater="+e.value+"");
}


</script>

<title>${userName }欢迎进入老鱼聊天室</title>
</head>
<body>
<div class="top_box"><div class="top"><div class="login_logo"></div></div></div>
<div class="main_box">
	<div class="main">
		<div id="main_left">
		<label>${userName }</label><a href="logout">注销</a><br/>
			<label>老鱼聊天室</label><br/>
<!-- 			<textarea cols="70"rows="20" id="messageList" readonly="readonly"></textarea> -->
			<div id="chatLog"></div>
			
			<div id="contentDiv">
				<textarea cols="70"rows="10"  id="content"></textarea><br/>
			</div>
			<div id="sendDiv">
				<input type="button" value="发送" id="send"/>
			</div>
		</div>
		<div id="main_right">
			<label>在线用户</label><br/>
			<select  id="userList" multiple="multiple" >
			</select>
		</div>
		
	</div>
</div>
<div class="footer_box">
        <div class="footer">
            <p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事
            &nbsp;&nbsp;&nbsp;&nbsp;<a href="admin/login.html"><span style="color:#FF6600">后台登录</span></a>  
        </div>
    </div>
</body>
</html>