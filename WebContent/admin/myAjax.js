var xmlHttpRequest;

function create()
{
	try
	{
		// 非IE
		xmlHttpRequest = new XMLHttpRequest();
	}
	catch(e)
	{
		// IE
		try
		{
			// IE 方式一
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e)
		{
			try
			{
				// IE 方式二
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e)
			{
				alert("您的浏览器不支持AJAX！");
				return false;
			}
		}
	}
}

/**
 * 发送Ajax请求
 * @param url 请求地址
 * @param callBack 回调函数名
 */
function sendRequest(method, url, data, callBack)
{
	create();
	xmlHttpRequest.open(method, url, true); // open("GET"|"POST", 请求地址, 是否异步 )
	xmlHttpRequest.onreadystatechange = callBack; // 配置处理响应结果方法 
	if(method == "POST")
		xmlHttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded"); // post提交，模拟表单
	xmlHttpRequest.send(data); // send() 发送请求 
}

function get(url, callBack)
{
	sendRequest("GET", url, null, callBack);
}

function post(url, data, callBack)
{
	sendRequest("POST", url, data, callBack);
}