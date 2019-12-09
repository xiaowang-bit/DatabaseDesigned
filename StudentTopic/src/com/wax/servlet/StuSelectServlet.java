package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Student_infoDao;


public class StuSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StuSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Student_infoDao dao = new Student_infoDao();
		List<Map<String, Object>> list = dao.findall();
		HttpSession session = request.getSession();
		session.setAttribute("stus", list);
		response.sendRedirect("/StudentTopic/Essay/admin/stus.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
