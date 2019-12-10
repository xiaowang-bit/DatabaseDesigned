package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.Team_info;
import com.wax.dao.Team_infoDao;
import com.wax.dao.Topic_InfoDao;
import com.wax.utils.Page;

public class StudentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Team_infoDao teamdao=new Team_infoDao();
		List<Team_info> teams = teamdao.searchAll();
		//将分页所需的5个字段组装到page对象中
		int currentPage=Integer.parseInt(request.getParameter("currentPage"));
		Topic_InfoDao dao = new Topic_InfoDao();
		int totalCount = dao.getTotalCount();
		List<Map<String, Object>> list = dao.findAll(currentPage);
		Page page=new Page(list,totalCount,currentPage);
		HttpSession session = request.getSession();
		System.out.println(teams);
		session.setAttribute("subjs", page);
		session.setAttribute("teams", teams);
		response.sendRedirect("/StudentTopic/Essay/student/subjs.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
