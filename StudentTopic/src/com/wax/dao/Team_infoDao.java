package com.wax.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.wax.JavaBeen.Team_info;
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
}
