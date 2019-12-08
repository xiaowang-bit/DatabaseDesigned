<%@page import="com.wax.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form action="/StudentTopic/TeacherUpdateServlet"method="post"class="form-horizontal">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h1>编辑</h1>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">工号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_id" name="tea_id" value="${sessionScope.login_tea.tea_id}" readonly="readonly" />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">姓名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_name" name="tea_name" value="${sessionScope.login_tea.tea_name}"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学院</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_academy" name="tea_academy" value="${sessionScope.login_tea.tea_academy}" readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">性别</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_sex" name="tea_sex" value="${sessionScope.login_tea.tea_sex}" />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">职称</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_title" name="tea_title" value="${sessionScope.login_tea.tea_title}"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">电话</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_phone" name="tea_phone" value="${sessionScope.login_tea.tea_phone}"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">邮箱</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_email" name="tea_email" value="${sessionScope.login_tea.tea_email}"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">密码</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_pwd" name="tea_pwd" value="${sessionScope.login_tea.tea_pwd}"/>
        					</div>
        				</div>
        			</div>
       				<div class="modal-footer">
       					<button type="submit"class="btn btn-sm btn-danger">修改</button>
       					<button type="reset"class="btn btn-sm btn-default"
       						data-dismiss = "modal">取消</button>
       				</div>
        		</div>
        	</div>
       </form>
</body>
</html>