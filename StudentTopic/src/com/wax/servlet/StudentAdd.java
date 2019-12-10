package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.dao.Student_infoDao;

public class StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stu_id = request.getParameter("stu_id");
		String stu_name = request.getParameter("stu_name");
		String stu_grade = request.getParameter("stu_grade");
		String stu_sex = request.getParameter("stu_sex");
		String stu_class = request.getParameter("stu_class");
		String stu_phone = request.getParameter("stu_phone");
		String stu_email = request.getParameter("stu_email");
		String stu_pwd = request.getParameter("stu_pwd");
		Student_infoDao dao = new Student_infoDao();
		int row = 0;
		Object[]ob= {stu_id, stu_name, stu_grade, stu_sex,stu_class,stu_phone,stu_email,stu_pwd};
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
