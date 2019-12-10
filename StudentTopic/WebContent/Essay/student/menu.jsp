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
			
			#admin_menu
			{
				height: 80px;
				background-color: #FAFBFC;
				padding-top: 30px;
				
			}
			li{
				font-size: 18px;
				font-weight: bold;
			}
			body{
			}
			
			span{
				color: #008080;
			}

		</style>
	</head>
	<body>
		<div id="admin_menu">
			<ul class="nav nav-tabs">
  				<li><a href="content_center.html"  target="center"  style="margin-left: 180px;">Home</a></li>
  				<li><a href="/StudentTopic/StudentSelectServlet" target="center" >可选的题目</a></li>
 				<li><a href="/StudentTopic/TopicSelectedServlet?stu_id=${sessionScope.login_stu.stu_id}" target="center" >选题情况</a></li>
 				<li><a href="upload_topic.jsp?stu_id=${sessionScope.login_stu.stu_id}&stu_major=${sessionScope.login_stu.stu_major}&stu_grade=${sessionScope.login_stu.stu_grade}&stu_class=${sessionScope.login_stu.stu_class}" target="center" >上传文档报告</a></li>
			</ul>
		</div>

	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>