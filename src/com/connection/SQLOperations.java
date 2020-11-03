package com.connection;

import com.model.*;
import java.sql.*; 

public class SQLOperations {
	private Connection dbConn;
	Statement stmt;
	boolean numRows;
	
	//Student Table
	//--Insert Statement
	public boolean insertStudent(Student stu) {
		String insertSql = "INSERT INTO UTeQueDB.Students";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			//Insert to database
			
			
			numRows = stmt.execute(insertSql);
			dbConn.close();
			//return (numRows == 1); //check this
			
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Update Statement
	public boolean updateStudent(Student stu) {
		String updateSql = "UPDATE UTeQueDB.Students";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(updateSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Delete Statement
	public boolean deleteStudent(Student stu) {
		String deleteSql = "DELETE from UTeQueDB.Students";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(deleteSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	
	
	
	
	//Services Table
	//--Insert Statement
	public boolean insertServices(Users services) {
		String insertSql = "INSERT INTO UTeQueDB.Services";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			//Insert to database
			
			
			numRows = stmt.execute(insertSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Update Statement
	public boolean updateServices(Users services) {
		String updateSql = "UPDATE UTeQueDB.Services";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(updateSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Delete Statement
	public boolean deleteServices(Users services) {
		String deleteSql = "DELETE from UTeQueDB.Services";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(deleteSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	
	
	
	//Issues Table
	//--Insert Statement
	public boolean insertIssue(Issue issue) {
		String insertSql = "INSERT INTO UTeQueDB.Issue";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(insertSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Update Statement
	public boolean updateIssue(Issue issue) {
		String updateSql = "UPDATE UTeQueDB.Issue";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(updateSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	//--Delete Statement
	public boolean deleteIssue(Issue issue) {
		String deleteSql = "DELETE from UTeQueDB.Issue";
		try {
			dbConn = ConnectorFactoryDB.getDatabaseConnection();
			stmt = (Statement) dbConn.createStatement();
			
			numRows = stmt.execute(deleteSql);
			
			dbConn.close();
			//return (numRows == 1); //check this
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}

}
