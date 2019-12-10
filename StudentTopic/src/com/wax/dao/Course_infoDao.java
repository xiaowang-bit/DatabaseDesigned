package com.wax.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;

public class Course_infoDao {
	public List<Map<String, Object>> findAll(){
		List<Map<String, Object>> list=null;
		String sql="select * from course_info";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int insert( String course_id  ,String course_name  ,String course_grade) {
		int row=0;
		String sql="insert into course_info values( ?,?,? )";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[] obs= { course_id  ,course_name  ,course_grade};
		try {
			row = qr.update(sql,obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return row;
	}
	public  int getTotalCount() {
		String sql = "select count(1) from admin_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
}
