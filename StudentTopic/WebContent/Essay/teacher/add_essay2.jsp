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
						<th>题号</th>
						<th>课程名</th>
						<th>题名</th>
						<th>小组名</th>
						<th>学生名</th>
						<th>身份</th>
						<th>限制人数</th>
						<th>审核状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.topics.objectList }">
						<tr>
							<td>${item.topic_id }</td>
							<td>${item.COURSE_NAME}</td>
					   	 	<td>${item.topic_name }</td>
					   	 	<td>${item.team_name }</td>
					   	 	<td>${item.STU_NAME }</td>
					   	 	<td>${item.ST_STU_CHECK }</td>
					   	 	<td>${item.topic_limit_stu }</td>
					   	 	<td>${item.st_checked }</td>
					    	<td>
					    	<a href="#" onclick="docheck('${item.stu_name}','${item.stu_id}','${item.tea_id}','${item.topic_id}','${item.st_checked  }','${item.st_team_id }')">通过</a>
					    	<a href="#" onclick="Delete('${item.stu_name}','${item.stu_id}','${item.tea_id}','${item.topic_id}','${item.st_checked  }','${item.st_team_id }')">不通过</a>
					    	</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
			
	<form action="/StudentTopic/TopicSelectUpdateServlet" method="post" class="form-horizontal">
		<input type="hidden" name="topic_id" id="topic_id">
		<input type="hidden" name="stu_id" id="stu_id">
		<input type="hidden" name="tea_id" id="tea_id">
		<input type="hidden" name="st_team_id" id="st_team_id">
		<input type="hidden" name="st_checked" id="tea_id" value="通过">
		<div class="modal" id="model_check">
			<div class="modal-dialog">
			    <div class="modal-content">
				    <div class="modal-header">
					    <h1>修改审核状态</h1>
				    </div>
				    <div class="modal-body">
					     	您确定要通过[<span id="u_name"></span>]吗?
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
	  <form action="/StudentTopic/TopicSelectUpdateServlet" method="post" class="form-horizontal">
		<input type="hidden" name="topic_id" id="topic_id1">
		<input type="hidden" name="stu_id" id="stu_id1">
		<input type="hidden" name="tea_id" id="tea_id1">
		<input type="hidden" name="st_team_id" id="st_team_id1">
		<input type="hidden" name="st_checked" id="u_name1" value="不通过">
		<div class="modal" id="model_delete">
			<div class="modal-dialog">
			    <div class="modal-content">
				    <div class="modal-header">
					    <h1>修改审核状态</h1>
				    </div>
				    <div class="modal-body">
					    	您确定要不通过[<span id="u_name1"></span>]吗?
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
	<div>
			<a href="/StudentTopic/TopicSelectTeacherServlet?currentPage=1&tea_id=${sessionScope.login_tea.tea_id}">首页</a>
			<a href="/StudentTopic/TopicSelectTeacherServlet?currentPage=${sessionScope.topics.currentPage==1?1:sessionScope.topics.currentPage-1}&tea_id=${sessionScope.login_tea.tea_id}">上一页</a>
			<a href="/StudentTopic/TopicSelectTeacherServlet?currentPage=${sessionScope.topics.currentPage>sessionScope.topics.totalPage?sessionScope.topics.currentPage%sessionScope.topics.totalPage+1:sessionScope.topics.totalPage}&tea_id=${sessionScope.login_tea.tea_id}">下一页</a>
			<a href="/StudentTopic/TopicSelectTeacherServlet?currentPage=${sessionScope.topics.totalPage}&tea_id=${sessionScope.login_tea.tea_id}">尾页</a>
	</div>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
	<script type="text/javascript">
		function docheck(stu_name,stu_id,tea_id,topic_id,st_checked,st_team_id)
		{
			jQuery("#u_name").html(stu_name);
			jQuery("#model_check").modal();
			jQuery("#stu_id").val(stu_id);
			jQuery("#tea_id").val(tea_id);
			jQuery("#st_team_id").val(st_team_id);
			jQuery("#st_checked").val(st_checked);
			jQuery("#topic_id").val(topic_id);
		}
		function Delete(stu_name,stu_id,tea_id,topic_id,st_checked,st_team_id)
		{
			
			jQuery("#u_name1").html(stu_name);
			jQuery("#model_delete").modal();
			jQuery("#stu_id1").val(stu_id);
			jQuery("#tea_id1").val(tea_id);
			jQuery("#st_team_id1").val(st_team_id);
			jQuery("#st_checked1").val(st_checked);
			jQuery("#topic_id1").val(topic_id);
		}
	</script>
</html>