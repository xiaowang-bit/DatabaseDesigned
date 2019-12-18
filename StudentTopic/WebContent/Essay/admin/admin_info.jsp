<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
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
		<h1 align="center" style="font-size: 43px">个人信息</h1>
		<form action="/StudentTopic/AdminUpdateServlet" method="post" class="form-horizontal" >
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_id" name=admin_id  value="${sessionScope.login_admin.admin_id}" readonly="readonly" />
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_name"  name="admin_name" value="${sessionScope.login_admin.admin_name}"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
   					    <div class="col-sm-6">
   					    	<input type="text" class="form-control"
   							    id="stu_grade"  name="admin_sex" value="${sessionScope.login_admin.admin_sex}"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_sex" name="admin_academy"  value="${sessionScope.login_admin.admin_academy}" />
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_major" name="admin_title" value="${sessionScope.login_admin.admin_title}"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_class" name="admin_phone" value="${sessionScope.login_admin.admin_phone}"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_academy" name="admin_email" value="${sessionScope.login_admin.admin_email}"/>
   					    </div>
   				    </div>
   				    <div class="form-group">
   					    <label class="control-label col-sm-4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
   					    <div class="col-sm-6">
   						    <input type="text" class="form-control"
   							    id="stu_phone" name="admin_pwd" value="${sessionScope.login_admin.admin_pwd}"/>
   					    </div>
   				    </div>
   			    <div class="modal1-footer" align="center">
   				    <button type="submit" class="btn btn-sm btn-info">修改</button>&nbsp;&nbsp;&nbsp;
   				    <button type="reset" class="btn btn-sm btn-primary"
   					    data-dismiss="modal">取消</button>
   			    </div> 
	    </form>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
</html>