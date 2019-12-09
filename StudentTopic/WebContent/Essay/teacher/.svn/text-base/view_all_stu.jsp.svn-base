<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css" />
		
		<style type="text/css">
			*{
				padding: 0px;
				margin: 0px;
			}
			body{
				background:url(../img/BG.jpg) repeat;
			}
			#tea{
				width: 800px;
				margin: auto;
			}
			textarea{
			    margin-left:100px;
			    margin-top:30px;
			    height:300px;
			    width:400px;
			}
			.modal-footer{
			   display:flex;
			   flex-direction:row-reverse
			}
		</style>
	</head>
	<body>
		<div id="tea">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>学号</th>
						<th>学生姓名</th>
						<th>所选题目</th>
						<th>上传时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="item" items="${sessionScope.view_all_stu }">
					<tr>
						<td>${item.e_stu_no}</td>
						<td>${item.e_stu_name}</td>
						<td>${item.essay_name}</td>
						<td>${item.essay_date}</td>
						<td>
						  <c:choose>
							
							<c:when test="${item.stu_checked==1}"><a href="#" onclick="showmodal('${item.essay_content}','${item.e_stu_no}')">查看论文</a></c:when>
							
							
							<c:when test="${item.stu_checked==2}">已通过</c:when>
						</c:choose>  
						<%-- <a href="#" onclick="showmodal('${item.essay_content}','${item.e_stu_no}')">查看论文</a> --%>
							
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		
 		<div class="modal" id="modal_show">
			<div class="modal-dialog">
			    论 文 显 示
				<div class="modal-content">
                    <textarea id="essay_content" readonly="readonly">
                      
                    </textarea>				
					<div class="modal-footer">
					 <button type="reset" class="btn btn-sm btn-default" data-dismiss = "modal">取消</button>
		           
		           
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	            <form action="/Essay_Student/UpdateEssayCheckServlet" method="post">
		              <input type="hidden" value="-1" name="checked">
		              <input type="hidden"  name="e_stu_no" id="r_stu_no">
		              <button type="submit" class="btn btn-sm btn-danger">拒绝通过</button>
		               </form> 
		            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		            <form action="/Essay_Student/UpdateEssayCheckServlet" method="post">
		              <input type="hidden" value="2" name="checked">
		              <input type="hidden"  name="e_stu_no" id="s_stu_no">
		              <button type="submit" class="btn btn-sm btn-success">论文通过</button>
		              
					   </form>
					</div>
				</div>
				
			</div>
		</div>	
		
		
	</body>

	<script type="text/javascript" src="../js/jquery-3.2.1.min.js" ></script>
	<script type="text/javascript" src="../bootstrap/js/bootstrap.min.js" ></script>
 	<script type="text/javascript">
		function showmodal(content,sno)
		{
			jQuery("#modal_show").modal();
			jQuery("#essay_content").val(content);
			jQuery("#s_stu_no").val(sno);
			jQuery("#r_stu_no").val(sno);
		}

	</script> 
	
</html>