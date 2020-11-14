package com.connection;

//Import classes of Model package
import com.model.*;

//Import Log4j packages
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

//Import SQL packages
import java.sql.*;

//Import ArrayList packages
import java.util.ArrayList; 

public class SQLOperations {
	//Attributes
	private Connection dbConn;
	boolean numRows;
	private static final Logger logger = LogManager.getLogger(SQLOperations.class);
	
	//Student Table
	//--Insert Statement
	public void insertStudent(Student student) {
		try {
			logger.warn("Attempting to INSERT Data INTO SQL table Student, Error May Occur");
			
			String insertSql = "INSERT INTO UTeQueDB.Students (type, id, password, firstname, lastname, gender, email, dob, phone) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			statement.setString(2, student.getID());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getFname());
			statement.setString(5, student.getLname());
			statement.setString(6, student.getGender());
			statement.setString(7, student.getEmail());
			statement.setDate(8, (Date) student.getDOB());
			statement.setString(9, student.getPhone());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---User INSERTED successfully!");
			    logger.info("SQL insert statement was successful");
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT statement was NOT successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	
	//--Update Statement
	public void updateStudent(Student student) {
		if(checkExistingStudent(student.getID())) {
			try {
				logger.warn("Attempting to UPDATE Data FROM SQL table Student, Error May Occur");
				
				String updateSql = "UPDATE UTeQueDB.Students SET type=?, id=?, password=?, firstname=?, lastname=?, "
						+ "gender=?, email=?, dob=?, phone=? WHERE id=?";
				
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(2, student.getID());
				statement.setString(3, student.getPassword());
				statement.setString(4, student.getFname());
				statement.setString(5, student.getLname());
				statement.setString(6, student.getGender());
				statement.setString(7, student.getEmail());
				statement.setDate(8, (Date) student.getDOB());
				statement.setString(9, student.getPhone());
				
				int rowsUpdated = statement.executeUpdate();
				if(rowsUpdated > 0) {
					System.out.println("---Existing User UPDATED successfully !");
					logger.info("SQL UPDATE statement was Successful");
				}
			} catch (SQLException e) {
				logger.error("SQL UPDATE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}
		}else
			System.out.println("---"+student.getID() +" "+student.getFname() +" "+ student.getLname() + " was NOT found.");
	}
	
	//--Delete Statement
	public void deleteStudent(Student student) {
		if(checkExistingStudent(student.getID())) {
			String deleteSql = "DELETE from UTeQueDB.Students WHERE id=?";
			
			try {
				logger.warn("Attempting to DELETE data FROM SQL table Student, Error May Occur");
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, student.getID());
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("---User was DELETED Successfully!");
				    logger.info("SQL DELETE statement was successful");
				}
			} catch (SQLException e) {
				logger.error("SQL DELETE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}		
		}else
			System.out.println("---Student was NOT Found.");
	}
	
	//--Read Statement
	public ArrayList<Student> readStudent() {

		ArrayList<Student> student = new ArrayList<Student>();
		String readAll = "SELECT * FROM UTeQueDB.Students";
		Student copyStudent = new Student(); // Used to set data from database
		
		try {
			logger.warn("Attempting to READ Data FROM SQL table Student, Error May Occur");
			Statement statement = dbConn.createStatement();
			ResultSet result = statement.executeQuery(readAll);
			
			while(result.next()) {
				copyStudent.setID(result.getString(2));
				copyStudent.setPassword(result.getString(3));
				copyStudent.setFname(result.getString(4));
				copyStudent.setLname(result.getString(5));
				copyStudent.setGender(result.getString(6));
				copyStudent.setEmail(result.getString(7));
				copyStudent.setDOB(result.getDate(8));
				copyStudent.setPhone(result.getString(9));

				student.add(copyStudent);
			}
			logger.info("SQL READ Statement was Successful");
		} catch (SQLException e) {
			logger.error("SQL READ Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		
		if(student.size() != 0) {
			//display(student);
		}
			
		if(student.size()==0) {
			System.out.println("---No Student Record Found..\n");
		}
		
		return student;
	}
	
	//Services Table
	//--Insert Statement
	public void insertServices(User services) {
		try {
			logger.warn("Attempting to INSERT Data INTO SQL table Services, Error May Occur");
			
			String insertSql = "INSERT INTO UTeQueDB.Services (type, id, password, firstname, lastname, gender, email, dob, phone) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			statement.setString(2, services.getID());
			statement.setString(3, services.getPassword());
			statement.setString(4, services.getFname());
			statement.setString(5, services.getLname());
			statement.setString(6, services.getGender());
			statement.setString(7, services.getEmail());
			statement.setDate(8, (Date) services.getDOB());
			statement.setString(9, services.getPhone());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---User INSERTED Successfully!");
			    logger.info("SQL INSERT statement was successful");
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	
	//--Update Statement
	public void updateServices(User services) {
		if(checkExistingServices(services.getID())) {
			logger.warn("Attempting to UPDATE data FROM SQL table Services, Error May Occur");
			
			String updateSql = "UPDATE UTeQueDB.Services SET type=?, id=?, password=?, firstname=?, lastname=?, "
					+ "gender=?, email=?, dob=?, phone=? WHERE id=?";
			try {
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(2, services.getID());
				statement.setString(3, services.getPassword());
				statement.setString(4, services.getFname());
				statement.setString(5, services.getLname());
				statement.setString(6, services.getGender());
				statement.setString(7, services.getEmail());
				statement.setDate(8, (Date) services.getDOB());
				statement.setString(9, services.getPhone());
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				int rowsUpdated = statement.executeUpdate();
				
				if(rowsUpdated > 0) {
					System.out.println("---Existing User UPDATED Successfully !");
					logger.info("SQL UPDATE statement was successful");
				}
			} catch (SQLException e) {
				logger.error("SQL UPDATE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}
		}else
			System.out.println("---"+services.getID() +" "+services.getFname() +" "+ services.getLname() + " was NOT found.");
	}
	
	//--Delete Statement
	public void deleteServices(User services) {
		if(checkExistingServices(services.getID())) {
			logger.warn("Attempting to DELETE data FROM SQL table Services, Error May Occur");
			
			String deleteSql = "DELETE from UTeQueDB.Services WHERE id=?";
			
			try {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, services.getID());
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				int rowsDeleted = statement.executeUpdate();
				
				if (rowsDeleted > 0) {
				    System.out.println("---User was DELETED Successfully!");
				    logger.info("SQL DELETE Statement was Successful");
				}
			} catch (SQLException e) {
				logger.error("SQL DELETE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}		
		}else
			System.out.println("---Student was NOT Found.");
	}
	//--Read Statement
	public ArrayList<User> readServices() {

			ArrayList<User> service = new ArrayList<User>();
			
			String readAll = "SELECT * FROM UTeQueDB.Services";
			User copyService = new User(); // Used to set data from database
			
			logger.warn("Attempting to READ Data FROM SQL table Services, Error May Occur");
			
			try {
				Statement statement = dbConn.createStatement();
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				ResultSet result = statement.executeQuery(readAll);
				
				while(result.next()) {
					copyService.setID(result.getString(2));
					copyService.setPassword(result.getString(3));
					copyService.setFname(result.getString(4));
					copyService.setLname(result.getString(5));
					copyService.setGender(result.getString(6));
					copyService.setEmail(result.getString(7));
					copyService.setDOB(result.getDate(8));
					copyService.setPhone(result.getString(9));

					service.add(copyService);
				}
				logger.info("SQL READ Statement was Successful");
				
			} catch (SQLException e) {
				logger.error("SQL DELETE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}
			
			if(service.size() != 0) {
				//display();
			}
				
			if(service.size()==0) {
				System.out.println("---No Record found..\n");
			}
			
			return service;
	}
	
	//Issues Table
	//--Insert Statement
	public void insertIssue(Issue issue) {
		try {
			logger.warn("Attempting to INSERT Data INTO SQL table Issue, Error May Occur");
			
			String insertSql = "INSERT INTO UTeQueDB.Issue (issueId, type, status, studentId, message, scheduledDateTime, repId) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			statement.setString(1, issue.getIssueId());
			statement.setString(2, issue.getType());
			statement.setString(3, issue.getStatus());
			statement.setString(4, issue.getStudentId());
			statement.setString(5, issue.getMessage());
			statement.setDate(6, (Date) issue.getScheduledDateTime());
			statement.setString(7, issue.getRepId());
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---Issue was INSERTED Successfully!");
			    logger.info("SQL INSERT Statement was Successful");
			}
			
		} catch(SQLException e) {
			logger.error("SQL INSERT Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	
	//--Update Statement
	public void updateIssue(Issue issue) {
		if(checkExistingIssue(issue.getIssueId())) {
			logger.warn("Attempting to UPDATE Data FROM SQL table Issue, Error May Occur");
			
			String updateSql = "UPDATE UTeQueDB.Issue SET issueId=?, type=?, status=?, studentId=?, message=?, "
					+ "scheduledDateTime=?, repId=? WHERE id=?";
			try {
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(1, issue.getIssueId());
				statement.setString(2, issue.getType());
				statement.setString(3, issue.getStatus());
				statement.setString(4, issue.getStudentId());
				statement.setString(5, issue.getMessage());
				statement.setDate(6, (Date) issue.getScheduledDateTime());
				statement.setString(7, issue.getRepId());
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				int rowsUpdated = statement.executeUpdate();
				
				if(rowsUpdated > 0) {
					System.out.println("---Existing Issue was UPDATED !");
					logger.info("SQL UPDATE Statement was Successful");
				}
			} catch (SQLException e) {
				logger.error("SQL UPDATE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}
		}else
			System.out.println("---"+issue.getIssueId() + " was NOT found.");
	}
	
	//--Delete Statement
	public void deleteIssue(Issue issue) {
		if(checkExistingIssue(issue.getIssueId())) {
			logger.warn("Attempting to DELETE Data FROM SQL table Issue, Error May Occur");
			
			String deleteSql = "DELETE from UTeQueDB.Issue WHERE issueId=?";
			
			try {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, issue.getIssueId());
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				int rowsDeleted = statement.executeUpdate();
				
				if (rowsDeleted > 0) {
				    System.out.println("---Issue was DELETED Successfully!");
				    logger.info("SQL DELETE Statement was Successful");
				}
			} catch (SQLException e) {
				logger.error("SQL DELETE Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}		
		}else
			System.out.println("---Issue was NOT found.");
	}
	
	//--Read Statement
	public ArrayList<Issue> readIssue() {

			ArrayList<Issue> issue = new ArrayList<Issue>();
			
			String readAll = "SELECT * FROM UTeQueDB.Issue";
			Issue copyIssue = new Issue(); // Used to set data from database
			try {
				logger.warn("Attempting to READ Data FROM SQL table Issue, Error May Occur");
				
				Statement statement = dbConn.createStatement();
				
				logger.warn("Attempting to EXECUTE Statement, Error May Occur");
				ResultSet result = statement.executeQuery(readAll);
				
				while(result.next()) {
					copyIssue.setIssueId(result.getString(1));
					copyIssue.setType(result.getString(2));
					copyIssue.setStatus(result.getString(3));
					copyIssue.setStatus(result.getString(4));
					copyIssue.setStudentId(result.getString(5));
					copyIssue.setMessage(result.getString(6));
					copyIssue.setScheduledDateTime(result.getDate(7));
					copyIssue.setRepId(result.getString(9));

					issue.add(copyIssue);
				}
				logger.info("SQL READ Statement was Successful");
				
			} catch (SQLException e) {
				logger.error("SQL READ Statement was NOT Successful");
				System.out.println("SQL Exception Thrown: " + e.getMessage());
			}
			
			if(issue.size() != 0) {
				//display(student);
			}
				
			if(issue.size()==0) {
				System.out.println("---No Record Found..\n");
			}
			
			return issue;
	}
		
	
	//checkExisting 
	public Boolean checkExistingStudent(String id) {
		String selectStudent = "SELECT COUNT(*) FROM UTeQueDB.Students WHERE id=?";
		
		try {
			logger.warn("Attempting to COUNT Data FROM SQL table Student, Error May Occur");
			
			PreparedStatement statement = dbConn.prepareStatement(selectStudent);
			statement.setString(1, id);
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				final int count = result.getInt(1);
				
				if(count == 1) {
					logger.info("SQL COUNT Statement was Successful");
					System.out.println("---STUDENT EXIST");
					return true;
				}
			}

		}catch(SQLException e){
			logger.error("SQL COUNT Statement was NOT successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		System.out.println("---Student does NOT Exist");
		return false;
	}
	
	public Boolean checkExistingServices(String id) {
		String selectServices = "SELECT COUNT(*) FROM UTeQueDB.Services WHERE id=?";
		
		try {
			logger.warn("Attempting to COUNT Data FROM SQL table Services, Error May Occur");
			
			PreparedStatement statement = dbConn.prepareStatement(selectServices);
			statement.setString(1, id);
			
			logger.warn("Attempting to EXECUTE Statement, Error May Occur");
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				final int count = result.getInt(1);
				
				if(count == 1) {
					logger.info("SQL COUNT Statement was Successful");
					System.out.println("---SERVICE EMPLOYEE EXIST");
					return true;
				}
			}

		}catch(SQLException e){
			logger.error("SQL COUNT Statement was NOT Successful");
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
		System.out.println("---Service Does NOT Exist");
		return false;
	}
	
	public Boolean checkExistingIssue(String id) {
		String selectIssue = "SELECT COUNT(*) FROM UTeQueDB.Issue WHERE issueId=?";
		
		try {
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
		System.out.println("---Issue Does NOT Exist");
		return false;
	}

}
