package com.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.persistence.Query;

import com.connectionFactories.Hibernate.SessionFactoryBuilder;
import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
	
	
	@SuppressWarnings("unchecked")
	public static Response getResponseUsingIssue(String issueID) {
		Response response = new Response();
		
		String getStudentIssues = "FROM Response R WHERE R.issueID = :issue_ID";
		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(getStudentIssues);
			query.setParameter("issue_ID", issueID);
			
			response = (Response) query.getResultList().stream().findFirst().orElse(null);
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}
		}
		
		return response;
	}
	
	public static boolean postResponse(Response response) {
		Transaction transaction = null;
		
		logger.warn("Attempting to POST RESPONSE FOR ISSUE, Error May Occur");
		
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			transaction = session.beginTransaction();
			
			session.save(response);			
			transaction.commit();
			
		    logger.info(" RESPONSE POSTED SUCCESSFULLY");
		    return true;
		    
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}
		}

		return false;
	}
	
	public static boolean updateComment(String issueID, String comment) {
		boolean updateCommentSuccess = false;

		logger.warn("Attempting to UPDATE Data FROM SQL table Response, Error May Occur");
		
		String updateSql = "UPDATE UTeQueDB.Response SET  UTeQueDB.Response.comment = ? WHERE issueID=?";
		
		try(Connection dbConn = DBConnectorFactory.getDatabaseConnection()) {
			PreparedStatement statement = dbConn.prepareStatement(updateSql);
			statement.setString(1, comment);
			statement.setString(2, issueID);
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			
			statement.executeUpdate();
			
			return true;
		
		} catch (SQLException e) {
			logger.error("SQL UPDATE NOT Successful - ERROR(" 
							+ e.getErrorCode() + ") " + e.getMessage() 
							+ "At-" + e.getStackTrace());
		}		
		return updateCommentSuccess;
	}
	
	
	
}
