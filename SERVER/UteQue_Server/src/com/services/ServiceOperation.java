package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.Service;

public class ServiceOperation {
	private static final Logger logger = LogManager.getLogger(ServiceOperation.class);

	public static int countSpecificService(int serviceID, String status) {
		String Sql = "SELECT Count(*) FROM UTeQueDB.`Issue` WHERE serviceID=? AND status=?";

		try(Connection dbConn = DBConnectorFactory.getDatabaseConnection()) {
			PreparedStatement statement = dbConn.prepareStatement(Sql);
			statement.setInt(1, serviceID);
			statement.setString(2, status);
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			result.next();
			int count = result.getInt(1);
			logger.info("COUNT SQL WAS  SUCCESSFUL");
			return count;
		} catch (SQLException e) {
			logger.error("SQL READ Statement NOT Successful: "
					+ "ERROR(" + e.getErrorCode()
					+ ") " + e.getMessage());
		}
		return 0;
	}
	
	
	public static String retrieveServiceType(int serviceID) {
		String Sql = "SELECT type FROM UTeQueDB.`Service` WHERE serviceID=?";
		String type = null;
		try(Connection dbConn = DBConnectorFactory.getDatabaseConnection()) {
			PreparedStatement statement = dbConn.prepareStatement(Sql);
			statement.setInt(1, serviceID);
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
			result.next();
			type = result.getString(1);
			logger.info("SQL WAS  SUCCESSFUL");
		} catch (SQLException e) {
			logger.error("SQL READ Statement NOT Successful: "
					+ "ERROR(" + e.getErrorCode()
					+ ") " + e.getMessage());
			return null;
		}
		return type;
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
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return services;
	}
}
