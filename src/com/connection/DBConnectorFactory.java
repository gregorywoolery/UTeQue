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
	private static String jdbcUrl = "jdbc:mysql://localhost:8889/UTeQueDB?useSSL=false";
	private static String username = "root"; //User name & Password for database connection
	private static String password = "root";
	private static final Logger logger = LogManager.getLogger(SQLOperations.class);
	
	public static Connection getDatabaseConnection() {
		try {
			logger.warn("Attempting to CONNECT to MySQL Server Database, Error may occur");
			//Try to get a connection to the MySQL server and database
			dbConn = DriverManager.getConnection(jdbcUrl, username, password);
			
			if(dbConn != null) { //Check if the connection was successful
				logger.info("MySQL Database was connected successfully");
				JOptionPane.showMessageDialog(null, 
						"Connection to database server succesful", 
						"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
			}
			
		}catch(SQLException e) {
			
			JOptionPane.showMessageDialog(null, 
					"Setting up Database and table", 
					"DB Connection Status", JOptionPane.WARNING_MESSAGE);
			try {//Try to connect to the MySQL Server and create database
				
				String Url = "jdbc:mysql://localhost:8889";
				dbConn = DriverManager.getConnection(Url, username, password);
				CreateDB db = new CreateDB(dbConn);
				
				//Call method to create database & table
				boolean dbIsCreated;
				logger.warn("Setting up MySQL Table Student, Error may occur");
				dbIsCreated = db.createStudentTable();
				
				if(dbIsCreated == true) { //If database and table was created successfully
					logger.info("MySQL Table Student was CREATED successfully");
					JOptionPane.showMessageDialog(null, 
							"Connected to UTeQueDB - Student", 
							"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
				logger.warn("Setting up MySQL Table Services, Error may occur");
				dbIsCreated = db.createServicesTable();
				
				if(dbIsCreated == true) { //If database and table was created successfully
					logger.info("MySQL Table Services was CREATED successfully");
					JOptionPane.showMessageDialog(null, 
							"Connected to UTeQueDB - Services", 
							"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
				}
				
				logger.warn("Setting up MySQL Table Issue, Error may occur");
				dbIsCreated = db.createIssueTable();
				
				if(dbIsCreated == true) { //If database and table was created successfully
					logger.info("MySQL Table Issue was CREATED successfully");
					JOptionPane.showMessageDialog(null, 
							"Connected to UTeQueDB - Issue", 
							"DB Connection Status", JOptionPane.INFORMATION_MESSAGE);
				}
			}catch(SQLException e1) {
				logger.error("SQL Table was NOT CREATED successfully");
				System.out.println("HELP: " + e1.getMessage());
			}
		
		}catch(RuntimeException e) {
			System.out.println("Database doesn't exist");
		}
		return dbConn;
	}
	

}
