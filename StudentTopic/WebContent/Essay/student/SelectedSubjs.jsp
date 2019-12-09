<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示所有学生 </title>
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
				<thred>
					<tr>
						<th>学期</th>
						<th>题目编号</th>
						<th>题目名字</th>
						<th>老师名字</th>
						<th>审核状态</th>
						<th>操作</th>
					</tr>
				</thred>
		        <tbody>
		        	<c:forEach var="item" items="${sessionScope.subjs }">
			        	<tr>
				    	<td>${item.st_semater }</td>
				    	<td>${item.st_topic_id }</td>
				    	<td>${item.topic_name }</td>
				    	<td>${item.tea_name }</td>
				    	<td>${item.st_checked}</td>
				    	<td>
			    			<a href="#" onclick="showDelete('${item.st_topic_id}')">退选 </a>
			    		</td>
				    	</tr>
		        	</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- 选题操作的模态框，对话框 -->
		<form action="/StudentTopic/StudentDeleteTopicServlet?stu_id=${sessionScope.login_stu.stu_id}" method="post" class="form-horizontal">
		<input type="hidden" name="topic_id" id="topic_id">
			<div class="modal" id="modal_delete">
				<div class="modal-dialog">
				    <div class="modal-content">
					    <div class="modal-header">
						    <h1>提示</h1>
					    </div>
					    <div class="modal-body">
						       您确定要退选【<span id="u_name"></span>】吗？
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
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
	<script type="text/javascript">
		function showinfo(n)
		{
			jQuery("#u_name").html(n);
			jQuery("#modal_delete").modal();
			jQuery("#topic_id").val(n);
		}
		function showDelete(n)
		{
			jQuery("#u_name").html(n);
			jQuery("#modal_delete").modal();
			jQuery("#topic_id").val(n);
		}
	</script>
</html>