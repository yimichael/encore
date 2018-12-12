package com.encore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBUtil {

	public static Connection dbconnect() {
		Connection conn=null;
		String url="jdbc:mysql://192.168.22.116:3306/employees";
		String user="root", password="1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void DBDisconnect(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null)rs.close(); //순서 지킬 것.
			if(st!=null)st.close(); //안에서 부터 하는 것.
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

