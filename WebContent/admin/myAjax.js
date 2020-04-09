var xmlHttpRequest;

function create()
{
	try
	{
		// ��IE
		xmlHttpRequest = new XMLHttpRequest();
	}
	catch(e)
	{
		// IE
		try
		{
			// IE ��ʽһ
			xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch(e)
		{
			try
			{
				// IE ��ʽ��
				xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch(e)
			{
				alert("�����������֧��AJAX��");
				return false;
			}
		}
	}
}

/**
 * ����Ajax����
 * @param url �����ַ
 * @param callBack �ص�������
 */
function sendRequest(method, url, data, callBack)
{
	create();
	xmlHttpRequest.open(method, url, true); // open("GET"|"POST", �����ַ, �Ƿ��첽 )
	xmlHttpRequest.onreadystatechange = callBack; // ���ô�����Ӧ������� 
	if(method == "POST")
		xmlHttpRequest.setRequestHeader("content-type", "application/x-www-form-urlencoded"); // post�ύ��ģ���
	xmlHttpRequest.send(data); // send() �������� 
}

function get(url, callBack)
{
	sendRequest("GET", url, null, callBack);
}

function post(url, data, callBack)
{
	sendRequest("POST", url, data, callBack);
}