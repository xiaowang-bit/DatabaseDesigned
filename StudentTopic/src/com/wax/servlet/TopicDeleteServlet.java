package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Topic_InfoDao;

public class TopicDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");	
		
		String tea_id = request.getParameter("tea_id");
		String topic_id = request.getParameter("topic_id");
		String course_id = request.getParameter("course_id");
		if (tea_id==null||topic_id==null||course_id==null) {
			response.sendRedirect("fail.jsp");
		}
		else {
			Topic_InfoDao dao=new Topic_InfoDao();
			int row = dao.delete(tea_id, course_id, topic_id);
			if(row>0)
			{
				response.sendRedirect("success.jsp");
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
