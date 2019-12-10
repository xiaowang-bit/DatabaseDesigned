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

public class StudentSelectByteaIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSelectByteaIdServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Team_infoDao teamdao=new Team_infoDao();
		List<Team_info> teams = teamdao.searchAll();
		String tea_id = request.getParameter("select_tea_id");
		String cPage = request.getParameter("currentPage");
		int currentPage=0;
		if(cPage==null) {
			currentPage=1;
		}else {
			currentPage=Integer.parseInt(cPage);
		}
		Topic_InfoDao dao = new Topic_InfoDao();
		int totalCount = dao.getTotalCount();
		List<Map<String, Object>> list = dao.searchAllByTea(tea_id,currentPage);
		Page page=new Page(list,totalCount,currentPage);

		HttpSession session = request.getSession();
		session.setAttribute("teams", teams);
		session.setAttribute("subjs1", page);
		response.sendRedirect("/StudentTopic/Essay/student/subs1.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
