function validate()
{
	var tchNO=document.getElementById("tchNO").value;
	var email=document.getElementById("email").value;
	var password=document.getElementById("password").value;
	var gpassword=document.getElementById("myPassword");
	var p=document.getElementById("password");
	if(tchNO.length==0)
	{
		document.getElementById("inputtchNO").innerHTML="请填写教师号";
		document.getElementById("inputtchNO").style.borderColor="red";
		return false;
	}
	if(email.length==0 )
	{
		document.getElementById("inputmail").innerHTML="请填写邮箱";
		return false;
	}
	var myreg = /(\S)+[@]{1}(\S)+[.]{1}(\w)+/;
	if(!myreg.test(email))
		{
			document.getElementById("inputmail").innerHTML="邮箱格式不正确";
			document.getElementById("email").style.borderColor="red";
			return false;
		}
	if(password.length==0)
	{
		gpassword.innerHTML="请填写密码";
		p.style.borderColor="red";
		return false;
	}
	if(password.length<6 ||password.length>14 )
		{
			gpassword.innerHTML="密码最少6个字符，最长不得超过14个字符";
			p.style.borderColor="red";
			return false;
		}
	var cpassword=document.getElementById("cpassword").value;
	var gconfirmpassword=document.getElementById("confirmpassword");
	if(cpassword.length==0)
	{
		gconfirmpassword.innerHTML="请输入确认密码";
		document.getElementById("cpassword").style.borderColor="red";
		return false;
	}
	if(cpassword!=password)
		{
			gconfirmpassword.innerHTML="密码与确认密码不一致";
			return false;
		}
	
	return true;
}
function inputTtchNO()
{
	document.getElementById("inputtchNO").innerHTML="请输入教师号，用于验证教师是否存在";
	document.getElementById("tchNO").style.borderColor="red";
}
function inputtchNO()
{
	var tchNO=document.getElementById("tchNO");
	var inputtchNO=document.getElementById("inputtchNO");
	if(id.value.length==0)
	{
		inputtchNO.innerHTML="请填写教师号";
		tchNO.style.borderColor="red";
	}
	else
	{
		inputeId.innerHTML="";
		id.style.borderColor="";
	}
}
function inputemail()
{
		document.getElementById("inputmail").innerHTML="请输入常用邮箱,通过验证后可用于登录和找回密码";
		document.getElementById("email").style.borderColor="";
}
function inputmail()
{
	var email=document.getElementById("email");
	var inputemail=document.getElementById("inputmail");
	var myreg = /(\S)+[@]{1}(\S)+[.]{1}(\w)+/;
	if(email.value.length==0)
	{
		inputemail.innerHTML="请填写邮箱";
		email.style.borderColor="red";
	}
	else if(!myreg.test(email.value))
		{
			inputemail.innerHTML="邮箱格式不正确";
			email.style.borderColor="red";
		}
		else
			{
			inputemail.innerHTML="";
			email.style.borderColor="";
			}
}

function passwordfocus()
{
	
		document.getElementById("myPassword").innerHTML="密码长度6到14位，字母区分大小写";
		document.getElementById("password").style.borderColor="";
}
function passwordblur()
{
	var password=document.getElementById("password");
	var myPassword=document.getElementById("myPassword");
	if(password.value.length==0)
	{
		myPassword.innerHTML="请填写密码";
		password.style.borderColor="red";
	}
	else if(password.value.length<6 ||password.value.length>14 )
		{
			myPassword.innerHTML="密码最少6个字符，最长不得超过14个字符";
			password.style.borderColor="red";
		}
		else
			{
			myPassword.innerHTML="";
			password.style.borderColor="";
			}
}
function cpasswordfocus()
{
	
		document.getElementById("confirmpassword").innerHTML="";
		document.getElementById("cpassword").style.borderColor="";
}
function cpasswordblur()
{
	var cpassword=document.getElementById("cpassword");
	var password=document.getElementById("password").value;
	var confirmpassword=document.getElementById("confirmpassword");
	if(cpassword.value.length==0)
	{
		confirmpassword.innerHTML="请输入确认密码";
		cpassword.style.borderColor="red";
	}
	else if(cpassword.value!=password)
		{
			confirmpassword.innerHTML="密码与确认密码不一致";
		}
}