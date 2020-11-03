package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorFactoryDB {
	private static Connection connDB;
	
	public static Connection getDatabaseConnection() {
			String jdbcUrl = "jdbc:mysql://localhost:3306/UTeQueDB?useSSL=false";
			String username = "root"; //User name & Password for database connection
			//String password = "root";
			String password = "";
			if(connDB==null) {
				//connect to the database
				try {
					connDB = DriverManager.getConnection(jdbcUrl, username, password);
					System.out.println("Connected database successfully...");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Database was not connected...");
				//return the connection
				return connDB;
			}
			return connDB;
	}
	

}
