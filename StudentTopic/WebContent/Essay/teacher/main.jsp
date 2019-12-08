<%@page import="com.sun.mail.imap.protocol.ID"%>
<%@page import="com.wax.model.Subject"%>
<%@page import="java.util.List"%>
<%@page import="com.wax.model.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <table>
	 	<% 
	 	String id=(String)request.getAttribute("tea_id");
	 	%>
	 	<tr><td><a href="<%=request.getContentType() %>/update.tdo?id=<%=id %>">修改个人信息</a><td></tr>
	 	<tr>
	 		<td>题号</td>
	 		<td>题目名</td>
	 		<td>题目内容</td>
	 		<td>题目所属课程</td>
	 		<td>题目限制人数</td>
	 		<td>学院</td>
	 		<td>学期</td>
	 	</tr>
		<%
			
			List<Subject> list=(List<Subject>)request.getAttribute("topiclist");
			if(list!=null && list.size()>0){
				for(Subject subject:list){
		%>
	 	<tr>
	 		<td><%=subject.getTopic_id() %></td>
	 		<td><%=subject.getTopic_name() %></td>
	 		<td><%=subject.getTopic_content()%></td>
	 		<td><%=subject.getTopic_course() %></td>
	 		<td><%=subject.getTopic_limit_stu() %></td>
	 		<td><%=subject.getTopic_academy() %></td>
	 		<td><%=subject.getTopic_semater() %></td>
	 		<td>
	 			<a href="<%=request.getContextPath()%>/update.sdo?topic_id=<%=subject.getTopic_id()%>&topic_tea_id=<%=subject.getTopic_tea_id() %>">修改题目</a>
	 			<a href="<%=request.getContextPath()%>/query.ssdo?st_topic_id=<%=subject.getTopic_id()%>&st_tea_id=<%=subject.getTopic_tea_id() %>">选题详情</a>
	 		</td>
	 		
	 	</tr>
	 	<% 
				}
	 		}
	 	%>
	 	<tr>
	 		<td>
	 			<a href="<%=request.getContextPath() %>/add_sub_info.jsp">增添题目</a>
	 		</td>
	 	</tr>
	 </table>

<!--  
    <form action="<%=request.getContextPath() %>/update.tdo" method="get">
    <table>
    	
    	<tr>
    		<td>
    			<input type="submit" value="修改个人信息">
    		</td>
    	</tr>
    </table>
    </form>
-->
</body>
</html>