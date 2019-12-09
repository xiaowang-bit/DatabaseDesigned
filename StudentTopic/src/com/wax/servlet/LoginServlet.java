package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Admin_InfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String account = request.getParameter("account");
		String pwd = request.getParameter("pwd");
		String type = request.getParameter("user_leixing");
		
		if("管理员".equals(type))
		{
			Admin_InfoDao dao_admin = new Admin_InfoDao();
			List<Map<String, Object>> list_admin = dao_admin.checkLogin(account, pwd);
					if(list_admin!=null&&list_admin.size()>0)
					{
						//获取存放数据的区域
						HttpSession session = request.getSession();
						//把从数据库查到的数据存放到session
						//但是我们知道，按照账号和密码查询最多能查到一条数据
						session.setAttribute("login_admin",list_admin.get(0));
						response.sendRedirect("/StudentTopic/Essay/admin/main.html");
			        }
		            else{
		            	response.sendRedirect("fail.jsp");
		            }
		}
		else if("教师".equals(type))
		{
			Teacher_InfoDao dao_tea = new Teacher_InfoDao();
			List<Map<String, Object>> list_tea = dao_tea.checkLogin(account, pwd);
			if(list_tea!=null&&list_tea.size()>0)
			{
				//获取存放数据的区域
				HttpSession session = request.getSession();
				//把从数据库查到的数据存放到session
				//但是我们知道，按照账号和密码查询最多能查到一条数据
				session.setAttribute("login_tea",list_tea.get(0));
				response.sendRedirect("/StudentTopic/Essay/teacher/main.html");
			}
            else{
            	response.sendRedirect("fail.jsp");
            }
		}
		else if("学生".equals(type))
		{
			Student_infoDao dao_stu = new Student_infoDao();
			List<Map<String, Object>> list_stu = dao_stu.checkLogin(account, pwd);
			if(list_stu!=null&&list_stu.size()>0)
			{
				//获取存放数据的区域
				HttpSession session = request.getSession();
				//把从数据库查到的数据存放到session
				//但是我们知道，按照账号和密码查询最多能查到一条数据
				session.setAttribute("login_stu",list_stu.get(0));
				System.out.println(list_stu.get(0));
				response.sendRedirect("/StudentTopic/Essay/student/main.html");
			}
            else{
            	response.sendRedirect("fail.jsp");
            }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
