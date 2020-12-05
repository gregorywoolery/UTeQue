package com.services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Query;

import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.Issue;
import com.model.Response;
import com.model.Student;
import com.connectionFactories.Hibernate.SessionFactoryBuilder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IssueOperation {
	private static final Logger logger = LogManager.getLogger(IssueOperation.class);

	public static boolean insertIssue(Issue issue) {
		Transaction transaction = null;
		
		logger.warn("Attempting to INSERT Data INTO SQL table Issue, Error May Occur");
		
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			issue.setScheduledDateTime(null);
			issue.setIssuedAt(new Date(issue.getIssuedAt().getTime()));
			transaction = session.beginTransaction();
			session.save(issue);			
			transaction.commit();
			
		    logger.info(" INSERT ISSUE was Successful");
		    return true;
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}
		}
		
		return false;
	}						
	
	public static ArrayList<Issue> getAllIssuesForStudent(String studentID){
		
		ArrayList<Issue> studentIssues = new ArrayList<Issue>();
		
		String getStudentIssues = "FROM Issue WHERE studentID = :student_ID";
		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(getStudentIssues);
			query.setParameter("student_ID", studentID);
			
			studentIssues = (ArrayList<Issue>) query.getResultList();
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}

		}
		return studentIssues;
	}
	
	
	public static int[] getUserIssueStats(String studentID){
		String status = null;
		int[] stats = new int[] {0,0,0};
		
		String selectAssignment = "SELECT status FROM UTeQueDB.`Issue` WHERE studentID = ?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = dbConn.prepareStatement(selectAssignment);
			statement.setString(1, studentID);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				status = result.getString(1);
				
				if(status.equals("Resolved"))
					stats[1]+=1;
				else
					stats[2]+=1;
			}	
			stats[0] = stats[1] + stats[2];
			
		}catch(SQLException e){
			logger.error("Error(" + e.getErrorCode()
								+ ") Occured. " + e.getMessage());
		}
	
		return stats;
		
	}
	
	//An employee should be able to view all students enquiries by category.
	public static ArrayList<Issue> getIssuesByType(int serviceID) {
		
		ArrayList<Issue> issues = new ArrayList<Issue>();
		Issue issueObj = new Issue();

		String hql = "FROM Issue I WHERE I.serviceID =:service_ID";

		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			logger.warn("Receiving results from executed Prepared Statement, Error May Occur");
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("service_ID", serviceID);
			
			issues = (ArrayList<Issue>) query.getResultList();
			
			transaction.commit();
			
			logger.info("ISSUES FOUND SUCCESSFUL");	
		
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}

		}
		
		return issues;
	}
	
	
	public static ArrayList<Issue> getIssueByService(String studentID, int serviceID){
		
		ArrayList<Issue> studentIssue = new ArrayList<Issue>();
		String hql = "FROM Issue I WHERE I.studentID = :studentID AND I.serviceID = :serviceID";

		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("studentID", studentID);
			query.setParameter("serviceID", serviceID);
			
			studentIssue = (ArrayList<Issue>) query.getResultList();
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}

		}
		
		return studentIssue;
	}
	
	public static Issue getIssue(String issueID) {
		
		Issue issue = new Issue();
		String hql = "FROM Issue I WHERE I.issueID = :issue_ID";

		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("issue_ID", issueID);
			
			issue = (Issue) query.getSingleResult();
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}

		}
		
		return issue;
	}

	
	//Deletes Issue Record by issueID
	public static boolean deleteIssue(String issueID) {
		
		//Checks if issueID was already assigned to a repID
		if(checkIssueRepID(issueID)) {
		logger.warn("Attempting to DELETE Data FROM SQL table Issue, Error May Occur");
		
		String deleteSql = "DELETE from UTeQueDB.Issue WHERE issueID=?";
		
			try(Connection dbConn = DBConnectorFactory.getDatabaseConnection()) {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, issueID);
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				int rowsDeleted = statement.executeUpdate();
				
				if (rowsDeleted > 0) {
				    System.out.println("---Issue was DELETED Successfully!");
				    logger.info("SQL DELETE Statement was Successful");
				    return true;
				}
			} catch (SQLException e) {
				logger.error("SQL DELETE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}		
		}
		return false;
	}
	
	//Retrieves Issues By specific type OR specific serviceID
	public static ArrayList<Issue> getAllSearchIssuesForStudent(Issue searchIssue){
		
		ArrayList<Issue> studentIssues = new ArrayList<Issue>();
		
		String issueID = "", type = "", status = "", message = "", repID = "", studentID = "";
		Date issuedAt = null, scheduledDateTime = null;
		int serviceID = 0;
		String getStudentIssues = null;
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			PreparedStatement statement = null;
			
			//Query String Statements
			
			//Check IF type is Equal to Exclude and returns specific records of the serviceID with all record types(Complaint/Query)
			if(searchIssue.getType().equals("Exclude")) {
					getStudentIssues = "SELECT * FROM UTeQueDB.`Issue` WHERE studentID = ? AND serviceID = ? ORDER BY issuedAt ASC";
					statement = dbConn.prepareStatement(getStudentIssues);
					statement.setString(1, searchIssue.getStudentID());
					statement.setInt(2, searchIssue.getServiceID());
			}
			//Displays records based on specific type(Complaint/Query) and serviceID
			else if(searchIssue.getType()!=null ) {
				getStudentIssues = "SELECT * FROM UTeQueDB.`Issue` WHERE studentID = ? AND type = ? AND serviceID = ? ORDER BY issuedAt ASC";
				statement = dbConn.prepareStatement(getStudentIssues);
				statement.setString(1, searchIssue.getStudentID());
				statement.setString(2, searchIssue.getType());
				statement.setInt(3, searchIssue.getServiceID());
			} 
			
			ResultSet result = statement.executeQuery();
			
			//Populates studentIssues Object with Values
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
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return studentIssues;
	}
	
	public static Boolean checkExistingIssue(String id) {
		String selectIssue = "SELECT COUNT(*) FROM UTeQueDB.Issue WHERE issueID=?";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			logger.warn("Attempting to COUNT Data FROM SQL Table: Issue, Error May Occur");
			
			PreparedStatement statement = dbConn.prepareStatement(selectIssue);
			statement.setString(1, id);
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
	
			while(result.next()) {
				
				final int count = result.getInt(1);
				if(count == 1) {
					logger.info("SQL COUNT Statement was Successful");
					System.out.println("---ISSUE EXIST");
					return true;
				}
			}
	
		}catch(SQLException e){
			logger.error("SQL COUNT Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		System.out.println("---Search Results WERE NOT FOUND");
		return false;
	}
	
	//Check Whether Issue was Assigned to a repID
	public static Boolean checkIssueRepID(String issueID) {
		String selectIssue = "SELECT COUNT(*) FROM UTeQueDB.Issue WHERE issueID=? AND repID IS NULL";
		
		try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
			logger.warn("Attempting to COUNT Data FROM SQL Table: Issue, Error May Occur");
			
			PreparedStatement statement = dbConn.prepareStatement(selectIssue);
			statement.setString(1, issueID);
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			ResultSet result = statement.executeQuery();
	
			while(result.next()) {
				
				final int count = result.getInt(1);
				if(count == 1) {
					logger.info("SQL COUNT Statement was Successful");
					return true;
				}
			}
	
		}catch(SQLException e){
			logger.error("SQL COUNT Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		return false;
	}
	
	public static boolean assignRepresentative(String issueID, String repID) {
		String hql = "UPDATE Issue set repID = :rep_id, scheduledDateTime = :sdateTime WHERE issueID = :issue_id";
		int result = 1;

		LocalDateTime date = LocalDateTime.now();
		Date scheduledDateTime = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("sdateTime", scheduledDateTime);
			query.setParameter("rep_id", repID);
			query.setParameter("issue_id", issueID);
			result = query.executeUpdate();
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}
		}
		
		if(result == 1)
			return true;
		
		return false;
		
		
	}

	public static int[] getServiceResolvedCount() {
		int count  [] = new int [8];
		int [] serviceId = new int [ ] { 1, 2, 3, 4, 5, 6, 7, 8 };
		
		String countSQL = "SELECT COUNT(UTeQueDB.issue.issueID) FROM UTeQueDB.issue WHERE UTeQueDB.issue.serviceID = ? AND UTeQueDB.issue.status= 'Resolved'";
		for (int i = 0;  i < serviceId.length; i++) {
			try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
				PreparedStatement statement = dbConn.prepareStatement(countSQL);
				statement.setInt(1, serviceId [ i ] );
				ResultSet result = statement.executeQuery();

				while(result.next()) {
					count[i] = result.getInt(1);
				}	
				
			}catch(SQLException e){
				logger.error("Error(" + e.getErrorCode()
									+ ") Occured. " + e.getMessage());
			}
		}

		return count;
	}

	public static int[] getServiceUnresolvedCount() {
		int count  [] = new int [8];
		int [] serviceId = new int [ ] { 1, 2, 3, 4, 5, 6, 7, 8 };
		
		String countSQL = "SELECT COUNT(UTeQueDB.issue.issueID) FROM UTeQueDB.issue WHERE UTeQueDB.issue.serviceID = ? AND UTeQueDB.issue.status= 'Unresolved'";
		for (int i = 0;  i < serviceId.length; i++) {
			try (Connection dbConn = DBConnectorFactory.getDatabaseConnection()){
				PreparedStatement statement = dbConn.prepareStatement(countSQL);
				statement.setInt(1, serviceId [ i ] );
				ResultSet result = statement.executeQuery();

				while(result.next()) {
					count[i] = result.getInt(1);
				}	
				
			}catch(SQLException e){
				logger.error("Error(" + e.getErrorCode()
									+ ") Occured. " + e.getMessage());
			}
		}
		return count;
	}

	public static boolean updateStatus(String issueID) {
		boolean updateIssueSuccess = false;

		logger.warn("Attempting to UPDATE Data FROM SQL table Issue, Error May Occur");
		
		String updateSql = "UPDATE UTeQueDB.Issue SET  UTeQueDB.Issue.status = 'Resolved' WHERE issueID=?";
		
			try(Connection dbConn = DBConnectorFactory.getDatabaseConnection()) {
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(1, issueID);
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				statement.executeUpdate();
				return true;
			} catch (SQLException e) {
				logger.error("SQL UPDATE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}		
		return updateIssueSuccess;
	}

}
