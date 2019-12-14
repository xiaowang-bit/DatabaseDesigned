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
import com.wax.utils.JdbcUtils;

public class Student_infoDao{
	public int insert(Student_info stu)
	{
		int row = 0;
		String sql = "insert into student_info values(?,?,?,?,?,?,?)";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			Object[] ob= {stu.getStu_id(), stu.getStu_name(), stu.getStu_class_id(), stu.getStu_sex(), stu.getStu_phone(), stu.getStu_email(), stu.getStu_pwd()};
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	public int update(Student_info stu)
	{
		int row = 0;
		String sql = "update student_info set "
				+ "stu_name=?,"
				+ "stu_sex =?,stu_pwd=?,stu_phone=?,"
				+ "stu_email=? where stu_id=? and stu_class_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		Object[]ob={stu.getStu_name(),stu.getStu_sex(),stu.getStu_pwd(),stu.getStu_phone(),stu.getStu_email(),stu.getStu_id(),stu.getStu_class_id()};
		try {
			row = qr.update(sql,ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public int delete(String no)
	{
		int row = 0;
		String sql = "delete from student_info where stu_id=?";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			row = qr.update(sql,no);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	public List<Map<String, Object>> search(String stu_id)
	{
		List<Map<String, Object>> list = null;
		String sql = "select * from student_info,class_info where stu_id=? and class_id=stu_class_id";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),stu_id);
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
	
	public List<Map<String, Object>> searchByPage(int currentPage)
	{
		List<Map<String, Object>> list = null;
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select *from(select rownum r,s.*,c.*from Student_info s ,class_info c "
				+ "where rownum<= ? and class_id=stu_class_id)"
				+ "where r>=?";
		Object[]ob= {currentPage*8,(currentPage-1)*8+1};
		try {
			list = qr.query(sql,new MapListHandler(),ob);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public  int getTotalCount() {
		String sql = "select count(1) from student_info ";
		return JdbcUtils.getTotalCount(sql);
		
	}
}
