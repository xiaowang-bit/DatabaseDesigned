<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
						<th>题目名称</th>
						<th>题目描述</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				  <c:forEach var="item" items="${sessionScope.essay}">
					<tr>
						<td>${item.en_tea_name}</td>
						<td>${item.en_essay_name}</td>
						<td>${item.en_essay_content}</td>
						<td>
							<a href="#" onclick="modalupdate('${item.en_tea_name}','${item.en_essay_name}','${item.en_essay_content }')">修改</a>
							<a href="#" onclick="modaldelete('${item.en_essay_name}')">删除</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!--//修改操作的模态框-->
		<form action="/Essay_Student/EssayUpdateServlet" method="post" class="form-horizontal">
			<div class="modal" id="modal_update">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h2>课题信息修改</h2>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label class="control-label col-sm-3">老师姓名：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" readonly="readonly" id="tea_name" name="tea_name" />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">题目名称：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" readonly="readonly" id="tea_title" name="tea_title"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-3">题目描述：</label>
								<div class="col-sm-6">
									<input type="text" class="form-control" id="tea_content" name="tea_content"/>
								</div>
							</div>
							
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-sm btn-info">确定</button>
							<button type="reset" class="btn btn-sm btn-primary" data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!--删除操作的模态框-->
		<form action="/EssayStudent/EssayDeleteServlet" method="post" class="form-horizontal">
		<input type="hidden" id="title" name="title">
			<div class="modal" id="modal_delete">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header"><h1>提示</h1></div>
						<div class="modal-body" >
							您确定要删除【<span id="u_title"></span>】吗？
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
		function modalupdate(name,title,miaoshu)
		{
			jQuery("#tea_name").val(name);
			jQuery("#tea_title").val(title);
			jQuery("#tea_content").val(miaoshu);
			jQuery("#modal_update").modal();
		}
		function modaldelete(n)
		{
			jQuery("#modal_delete").modal();
			jQuery("#u_title").html(n);
			jQuery("#title").val(n);
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>
