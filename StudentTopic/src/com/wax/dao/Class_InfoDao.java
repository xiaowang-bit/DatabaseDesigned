package com.wax.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.Class_Info;
import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;

public class Class_InfoDao {
	public static Connection con;
	static {
		con = DBCPUtilsService.getConnection();
	}
	public int insert(String no,String name,String pwd,String check)
	{
		int str = 0;
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		String sql = "insert into class_info(class_grade,class_name,class_major,class_academy) values(?,?,?,?)";
		Object[] agure= {no,name,pwd,check};
		try {
			int lt = qr.update(con, sql,agure);
			str=lt;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	public int delete(String class_grade,String class_name,String class_major ,String class_academy)
	{
		int row = 0;
		String sql = "delete from class_info where class_grade=? and class_name=? and class_major=? and class_academy=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {class_grade,class_name,class_major ,class_academy};
		try {
			row = qr.update(con, sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public int update(String class_grade,String class_name,String class_major ,String class_academy)
	{
		int row = 0;
		String sql = "update class_info set class_grade=? and class_name=? and class_major=? and class_academy=? "
				+ "where class_grade=? and class_name=? and class_major=? and class_academy=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {class_grade,class_name,class_major ,class_academy,class_grade,class_name,class_major ,class_academy};
		try {
			row = qr.update(con, sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public List<Map<String, Object>> findAll(){
		List<Map<String, Object>> list = null;
		QueryRunner qr=new QueryRunner();
		String sql="select *from class_info";
		try {
			list = qr.query(con,sql,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public  int getTotalCount() {
		String sql = "select count(1) from admin_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
}
