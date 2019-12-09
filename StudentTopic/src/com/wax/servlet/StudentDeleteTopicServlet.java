package com.wax.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.dao.SelectTopicInfoDao;

public class StudentDeleteTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentDeleteTopicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		String st_stu_id=request.getParameter("stu_id");
		int row = dao.delete(st_stu_id);
		if(row>0)
		{
			response.sendRedirect("success.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
