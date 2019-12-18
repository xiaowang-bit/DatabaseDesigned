package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Topic_info;
import com.wax.dao.SelectTopicInfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Team_infoDao;
import com.wax.dao.Topic_InfoDao;

public class StudentService {
	public int addTopic(SelectTopic_info topic) {
		int row=0;
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		List<Map<String, Object>> search = dao.search(topic.getSt_stu_id());
		if (search==null||search.size()<=0) {
			List<Map<String, Object>> searchBystu = dao.searchBystu(topic.getSt_topic_id(), topic.getSt_stu_check());
			if (searchBystu==null||searchBystu.size()<=0) {
				Topic_InfoDao dao2=new Topic_InfoDao();
				List<Topic_info> search2 = dao2.search(topic.getSt_topic_id());
				List<Map<String, Object>> searchByTopic = dao.searchByTopic(topic.getSt_topic_id());
				if (searchBystu!=null||searchByTopic.size()<=Integer.parseInt(search2.get(0).getTopic_limit_stu())) {
					row = dao.insert(topic);
				}
			}
		}
		return row;
	} 
	public int deleteTopic(String stu_id) {
		SelectTopicInfoDao dao=new SelectTopicInfoDao();
		List<Map<String, Object>> search = dao.search(stu_id);
		if("通过".equals(search.get(0).get("st_checked"))){
			return 0;
		}
		return dao.delete(stu_id);
	}
	public List<Map<String, Object>> searchStu(String stu_id) {
		Student_infoDao dao=new Student_infoDao();
		return dao.search(stu_id);
	}
	public int updateStudentInfo(Student_info stu) {
		Student_infoDao dao=new Student_infoDao();
		return dao.update(stu);
	}
	public int updateReport(String team_id,String status) {
		Team_infoDao dao=new Team_infoDao();
		return dao.updateTeam_report_status(team_id, status);
	}
}
