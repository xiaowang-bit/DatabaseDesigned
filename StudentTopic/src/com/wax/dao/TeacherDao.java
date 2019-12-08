package com.wax.dao;

import java.util.List;
import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.wax.model.Teacher;
import com.wax.utils.JdbcUtils;

public class TeacherDao {
	QueryRunner queryRunner=new QueryRunner();
	public int  add(Teacher teacher)
	{
		Connection conn=null;
		int rows=0;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into teacher_info values(?,?,?,?,?,?,?,?)";
			rows=queryRunner.update(conn, sql,teacher.getTea_id(),
					teacher.getTea_name(),teacher.getTea_sex(),
					teacher.getTea_academy(),teacher.getTea_title(),
					teacher.getTea_phone(),teacher.getTea_email(),teacher.getTea_pwd());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public int save(Teacher teacher) {
		int rows=0;
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="update teacher_info set tea_academy=?,tea_title=?,tea_phone=?,tea_email=?,tea_pwd=? where tea_id=?";
			rows=queryRunner.update(conn, sql, teacher.getTea_academy(),teacher.getTea_title(),teacher.getTea_phone(),teacher.getTea_email(),teacher.getTea_pwd(),teacher.getTea_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public int delete(String tea_id) {
		Connection conn=JdbcUtils.getConnection();
		int rows=0;
		try {
			String sql="delete from teacher_info where tea_id=?";
			rows=queryRunner.update(conn, sql, tea_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public List <Teacher> getAllTeacher() {
		Connection conn=JdbcUtils.getConnection();
		List <Teacher> list=null;
		try {
			String sql="select * from teacher_info";
			list=queryRunner.query(conn, sql, new BeanListHandler<Teacher>(Teacher.class));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	public Teacher get(String tea_id) {
		Connection conn=JdbcUtils.getConnection();
		Teacher teacher=null;
		try {
			String sql="select * from teacher_info where tea_id=?";
			teacher=queryRunner.query(conn, sql,new BeanHandler<Teacher>(Teacher.class), tea_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return teacher;
	}
	public Teacher getByName(String tea_name) {
		Connection conn=JdbcUtils.getConnection();
		Teacher teacher=null;
		try {
			String sql="select * from teacher_info where tea_name=?";
			teacher=queryRunner.query(conn, sql,new BeanHandler<Teacher>(Teacher.class), tea_name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return teacher;
	}
}
