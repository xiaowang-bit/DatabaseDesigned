package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.service.AdminService;

public class SearchClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchClassServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService as=new AdminService();
		List<Map<String, Object>> list = as.searchAllClass();
		HttpSession session = request.getSession();
		session.setAttribute("classes", list);
		System.out.println(list);
		response.sendRedirect("/StudentTopic/Essay/admin/stu_add.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
