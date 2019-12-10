package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Topic_info;
import com.wax.dao.SelectTopicInfoDao;
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
}
