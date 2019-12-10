<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示所有老师 </title>
		<link rel="stylesheet" type="text/css"
			href="../bootstrap/css/bootstrap.min.css" />
			<style type="text/css">
				*{
				font-size: 14px!important;
			}
			body{
				background:url(../img/BG.jpg) repeat;
			}

			</style>
	</head>
	<body>
		<div>
			<table class="table table-bordered table-hover">
				<thred>
					<tr>
						<th>年级</th>
						<th>专业</th>
						<th>班级</th>
						<th>课程</th>
						<th>分组编号</th>
						<th>分组名</th>
						<th>操作</th>
					</tr>
				</thred>
		        <tbody>
		        <c:forEach var="item" items="${sessionScope.sub }">
		        	<tr>
			
			    	<td>${item.stu_grade}</td>
			    	<td>${item.stu_major}</td>
			    	<td>${item.stu_class}</td>
			    	<td>${item.course_name}</td>
			    	<td>${item.st_team_id}</td>
			    	<td>${item.team_name}</td>
			    	<td>
			    		<a href="/StudentTopic/ListFileServlet?stu_id=${item.stu_id}">下载 </a>
			    	</td>
			    	</tr>
		        </c:forEach>
			    
			</tbody>
		</table>
	</div>
		
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
</html>