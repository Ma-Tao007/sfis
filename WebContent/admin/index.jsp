<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台主页</title>
<link href="images/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="javascript/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//setMenuHeight
	$('.menu').height($(window).height()-51-27-26-5);
	$('.sidebar').height($(window).height()-51-27-26-5);
	$('.page').height($(window).height()-51-27-26-5);
	$('.page iframe').width($(window).width()-15-168);
	
	//menu on and off
	$('.btn').click(function(){
		$('.menu').toggle();
		
		if($(".menu").is(":hidden")){
			$('.page iframe').width($(window).width()-15+5);
			}else{
			$('.page iframe').width($(window).width()-15-168);
				}
		});
		
	//
	$('.subMenu a[href="#"]').click(function(){
		$(this).next('ul').toggle();
		return false;
		});
})
</script>


</head>

<body style="overflow-y:hidden">
<div id="wrap">
	<div id="header">
    <div class="logo fleft"></div>
    <div class="nav fleft">
         <h1> 欢迎您：${admin.adminName}管理员</h1>
    </div>
    <a class="logout fright" href="adminLogout"> </a>
    <div class="clear"></div>
    <div class="subnav">
    	<div class="subnavLeft fleft"></div>
        <div class="fleft"></div>
        <div class="subnavRight fright"></div>
    </div>
    </div><!--#header -->
    <div id="content">
    <div class="space"></div>
    <div class="menu fleft">
    	<ul>
        	<li class="subMenuTitle"><h1>管理菜单</h1></li>
            <li class="subMenu"><a href="#">学生管理</a>
            	<ul>
            		<li><a href="addStudent.jsp" target="right">学生录入</a></li>
                	<li><a href="studentList.jsp" target="right">学生列表</a></li>
                </ul>
            </li>
           
            <li class="subMenu"><a href="#">家长管理</a>
            	<ul>
                	<li><a href="parentList.jsp" target="right">家长列表</a></li>
                </ul>
            </li>
            
            <li class="subMenu"><a href="#">教师管理</a>
            	<ul>
                	<li><a href="addTeacher.jsp" target="right">教师录入</a></li>
                    <li><a href="teacherList.jsp" target="right">教师列表</a></li>
                </ul>
            </li>
            
             <li class="subMenu"><a href="#">留言管理</a>
            	<ul>
                    <li><a href="messageList.jsp" target="right">留言列表</a></li>
                </ul>
            </li>
            
            
              <li class="subMenu"><a href="#">回复管理</a>
            	<ul>
                    <li><a href="replyList.jsp" target="right">回复列表</a></li>
                </ul>
            </li>
            <li class="subMenu"><a href="#">管理员管理</a>
            	<ul>
                	<li><a href="addAdmin.jsp" target="right">添加管理员</a></li>
                    <li><a href="adminList.jsp" target="right">管理员列表</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <div class="sidebar fleft"><div class="btn"></div></div>
    <div class="page">
    <iframe width="100%" scrolling="auto" height="100%" frameborder="false" allowtransparency="true" style="border: medium none;" src="main.html" id="rightMain" name="right"></iframe>
    </div>
    </div><!--#content -->
    <div class="clear"></div>
    <div id="footer"><p>老鱼的故事<span style="color:#FF6600">v1.0版本</span>　丨网站所有：老鱼的故事</p></div><!--#footer -->
   
    
</div><!--#wrap -->
</body>
</html>
