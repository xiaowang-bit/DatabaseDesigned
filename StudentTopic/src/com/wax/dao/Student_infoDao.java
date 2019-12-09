package com.wax.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.neu.dao.BaseDao;
import com.wax.JavaBeen.SelectTopic_info;
import com.wax.JavaBeen.Student_info;
import com.wax.service.DBCPUtilsService;

public class Student_infoDao{
	public static Connection con;
	static {
		con = DBCPUtilsService.getConnection();
	}
	public int insert(Object[]ob)
	{
		int str = 0;
		String sql = "insert into t_student_info values(?,?,?,?)";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			str = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	public int update(Student_info stu)
	{
		int row = 0;
		String sql = "update student_info set "
				+ "stu_name=?,stu_grade =?,stu_class=?,stu_major=?,"
				+ "stu_sex =?,stu_pwd=?,stu_academy=?,stu_phone=?,"
				+ "stu_email=? where stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob={stu.getStu_name(),stu.getStu_grade(),stu.getStu_class(),stu.getStu_major(),stu.getStu_sex(),stu.getStu_pwd(),stu.getStu_academy(),stu.getStu_phone(),stu.getStu_email(),stu.getStu_id()};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	public int updateCheck(String check,String sno)
	{
		int str = 0;
		String sql = "UPDATE t_student_info SET stu_checked=? where stu_no=?";
//		str = super.executeUpdate(sql, check,sno);
		return str;
	}
	
	public int delete(String no)
	{
		int row = 0;
		String sql = "delete from student_info where stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			row = qr.update(con, sql,no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public List<Map<String, String>> select()
	{
		List<Map<String, String>> list = null;
		String sql = "select * from t_student_info";
//		list = qr.executeQuery(sql);
		return list;
	}
	public List<Student_info> search(String stu_id)
	{
		List<Student_info> list = null;
		String sql = "select * from student_info where stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new BeanListHandler<Student_info>(Student_info.class,new BasicRowProcessor(new GenerousBeanProcessor())),stu_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Map<String, Object>> checkLogin(String no,String pwd)
	{
		List<Map<String, Object>> list = null;
		String sql = "select * from student_info where stu_id=? and stu_pwd = ? ";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob= {no,pwd};
		try {
			list=qr.query(sql,new MapListHandler(), ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Map<String, Object>> findall()
	{
		List<Map<String, Object>> list = null;
		QueryRunner qr=new QueryRunner();
		String sql="select *from Student_info";
		try {
			list = qr.query(con,sql,new MapListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int updatecheck(String no)
	{
		int row = 0;
		String sql = "update t_student_info set stu_checked=1 where stu_no=?";
//		row = super.executeUpdate(sql, no);
		return row;
	}
}
