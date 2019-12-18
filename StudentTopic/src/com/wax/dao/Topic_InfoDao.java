package com.wax.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.Topic_info;
import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;

public class Topic_InfoDao {
	public List<Map<String, Object>> findAll(int currentPage){
		List<Map<String, Object>> list=null;
		String sql="select * from "
				+ "("
				+ "select rownum r,t.* from "
				+ "(select* from "
				+ "topic_info,teacher_info,course_info "
				+ "where topic_tea_id=tea_id and topic_course_id=course_id) t"
				+ " where rownum<=?"
				+ ")"
				+ "where r>=?";
		Object[]ob= {currentPage*8,(currentPage-1)*8+1};
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Topic_info> search(String topic_id){
		List<Topic_info> list=null;
		String sql="select * from  topic_info where topic_id=?";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		try {
			list = qr.query(sql,new BeanListHandler<Topic_info>(Topic_info.class,new BasicRowProcessor(new GenerousBeanProcessor())),topic_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> searchByTea(String tea_id){
		List<Map<String, Object>> list=null;
		String sql="select * from (select * from topic_info,course_info "
				+ "where topic_course_id(+)=course_id) "
				+ "where topic_tea_id=? or topic_tea_id is null";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> searchAllByTea(String tea_id,int currentPage){
		List<Map<String, Object>> list=null;
		String sql="select * from "
				+ "(select rownum r,t1.*,t2.*,t3.* from "
				+ "topic_info t1,course_info t2,teacher_info t3"
				+ " where topic_course_id(+)=course_id"
				+ " and topic_tea_id=? and topic_tea_id=tea_id and rownum<=?"
				+ ")"
				+ " where r>=?";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[]ob= {tea_id,currentPage*8,(currentPage-1)*8+1};
		try {
			list = qr.query(sql,new MapListHandler(),ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int delete( String tea_id,String course_id,String topic_id){
		int row=0;
		String sql="delete from topic_info "
				+ " where topic_tea_id=? and topic_course_id=? and topic_id=? ";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[] ob= {tea_id,course_id,topic_id};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public int update(Topic_info topic){
		int row=0;
		String sql="update topic_info "
				+ "set topic_name =?,topic_content =?,topic_limit_stu =?,topic_semater =?"
				+ " where topic_tea_id=? and topic_course_id=? and topic_id=? ";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[] obs= {topic.getTopic_name(),topic.getTopic_content(),topic.getTopic_limit_stu(),topic.getTopic_semater(),topic.getTopic_tea_id(),topic.getTopic_course_id(),topic.getTopic_id()};
		try {
			row = qr.update(sql,obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public int insert( Topic_info topic){
		int row=0;
		String sql="insert into topic_info(topic_name,topic_content,topic_limit_stu,topic_semater,"
				+ " topic_tea_id , topic_course_id , topic_id ) "
				+ "values( ?,?,?,?,?,?,? )";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[] obs= {topic.getTopic_name(),topic.getTopic_content(),topic.getTopic_limit_stu(),topic.getTopic_semater(),topic.getTopic_tea_id(),topic.getTopic_course_id(),topic.getTopic_id()};
		try {
			row = qr.update(sql,obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public  int getTotalCount() {
		String sql = "select count(1) from topic_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
}
