package com.wax.test;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.wax.service.DBCPUtilsService;

public class DBCPUTILServiceTest {
	@Test
	public void test01() throws SQLException{
	Connection conn = null;
	try {
		conn = DBCPUtilsService.getConnection();
		System.out.println("OK！");
	}finally{
		DBCPUtilsService.close(conn);
	}
	}
}
