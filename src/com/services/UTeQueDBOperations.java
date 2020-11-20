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
import com.model.Student;
import com.model.User;


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
	
	public static ArrayList<Issue> getAllIssuesForStudent(String studentID){
		
		ArrayList<Issue> studentIssues = new ArrayList<Issue>();
		
		String issueID = "", type = "", status = "", message = "", repID = "";
		Date issuedAt = null, scheduledDateTime = null;
		int serviceID = 0;

		String getStudentIssues = "SELECT * FROM UTeQueDB.`Issue` WHERE studentID = ?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			
			PreparedStatement statement = dbConn.prepareStatement(getStudentIssues);
			statement.setString(1, studentID);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				issueID = result.getString(1);
				type = result.getString(2);
				status = result.getString(3);
				studentID = result.getString(4);
				message = result.getString(5);
				serviceID = result.getInt(6);
				issuedAt = result.getDate(7);
				scheduledDateTime = result.getDate(8);
				repID = result.getString(9);
				
				studentIssues.add(new Issue(issueID, type, status, studentID, message, 
						serviceID, issuedAt, scheduledDateTime, repID));
				
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return studentIssues;
	}

	public static boolean loginAgent(String username, String password) {
		
		String studentID, pass = "";
		
		String loginSql = "SELECT agentID, password FROM UTeQueDB.`StudentServicesAgent` WHERE agentID = ? AND password =?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				studentID = result.getString(1);
				pass = result.getString(2);
				
				if(studentID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
	
	public static boolean loginRep(String username, String password) {
		
		String studentID, pass = "";
		
		String loginSql = "SELECT repID, password FROM UTeQueDB.`StudentServicesRep` WHERE repID = ? AND password =?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				studentID = result.getString(1);
				pass = result.getString(2);
				
				if(studentID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
	
	public static boolean loginStudent(String username, String password) {
		
		String studentID, pass = "";
		
		String loginSql = "SELECT studentID, password FROM UTeQueDB.`Student` WHERE studentID = ? AND password =?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				studentID = result.getString(1);
				pass = result.getString(2);
				
				if(studentID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
	
	public static User getUser(String username, String type) {
		User currentUser = new User();
		
		String searchSql = null;
		if(type.equals("Student"))
			searchSql = "SELECT studentID, firstname, lastname, gender, email FROM UTeQueDB.`Student` WHERE studentID = ?";
		else if(type.equals("Agent"))
			searchSql = "SELECT agentID, firstname, lastname, gender, email FROM UTeQueDB.`StudentServicesAgent` WHERE agentID = ?";
		else if(type.equals("Rep"))
			searchSql = "SELECT repID, firstname, lastname, gender, email FROM UTeQueDB.`StudentServicesRep` WHERE repID = ?";
		 
		
		//if type is Student
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			
			PreparedStatement statement = dbConn.prepareStatement(searchSql);
			statement.setString(1, username);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				currentUser.setID(result.getString(1));
				currentUser.setFirstname(result.getString(2));
				currentUser.setLastname(result.getString(3));
				currentUser.setGender(result.getString(4));
				currentUser.setEmail(result.getString(5));
				
				if(currentUser.getID().equals(username))
					return currentUser;
			}
			
		} catch (SQLException e) {
			System.out.println("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return null;
	}


}
