package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.Student_info;
import com.wax.dao.Student_infoDao;
import com.wax.service.AdminService;

public class StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String stu_id = request.getParameter("stu_id");
		String stu_name = request.getParameter("stu_name");
		String stu_class_id = request.getParameter("class_id");
		String stu_sex = request.getParameter("stu_sex");
		String stu_phone = request.getParameter("stu_phone");
		String stu_email = request.getParameter("stu_email");
		String stu_pwd = request.getParameter("stu_pwd");
		Student_info stu=new Student_info(stu_id, stu_name, stu_class_id, stu_sex, stu_phone, stu_email, stu_pwd);
		AdminService dao = new AdminService();
		int row = dao.addStudent(stu);
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "添加成功！", "提示", 
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
