package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.SelectTopicInfoDao;

public class TopicSelectUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicSelectUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");	
		
		String topic_id = request.getParameter("topic_id");
		String stu_id = request.getParameter("stu_id");
		String course_id = request.getParameter("course_id");
		String tea_id = request.getParameter("tea_id");
		String check = request.getParameter("st_checked");
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		int row = dao.update(topic_id, stu_id, course_id, tea_id,check);
		if(row>0)
		{
			response.sendRedirect("success.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
