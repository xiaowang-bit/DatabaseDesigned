package com.wax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wax.JavaBeen.Student_info;
import com.wax.dao.Class_InfoDao;
import com.wax.service.AdminService;
import com.wax.utils.BeanUtil;
import com.wax.utils.Page;


public class StuSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StuSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String cpage = request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		int currentPage=Integer.parseInt(cpage);
		AdminService dao = new AdminService();
		List<Map<String, Object>> list = dao.searchAllStudent(currentPage);
		int totalCount = dao.getStudetnCount();
		Page page=new Page(list,totalCount,currentPage);
		HttpSession session = request.getSession();
		List<Map<String, Object>> cla = dao.searchAllClass();
		session.setAttribute("classes", cla);
		session.setAttribute("stus", page);
		response.sendRedirect("/StudentTopic/Essay/admin/stus.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
