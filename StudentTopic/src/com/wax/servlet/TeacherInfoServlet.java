package com.wax.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.Teacher_info;
import com.wax.service.TeacherService;

public class TeacherInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherService dao = new TeacherService();
		String tea_id = request.getParameter("tea_id");
		Teacher_info tea = dao.searchTeacherInfo(tea_id);
		HttpSession session = request.getSession();
		session.setAttribute("teas", tea);
		response.sendRedirect("/StudentTopic/Essay/teacher/tea_inf.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
