<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示所有学生</title>
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
		<form action="/StudentTopic/StudentUpdateServlet" method="post" class="form-horizontal">
   				    <h1>修改个人信息</h1>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_id" name="stu_id"  value="<%=session.getAttribute("stu_id")%>" readonly="readonly" />
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_name"  name="stu_name" value="<%=session.getAttribute("stu_name")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
   					    <div class="col-sm-6">
   					    	<input type="text" class="form-control"
   							    id="stu_grade"  name="stu_grade" value="<%=session.getAttribute("stu_grade")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_sex" name="stu_sex"  value="<%=session.getAttribute("stu_sex")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_major" name="stu_major" value="<%=session.getAttribute("stu_major")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_class" name="stu_class" value="<%=session.getAttribute("stu_class")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_academy" name="stu_academy" value="<%=session.getAttribute("stu_academy")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_phone" name="stu_phone" value="<%=session.getAttribute("stu_phone")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_email" name="stu_email" value="<%=session.getAttribute("stu_email")%>"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_pwd" name="stu_pwd" value="<%=session.getAttribute("stu_pwd")%>"/>
   					    </div>
   				    </div>
   			    <div class="modal-footer">
   				    <button type="submit" class="btn btn-sm btn-danger">修改</button>
   				    <button type="reset" class="btn btn-sm btn-default"
   					    data-dismiss="modal">取消</button>
   			    </div> 
	    </form>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
</html>