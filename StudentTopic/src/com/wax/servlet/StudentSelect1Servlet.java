package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Topic_InfoDao;

public class StudentSelect1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSelect1Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Student_infoDao dao = new Student_infoDao();
		String stu_id=request.getParameter("stu_id");
		List<Student_info> list = dao.search(stu_id);
		HttpSession session = request.getSession();
		session.setAttribute("stu_id", list.get(0).getStu_id());
		session.setAttribute("stu_name", list.get(0).getStu_name());
		session.setAttribute("stu_grade", list.get(0).getStu_grade());
		session.setAttribute("stu_sex", list.get(0).getStu_sex() );
		session.setAttribute("stu_major", list.get(0).getStu_major());
		session.setAttribute("stu_class", list.get(0).getStu_class());
		session.setAttribute("stu_academy", list.get(0).getStu_academy());
		session.setAttribute("stu_phone", list.get(0).getStu_phone());
		session.setAttribute("stu_email", list.get(0).getStu_email());
		session.setAttribute("stu_pwd", list.get(0).getStu_pwd());
		
		response.sendRedirect("/StudentTopic/Essay/student/stu_info.jsp");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
