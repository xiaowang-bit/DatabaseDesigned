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
		<form action="/StudentTopic/CourseAddServlet" method="post" class="form-horizontal">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
						<div class="addstu" align="left">
							添加课程		
						</div>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">课程号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_semater1" name="course_id"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">课程名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_academy1" name="course_name"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">年级</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_limit_stu1" name="course_grade"/>
        					</div>
        				</div>
        				
        			</div>
       				<div class="modal-footer">
       					<button type="submit"class="btn btn-sm btn-info">添加</button>
       					<button type="reset"class="btn btn-sm btn-primary"
       						data-dismiss = "modal">取消</button>
       				</div>
        		</div>
        	</div>
	</form>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
</html>