package com.wax.service;

import java.util.List;

import com.wax.dao.SelectSubjectDao;
import com.wax.model.SelectSubject;

public class SelectSubjectService {
	SelectSubjectDao selectSubjectDao=new SelectSubjectDao();
	public int delete(String st_topic_id,String st_tea_id,String st_stu_id) {
		return selectSubjectDao.delete(st_topic_id, st_tea_id, st_stu_id);
	}
	public int setChecked(String st_topic_id,String st_tea_id,String st_stu_id) {
		return selectSubjectDao.setChecked(st_topic_id, st_tea_id, st_stu_id);
	}
	public List<SelectSubject> getChecked(String st_topic_id,String st_tea_id) {
		return selectSubjectDao.getChecked(st_topic_id, st_tea_id);
	}
	public List<SelectSubject> getUnchecked(String st_topic_id,String st_tea_id) {
		return selectSubjectDao.getUnchecked(st_topic_id, st_tea_id);
	}
}
