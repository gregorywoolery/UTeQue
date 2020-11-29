package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.Query;

import com.connectionFactories.Hibernate.SessionFactoryBuilder;
import com.connectionFactories.JDBC.DBConnectorFactory;
import com.model.StudentServicesRep;
import com.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserOperation {
	private static final Logger logger = LogManager.getLogger(UserOperation.class);
	
	public static User getUserInfo(String username, String userType) {
		User currentUser = new User();
		
		userType = userType.toUpperCase();
		
		String searchSql = null;
		switch(userType) {
			case "STUDENT":
				searchSql = "SELECT studentID, firstname, lastname, gender, email, phone FROM UTeQueDB.`Student` WHERE studentID = ?";
				break;
			case "AGENT":
				searchSql = "SELECT agentID, firstname, lastname, gender, email FROM UTeQueDB.`StudentServicesAgent` WHERE agentID = ?";
				break;
			case "REP":
				searchSql = "SELECT repID, firstname, lastname, gender, email FROM UTeQueDB.`StudentServicesRep` WHERE repID = ?";
				break;
		}		 
		
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
			logger.error("Error(" + e.getErrorCode() 
					+ ") " + e.getMessage());
		}
		
		return null;
	}	
	
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getStudentServiceReps(){
		ArrayList<StudentServicesRep> representatives = new ArrayList<StudentServicesRep>();
		
		String hql = "FROM StudentServicesRep S";
		
		Transaction transaction = null;
		try(Session session = SessionFactoryBuilder
				.getSessionFactory().getCurrentSession()
		){
			
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setMaxResults(5);
			
			representatives = (ArrayList<StudentServicesRep>) query.getResultList();
			
			transaction.commit();
			
		}catch(HibernateException hex) {
			if(transaction != null) {
				
				transaction.rollback();
			}

		}
		
		ArrayList<String> repNames = new ArrayList<String>();
		for(StudentServicesRep rep: representatives)
			repNames.add(rep.getID() + " - " + rep.getFirstname() + " " + rep.getLastname());
		
		
		return repNames;
	}
}