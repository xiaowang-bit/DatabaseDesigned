package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;

public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tea_id = request.getParameter("tea_id");
		String tea_name = request.getParameter("tea_name");
		String tea_grade = request.getParameter("tea_sex");
		String tea_sex = request.getParameter("tea_academy");
		String tea_phone = request.getParameter("tea_phone");
		String tea_email = request.getParameter("tea_email");
		String tea_pwd = request.getParameter("tea_pwd");
		Teacher_InfoDao dao = new Teacher_InfoDao();
		int row = 0;
		Object[]ob= {tea_id, tea_name, tea_grade, tea_sex,tea_phone,tea_email,tea_pwd};
		row = dao.insert(ob);
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
