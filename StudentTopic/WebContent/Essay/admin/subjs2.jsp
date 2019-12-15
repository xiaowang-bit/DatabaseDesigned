<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>待录取题目 </title>
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
			<script type="text/javascript"> 
			function setsubmit() 
			{ 
				if(mylink.value == 0) 
				window.location='/StudentTopic/SubjectSelectServlet'; 
				if(mylink.value == 1) 
				window.location='/StudentTopic/Subject1SelectServlet'; 
				if(mylink.value == 2) 
				window.location='#'; 
			} 
		</script> 
	</head>

	<body>
		<div>
			<table class="table table-bordered table-hover">
				<thred>
					<tr>
						<select name="mylink" id="mylink"> 
							<OPTION value="0">选题通过</OPTION> 
							<OPTION value="1">选题未审核</OPTION> 
							<OPTION value="2">选题不通过</OPTION>  
						</select> 
						<input type="button"  class="btn btn-primary" id="btn" value="确定" onclick="setsubmit(this)" /> 
						
					</tr>
					<tr></tr>
					<tr>
						<th>题目编号</th>
						<th>题目名字</th>
						<th>教师名字</th>
						<th>学生名字</th>
						<th>组长标记</th>
						<th>录取状态</th>
					</tr>
				</thred>
		        <tbody>
		        	<c:forEach var="item" items="${sessionScope.subjs2 }">
			        	<tr>
				    	<td>${item.st_topic_id }</td>
				    	<td>${item.topic_name }</td>
				    	<td>${item.tea_name }</td>
				    	<td>${item.stu_name  }</td>
				    	<td>${item.st_stu_check  }</td>
				    	<td>${item.st_checked  }</td>
				    	</tr>
		        	</c:forEach>
				</tbody>
			</table>
		</div>
	
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
</html>