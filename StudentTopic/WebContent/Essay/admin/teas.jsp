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
						<th>工号</th>
						<th>姓名</th>
						<th>密码</th>
						<th>学院</th>
						<th>职称</th>
						<th>操作</th>
					</tr>
				</thred>
		        <tbody>
		        <c:forEach var="item" items="${sessionScope.teas.objectList }">
		        	<tr>
			
			    	<td>${item.tea_id  }</td>
			    	<td>${item.tea_name  }</td>
			    	<td>${item.tea_pwd }</td>
			    	<td>${item.tea_academy }</td>
			    	<td>${item.tea_title }</td>
			    	<td>
			    		<a href="#"onclick="showInfo('${item.tea_id}','${item.tea_name}','${item.tea_sex }','${item.tea_academy }','${item.tea_title}','${item.tea_phone}','${item.tea_email }','${item.tea_pwd}')">详情 </a>
			    		<a href="#" onclick="showDelete('${item.tea_id}')">删除 </a>
			    		<a href="#"onclick="showUpdate('${item.tea_id}','${item.tea_name}','${item.tea_sex }','${item.tea_academy }','${item.tea_title}','${item.tea_phone}','${item.tea_email}','${item.tea_pwd}')">修改 </a>
			    	</td>
			    	</tr>
		        </c:forEach>
			    
			</tbody>
		</table>
	</div>
	<div class="addtea">
		<a href="Add_tea.html">
			<button>添加老师</button>
		</a>
		<a href="/StudentTopic/TeaSelectServlet?currentPage=1">首页</a>
		<a href="/StudentTopic/TeaSelectServlet?currentPage=${sessionScope.teas.currentPage==1?1:sessionScope.teas.currentPage-1}">上一页</a>
		<a href="/StudentTopic/TeaSelectServlet?currentPage=${sessionScope.teas.currentPage>sessionScope.teas.totalPage?sessionScope.teas.currentPage%sessionScope.teas.totalPage+1:sessionScope.teas.totalPage}">下一页</a>
		<a href="/StudentTopic/TeaSelectServlet?currentPage=${sessionScope.teas.totalPage}">尾页</a>
	</div>	
		<!-- 删除操作的模态框，对话框 -->
		<form action="/StudentTopic/TeacherDeleteServlet" method="post" class="form-horizontal">
			<input type="hidden" name="user_no" id="user_no">
			<div class="modal" id="modal_delete">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h1>提示</h1>
						</div>
						<div class="modal-body">
							您确定要删除[<span id="tea_id"></span>]吗?
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
       <form action="/StudentTopic/TeacherUpdateServlet"method="post"class="form-horizontal">
        <div class="modal"id="modal_update">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h1>编辑</h1>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">工号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_id" name="tea_id" readonly="readonly" />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">姓名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_name" name="tea_name"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学院</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_academy" name="tea_academy"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">性别</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_sex" name="tea_sex"  />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">职称</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_title" name="tea_title"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">电话</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="tea_phone" name="tea_phone"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">邮箱</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_email" name="tea_email"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">密码</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="tea_pwd" name="tea_pwd"/>
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
        </div>
       </form>
       <div class="form-horizontal">
        <div class="modal"id="modal_show">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h1>编辑</h1>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">工号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_id1" name="tea_id" readonly="readonly" />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">姓名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_name1" name="tea_name"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学院</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_academy1" name="tea_academy"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">性别</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_sex1" name="tea_sex1" readonly="readonly" />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">职称</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_title1" name="tea_title"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">电话</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="tea_phone1" name="tea_phone"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">邮箱</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_email1" name="tea_email"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">密码</label>
        					<div class="col-sm-6">
        						<input type="password"class="form-control"
        							id="tea_pwd1" name="tea_pwd"readonly="readonly"/>
        					</div>
        				</div>
        			</div>
       				<div class="modal-footer">
       				</div>
        		</div>
        	</div>
        </div>
       </div>
	</body>
	<script src="../js/jquery-3.2.1.min.js"type="text/javascript"charset="UTF-8"></script>
	<script src="../bootstrap/js/bootstrap.min.js"type="text/javascript"charset="UTF-8"></script>
	<script type="text/javascript">
		function showDelete(tea_id)
		{
			jQuery("#tea_id").html(tea_id);
			jQuery("#modal_delete").modal();
			jQuery("#user_no").val(tea_id);
		}
		function showUpdate(tea_id,tea_name,tea_sex ,tea_academy ,tea_title,tea_phone,tea_email,tea_pwd)
		{//在jquery中所有的表单控件通过val()方法赋值和取值
			//在jquery中除了form表单控件以外的控件 使用html()方法赋值和取值因为他们没有value属性对应的innerhtml
			jQuery("#tea_id").val(tea_id);
			jQuery("#tea_name").val(tea_name);
			jQuery("#tea_academy").val(tea_academy);
			jQuery("#tea_title").val(tea_title);
			jQuery("#tea_sex").val(tea_sex);
			jQuery("#tea_phone").val(tea_phone);
			jQuery("#tea_email").val(tea_email);
			jQuery("#tea_pwd").val(tea_pwd);
			jQuery("#modal_update").modal();	
		}
		function showInfo(tea_id,tea_name,tea_sex ,tea_academy ,tea_title,tea_phone,tea_email,tea_pwd)
		{//在jquery中所有的表单控件通过val()方法赋值和取值
			//在jquery中除了form表单控件以外的控件 使用html()方法赋值和取值因为他们没有value属性对应的innerhtml
			jQuery("#tea_id1").val(tea_id);
			jQuery("#tea_name1").val(tea_name);
			jQuery("#tea_academy1").val(tea_academy);
			jQuery("#tea_title1").val(tea_title);
			jQuery("#tea_sex1").val(tea_sex);
			jQuery("#tea_phone1").val(tea_phone);
			jQuery("#tea_email1").val(tea_email);
			jQuery("#tea_pwd1").val(tea_pwd);
			jQuery("#modal_show").modal();	
		}
	</script>
</html>