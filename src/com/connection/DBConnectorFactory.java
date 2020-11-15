package com.connection;

//Import Log4j packages
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

//Import SQL packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnectorFactory {
	private static Connection dbConn = null;

	private static String DATABASE_URL = "jdbc:mysql://localhost:3306/UTeQueDB?useSSL=false";
	//User name & Password for database connection
	private static String username = "root"; 
	private static String password = "";
	private static final Logger logger = LogManager.getLogger(SQLOperations.class);
	private static boolean dbIsCreated = false;
	private static boolean tableIsCreated = false;
	
	
	/**
	 * Returns connection link from database application.  
	 */
	public static Connection getDatabaseConnection() {
		try {
			logger.warn("Attempting to CONNECT to MySQL Server Database, Error May Occur");
			
			/**
			 * Attempt to connect to the MySQL server and database through
			 * receiving database URL, USERNAME and PASSWORD.
			 */
			dbConn = DriverManager.getConnection(DATABASE_URL, username, password);
			
			//Check if the connection was successful
			if(dbConn != null) { 
				logger.info("UTeQue Database was CONNECTED Successfully");
				JOptionPane.showMessageDialog(null, 
						"Connection to database server succesful", 
						"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(SQLException e) {
			/**
			 * If connection to database was unsuccessful try connecting to 
			 * and creating Database through CreateDB class accepting the 
			 * java.sql.Connection dbConn variable.
			 */

			logger.info("UTeQue Database was NOT connected Successfully");
			
			JOptionPane.showMessageDialog(null, 
					"Setting up Database and table", 
					"DB Connection Status", JOptionPane.WARNING_MESSAGE);

			//Try to connect to the MySQL Server and create database
			try {
								
				String HOST_URL = "jdbc:mysql://localhost:3306";
				dbConn = DriverManager.getConnection(HOST_URL, username, password);
				DBInitializer db = new DBInitializer(dbConn);
				
				//Call method to create database and tables
				dbIsCreated = db.createUTeQueDataBase();
				
				/**
				 * If Database creation is successful table creation is now
				 * allowed.
				 */
				if(dbIsCreated) {
					logger.warn("Setting up Student Table, Error May Occur");
					tableIsCreated = db.createStudentTable();
					
					if(!tableIsCreated)
						throw new SQLException();
					
					//Creating Student Services Table
					logger.warn("Setting up MySQL StudentServicesRep Table, Error May Occur");
					tableIsCreated = db.createStudentServicesRepsTable();

					if(!tableIsCreated)
						throw new SQLException();

					//Creating Student Services Table
					logger.warn("Setting up MySQL StudentServicesAgent Table, Error May Occur");
					tableIsCreated = db.createStudentServicesAgentsTable();

					if(!tableIsCreated)
						throw new SQLException();
					
					//Creating Student Services Table
					logger.warn("Setting up MySQL Services Table, Error May Occur");
					tableIsCreated = db.createServiceTable();

					if(!tableIsCreated)
						throw new SQLException();
					
					//Creating Issue Table
					logger.warn("Setting up MySQL Issue Table, Error May Occur");
					tableIsCreated = db.createIssueTable();

					if(!tableIsCreated)
						throw new SQLException();
					
					//Creating Response Table
					logger.warn("Setting up MySQL Response Table, Error May Occur");
					tableIsCreated = db.createResponseTable();
					
					if(!tableIsCreated)
						throw new SQLException();
					
				}
				
			}catch(SQLException e1) {
				logger.error("DATABASE was NOT CREATED Successfully: ERROR(" 
						+ e1.getErrorCode() + ") " 
						+ e1.getMessage());
			}
		
		}catch(RuntimeException e) {
			JOptionPane.showMessageDialog(null, 
					"ERROR CONNECTING TO DATABASE. FAILED CONNECTION", 
					"CONTACT DEVELOPER", JOptionPane.ERROR_MESSAGE);
			logger.error("Database Does NOT Exist: ERROR: " 
						+ e.getMessage());
			System.exit(0);
		}
		return dbConn;
	}

}
