<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/style.css"/>
		<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.min.css"/>
		<style type="text/css">

		</style>
	</head>
	<body>
					
		<div id="wrapper">
			<div id="wrappertop"></div>
			<div id="wrappermiddle">
				<h2>Add Student</h2>
				<br /><br /><br />
	      		<form action="/StudentTopic/StudentAdd" method="post" >
	      		选择添加学生所在的班级：
				<select name="class_id" > 
					<c:forEach var = "item" items="${sessionScope.classes }">
							<OPTION value="${item.class_id }">${item.class_grade}${item.class_major}${item.class_name}</OPTION> 
					</c:forEach>
				</select>
				<a href="class_add.html">添加班级</a>
				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_id" class="url" placeholder="学生学号">
					</div>
					<div class="inputright"></div>
				</div>
				
				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_name" class="url" placeholder="学生姓名">
					</div>
					<div class="inputright"></div>
				</div>
				
 				
 				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_sex" class="url" placeholder="学生性别">
					</div>
					<div class="inputright"></div>
 				</div>
					

				
				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_academy" class="url" placeholder="学院">
					</div>
					<div class="inputright"></div>
				</div>
				
				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_phone" class="url" placeholder="学生电话">
					</div>
					<div class="inputright"></div>
				</div>
				
				<div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_email" class="url" placeholder="学生邮箱">
					</div>
					<div class="inputright"></div>
				</div>
				
			    <div class="addstu">
					<div class="inputleft"></div>
					<div class="inputmiddle">
						<input type="text" name="stu_pwd" class="url" placeholder="学生密码">
					</div>
					<div class="inputright"></div>
				</div>
				
				<div class="text-center" style="margin-top:10px ;">
		        	<button type="submit" class="btn btn-success">添加</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-danger">重置</button>
	            <br /><br />
				</div>	
				       
				</form>
			</div>
		</div>
	</body>
</html>