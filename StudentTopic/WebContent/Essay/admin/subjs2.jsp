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
   			.mylink{
   			width:500px
   			height:40px
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
				<br/>
					<tr>
					<form name="form1" method="post" style="margin-left:10px"> 
						<select class="downtable" name="mylink" id="mylink"style="heigth:100px""> 
							<OPTION></OPTION> 
							<OPTION value="0">选题通过</OPTION> 
							<OPTION value="1">选题未审核</OPTION> 
							<OPTION value="2">选题不通过</OPTION>  
						</select> 
						</form>
						<input type="button"  class="btn btn-primary"  style="margin-left: 50px;"id="btn" value="确定" onclick="setsubmit(this)" /> 
						
					</tr>
					<br/><br/><br/>
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
		        	<c:forEach var="item" items="${sessionScope.subjs2.objectList }">
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
			<a href="/StudentTopic/Subject2SelectServlet?currentPage=1" style="margin-left: 195px;">首页</a>
			<a href="/StudentTopic/Subject2SelectServlet?currentPage=${sessionScope.subjs2.currentPage==1?1:sessionScope.subjs2.currentPage-1}">上一页</a>
			<a href="/StudentTopic/Subject2SelectServlet?currentPage=${sessionScope.subjs2.currentPage>sessionScope.subjs2.totalPage?sessionScope.subjs2.currentPage%sessionScope.subjs2.totalPage+1:sessionScope.subjs2.totalPage}">下一页</a>
			<a href="/StudentTopic/Subject2SelectServlet?currentPage=${sessionScope.subjs2.totalPage}">尾页</a>
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
</html>