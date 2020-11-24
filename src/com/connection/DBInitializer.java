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
	private Connection dbConn =  null;
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
				+ "studentID VARCHAR(12) NOT NULL , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(20) NOT NULL , "
				+ "gender CHAR(1) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "dob DATE NOT NULL , "
				+ "PRIMARY KEY (`studentID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`Student`, Error May Occur");
			stmt.execute(tableSql, 0);
						
			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`Student` was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {	
			logger.error("UTeQueDB.`Student` CREATION NOT Successful. ERROR(" 
						+ e.getErrorCode() +") " 
						+ e.getMessage());
			return false;
		}			
	}
	
	//Method to Create Services Table
	public boolean createStudentServicesRepTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`StudentServicesRep` ( "
				+ "repID VARCHAR(12) NOT NULL  , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(20) NOT NULL , "
				+ "gender CHAR(1) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "canRespond BOOLEAN DEFAULT TRUE , "
				+ "PRIMARY KEY (`repID`)) ENGINE = InnoDB";
			
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
	
	
	//Method to Create Services Table
	public boolean createStudentServicesAgentTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`StudentServicesAgent` ( "
				+ "agentID VARCHAR(12) NOT NULL  , "
				+ "password VARCHAR(20) NOT NULL , "
				+ "firstname VARCHAR(20) NOT NULL , "
				+ "lastname VARCHAR(20) NOT NULL , "
				+ "gender CHAR(1) NOT NULL , "
				+ "email VARCHAR(100) NOT NULL , "
				+ "phone VARCHAR(15) NOT NULL DEFAULT \'0(876) 000-0000\' , "
				+ "canRespond BOOLEAN DEFAULT FALSE , "
				+ "PRIMARY KEY (`agentID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`StudentServicesAgent`, Error May Occur");
			stmt.execute(tableSql, 0);
						
			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`StudentServicesAgent`, was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {	
			logger.error("UTeQueDB.`StudentServicesAgent` CREATION NOT Successfully. ERROR(" 
					+ e.getErrorCode() +") " 
					+ e.getMessage());
			return false;
		}			
	}
	
	//Method to Create Service Table
	public boolean createServiceTable() {
		String tableSql = "CREATE TABLE UTeQueDB.`Service` ( "
				+ "serviceID INT(10) NOT NULL AUTO_INCREMENT , "
				+ "type VARCHAR(85) NOT NULL , "
				+ "PRIMARY KEY (`serviceID`)) ENGINE = InnoDB";
			
		Statement stmt;
		
		try {
			logger.warn("Attempting to CREATE SQL STATEMENT to execute Create command");
			stmt = (Statement) dbConn.createStatement();
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			logger.warn("Creating table UTeQueDB.`Service`, Error May Occur");
			stmt.execute(tableSql, 0);

			//If the program comes here database and table creation went well
			logger.info("UTeQueDB.`Service` was CREATED Successfully");
			return true;
			
		} catch (SQLException e) {		
			logger.error("UTeQueDB.`Service` CREATION NOT Successful. ERROR(" 
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
				+ "studentID VARCHAR(12) NOT NULL  , "
				+ "message VARCHAR(140) NOT NULL , "
				+ "serviceID INT(10) NOT NULL , "
				+ "issuedAt DATE NOT NULL , "
				+ "scheduledDateTime DATETIME , "
				+ "repID VARCHAR(10) , "
				+ "PRIMARY KEY (`issueID`) , "
				+ "FOREIGN KEY(studentID) REFERENCES UTeQueDB.`Student`(studentId) , "
				+ "FOREIGN KEY(serviceID) REFERENCES UTeQueDB.`Service`(serviceID) , "
				+ "FOREIGN KEY(repID) REFERENCES UTeQueDB.`StudentServicesRep`(repID)"
				+ ") ENGINE = InnoDB";
			
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
				+ "responseID VARCHAR(12) NOT NULL , "
				+ "issueID VARCHAR(13) NOT NULL , "
				+ "userID VARCHAR(12) NOT NULL , "
				+ "message VARCHAR(140) NOT NULL , "
				+ "responseAt DATE NOT NULL , "
				+ "isAnswer BOOLEAN DEFAULT FALSE , "
				+ "PRIMARY KEY (`responseID`),"
				+ "FOREIGN KEY(issueID) REFERENCES UTeQueDB.`Issue`(issueID)"
				+ ") ENGINE = InnoDB";
			
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
