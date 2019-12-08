package com.wax.service;

import java.util.List;

import com.wax.dao.SubjectDao;
import com.wax.model.Subject;

public class SubjectService {
	SubjectDao subjectDao=new SubjectDao();
	public int add(Subject subject) {
		return subjectDao.add(subject);
	}
	public int save(Subject subject) {
		return subjectDao.save(subject);
	}
	public List <Subject> getAllSubject() {
		return subjectDao.getAllSubject();
	}
	public List <Subject> getSubjectByTea_name(String topic_tea_name) {
		return subjectDao.getSubjectByTea_name(topic_tea_name);
	}
	public Subject get(String topic_id,String topic_tea_id) {
		return subjectDao.get(topic_id, topic_tea_id);
	}
}
