package com.wax.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Topic_info;
import com.wax.service.DBCPUtilsService;

public class SelectTopicInfoDao {
	public static Connection con;
	static {
		con=DBCPUtilsService.getConnection();
	}
	public List<Map<String, Object>> findAll(String i){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info,topic_info,teacher_info,student_info where st_topic_id=topic_id and st_tea_id=tea_id and st_stu_id=stu_id and st_checked=?";
		QueryRunner qr=new QueryRunner();
		try {
			list = qr.query(con,sql,new MapListHandler(),i);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> searchByTea(String tea_id){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info,topic_info,student_info,course_info,teacher_info "
				+ " where st_course_id=course_id and st_topic_id=topic_id and st_tea_id=tea_id and st_stu_id=stu_id "
				+ "and st_tea_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> searchByClass(String tea_id){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info,topic_info,team_info,student_info,course_info "
				+ " where st_course_id=course_id and st_topic_id=topic_id and st_stu_id=stu_id "
				+ "and team_id=st_team_id and st_tea_id=? and st_checked ='通过' and st_stu_check='组长'";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> search(String st_stu_id){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info,topic_info,teacher_info,student_info where st_tea_id=tea_id and st_topic_id=topic_id and stu_id=st_stu_id and st_stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),st_stu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int insert(String st_semater,String topic_id,String tea_id,String course_id,String stu_id,String st_stu_check){
		int row=0;
		String sql="insert into select_topic_info values(?,?,?,?,?,?,?)";
		String sql2="select * from select_topic_info where st_stu_check=? and st_topic_id=?";
		String sql3="select * from select_topic_info where st_topic_id=?";
		
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {st_semater,topic_id,tea_id,course_id,stu_id,st_stu_check,"未审核"};
		Object[]ob2= {st_stu_check,topic_id};
		
		try {
			//只有一个组长的限制、和人数限制
			List<SelectTopic_info> search3 = qr.query(sql3, new BeanListHandler<SelectTopic_info>(SelectTopic_info.class,new BasicRowProcessor(new GenerousBeanProcessor())),topic_id);
			if("组长".equals(st_stu_check)) {
				List<SelectTopic_info> search2 = qr.query(sql2, new BeanListHandler<SelectTopic_info>(SelectTopic_info.class,new BasicRowProcessor(new GenerousBeanProcessor())),ob2);
				if(search2==null||search2.size()<=0)
					if(search3.size()>=0&&search3.size()<=4)
						row = qr.update(sql,ob);
			}
			else{
				List<Map<String, Object>> search = search(stu_id);
				if(search==null||search.size()<=0)
					if(search3.size()>=0&&search3.size()<=4)
						row = qr.update(sql,ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public int delete(String no){
		int row = 0;
		String sql = "delete from select_topic_info where st_stu_id= ?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			row = qr.update(sql,no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	
	public int update(String topic_id,String  stu_id,String course_id,String tea_id,String check){
		int row = 0;
		String sql = "UPDATE select_topic_info SET st_checked=? WHERE st_topic_id=? and st_stu_id=? and st_course_id = ? and st_tea_id=? ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {check,topic_id, stu_id, course_id, tea_id};
		try {
			if("不通过".equals(check)) {
				row = delete(stu_id);
			} else {
				row = qr.update(sql,ob);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
