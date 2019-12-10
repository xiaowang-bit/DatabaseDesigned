package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;

public class TeacherUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Teacher_info tea=new Teacher_info();
		tea.setTea_id(request.getParameter("tea_id"));
		tea.setTea_name(request.getParameter("tea_name"));
		tea.setTea_academy(request.getParameter("tea_academy"));
		tea.setTea_phone(request.getParameter("tea_phone"));
		tea.setTea_pwd(request.getParameter("tea_pwd"));
		tea.setTea_sex(request.getParameter("tea_sex"));
		tea.setTea_title(request.getParameter("tea_title"));
		tea.setTea_email(request.getParameter("tea_email"));
		Teacher_InfoDao dao = new Teacher_InfoDao();
		int row = dao.update(tea);
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
