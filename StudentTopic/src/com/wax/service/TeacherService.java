package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.JavaBeen.Topic_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Teacher_InfoDao;
import com.wax.dao.Team_infoDao;
import com.wax.dao.Topic_InfoDao;

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
	public int addTopic(Topic_info topic) {
		Topic_InfoDao dao=new Topic_InfoDao();
		List<Topic_info> search = dao.search(topic.getTopic_id());
		if(search==null||search.size()<1) {
			return dao.insert(topic);
		}else {
			return 0;
		}
	}
	public int updateTopic(Topic_info topic) {
		Topic_InfoDao dao=new Topic_InfoDao();
		List<Topic_info> search = dao.search(topic.getTopic_id());
		if(search!=null&&search.size()>0) {
			return dao.update(topic);			
		}
		return 0;
	}
	public Teacher_info searchTeacherInfo(String tea_id) {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		Teacher_info search = dao.searchBytea_id(tea_id);
		return search;
	}
	public List<Map<String, Object>> searchGroupByTeam(String tea_id) {
		Team_infoDao dao=new Team_infoDao();
		return dao.searchGroupByTeam(tea_id);
	}
}
