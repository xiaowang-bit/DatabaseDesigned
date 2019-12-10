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
import com.wax.JavaBeen.Topic_info;
import com.wax.service.DBCPUtilsService;

public class Topic_InfoDao {
	public static Connection con;
	static {
		con=DBCPUtilsService.getConnection();
	}
	public List<Map<String, Object>> findAll(){
		List<Map<String, Object>> list=null;
		String sql="select * from topic_info,teacher_info,course_info where topic_tea_id=tea_id and topic_course_id=course_id";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Topic_info> search(String topic_id){
		List<Topic_info> list=null;
		String sql="select * from topic_info where topic_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
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
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> searchAllByTea(String tea_id){
		List<Map<String, Object>> list=null;
		String sql="select * from topic_info,course_info,teacher_info "
				+ " where topic_course_id(+)=course_id"
				+ " and topic_tea_id=? and topic_tea_id=tea_id ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int delete( String tea_id,String course_id,String topic_id){
		int row=0;
		String sql="delete from topic_info "
				+ " where topic_tea_id=? and topic_course_id=? and topic_id=? ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[] ob= {tea_id,course_id,topic_id};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public int update( String topic_name ,String topic_content ,String topic_academy ,String topic_limit_stu,String topic_semater, String tea_id,String course_id,String topic_id){
		int row=0;
		String sql="update topic_info "
				+ "set topic_name =?,topic_content =?,topic_academy =?,topic_limit_stu =?,topic_semater =?"
				+ " where topic_tea_id=? and topic_course_id=? and topic_id=? ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[] obs= {topic_name,topic_content,topic_academy,topic_limit_stu,topic_semater,tea_id,course_id,topic_id};
		try {
			row = qr.update(sql,obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public int insert( String topic_name ,String topic_content ,String topic_academy ,String topic_limit_stu,String topic_semater, String tea_id,String course_id,String topic_id){
		int row=0;
		String sql="insert into topic_info(topic_name,topic_content,topic_academy,topic_limit_stu,topic_semater,"
				+ " topic_tea_id , topic_course_id , topic_id ) "
				+ "values( ?,?,?,?,?,?,?,? )";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[] obs= {topic_name,topic_content,topic_academy,topic_limit_stu,topic_semater,tea_id,course_id,topic_id};
		try {
			row = qr.update(sql,obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}

}
