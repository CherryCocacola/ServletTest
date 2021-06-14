package com.mvc.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			 String url = "jdbc:mysql://13.124.135.97:3306/PROJECT";
			 String id = "cinema_pm";
			 String pass = "cinema1234";
			 String driver = "com.mysql.jdbc.Driver";
			 Class.forName(driver);
			 con = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
