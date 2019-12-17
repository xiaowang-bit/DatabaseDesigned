package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;
import com.wax.service.AdminService;

public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String tea_id = request.getParameter("tea_id");
		String tea_name = request.getParameter("tea_name");
		String tea_sex = request.getParameter("tea_sex");
		String tea_academy = request.getParameter("tea_academy");
		String tea_title = request.getParameter("tea_title");
		String tea_phone = request.getParameter("tea_phone");
		String tea_email = request.getParameter("tea_email");
		String tea_pwd = request.getParameter("tea_pwd");
		Teacher_info tea=new Teacher_info(tea_id, tea_name, tea_sex, tea_academy, tea_title, tea_phone, tea_email, tea_pwd);
		AdminService as=new AdminService();
		int row = as.addTeacher(tea);
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "添加成功！", "提示", 
        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
        	null, options, options[0]); 
			response.sendRedirect("/StudentTopic/Essay/admin/teas.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
