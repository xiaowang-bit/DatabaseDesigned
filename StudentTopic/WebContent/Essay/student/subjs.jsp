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
				background:url(../img/BG4.jpg);
			}

			</style>
		
	</head>

	<body>
		<div>
		<br/>
			老师编号查询：
			<form action="/StudentTopic/StudentSelectByteaIdServlet" method="post">
				<select name="select_tea_id" id="select_tea_id"> 
		        	<c:forEach var="item" items="${sessionScope.subjs.objectList }">
						<OPTION value="${item.topic_tea_id}" >${item.tea_name}</OPTION> 
	        		</c:forEach>
				</select> 
				<input type="submit" value="查询">
				</form>
				<br/>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>题目编号</th>
						<th>老师名字</th>
						<th>题目名字</th>
						<th>课程名字</th>
						<th>题目内容</th>
						<th>限制人数</th>
						<th>操作</th>
					</tr>
				</thead>
		        <tbody>
		        	<c:forEach var="item" items="${sessionScope.subjs.objectList }">
			        	<tr>
				    	<td>${item.topic_id }</td>
				    	<td>${item.tea_name }</td>
				    	<td>${item.topic_name }</td>
				    	<td>${item.course_name}</td>
				    	<td>${item.topic_content}</td>
				    	<td>${item.topic_limit_stu}</td>
				    	<td>
			    			<a href="#" onclick="showDelete('${item.topic_id}','${item.course_id}','${item.tea_id}','${item.topic_semater} ')">选择 </a>
			    		</td>
				    	</tr>
		        	</c:forEach>
				</tbody>
			</table>
		</div>
		<div align="center">
			<a href="/StudentTopic/StudentSelectByteaIdServlet?currentPage=1">首页</a>
			<a href="/StudentTopic/StudentSelectByteaIdServlet?currentPage=${sessionScope.subjs.currentPage==1?1:sessionScope.subjs.currentPage-1}">上一页</a>
			<a href="/StudentTopic/StudentSelectByteaIdServlet?currentPage=${sessionScope.subjs.currentPage>sessionScope.subjs.totalPage?sessionScope.subjs.currentPage%sessionScope.subjs.totalPage+1:sessionScope.subjs.totalPage}">下一页</a>
			<a href="/StudentTopic/StudentSelectByteaIdServlet?currentPage=${sessionScope.subjs.totalPage}">尾页</a>
		</div>
		<!-- 选题操作的模态框，对话框 -->
		<form action="/StudentTopic/StudentSelectTopicServlet?stu_id=${sessionScope.login_stu.stu_id}" method="post" class="form-horizontal">
		<input type="hidden" name="st_semater" id="st_semater">
		<input type="hidden" name="topic_id" id="topic_id">
		<input type="hidden" name="course_id" id="course_id">
		<input type="hidden" name="tea_id" id="tea_id">
			<div class="modal" id="modal_delete">
				<div class="modal-dialog">
				    <div class="modal-content">
					    <div class="modal-header">
						    <h1>提示</h1>
					    </div>
					    <div class="modal-body">
					    	请确定你的身份
						    <select name="st_stu_check" style="display:inline;">
							  <option value ="组长" >组长</option>
							  <option value ="组员">组员</option>
							</select>
							请选择要加入的小组
						    <select name="team_id">
					        	<c:forEach var="item" items="${sessionScope.teams }">
									  <option value ="${item.team_id}" >${item.team_id}</option>
								</c:forEach>
							</select>
							</br>
						       您确定要选择【<span id="u_name"></span>】吗？
						       
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
		function showDelete(n,n1,n2,n3)
		{
			jQuery("#u_name").html(n);
			jQuery("#modal_delete").modal();
			jQuery("#topic_id").val(n);
			jQuery("#course_id").val(n1);
			jQuery("#st_semater").val(n3);
			jQuery("#tea_id").val(n2);
		}
	</script>
</html>