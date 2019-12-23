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
				background:url(../img/BG4.jpg) repeat;
			}
		</style>
	</head>
	<body>
		<div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学期</th>
						<th>课程号</th>
						<th>课程名</th>
						<th>题号</th>
						<th>题名</th>
						<th>限制人数</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var = "item" items="${sessionScope.topics.objectList }">
						<tr>
							<td>${item.topic_semater }</td>
					   	 	<td>${item.course_id }</td>
					   	 	<td>${item.course_name }</td>
							<td>${item.topic_id}</td>
					   	 	<td>${item.topic_name }</td>
					   	 	<td>${item.topic_limit_stu }</td>
					    	<td>
					    		<a href="#" onclick="Showinfo('${item.TOPIC_TEA_ID}','${item.TOPIC_COURSE_ID}','${item.topic_id}','${item.tea_name}','${item.course_name}','${item.topic_name}','${item.topic_content}','${item.topic_course_id }','${item.topic_limit_stu}','${item.topic_semater }')">详情</a>
					    		<a href="#" onclick="Update('${item.TOPIC_TEA_ID}','${item.TOPIC_COURSE_ID}','${item.topic_id}','${item.tea_name}','${item.course_name}','${item.topic_name}','${item.topic_content}','${item.topic_course_id }','${item.topic_limit_stu}','${item.topic_semater }')">修改</a>
					    		<a href="#" onclick="Delete('${item.tea_id}','${item.course_id}','${item.topic_id}')">删除</a>
					    	</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="addstu" >
				<a href="#" onclick="addTopic('${sessionScope.login_tea.tea_id}')"style="margin-left:600px;">
					<button type="submit" class="btn btn-primary">添加题目</button>
				</a>		
		
				<a href="/StudentTopic/TopicToTeacherServlet?currentPage=1&tea_id=${sessionScope.login_tea.tea_id}"style="margin-left:350px;" >首页</a>
				<a href="/StudentTopic/TopicToTeacherServlet?currentPage=${sessionScope.topics.currentPage==1?1:sessionScope.topics.currentPage-1}&tea_id=${sessionScope.login_tea.tea_id}">上一页</a>
				<a href="/StudentTopic/TopicToTeacherServlet?currentPage=${sessionScope.topics.currentPage>sessionScope.topics.totalPage?sessionScope.topics.currentPage%sessionScope.topics.totalPage+1:sessionScope.topics.totalPage}&tea_id=${sessionScope.login_tea.tea_id}">下一页</a>
				<a href="/StudentTopic/TopicToTeacherServlet?currentPage=${sessionScope.topics.totalPage}&tea_id=${sessionScope.login_tea.tea_id}">尾页</a>
		</div>
		<form action="/StudentTopic/TopicDeleteServlet" method="post" class="form-horizontal">
			<input type="hidden" name="topic_id" id="topic_id2">
			<input type="hidden" name="course_id" id="course_id2">
			<input type="hidden" name="tea_id" id="tea_id2">
			<div class="modal" id="model_delete">
				<div class="modal-dialog">
				    <div class="modal-content">
					    <div class="modal-header">
						    <h1>修改审核状态</h1>
					    </div>
					    <div class="modal-body">
						     	您确定要删除[<span id="u_name2"></span>]吗?
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
	  <form action="/StudentTopic/TopicUpdateServlet" method="post" class="form-horizontal">
	   	<div class="modal"id="model_update">
        	<div class="modal-dialog">
        		<div class="modal-content">
        		<input type="hidden" id="tea_id1" name="tea_id">
        		<input type="hidden" id="topic_id1" name="topic_id">
        		<input type="hidden" id="course_id1" name="course_id">
        			<div class="modal-header">
        				<h1>编辑要修改的内容</h1>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学期</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_semater1" name="topic_semater"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_name1" name="topic_name"/>
        					</div>
        				</div>

        				<div class="form-group ">
        					<label class="control-label col-sm-2">课程名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="course_name1" name="course_name" readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">限制人数</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_limit_stu1" name="topic_limit_stu"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题目内容</label>
        					<div class="col-sm-6">
        						<textarea class="form-control"
        							id="topic_content1" name="topic_content" rows="6">
        						</textarea>
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
	  <form class="form-horizontal">
	  <div class="modal"id="model_showinfo">
      	 <div class="modal-dialog">
        	  <div class="modal-content">
        			<div class="modal-header">
        				<h1>详情</h1>
        			</div>
        			<div class="modal-body">
        				
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_name" name="topic_name"readonly="readonly"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">限制人数</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_limit_stu" name="topic_limit_stu"readonly="readonly"/>
        					</div>
        				</div>
        				
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题目内容</label>
        					<div class="col-sm-6">
        						<textarea  style="overflow-x:scroll "class="form-control"
        							id="topic_content" name="topic_content"readonly="readonly"
        							rows="15">
        						</textarea>
        					</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
    </form>
      <form action="/StudentTopic/TopicAddServlet" method="post" class="form-horizontal">
	   	    <div class="modal"id="model_addTopic">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				请选择你要添加题目的所在课程：
		       				<select name="course_id" id="course_id"> 
		      					<c:forEach var = "item" items="${sessionScope.courses }">
									<OPTION value="${item.course_id }">${item.course_name }</OPTION> 
								</c:forEach>
							</select>
						<div class="addstu" align="right">
							<a href="addCourse.jsp">添加课程</a>
						</div>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">学期</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_semater1" name="topic_semater"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_id1" name="topic_id"  />
        				</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_name1" name="topic_name"/>
        					</div>
        				</div>
        				
        				<div class="form-group ">
        					<label class="control-label col-sm-2">老师工号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="tea_id3" name="tea_id" readonly="readonly" />
        					</div>
        				</div>
      				    <div class="form-group ">
        					<label class="control-label col-sm-2">限制人数</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_limit_stu1" name="topic_limit_stu"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">题目内容</label>
        					<div class="col-sm-6">
        						<textarea class="form-control"
        							id="topic_content1" name="topic_content" rows="8">
        						</textarea>
        					</div>
        				</div>

        				
        			</div>
	      				<div class="modal-footer">
	      					<button type="submit"class="btn btn-sm btn-danger">添加</button>
	      					<button type="reset"class="btn btn-sm btn-default"
	      						data-dismiss = "modal">取消</button>
	      				</div>
        			</div>
        		</div>
        	</div>
	  </form>
	<form action="/StudentTopic/TopicUpdateServlet" method="post" class="form-horizontal">
	   	<div class="modal"id="model_addCourse">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
						<div class="addstu" align="left">
							添加课程		
						</div>
        			</div>
        			<div class="modal-body">
        				<div class="form-group ">
        					<label class="control-label col-sm-2">课程号</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_semater1" name="course_id"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">课程名</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_academy1" name="course_name"/>
        					</div>
        				</div>
        				<div class="form-group ">
        					<label class="control-label col-sm-2">年级</label>
        					<div class="col-sm-6">
        						<input type="text"class="form-control"
        							id="topic_limit_stu1" name="course_grade"/>
        					</div>
        				</div>
        				
        			</div>
       				<div class="modal-footer">
       					<button type="submit"class="btn btn-sm btn-info">添加</button>
       					<button type="reset"class="btn btn-sm btn-primary"
       						data-dismiss = "modal">取消</button>
       				</div>
        		</div>
        	</div>
        </div>
	</form>
	</body>
	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" charset="UTF-8"></script>
	<script type="text/javascript">
		function Showinfo(tea_id,course_id,topic_id,tea_name,course_name,topic_name,topic_content,topic_course_id ,topic_limit_stu,topic_semater )
		{
			jQuery("#model_showinfo").modal();
			jQuery("#tea_id").val(tea_id);
			jQuery("#topic_name").val(topic_name);
			jQuery("#topic_content").val(topic_content);
			jQuery("#topic_course_id ").val(topic_course_id );
			jQuery("#topic_limit_stu").val(topic_limit_stu);
			jQuery("#topic_semater").val(topic_semater);
			jQuery("#tea_name").val(tea_name);
			jQuery("#course_name").val(course_name);
			jQuery("#course_id").val(course_id);
			jQuery("#topic_id").val(topic_id);
		}
		function Update(tea_id,course_id,topic_id,tea_name,course_name,topic_name,topic_content,topic_course_id ,topic_limit_stu,topic_semater )
		{
			jQuery("#model_update").modal();
			jQuery("#tea_id1").val(tea_id);
			jQuery("#topic_name1").val(topic_name);
			jQuery("#topic_content1").val(topic_content);
			jQuery("#topic_course_id1").val(topic_course_id );
			jQuery("#topic_limit_stu1").val(topic_limit_stu);
			jQuery("#topic_semater1").val(topic_semater);
			jQuery("#tea_name1").val(tea_name);
			jQuery("#course_name1").val(course_name);
			jQuery("#course_id1").val(course_id);
			jQuery("#topic_id1").val(topic_id);
		}
		function addTopic(tea_id)
		{
			jQuery("#model_addTopic").modal();
			jQuery("#tea_id3").val(tea_id);

		}
		function addCourse()
		{
			jQuery("#model_addTopic").modal();
			
		}
		function Delete(tea_id,course_id,topic_id)
		{
			jQuery("#u_name2").html(topic_id);
			jQuery("#model_delete").modal();
			jQuery("#tea_id2").val(tea_id);
			jQuery("#course_id2").val(course_id);
			jQuery("#topic_id2").val(topic_id);
		}
		function news() {
			document.getElementById("p_content").style.display="block";
		}
	</script>
</html>