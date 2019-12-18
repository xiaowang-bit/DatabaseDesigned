package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.Admin_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Teacher_InfoDao;
import com.wax.service.AdminService;
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Admin_info admin=new Admin_info();
		admin.setAdmin_id(request.getParameter("admin_id"));
		admin.setAdmin_name(request.getParameter("admin_name"));
		admin.setAdmin_academy(request.getParameter("admin_academy"));
		admin.setAdmin_phone(request.getParameter("admin_phone"));
		admin.setAdmin_pwd(request.getParameter("admin_pwd"));
		admin.setAdmin_sex(request.getParameter("admin_sex"));
		admin.setAdmin_title(request.getParameter("admin_title"));
		admin.setAdmin_email(request.getParameter("admin_email"));
		AdminService dao = new AdminService();
		int row = dao.updateAdmin_info(admin);
		
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "修改成功！", "提示", 
        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
        	null, options, options[0]); 
        	response.sendRedirect("/StudentTopic/Essay/admin/main.html");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
