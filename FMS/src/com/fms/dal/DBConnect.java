package com.fms.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getDatabaseConnection() {
		return openConnection();
	}
	
	private static Connection openConnection() {
		Connection connection=null;
		DBConfig config=new DBConfig();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  //com.mysql.jdbc.Driver - deprecated
			connection = DriverManager.getConnection(config.getDatabaseURL(),config.getUsername(),config.getPassword());
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}catch(ClassNotFoundException cnException) {
			cnException.printStackTrace();
		}
		return connection;
	}

}
