package com.wax.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wax.model.SelectSubject;
import com.wax.model.Teacher;
import com.wax.utils.JdbcUtils;

public class SelectSubjectDao {
	QueryRunner queryRunner=new QueryRunner();
	public int delete(String st_topic_id,String st_tea_id,String st_stu_id) {
		Connection conn=JdbcUtils.getConnection();
		int rows=0;
		try {
			String sql="delete from select_topic_info where st_topic_id=? and st_tea_id=? and st_stu_id=?";
			rows=queryRunner.update(conn, sql, st_topic_id,st_tea_id,st_stu_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public List <SelectSubject> getChecked(String st_topic_id,String st_tea_id) {
		Connection conn=JdbcUtils.getConnection();
		List <SelectSubject> list=null;
		try {
			String sql="select * from select_topic_info where st_topic_id=? and st_tea_id=? and st_checked=1";
			list=queryRunner.query(conn, sql, new BeanListHandler<SelectSubject>(SelectSubject.class),st_topic_id,st_tea_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	public List <SelectSubject> getUnchecked(String st_topic_id,String st_tea_id) {
		Connection conn=JdbcUtils.getConnection();
		List <SelectSubject> list=null;
		try {
			String sql="select * from select_topic_info where st_topic_id=? and st_tea_id=? and st_checked=0";
			list=queryRunner.query(conn, sql, new BeanListHandler<SelectSubject>(SelectSubject.class));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	public int setChecked(String st_topic_id,String st_tea_id,String st_stu_id) {
		Connection conn=JdbcUtils.getConnection();
		int rows=0;
		try {
			String sql="update select_topic_info set st_checked=1 where st_topic_id=? and st_tea_id=? and st_stu_id=?";
			rows=queryRunner.update(conn, sql, st_topic_id,st_tea_id,st_stu_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
}
