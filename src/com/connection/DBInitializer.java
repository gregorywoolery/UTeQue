package com.connection;

//Import SQL packages
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//Import Log4j packages
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBInitializer {
	
	//Attributes
	private Connection dbConn = null;
	private static final Logger logger = LogManager.getLogger(SQLOperations.class);
	
	//Method to Create Database
	public DBInitializer(Connection dbConn){
		this.dbConn = dbConn;				
	}
	
	//Method to Create Users Database
	public boolean createUTeQueDataBase() {		
		String dbSql = "CREATE DATABASE UTEQUEDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE Database, Error May Occur");
			stmt = (Statement) dbConn.createStatement();
			stmt.execute(dbSql, 0);
			
			//If the program comes here database and table creation is successful
			logger.info("Database was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {
			logger.error("Database Connection was NOT Successful");
			return false;
		}			
	}
	
	//Method to Create Student Table
	public boolean createStudentTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`Student` ( "
				+ "studentID VARCHAR(10) NOT NULL , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(25) NOT NULL , "
				+ "gender CHAR(2) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "dob DATE NOT NULL , "
				+ "PRIMARY KEY (`studentID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`Students`, Error May Occur");
			stmt.execute(tableSql, 0);
						
			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`Students` was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {	
			logger.error("UTeQueDB.`Students` CREATION NOT Successful. ERROR(" 
						+ e.getErrorCode() +") " 
						+ e.getMessage());
			return false;
		}			
	}
	
	//Method to Create Services Table
	public boolean createStudentServicesStaffTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`StudentServicesStaff` ( "
				+ "staffID VARCHAR(10) NOT NULL  , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(25) NOT NULL , "
				+ "gender CHAR(2) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "PRIMARY KEY (`staffID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`StudentServicesStaff`, Error May Occur");
			stmt.execute(tableSql, 0);
						
			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`StudentServicesStaff`, was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {	
			logger.error("UTeQueDB.`StudentServicesStaff` CREATION NOT Successfully. ERROR(" 
					+ e.getErrorCode() +") " 
					+ e.getMessage());
			return false;
		}			
	}
	
	//Method to Create Issue Table
	public boolean createIssueTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`Issue` ( "
				+ "issueID VARCHAR(13) NOT NULL , "
				+ "type VARCHAR(11) NOT NULL , "
				+ "status VARCHAR(12) NOT NULL , "
				+ "studentId VARCHAR(9) NOT NULL  , "
				+ "message VARCHAR(140) NOT NULL , "
				+ "issuedAt DATE NOT NULL , "
				+ "scheduledDateTime DATETIME , "
				+ "repId VARCHAR(10) , "
				+ "PRIMARY KEY (`issueId`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`Issue`, Error May Occur");
			stmt.execute(tableSql, 0);

			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`Issue` was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {		
			logger.error("UTeQueDB.`Issue` CREATION NOT Successful. ERROR(" 
					+ e.getErrorCode() +") " 
					+ e.getMessage());
			return false;
		}			
	}
	
	public boolean createResponseTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`Response` ( "
				+ "responseID VARCHAR(13) NOT NULL , "
				+ "issueID VARCHAR(11) NOT NULL , "
				+ "userID VARCHAR(12) NOT NULL , "
				+ "message VARCHAR(140) NOT NULL , "
				+ "responseAt DATE NOT NULL , "
				+ "isAnswer BOOLEAN DEFAULT false, "
				+ "PRIMARY KEY (`responseID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`Response`, Error May Occur");
			stmt.execute(tableSql, 0);

			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`Response` was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {		
			logger.error("UTeQueDB.`Response` CREATION NOT Successfully. ERROR(" 
					+ e.getErrorCode() +") " 
					+ e.getMessage());
			return false;
		}
	}
	
}
