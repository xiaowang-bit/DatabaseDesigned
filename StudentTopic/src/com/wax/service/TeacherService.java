package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.dao.SelectTopicInfoDao;

public class TeacherService {
	public List<Map<String, Object>> searchTopicByTeaId(String tea_id,int currentPage) {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		return dao.searchByTea(tea_id,currentPage);
	}
	public int updateCheck(String topic_id,String stu_id, String tea_id,String team_id,String check) {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		SelectTopic_info st_topic = (SelectTopic_info) dao.searchOne(topic_id, stu_id, tea_id, team_id);
		return  dao.updateCheck(st_topic,check);
	}
	public int getTatolCount() {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		return dao.getTotalCount();
	}
}
