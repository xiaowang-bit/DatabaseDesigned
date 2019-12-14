package com.wax.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Teacher_InfoDao;
import com.wax.service.AdminService;
import com.wax.utils.BeanUtil;
import com.wax.utils.Page;


public class TeaSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TeaSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String cpage = request.getParameter("currentPage");
		if(cpage==null) {
			cpage="1";
		}
		int currentPage=Integer.parseInt(cpage);
		AdminService dao = new AdminService();
		List<Teacher_info> list = dao.searchAllTeacher(currentPage);
		int totalCount = dao.getTeacherCount();
		List<Map<String, Object>>listmap=new ArrayList<Map<String,Object>>();
		for(Teacher_info stu:list) {
			try {
				Map<String, Object> bean2map = BeanUtil.bean2map(stu);
				listmap.add(bean2map);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Page page=new Page(listmap,totalCount,currentPage);
		HttpSession session = request.getSession();
		session.setAttribute("teas", page);
		response.sendRedirect("/StudentTopic/Essay/admin/teas.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
