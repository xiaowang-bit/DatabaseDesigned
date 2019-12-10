package com.wax.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;



public class Admin_InfoDao{
	public static Connection con;
	static {
		con=DBCPUtilsService.getConnection();
	}
	public List<Map<String, Object>> checkLogin(String no,Object pwd)
	{
		List<Map<String, Object>> list = null;
		String sql = "select * from admin_info where admin_id=? and admin_pwd=?";
		QueryRunner queryRunner = new QueryRunner();
		try {
			list = queryRunner.query(con,sql,new MapListHandler(),no,pwd);
			

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
