package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Class_InfoDao;
import com.wax.dao.Topic_InfoDao;

public class ClassSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Class_InfoDao dao = new Class_InfoDao();
		List<Map<String, Object>> list = dao.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("classes", list);
		response.sendRedirect("/StudentTopic/Essay/admin/class.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
