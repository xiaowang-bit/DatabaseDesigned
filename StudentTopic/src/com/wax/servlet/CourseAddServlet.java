package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.dao.Course_infoDao;
import com.wax.dao.Topic_InfoDao;

public class CourseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CourseAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");	
		String course_name = request.getParameter("course_name");
		String course_grade = request.getParameter("course_grade");
		String course_id = request.getParameter("course_id");
		if (course_id==null) {
			response.sendRedirect("fail.jsp");
		}
		else {
			Course_infoDao dao=new Course_infoDao();
			int row = dao.insert(course_id, course_name, course_grade);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
