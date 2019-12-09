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
		<div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>姓名</th>
						<th>登录密码</th>
						<th>审核标志</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.stus }">
						<tr>
							<td>${item.stu_no }</td>
							<td>${item.stu_name }</td>
					   	 	<td>${item.stu_pwd }</td>
					   		<td>${item.stu_checked }</td>
					    	<td>
					    	<a href="#" onclick="showDelete('${item.stu_no}')">删除</a>
					    	<a href="#" onclick="showUpdate('${item.stu_no}','${item.stu_name}','${item.stu_pwd}','${item.stu_checked}')">修改</a>
					    </td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	<form action="/Essay_Student/StudentDeleteServlet" method="post" class="form-horizontal">
		<input type="hidden" name="user_no" id="user_no">
		<div class="modal" id="modal_delete">
			<div class="modal-dialog">
			    <div class="modal-content">
				    <div class="modal-header">
					    <h1>提示</h1>
				    </div>
				    <div class="modal-body">
					       您确定要删除【<span id="u_name"></span>】吗？
				    </div>
				    <div class="modal-footer">
					    <button type="submit" class="btn btn-sm btn-danger">确定</button>
					    <button type="reset" class="btn btn-sm btn-default"
					    	data-dismiss="modal">取消</button>
                    </div>
			    </div>
		    </div>
	    </div>
	  </form>
	    <form action="/Essay_Student/StudentUpdateServlet" method="post" class="form-horizontal">
	        <div class="modal" id="modal_update">
	    	    <div class="modal-dialog">
	    		    <div class="modal-content">
	    			    <div class="modal-header">
	    				    <h1>编辑</h1>
	    			    </div>
	    			    <div class="modal-body">
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_no" name="stu_no" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_name"  name="stu_name"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">登录密码:</label>
	    					    <div class="col-sm-6">
	    					    	<input type="password" class="form-control"
	    							    id="stu_pwd"  name="stu_pwd"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">审核标志:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_checked" name="stu_check" readonly="readonly"/>
	    					    </div>
	    				    </div>
                        </div>
	    			    <div class="modal-footer">
	    				    <button type="submit" class="btn btn-sm btn-danger">修改</button>
	    				    <button type="reset" class="btn btn-sm btn-default"
	    					    data-dismiss="modal">取消</button>
	    			    </div> 
	    		    </div>
	    	    </div>
	        </div>
	    </form>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
	<script type="text/javascript">
		function showDelete(n)
		{
			jQuery("#u_name").html(n);
			jQuery("#modal_delete").modal();
			jQuery("#user_no").val(n);
		}
		function showUpdate(no,name,pwd,check)
		{
			jQuery("#stu_no").val(no);
			jQuery("#stu_name").val(name);
			jQuery("#stu_pwd").val(pwd);
			jQuery("#stu_checked").val(check);
			jQuery("#modal_update").modal();
		}
	</script>
</html>