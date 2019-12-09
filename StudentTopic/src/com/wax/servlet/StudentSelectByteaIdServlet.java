package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Topic_InfoDao;

public class StudentSelectByteaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSelectByteaIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String tea_id = request.getParameter("mylink");
		Topic_InfoDao dao = new Topic_InfoDao();
		List<Map<String, Object>> list = dao.searchAllByTea(tea_id);
		HttpSession session = request.getSession();
		session.setAttribute("subjs", list);
		response.sendRedirect("/StudentTopic/Essay/student/subjs.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}