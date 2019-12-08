<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理课题信息</title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			body{
				background:url(../img/BG.jpg) repeat;
			}
			#tea{
				width: 800px;
				margin: auto;
			}
		</style>
	</head>
	<body>
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>学生姓名</th>
						<th>所选题目</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${sessionScope.stu_request }">
					<tr>
						<td>${item.sc_stu_no }</td>
						<td>${item.sc_stu_name }</td>
						<td>${item.sc_essay_name }</td>
						<td>
							<a href="#" onclick="modalagr('${item.sc_stu_name}')">确认申请</a>
							<a href="#" onclick="modalreg('${item.sc_stu_name}')">拒绝申请</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<form action="/Essay_Student/Update_SelectCourseServlet" method="post" >
		<input type="hidden" id="check" name="checked" value="1">
		<input type="hidden" id="stu_name" name="stu_name">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>提示</h1></div>
					<div class="modal-body" >
						确认同意【<span id="tea_name1"></span>】的请求吗？
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
					</div>
				</div>
				
			</div>
		</div>
		</form>
		
		<form action="/Essay_Student/Update_SelectCourseServlet" method="post" >
		<input type="hidden" id="fcheck" name="checked" value="-1">
		<input type="hidden" id="fstu_name" name="stu_name">
		<div class="modal" id="modal_reg">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>提示</h1></div>
					<div class="modal-body" >
						确认同意【<span id="tea_name"></span>】的请求吗？
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-sm btn-danger">确定</button>
						<button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
					</div>
				</div>
				
			</div>
		</div>
		</form>
	</body>
	<script type="text/javascript">
	
		/* jQuery("#anniu").hide(); */
		function modalagr(name1)
		{
			jQuery("#tea_name1").html(name1);
			jQuery("#stu_name").val(name1);
			jQuery("#modal_queren").modal();
		}
		function modalreg(name)
		{
			jQuery("#modal_reg").modal();
			jQuery("#tea_name").html(name);
			jQuery("#fstu_name").val(name);
			
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>