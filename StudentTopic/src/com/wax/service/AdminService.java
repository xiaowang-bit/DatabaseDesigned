package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.Admin_info;
import com.wax.JavaBeen.Class_Info;
import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Admin_InfoDao;
import com.wax.dao.Class_InfoDao;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;

public class AdminService {
	public List<Map<String, Object>> searchAllStudent(int currentPage) {
		Student_infoDao dao=new Student_infoDao();
		return dao.searchByPage(currentPage);
	}
	public int getStudetnCount () {
		Student_infoDao dao=new Student_infoDao();
		return dao.getTotalCount();
	}
	public int getSelectTopicCount () {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		return dao.getTotalCount();
	}
	public int addTeacher(Teacher_info tea) {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		Teacher_info searchBytea_id = dao.searchBytea_id(tea.getTea_id());
		if(searchBytea_id==null)
			return dao.insert(tea);
		return 0;
	}
	public int deleteStudent(String stu_id) {
		Student_infoDao dao=new Student_infoDao();
		return dao.delete(stu_id);
	} 
	public int getTeacherCount () {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		return dao.getTotalCount();
	}
	public List<Teacher_info> searchAllTeacher(int currentPage) {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		return dao.searchAll(currentPage);
	}
	public List<Map<String, Object>> searchAllClass () {
		Class_InfoDao dao=new Class_InfoDao();
		return dao.findAll();
	}
	public int addClass(Class_Info cla) {
		Class_InfoDao dao=new Class_InfoDao();
		List<Map<String, Object>> search = dao.search(cla.getClass_id());
		if(search==null||search.size()<=0)
			return dao.insert(cla);
		return 0;
	}
	public int addStudent(Student_info stu) {
		Student_infoDao dao=new Student_infoDao();
		List<Map<String, Object>> search = dao.search(stu.getStu_id());
		if(search==null||search.size()<=0)
			return dao.insert(stu);
		return 0;
	}
	public List<Map<String, Object>> searchAllSelectTopic(String i,int currentPage) {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		List<Map<String, Object>> list = dao.findAll(i, currentPage);
		return list;
	}
	public int updateAdmin_info(Admin_info admin) {
		Admin_InfoDao dao=new Admin_InfoDao();
		return dao.update(admin);
	}
}
