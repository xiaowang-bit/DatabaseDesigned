<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>显示所有老师 </title>
		<link rel="stylesheet" type="text/css"
			href="../bootstrap/css/bootstrap.min.css" />
			<style type="text/css">
				*{
				font-size: 14px!important;
			}
			body{
				background:url(../img/BG4.jpg);
				background-size:100%;
			}

			</style>
	</head>
	<body>
		<div>
			<table class="table table-bordered table-hover">
				<thred>
					<tr>
						<th>年级</th>
						<th>班级名</th>
						<th>专业</th>
						<th>学院</th>
						<th>操作</th>
					</tr>
				</thred>
		        <tbody>
		        <c:forEach var="item" items="${sessionScope.classes }">
		        	<tr>
			
			    	<td>${item.class_grade  }</td>
			    	<td>${item.class_name  }</td>
			    	<td>${item.class_major }</td>
			    	<td>${item.class_academy }</td>
			    	<td>
			    		<a href="#" onclick="showDelete('${item.class_grade}','${item.class_name}','${item.class_major }','${item.class_academy }')">删除 </a>
			    		<a href="#"onclick="showUpdate('${item.class_grade}','${item.class_name}','${item.class_major }','${item.class_academy }')">修改 </a>
			    	</td>
			    	</tr>
		        </c:forEach>
			    
			</tbody>
		</table>
	</div>
	</br>
	<div class="addtea">
		<a href="class_add.html">
			<button class="btn btn-primary">添加班级</button>
		</a>
	</div>	
		<!-- 删除操作的模态框，对话框 -->
		<form action="/StudentTopic/ClassDeleteServlet" method="post" class="form-horizontal">
			<input type="hidden" name="class_grade0" id="class_grade0">
			<input type="hidden" name="class_name0" id="class_name0">
			<input type="hidden" name="class_major0" id="class_major0">
			<input type="hidden" name="class_academy0" id="class_academy0">
			<div class="modal" id="modal_delete">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1>提示</h1>
						</div>
						<div class="modal-body">
							您确定要删除吗?
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
       <form action="/StudentTopic/ClassUpdateServlet"method="post"class="form-horizontal">
       <div class="modal"id="modal_update">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h1>编辑</h1>
        			</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">年级</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="class_grade" name="class_grade"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">班级</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="class_name" name="class_name"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">专业</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="class_major" name="class_major"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学院</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="class_academy" name="class_academy"/>
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
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
	<script type="text/javascript">
		function showDelete(class_grade,class_name,class_major ,class_academy)
		{
			jQuery("#class_grade0").val(class_grade);
			jQuery("#class_name0").val(tea_sex);
			jQuery("#class_major0").val(tea_phone);
			jQuery("#class_academy0").val(tea_email);
			jQuery("#model_delete0").modal();
		}
		function showUpdate(class_grade,class_name,class_major,class_academy)
		{//在jquery中所有的表单控件通过val()方法赋值和取值
			//在jquery中除了form表单控件以外的控件 使用html()方法赋值和取值因为他们没有value属性对应的innerhtml
			jQuery("#class_grade").val(class_grade);
			jQuery("#class_name").val(tea_sex);
			jQuery("#class_major").val(tea_phone);
			jQuery("#class_academy").val(tea_email);
			jQuery("#modal_update").modal();	
		}
		</script>
</html>