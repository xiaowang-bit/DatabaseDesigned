package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.Class_Info;
import com.wax.dao.Class_InfoDao;
import com.wax.service.AdminService;

public class ClassAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String class_id=request.getParameter("class_id");
		String class_grade=request.getParameter("class_grade");
		String class_name=request.getParameter("class_name");
		String class_major=request.getParameter("class_major");
		String class_academy=request.getParameter("class_academy");
		Class_Info cla=new Class_Info(class_id,class_grade, class_name, class_major, class_academy);
		AdminService as=new AdminService();
		int row=as.addClass(cla);
		if(row>0){
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "添加成功！", "提示", 
        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
        	null, options, options[0]); 
			response.sendRedirect("/StudentTopic/Essay/admin/stus.jsp");
		}else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
