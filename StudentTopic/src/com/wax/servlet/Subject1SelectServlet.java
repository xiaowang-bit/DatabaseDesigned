package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.service.AdminService;
import com.wax.utils.Page;

public class Subject1SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Subject1SelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cpage = request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		int currentPage=Integer.parseInt(cpage);
		AdminService dao = new AdminService();
		List<Map<String, Object>> list = dao.searchAllSelectTopic("未审核", currentPage);
		int totalCount = dao.getSelectTopicCount();
		Page page=new Page(list,totalCount,currentPage);
		HttpSession session = request.getSession();
		session.setAttribute("subjs1", page);
		response.sendRedirect("/StudentTopic/Essay/admin/subjs1.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
