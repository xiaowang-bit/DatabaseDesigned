package com.wax.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.wax.model.SelectSubject;
import com.wax.service.SelectSubjectService;

/**
 * Servlet implementation class SelectSubjectServlet
 */
public class SelectSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SelectSubjectService selectSubjectService=new SelectSubjectService();
    public SelectSubjectServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		String mn=request.getServletPath();
		mn=mn.substring(1);
		mn=mn.substring(0, mn.length()-5);
		try {
			Method method=this.getClass().getDeclaredMethod(mn, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SelectSubject> selectSubjects=selectSubjectService.getUnchecked(request.getParameter("st_topic_id"), request.getParameter("st_tea_id"));
		List<SelectSubject> selectSubjectss=selectSubjectService.getChecked(request.getParameter("st_topic_id"), request.getParameter("st_tea_id"));
		request.setAttribute("selectSubjectList", selectSubjects);
		request.setAttribute("selectSubjectLists", selectSubjectss);
		request.setAttribute("st_topic_id", request.getParameter("st_topic_id"));
		request.setAttribute("st_tea_id", request.getParameter("st_tea_id"));
		request.getRequestDispatcher("/subjects.jsp").forward(request, response);
	}
	private void set_flag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rows=0;
		String st_topic_id=request.getParameter("st_topic_id");
		String st_tea_id=request.getParameter("st_tea_id");
		String st_stu_id=request.getParameter("st_stu_id");
		String st_checked=request.getParameter("st_checked");
		if(st_checked.equals("同意")) {
			rows=selectSubjectService.setChecked(st_topic_id, st_tea_id, st_stu_id);
		}else {
			rows=selectSubjectService.delete(st_topic_id, st_tea_id, st_stu_id);
		}
	}
}
