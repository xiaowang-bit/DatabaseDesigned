package com.wax.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.service.DBCPUtilsService;



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
	public List<Map<String, Object>> checkemail(String no,String email)
	{
		List<Map<String, Object>> list = null;
		String sql = "select * from t_man_info where man_no=? and man_email = ? ";
		QueryRunner queryRunner = new QueryRunner();
        Object[] params={no,email};
		try {
			list = queryRunner.query(con, sql,params,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
