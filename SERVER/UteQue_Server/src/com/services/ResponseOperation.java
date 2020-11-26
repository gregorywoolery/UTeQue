package com.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ResponseOperation {
	private static final Logger logger = LogManager.getLogger(IssueOperation.class);
	
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
}
