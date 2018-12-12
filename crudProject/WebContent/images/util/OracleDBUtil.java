package com.encore.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDBUtil {

	//DB����
	public static Connection dbConnect() {
		Connection conn= null;
		String url="jdbc:oracle:thin:@192.168.2.112:1521:orcl";  
		//String url="jdbc:oracle:thin:@localhost:1521:XE";  
		// javaEE Data sourece Explorer���� Ŀ�ؼ� ã�� ��ũ ����
		String user="hr", password="hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
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
	
	//DB���� ����
	public static void DBDisconnect(ResultSet rs, Statement st, Connection conn) {
		try {
			if(rs!=null)rs.close(); //���� ��ų ��.
			if(st!=null)st.close(); //�ȿ��� ���� �ϴ� ��.
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
