package com.wax.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.Admin_info;
import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;



public class Admin_InfoDao{
	public List<Map<String, Object>> checkLogin(String no,Object pwd)
	{
		List<Map<String, Object>> list = null;
		String sql = "select * from admin_info where admin_id=? and admin_pwd=?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDataSource());
		try {
			list = queryRunner.query(sql,new MapListHandler(),no,pwd);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  int getTotalCount() {
		String sql = "select count(1) from admin_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
	public int update(Admin_info admin) {
		int row=0;
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update admin_info set admin_name=?,admin_sex=?,admin_academy=?,admin_title=?," 
				+"admin_phone=?,admin_email=?,admin_pwd=? where admin_id=?";
		Object[]ob= {admin.getAdmin_name(),admin.getAdmin_sex(),admin.getAdmin_academy()
				,admin.getAdmin_title(),admin.getAdmin_phone()
				,admin.getAdmin_email(),admin.getAdmin_pwd(),admin.getAdmin_id()};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return row;
		
	}
}
