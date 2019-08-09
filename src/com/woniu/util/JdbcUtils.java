package com.woniu.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtils {
	

	public static String driver;
	public static String url;
	public static String user;
	public static String password;
	static {
		Properties pro=new Properties();
		try {
			pro.load(JdbcUtils.class.getResourceAsStream("User.properties"));
			driver = pro.getProperty("driver");
			url =pro.getProperty("url");
			user =pro.getProperty("user");
			password =pro.getProperty("password");
			Class.forName(driver);		//注册驱动 只需执行一次	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//创建链接
	public static Connection getConn() throws SQLException {
		
			Connection conn=DriverManager.getConnection(url, user, password);
		

		return conn;
	}

	//创建关闭流
	public static void getclose(ResultSet rs,Statement stat, Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(stat!=null) {
				stat.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
