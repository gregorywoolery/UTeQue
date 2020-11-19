package com.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.connection.DBConnectorFactory;
import com.model.Issue;
import com.model.Response;
import com.model.Service;


public class UTeQueDBOperations {
	private static final Logger logger = LogManager.getLogger(UTeQueDBOperations.class);
	
	/**
	 * Insert Statement
	 * @param issue
	 */
	public static boolean insertIssue(Issue issue) {
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			
			logger.warn("Attempting to INSERT Data INTO SQL table Issue, Error May Occur");
			
			String insertSql = "INSERT INTO UTeQueDB.Issue (issueID, type, status, "
					+ "studentID, message, serviceID, issuedAt, scheduledDateTime, repId) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			
			statement.setString(1, issue.getIssueID());
			statement.setString(2, issue.getType());
			statement.setString(3, issue.getStatus());
			statement.setString(4, issue.getStudentID());
			statement.setString(5, issue.getMessage());
			statement.setInt(6, issue.getServiceID());
			statement.setDate(7, new Date(issue.getIssuedAt().getTime()));
			statement.setDate(8, null);
			statement.setString(9, issue.getRepID());
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    logger.info("SQL INSERT Statement was Successful");
			    return true;
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT Statement was NOT Successful" 
					+ "Error(" + e.getErrorCode() 
					+") " + e.getMessage());
		}
		return false;
	}
	
	public static void insertResponse(Response response) {
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			logger.warn("Attempting to INSERT Data INTO SQL table Issue, Error May Occur");
			
			String insertSql = "INSERT INTO UTeQueDB.`Response` (responseID, issueID, userID, "
					+ "message, responeAt, isAnswer) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = dbConn.prepareStatement(insertSql);

			statement.setString(1, response.getResponseID());
			statement.setString(2, response.getIssueID());
			statement.setString(3, response.getUserID());
			statement.setString(4, response.getMessage());
			statement.setDate(5, (Date) response.getResponseAt());
			statement.setBoolean(6, response.isAnswer());
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    logger.info("SQL INSERT Statement was Successful");
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT Statement was NOT Successful");
		}
	}
	
	/**
	 * 
	 * @param service
	 */
	public static void insertService(Service service) {
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			logger.warn("Attempting to INSERT Data INTO SQL table Services, Error May Occur");
			
			String insertService = "INSERT INTO UTeQueDB.`Service` (type) "
					+ "VALUES (?)";
			
			PreparedStatement statement = dbConn.prepareStatement(insertService);
			statement.setString(1, service.getType());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    logger.info("SERVICE INSERTED SUCCESSFUL");
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT Statement NOT Successful: "
					+ "ERROR(" + e.getErrorCode()
					+ ") " + e.getMessage());
		}
	}
	public static ArrayList<Service> getAllServices() {
		
		ArrayList<Service> services = new ArrayList<Service>();
		
		String serviceName = "";
		int serviceID = 0;

		String readAll = "SELECT * FROM UTeQueDB.`Service`";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			
			Statement statement = dbConn.createStatement();
			ResultSet result = statement.executeQuery(readAll);
			
			while(result.next()) {
				serviceID = result.getInt(1);
				serviceName = result.getString(2);
				
				services.add(new Service(serviceID, serviceName));
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return services;
	}

}
