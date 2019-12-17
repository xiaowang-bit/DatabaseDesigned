package com.wax.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.SelectTopic_info;
import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;

public class SelectTopicInfoDao {
	public List<Map<String, Object>> findAll(String i,int currentPage){
		List<Map<String, Object>> list=null;
		String sql="select*from("
				+ "select  rownum r,t1.*,t2.*,t3.*,t4.* from select_topic_info t1,topic_info t2,teacher_info t3,student_info t4 "
				+ "where st_topic_id=topic_id and st_tea_id=tea_id and st_stu_id=stu_id and st_checked=? and rownum<=?"
				+ ")"
				+ "where r>=?";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[]ob= {i,currentPage*8,(currentPage-1)*8+1};
		try {
			list = qr.query(sql,new MapListHandler(),ob);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public SelectTopic_info searchOne(String topic_id,String stu_id,String tea_id,String team_id){
		SelectTopic_info list=null;
		String sql="select * from select_topic_info where st_topic_id=? and st_tea_id=? and st_stu_id=? and st_team_id=?";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[]ob= {topic_id, tea_id,stu_id,team_id};
		try {
			list = qr.query(sql,new BeanHandler<SelectTopic_info>(SelectTopic_info.class),ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> searchByTea(String tea_id,int currentPage){
		List<Map<String, Object>> list=null;
		String sql="select *from"
				+ "(select rownum r,t1.*,t2.*,t3.*,t4.*,t5.*,t6.* from select_topic_info t1,topic_info t6,student_info t2,"
				+ "team_info t3,course_info t4,teacher_info t5"
				+ " where topic_course_id=course_id and st_topic_id=topic_id"
				+ " and team_id=st_team_id and st_tea_id=tea_id and st_stu_id=stu_id "
				+ "and st_tea_id=? and rownum<=?)"
				+ "where r>=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[] ob= {tea_id,currentPage*8,(currentPage-1)*8+1};
		try {
			list = qr.query(sql,new MapListHandler(),ob);
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
	public List<Map<String, Object>> searchByTopic(String topic_id){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info where st_topic_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),topic_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<Map<String, Object>> searchBystu(String topic_id,String st_stu_check){
		List<Map<String, Object>> list=null;
		String sql="select * from select_topic_info where st_topic_id=? and st_stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),topic_id,st_stu_check);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insert(SelectTopic_info selectpInfo){
		int row=0;
		String sql="insert into select_topic_info values(?,?,?,?,?,?,?)";
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		Object[]ob= {selectpInfo.getSt_semater(),selectpInfo.getSt_topic_id(),selectpInfo.getSt_tea_id(),selectpInfo.getSt_stu_id(),selectpInfo.getSt_team_id(),selectpInfo.getSt_stu_check(),selectpInfo.getSt_checked()};
		try {
			row = qr.update(sql,ob);
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
	public int updateCheck(SelectTopic_info selectpInfo,String check){
		int row = 0;
		String sql = "UPDATE select_topic_info SET st_checked=? WHERE st_topic_id=? and st_stu_id=? and st_team_id = ? and st_tea_id=? ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {check,selectpInfo.getSt_topic_id(), selectpInfo.getSt_stu_id(), selectpInfo.getSt_team_id(), selectpInfo.getSt_tea_id()};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public  int getTotalCount() {
		String sql = "select count(1) from select_topic_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
}
