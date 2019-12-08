package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.model.Subject;
import com.wax.model.Teacher;
import com.wax.service.SubjectService;
import com.wax.service.TeacherService;

public class TeacherAddTopicServlet extends HttpServlet {
    SubjectService subjectService=new SubjectService();
    TeacherService teacherService=new TeacherService();
	private static final long serialVersionUID = 1L;
    public TeacherAddTopicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject subject=null;
		subject.setTopic_id(request.getParameter("topic_id"));
		subject.setTopic_name(request.getParameter("topic_name"));
		subject.setTopic_content(request.getParameter("topic_content"));
		subject.setTopic_tea_id(request.getParameter("topic_tea_id"));
		subject.setTopic_tea_name(request.getParameter("topic_tea_name"));
		subject.setTopic_academy(request.getParameter("topic_academy"));
		subject.setTopic_course(request.getParameter("topic_course"));
		subject.setTopic_limit_stu(request.getParameter("topic_limit_stu"));
		subject.setTopic_semater(request.getParameter("topic_semater"));
		int row=subjectService.add(subject);
		if(row>0)
		{
			response.sendRedirect("success.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
