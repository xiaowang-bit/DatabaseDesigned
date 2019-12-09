<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="load" method="post" enctype="multipart/form-data">
		name:<input type="text" name="name"><br/>
		pwd:<input type="text" name="pwd"><br/>
		<input type="file" name="File" ><br/>
		<input type="submit" value="上传">
	</form>
</body>
</html>