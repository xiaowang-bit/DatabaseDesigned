package com.wax.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Topic_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Topic_InfoDao;
import com.wax.service.StudentService;

public class StudentSelectTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentSelectTopicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String topic_id = request.getParameter("topic_id");
		String st_semater  = request.getParameter("st_semater");
		String st_stu_check=request.getParameter("st_stu_check");
		String tea_id=request.getParameter("tea_id");
		String stu_id=request.getParameter("stu_id");
		String team_id=request.getParameter("team_id");
		SelectTopic_info topic=new SelectTopic_info(st_semater,topic_id,tea_id,stu_id,team_id,st_stu_check,"未审核" );
		StudentService dao=new StudentService();
		int row = dao.addTopic(topic);
		if(row>0)
		{
			Object[] options = { "确定" }; 
        	JOptionPane.showOptionDialog(null, "选题成功！", "提示", 
        	JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
        	null, options, options[0]); 
			response.sendRedirect("/StudentTopic/Essay/student/subjs.jsp");
		}
		else{
			response.sendRedirect("fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
