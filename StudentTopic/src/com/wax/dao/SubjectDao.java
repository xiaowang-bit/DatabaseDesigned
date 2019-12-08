package com.wax.dao;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wax.model.Subject;
import com.wax.utils.JdbcUtils;

public class SubjectDao {
	QueryRunner queryRunner=new QueryRunner();
	public int  add(Subject subject)
	{
		Connection conn=null;
		int rows=0;
		try {
			conn=JdbcUtils.getConnection();
			String sql="insert into topic_info values(?,?,?,?,?,?,?,?,?)";
			rows=queryRunner.update(conn, sql,subject.getTopic_id(),subject.getTopic_name(),
					subject.getTopic_content(),subject.getTopic_tea_id(),
					subject.getTopic_tea_name(),subject.getTopic_course(),
					subject.getTopic_academy(),subject.getTopic_limit_stu(),
					subject.getTopic_semater());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public int save(Subject subject) {
		int rows=0;
		Connection conn=null;
		try {
			conn=JdbcUtils.getConnection();
			String sql="update topic_info set topic_name=?,topic_content=?,topic_course=?,topic_academy=?,topic_limit_stu=?,topic_semater=? where topic_id=? and topic_tea_id=?";
			rows=queryRunner.update(conn, sql, subject.getTopic_name(),subject.getTopic_content(),subject.getTopic_course(),subject.getTopic_academy(),
					                subject.getTopic_limit_stu(),subject.getTopic_semater(),subject.getTopic_id(),subject.getTopic_tea_id());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return rows;
	}
	public List <Subject> getAllSubject() {
		Connection conn=JdbcUtils.getConnection();
		List <Subject> list=null;
		try {
			String sql="select * from topic_info";
			list=queryRunner.query(conn, sql, new BeanListHandler<Subject>(Subject.class));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	public List <Subject> getSubjectByTea_name(String topic_tea_name) {
		Connection conn=JdbcUtils.getConnection();
		List <Subject> list=null;
		try {
			String sql="select * from topic_info where topic_tea_name=?";
			list=queryRunner.query(conn, sql, new BeanListHandler<Subject>(Subject.class),topic_tea_name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return list;
	}
	public Subject get(String topic_id,String topic_tea_id) {
		Connection conn=JdbcUtils.getConnection();
		Subject subject=null;
		try {
			String sql="select * from topic_info where topic_id=? and topic_tea_id=?";
			subject=queryRunner.query(conn, sql,new BeanHandler<Subject>(Subject.class),topic_id,topic_tea_id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.close(conn);
		}
		return subject;
	}
}
