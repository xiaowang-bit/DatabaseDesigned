package com.wax.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.dao.Teacher_InfoDao;


public class TeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no = request.getParameter("user_no");
		Teacher_InfoDao dao = new Teacher_InfoDao();
		int row = 0;
		row = dao.delete(no);
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "删除成功！", "提示", 
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
