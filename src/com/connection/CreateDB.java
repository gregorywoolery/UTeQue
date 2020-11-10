package com.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
	
	private Connection dbConn = null;
	
	public CreateDB(Connection dbConn){
		this.dbConn = dbConn;				
	}
	
	public boolean createUsersDataBase() {
			
		String dbSql = "CREATE DATABASE UTeQueDB";
			
		Statement stmt;
		
		try {
			dbConn = DBConnectorFactory.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(dbSql, 0);
			
			dbConn.close();
			//If the program comes here database and table creation went well
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
			
	public boolean createStudentTable() {
		String useSql = "USE UTeQueDB";
		String tableSql = "CREATE TABLE UTeQueDB.`Students` ( "
				+ "type VARCHAR(10) NOT NULL , "
				+ "id VARCHAR(9) NOT NULL  , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(25) NOT NULL , "
				+ "gender VARCHAR(7) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "dob VARCHAR(11) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "PRIMARY KEY (`id`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			dbConn = DBConnectorFactory.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(useSql, 0);
			stmt.execute(tableSql, 0);
			
			dbConn.close();
			//If the program comes here database and table creation went well
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
		
	public boolean createServicesTable() {
		String useSql = "USE UTeQuedb";
		String tableSql = "CREATE TABLE UTeQueDB.`Services` ( "
				+ "type VARCHAR(10) NOT NULL , "
				+ "id VARCHAR(9) NOT NULL  , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(25) NOT NULL , "
				+ "gender VARCHAR(7) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "dob VARCHAR(11) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "PRIMARY KEY (`id`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			dbConn = DBConnectorFactory.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(useSql, 0);
			stmt.execute(tableSql, 0);
			
			dbConn.close();
			//If the program comes here database and table creation went well
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
		
	public boolean createIssueTable() {
		String useSql = "USE UTeQueDB";
		String tableSql = "CREATE TABLE UTeQueDB.`ServicesRep` ( "
				+ "issueId VARCHAR(13) NOT NULL , "
				+ "type VARCHAR(11) NOT NULL , "
				+ "status VARCHAR(12) NOT NULL , "
				+ "studentId VARCHAR(9) NOT NULL  , "
				+ "message VARCHAR(100) NOT NULL , "
				+ "scheduledDateTime DATETIME NOT NULL , "
				+ "repId VARCHAR(10) NOT NULL , "
				+ "PRIMARY KEY (`issueId`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			dbConn = DBConnectorFactory.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(useSql, 0);
			stmt.execute(tableSql, 0);
			
			dbConn.close();
			//If the program comes here database and table creation went well
			return true;
		} catch (SQLException e) {			
			System.out.println("SQLException: " + e.getMessage());
			return false;
		}			
	}
	


}
