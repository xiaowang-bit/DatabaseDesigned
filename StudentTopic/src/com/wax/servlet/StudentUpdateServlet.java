package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.Student_infoDao;
import com.wax.service.StudentService;

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
		stu.setStu_class_id(request.getParameter("stu_class_id"));
		stu.setStu_phone(request.getParameter("stu_phone"));
		stu.setStu_pwd(request.getParameter("stu_pwd"));
		stu.setStu_sex(request.getParameter("stu_sex"));
		stu.setStu_email(request.getParameter("stu_email"));
		StudentService dao = new StudentService();
		int row = dao.updateStudentInfo(stu);
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
