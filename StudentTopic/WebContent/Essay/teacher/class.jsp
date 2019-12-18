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
				background:url(../img/BG4.jpg) repeat;
			}

			</style>
	</head>
	<body>
		<div>
			<table class="table table-bordered table-hover">
				<thred>
					<tr>
						<th>年级</th>
						<th>课程</th>
						<th>分组名</th>
						<th>组长</th>
						<th>提交状态</th>
						<th>操作</th>
					</tr>
				</thred>
		        <tbody>
		        <c:forEach var="item" items="${sessionScope.sub }">
		        	<tr>
			
			    	<td>${item.course_grade}</td>
			    	<td>${item.course_name}</td>
			    	<td>${item.team_name}</td>
			    	<td>${item.STU_NAME}</td>
			    	<td>${item.team_report_status}</td>
			    	<td>
			    		<a href="/StudentTopic/ListFileServlet?stu_id=${item.stu_id}">下载 </a>
			    	</td>
			    	</tr>
		        </c:forEach>
			    
			</tbody>
		</table>
	</div>
	<div align="center">
	<a href="/StudentTopic/DownloadServlet"><button >导出课程设计选题清单</button> </a>
	</div>
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
</html>