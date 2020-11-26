package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginAuthentication {
	
	private static final Logger logger = LogManager.getLogger(LoginAuthentication.class);

	
	public static boolean authLoginUser(User user) {
		System.out.println(user.toString());
		
		if(user.getType().equals("STUDENT"))
			return loginStudent(user.getID(), user.getPassword());
	
		else if(user.getType().equals("REP")) 
			return loginRep(user.getID(), user.getPassword());
		
		
		else if(user.getType().equals("AGENT"))
			return loginAgent(user.getID(), user.getPassword());
		
		return false;
		
	}
	
	/**
	 * Gets USERNAME and PASSWORD from DATABASE for specified STUDENT SERVICES AGENT
	 * using SQL SELECT STATEMENT.
	 * 
	 * @param username - USERNAME entered by AGENT at the login screen
	 * @param password - PASSWORD entered by AGENT at the login screen
	 * @return 	true 	- USER was FOUND and PASSWORD matched to that in the DATABASE.
	 * 			false 	- EITHER USER was NOT found in the system OR PASSWORD did not match.
	 */
	public static boolean loginAgent(String username, String password) {
		
		String agentID = "", pass = "";
		
		String loginSql = "SELECT agentID, password FROM UTeQueDB.`StudentServicesAgent` "
								+ "WHERE agentID = ? AND password = ?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			logger.info("AGENT Results Recieved");
			while(result.next()) {
				agentID = result.getString(1);
				pass = result.getString(2);
				
				if(agentID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Gets USERNAME and PASSWORD from DATABASE for specified STUDENT SERVICES REPRESENTATIVE
	 * using SQL SELECT STATEMENT.
	 * 
	 * @param username 	- USERNAME entered by REPRESENTATIVE at the login screen.
	 * @param password 	- PASSWORD entered by REPRESENTATIVE at the login screen.
	 * @return 	true 	- USER was FOUND and PASSWORD matched to that in the DATABASE.
	 * 			false 	- EITHER USER was NOT found in the system OR PASSWORD did not match.
	 */
	public static boolean loginRep(String username, String password) {
		
		String repID, pass = "";
		
		String loginSql = "SELECT repID, password FROM UTeQueDB.`StudentServicesRep` WHERE repID = ? AND password =?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			logger.info("REPRESENTATIVE Results Recieved");
			while(result.next()) {
				repID = result.getString(1);
				pass = result.getString(2);
				
				if(repID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
	
	/**
	 * Gets USERNAME and PASSWORD from DATABASE for specified STUDENT
	 * using SQL SELECT STATEMENT.
	 * 
	 * @param username - USERNAME entered by STUDENT at the login screen
	 * @param password - PASSWORD entered by STUDENT at the login screen
	 * @return 	true 	- USER was FOUND and PASSWORD matched to that in the DATABASE.
	 * 			false 	- EITHER USER was NOT found in the system OR PASSWORD did not match.
	 */
	public static boolean loginStudent(String username, String password) {
		
		String studentID, pass = "";
		
		String loginSql = "SELECT studentID, password FROM UTeQueDB.`Student` WHERE studentID = ? AND password =?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(loginSql);
			statement.setString(1, username);
			statement.setString(2, password);
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			
			logger.info("STUDENT Results Recieved");

			System.out.println("Login Student");
			
			while(result.next()) {
				studentID = result.getString(1);
				pass = result.getString(2);
				
				if(studentID.equals(username) && pass.equals(password))
					return true;
			}
			
		} catch (SQLException e) {
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return false;
	}
}
