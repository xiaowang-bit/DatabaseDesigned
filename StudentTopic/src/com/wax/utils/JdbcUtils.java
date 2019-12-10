package com.wax.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import com.wax.service.DBCPUtilsService;

/**
 * jdbc工具类
 * @author dell
 *
 */
public class JdbcUtils {
	private static DataSource dataSource;
	static{
        try {
            //1.加载properties配置文件
            InputStream is = DBCPUtilsService.class.getClassLoader().getResourceAsStream("db.properties");
            //2.加载输入流
            Properties props = new Properties();
            props.load(is);
            //3.创建数据源
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取dataSource方法
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

	/**
     * 获得连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 释放资源
     * @param connection
     */
    public static void releaseConnection(Connection connection, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs != null ) {
                rs.close();
            }
            if(pstmt != null ) {
                pstmt.close();
            }
            if(connection != null ) {
                connection.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getTotalCount(String sql) {
		int count= -1;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt = getConnection().prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			releaseConnection(getConnection(), pstmt, rs);
		}
		return count;
	}
}
