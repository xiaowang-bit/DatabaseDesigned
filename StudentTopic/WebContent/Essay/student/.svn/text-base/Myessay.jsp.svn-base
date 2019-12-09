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
			textarea
			{
			height=500px;
			width=500px;
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
						<th>老师姓名</th>
						<th>题目名称</th>
						<th>申请状态</th>
						<th>审核标志</th>
						<th>论文状态</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.MyEssay }">
						<tr>
						<td>${item.sc_tea_name }</td>
						<td>${item.sc_essay_name }</td>
						<td id="sign">
							<c:choose>
								<c:when test="${item.sc_checked==1 }">已通过</c:when>
								<c:when test="${item.sc_checked==0 }">申请中</c:when>
								<c:when test="${item.sc_checked==-1 }">已拒绝</c:when>
							</c:choose>
						</td>
						<td>
							<c:if test="${sessionScope.Mystudent.stu_checked==2&&item.sc_checked==1 }">审核通过</c:if>
							<c:if test="${sessionScope.Mystudent.stu_checked==1&&item.sc_checked==1 }">审核中</c:if>
							<c:if test="${sessionScope.Mystudent.stu_checked==0&&item.sc_checked==1 }">未提交</c:if>
							<c:if test="${sessionScope.Mystudent.stu_checked==-1&&item.sc_checked==1 }">审核失败</c:if>
						</td>
						<td>
							<%-- <c:if test="${item.sc_checked==0}">正在申请中</c:if>
							<c:if test="${item.sc_checked==-1}">申请被拒绝</c:if> --%>
							<c:if test="${item.sc_checked==1 and (sessionScope.Mystudent.stu_checked==0 or sessionScope.Mystudent.stu_checked==-1)}">
								<a href="#" onclick="modalupdate('${item.sc_essay_name}')">提交论文</a>
							</c:if>
							<c:if test="${sessionScope.Mystudent.stu_checked==1&&item.sc_checked==1 }">
								论文已提交
							</c:if>
							<c:if test="${sessionScope.Mystudent.stu_checked==2&&item.sc_checked==1 }">
								论文已通过
							</c:if>
						</td>
					   </tr>
					   
					</c:forEach>
					
				</tbody>
			</table>
		</div>
			<!--删除操作的模态框-->
	<form action="/Essay_Student/EssaySubmit" method="post">
		<input type="hidden" name="essayname" id="essayname">
		<div class="modal" id="modal_queren">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header"><h1>论文提交</h1></div>
					<div class="modal-body" >
						<textarea name="area" id="area"></textarea>
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
		function modalupdate(name)
		{
			jQuery("#essayname").val(name);
			jQuery("#modal_queren").modal();
		}
	</script>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
</html>