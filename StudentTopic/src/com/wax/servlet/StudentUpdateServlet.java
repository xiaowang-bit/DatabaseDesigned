package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.Student_infoDao;

public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Student_info stu=new Student_info();
		stu.setStu_id(request.getParameter("stu_id"));
		stu.setStu_name(request.getParameter("stu_name"));
		stu.setStu_grade(request.getParameter("stu_grade"));
		stu.setStu_major(request.getParameter("stu_major"));
		stu.setStu_class(request.getParameter("stu_class"));
		stu.setStu_academy(request.getParameter("stu_academy"));
		stu.setStu_phone(request.getParameter("stu_phone"));
		stu.setStu_pwd(request.getParameter("stu_pwd"));
		stu.setStu_sex(request.getParameter("stu_sex"));
		Student_infoDao dao = new Student_infoDao();
		int row = dao.update(stu);
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
