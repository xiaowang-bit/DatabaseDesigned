<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				background:url(../img/BG4.jpg) repeat;
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
						<th>老师姓名</th>
						<th>课程题目</th>
						<th>课题描述</th>
						<th>申请题目</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${sessionScope.essay }">
					<tr>
						<td>${item.en_tea_name }</td>
						<td>${item.en_essay_name}</td>
						<td>${item.en_essay_content}</td>
						<td>
							<a href="#" onclick="modalupdate('${item.en_tea_name }','${item.en_essay_name}')">确认申请</a>
						</td>
					</tr>
					
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!--删除操作的模态框-->
	<form action="/Essay_Student/EssaySelectServlet" method="post">
		<input type="hidden" name="tea1" id="tea1">
		<input type="hidden" name="essay" id="essay">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>提示</h1></div>
					<div class="modal-body" >
						确认选择【<span id="tea_name1"></span>】的课题【<span id="sub_name"></span>】？
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
		function modalupdate(name1,name2,name3)
		{
			jQuery("#tea_name1").html(name1);
			jQuery("#sub_name").html(name2);
			jQuery("#tea1").val(name1);
			jQuery("#essay").val(name2);
			jQuery("#modal_queren").modal();
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>