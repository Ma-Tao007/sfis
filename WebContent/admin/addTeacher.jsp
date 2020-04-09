<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>录入教师信息</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript" src="myAjax.js"></script>
<script type="text/javascript">
			var i = 1;
		
			function addRow()
			{
				var myTable = document.getElementById("myTable");
				
				var row = document.createElement("tr");
				
				var col1 = document.createElement("td");
				var col2 = document.createElement("td");
				var col3 = document.createElement("td");
				var col4 = document.createElement("td");
				
				var cell1 = document.createElement("input");
				cell1.setAttribute("value", i++);
				cell1.setAttribute("name", "id");
				var cell2 = document.createElement("input");
				cell2.setAttribute("name", "tchNO");
				var cell3 = document.createElement("input");
				cell3.setAttribute("name", "tchName");
				var cell4 = document.createElement("a");
				// cell4.setAttribute("href", "javascript:deleteRow();");
				cell4.setAttribute("href", "#");
				cell4.onclick = deleteRow;
				
				var value = document.createTextNode("X");
				cell4.appendChild(value);
				
				col1.appendChild(cell1);
				col2.appendChild(cell2);
				col3.appendChild(cell3);
				col4.appendChild(cell4);
				
				row.appendChild(col1);
				row.appendChild(col2);
				row.appendChild(col3);
				row.appendChild(col4);
				
				myTable.appendChild(row);
			}
		
			function deleteRow()
			{
				// 得到指定行 
				var deleteRow = this.parentNode.parentNode;
				
				// 执行删除行 
				var myTable = document.getElementById("myTable");
				myTable.removeChild(deleteRow);
			}
			
			function submitData()
			{
				var ids = document.getElementsByName("id");
				var titles = document.getElementsByName("tchNO");
				var authors = document.getElementsByName("tchName");
				
				var url = "addTeacher";
				var data = "";
				for(var i = 0; i < ids.length; i++)
				{
					data = data + "&id="+ids[i].value+"&tchNO="+titles[i].value+"&tchName="+authors[i].value;
				}
				data = data.substring(1, data.length);
				// alert(data);
				
				post(url, data);
			}
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
    <div class="pageTitle">后台——录入教师信息</div>
    <div class="pageColumn">
      <div class="pageButton"></div>
      <a href="javascript:addRow();">新增一行</a> &nbsp; <a href="javascript:submitData()">提交数据</a> <br/>
      <table id="myTable">
        <thead>
        <tr>
          <th width="150px">编号</th>
          <th width="150px">教师号</th>
          <th width="150px">教师姓名</th>
          <th width="150px">删除</th>
          </tr>
          </thead>
      </table>
    </div>
  </div><!-- #widget -->
</div>


</body>
</html>
