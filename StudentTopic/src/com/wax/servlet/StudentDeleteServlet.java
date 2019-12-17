package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.wax.dao.Student_infoDao;
import com.wax.service.AdminService;

public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public StudentDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String stu_id = request.getParameter("user_no");
		AdminService dao = new AdminService();
		int row = dao.deleteStudent(stu_id);
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "删除成功！", "提示", 
        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
        	null, options, options[0]); 
        	response.sendRedirect("/StudentTopic/Essay/admin/stus.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
