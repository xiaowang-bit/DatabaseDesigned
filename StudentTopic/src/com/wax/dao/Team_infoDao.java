package com.wax.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.wax.JavaBeen.Team_info;
import com.wax.service.DBCPUtilsService;
import com.wax.utils.JdbcUtils;

public class Team_infoDao {
	public List<Team_info> searchAll() {
		List<Team_info> list=null;
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="select *from team_info";
		try {
			list= qr.query(sql, new BeanListHandler<Team_info>(Team_info.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	public List<Map<String, Object>> searchGroupByTeam(String tea_id){
		List<Map<String, Object>> list=null;
		String sql="select * from team_info,topic_info,student_info,course_info,select_topic_info "
				+ " where st_topic_id=topic_id and st_stu_id=stu_id and course_id=topic_course_id "
				+ "and team_id=st_team_id and st_tea_id=? and st_checked ='通过' and st_stu_check='组长'";
		QueryRunner qr=new QueryRunner(DBCPUtilsService.getDataSource());
		try {
			list = qr.query(sql,new MapListHandler(),tea_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public int updateTeam_report_status (String team_id,String status) {
		int row=0;
		QueryRunner qr=new QueryRunner(JdbcUtils.getDataSource());
		String sql="update team_info set team_report_status=? where team_id=?";
		try {
			row=qr.update(sql,status,team_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}
