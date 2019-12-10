package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.SelectTopicInfoDao;

public class ListClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListClassServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String tea_id=request.getParameter("tea_id");
		SelectTopicInfoDao dao = new SelectTopicInfoDao();
		List<Map<String, Object>> list = dao.searchByClass(tea_id);
		HttpSession session = request.getSession();
		session.setAttribute("sub", list);
		response.sendRedirect("/StudentTopic/Essay/teacher/class.jsp");		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
