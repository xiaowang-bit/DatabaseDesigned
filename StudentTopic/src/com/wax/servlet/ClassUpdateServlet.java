package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.Class_InfoDao;
import com.wax.dao.Student_infoDao;

public class ClassUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String class_grade = request.getParameter("class_grade0");
		String class_name = request.getParameter("class_name0");
		String class_major = request.getParameter("class_major0");
		String class_academy = request.getParameter("class_academy0");
		Class_InfoDao dao = new Class_InfoDao();
		int row = dao.update(class_grade,class_name,class_major ,class_academy);
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
