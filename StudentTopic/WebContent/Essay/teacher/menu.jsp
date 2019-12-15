<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
	<head>
		<title></title>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css"/>
		<style type="text/css">
		*{
				margin: 0px;
				padding: 0px;
			}
			
			#teacher_menu
			{
				height: 80px;
				background-color:  #696969;
				padding-top: 30px;
			}
			li{
				font-size: 18px;
				font-weight: bold;
				background:#1E1E1E;
			}
			body{
			}
			
			span{
		
				color: #008080;
			}

		</style>
	</head>
	<body>
		<div id="teacher_menu">
			<ul class="nav nav-tabs">
  				<li><a href="content_center.html"  target="center" style="margin-left: 180px;">Home</a></li>
  				<li><a href="/StudentTopic/TopicSelectTeacherServlet?tea_id=${sessionScope.login_tea.tea_id}"  target="center">选题学生管理</a></li>
 				<li><a href="/StudentTopic/TopicToTeacherServlet?tea_id=${sessionScope.login_tea.tea_id}" target="center"  >题目管理</a></li>
 				<li><a href="/StudentTopic/ListClassServlet?tea_id=${sessionScope.login_tea.tea_id}" target="center" style="margin-right: 1060px;" >下载报告</a></li>
			</ul>
		</div>
		
		
		
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>