package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Teacher_InfoDao;


public class TeaSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TeaSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Teacher_InfoDao dao = new Teacher_InfoDao();
		List<Map<String, Object>> list = dao.findall();
		HttpSession session = request.getSession();
		session.setAttribute("teas", list);
		response.sendRedirect("/StudentTopic/Essay/admin/teas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
