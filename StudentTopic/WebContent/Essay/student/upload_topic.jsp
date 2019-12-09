<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h2>上传格式为word，重复上传会覆盖哦！</h2>
	<br /><br />
	<form action="/StudentTopic/LoadReportServlet?stu_id=<%=request.getParameter("stu_id") %>" method="post" enctype="multipart/form-data">
		<div class="text-center" style="margin-top:30px ;">
		<div style="margin-left:60px ;"><input type="file" name="File" ><br/><br/></div>
			<input type="submit"  class="btn btn-success" value="上传">&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset" class="btn btn-danger">重置</button>
			<br /><br />
		</div>
	</form>
	</div>
	</div>
</body>
</html>