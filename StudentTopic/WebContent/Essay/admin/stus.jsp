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
				background:url(../img/BG4.jpg);
				background-size:100%;
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
						<th>密码</th>
						<th>专业</th>
						<th>班级号</th>
						<th>班级</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.stus.objectList }">
						<tr>
							<td>${item.stu_id }</td>
							<td>${item.stu_name }</td>
					   	 	<td>${item.stu_pwd }</td>
					   	 	<td>${item.class_major }</td>
					   	 	<td>${item.class_id }</td>
					   	 	<td>${item.class_name }</td>
					    	<td>
					    	<a href="#" onclick="showInfo('${item.stu_id}','${item.stu_name}','${item.class_grade}','${item.stu_sex}','${item.class_major}','${item.class_name}','${item.class_academy}','${item.stu_phone}','${item.stu_email}','${item.stu_pwd}')">详情</a>
					    	<a href="#" onclick="showUpdate('${item.stu_id}','${item.stu_name}','${item.class_name}','${item.class_major}','${item.stu_pwd}','${item.class_name}')">修改</a>
					    	<a href="#" onclick="showDelete('${item.stu_id}')">删除</a>
					    </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="addstu" >
				<a href="/StudentTopic/SearchClassServlet">
					<button>添加单个学生</button>
				</a>
				<a href="stus_add.html">
   					<button>增加多个学生</button>
				</a>
				<a href="/StudentTopic/StuSelectServlet?currentPage=1">首页</a>
				<a href="/StudentTopic/StuSelectServlet?currentPage=${sessionScope.stus.currentPage==1?1:sessionScope.stus.currentPage-1}">上一页</a>
				<a href="/StudentTopic/StuSelectServlet?currentPage=${sessionScope.stus.currentPage>sessionScope.stus.totalPage?sessionScope.stus.currentPage%sessionScope.stus.totalPage+1:sessionScope.stus.totalPage}">下一页</a>
				<a href="/StudentTopic/StuSelectServlet?currentPage=${sessionScope.stus.totalPage}">尾页</a>
		</div>	
	<form action="/StudentTopic/StudentDeleteServlet" method="post" class="form-horizontal">
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
	  <form action="/StudentTopic/StudentUpdateServlet" method="post" class="form-horizontal">
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
	    							    id="stu_id" name="stu_id" readonly="readonly" />
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
	    					    <label class="control-label col-sm-4">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
	    					    <div class="col-sm-6">
	    					    	<input type="text" class="form-control"
	    							    id="stu_grade"  name="stu_grade"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_sex" name="stu_sex" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_major" name="stu_major" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_class" name="stu_class"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_academy" name="stu_academy"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_phone" name="stu_phone" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_email" name="stu_email"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_pwd" name="stu_pwd"/>
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
	    <div class="form-horizontal">
	        <div class="modal" id="modal_show">
	    	    <div class="modal-dialog">
	    		    <div class="modal-content">
	    			    <div class="modal-header">
	    				    <h1>学生信息</h1>
	    			    </div>
	    			    <div class="modal-body">
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_id1" name="stu_id" readonly="readonly" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_name1"  name="stu_name"readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
	    					    <div class="col-sm-6">
	    					    	<input type="text" class="form-control"
	    							    id="stu_grade1"  name="stu_grade"readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_sex1" name="stu_sex" readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_major1" name="stu_major"readonly="readonly" />
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_class1" name="stu_class"readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;院:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_academy1" name="stu_academy"readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_phone1" name="stu_phone" readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_email1" name="stu_email"readonly="readonly"/>
	    					    </div>
	    				    </div>
	    				    <div class="form-group">
	    					    <label class="control-label col-sm-4">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
	    					    <div class="col-sm-6">
	    						    <input type="text" class="form-control"
	    							    id="stu_pwd1" name="stu_pwd"readonly="readonly"/>
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
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
	<script type="text/javascript">
		function showDelete(n)
		{
			jQuery("#u_name").html(n);
			jQuery("#modal_delete").modal();
			jQuery("#user_no").val(n);
		}
		function showUpdate(stu_id,stu_name,stu_class,stu_major,stu_pwd,stu_academy)
		{
			jQuery("#stu_id").val(stu_id);
			jQuery("#stu_name").val(stu_name);
			jQuery("#stu_class").val(stu_class);
			jQuery("#stu_major").val(stu_major);
			jQuery("#stu_academy").val(stu_academy);
			jQuery("#stu_pwd").val(stu_pwd);
			jQuery("#modal_update").modal();
		}
		function showInfo(stu_id,stu_name,stu_grade,stu_sex,stu_major,stu_class,stu_academy,stu_phone,stu_email,stu_pwd)
		{
			jQuery("#stu_id1").val(stu_id);
			jQuery("#stu_name1").val(stu_name);
			jQuery("#stu_grade1").val(stu_grade);
			jQuery("#stu_sex1").val(stu_sex);
			jQuery("#stu_phone1").val(stu_phone);
			jQuery("#stu_email1").val(stu_email);
			jQuery("#stu_class1").val(stu_class);
			jQuery("#stu_major1").val(stu_major);
			jQuery("#stu_academy1").val(stu_academy);
			jQuery("#stu_pwd1").val(stu_pwd);
			jQuery("#modal_show").modal();
		}
	</script>
</html>