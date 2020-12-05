package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.Issue;
import com.model.Student;


public class UTeQueDBOperations {
	private static final Logger logger = LogManager.getLogger(UTeQueDBOperations.class);

		//Get Student Details
		public static Student getStudentDetails(String studentID) {
			Student student = new Student();
		

			String Sql = "SELECT * FROM UTeQueDB.Student WHERE studentID=?";
			
			try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
				PreparedStatement statement = dbConn.prepareStatement(Sql);
				statement.setString(1, studentID);
				logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
				
				ResultSet result = statement.executeQuery(Sql);
				
				while(result.next()) {
					student.setID(result.getString(1));
					student.setPassword(result.getString(2));
					student.setFirstname(result.getString(3));
					student.setLastname(result.getString(4));
					student.setGender(result.getString(5));
					student.setEmail(result.getString(6));
					student.setPhone(result.getString(7));
					student.setDOB(result.getDate(8));
				}
				logger.info("SQL WAS  SUCCESSFUL");
				
				return student;
				
			} catch (SQLException e) {
				logger.error("SQL READ Statement NOT Successful: "
						+ "ERROR(" + e.getErrorCode()
						+ ") " + e.getMessage());
				return null;
			}
		}
		
		
		//Get Specific Issue
		public static Issue getSpecificIssue(String issueID ) {
			
			Issue issue = new Issue();

			String Sql = "SELECT * FROM UTeQueDB.Issue WHERE issueID=?";
			
			try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
				PreparedStatement statement = dbConn.prepareStatement(Sql);
				statement.setString(1, issueID);
				logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
				
				ResultSet result = statement.executeQuery(Sql);
				
				while(result.next()) {
					issue.setIssueID(result.getString(1));
					issue.setType(result.getString(2));
					issue.setStatus(result.getString(3));
					issue.setStudentID(result.getString(4));
					issue.setMessage(result.getString(5));
					issue.setServiceID(result.getInt(6));
					issue.setIssuedAt(result.getDate(7));
					issue.setScheduledDateTime(result.getDate(8));
					issue.setRepId(result.getString(9));
				}
				logger.info("SQL WAS  SUCCESSFUL");

				return issue;
			} catch (SQLException e) {
				logger.error("SQL READ Statement NOT Successful: "
						+ "ERROR(" + e.getErrorCode()
						+ ") " + e.getMessage());
				return null;
			}
			
		}

}
