package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.Topic_info;
import com.wax.dao.Topic_InfoDao;
import com.wax.service.TeacherService;

public class TopicAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");	
		String topic_name = request.getParameter("topic_name");
		String topic_content = request.getParameter("topic_content");
		String topic_limit_stu = request.getParameter("topic_limit_stu");
		String topic_semater = request.getParameter("topic_semater");
		String topic_tea_id = request.getParameter("tea_id");
		String topic_id = request.getParameter("topic_id");
		String topic_course_id = request.getParameter("course_id");
		if (topic_tea_id==null||topic_id==null||topic_course_id==null) {
			response.sendRedirect("fail.jsp");
		}
		else {
			Topic_info topic=new Topic_info( topic_id,  topic_name,  topic_content,  topic_tea_id,
					 topic_course_id,  topic_limit_stu,  topic_semater);
			TeacherService dao=new TeacherService();			
			int row = dao.addTopic(topic);
			if(row>0)
			{
				Object[] options = { "确定" }; 
	        	JOptionPane.showOptionDialog(null, "添加成功！", "提示", 
	        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
	        	null, options, options[0]); 
				response.sendRedirect("/StudentTopic/Essay/teacher/subjects.jsp");
			}
			else{
				response.sendRedirect("fail.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
