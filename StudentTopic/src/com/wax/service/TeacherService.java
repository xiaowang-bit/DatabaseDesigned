package com.wax.service;

import java.util.List;

import com.wax.dao.TeacherDao;
import com.wax.model.Teacher;

public class TeacherService {
	TeacherDao teacherDao=new TeacherDao();
	
	public int add(Teacher teacher) {
		return teacherDao.add(teacher);
	}
	
	
	public int delete(String tea_id) {
		return teacherDao.delete(tea_id);
	}
	
	
	public int save(Teacher teacher) {
		return teacherDao.save(teacher);
	}
	
	
	public Teacher get(String tea_id) {
		return teacherDao.get(tea_id);
	}
	
	
	public List<Teacher> getAllTeacher() {
		return teacherDao.getAllTeacher();
	}
	public Teacher getByName(String tea_name) {
		return teacherDao.getByName(tea_name);
	}
}
