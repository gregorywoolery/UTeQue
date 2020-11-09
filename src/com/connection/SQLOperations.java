package com.connection;

import com.model.*;

import java.sql.*;
import java.util.ArrayList; 

public class SQLOperations {
	//Attributes
	private Connection dbConn;
	boolean numRows;
	
	//Student Table
	//--Insert Statement
	public void insertStudent(Student student) {
		try {
			String insertSql = "INSERT INTO UTeQueDB.Students (type, id, password, firstname, lastname, gender, email, dob, phone) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			statement.setString(1, student.getType());
			statement.setString(2, student.getID());
			statement.setString(3, student.getPassword());
			statement.setString(4, student.getFname());
			statement.setString(5, student.getLname());
			statement.setString(6, student.getGender());
			statement.setString(7, student.getEmail());
			statement.setDate(8, (Date) student.getDob());
			statement.setString(9, student.getPhone());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---User inserted successfully!");
			}
			
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	//--Update Statement
	public void updateStudent(Student student) {
		if(checkExistingStudent(student.getID())) {
			try {
				String updateSql = "UPDATE UTeQueDB.Students SET type=?, id=?, password=?, firstname=?, lastname=?, "
						+ "gender=?, email=?, dob=?, phone=? WHERE id=?";
				
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(1, student.getType());
				statement.setString(2, student.getID());
				statement.setString(3, student.getPassword());
				statement.setString(4, student.getFname());
				statement.setString(5, student.getLname());
				statement.setString(6, student.getGender());
				statement.setString(7, student.getEmail());
				statement.setDate(8, (Date) student.getDob());
				statement.setString(9, student.getPhone());
				
				int rowsUpdated = statement.executeUpdate();
				if(rowsUpdated > 0) 
					System.out.println("---Existing user updated successfully !");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			System.out.println("---"+student.getID() +" "+student.getFname() +" "+ student.getLname() + " was not found.");
	}
	//--Delete Statement
	public void deleteStudent(Student student) {
		if(checkExistingStudent(student.getID())) {
			String deleteSql = "DELETE from UTeQueDB.Students WHERE id=?";
			
			try {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, student.getID());
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("---User was deleted successfully!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}else
			System.out.println("---Student was not found.");
	}
	//--Read Statement
	public ArrayList<Student> readStudent() {

		ArrayList<Student> student = new ArrayList<Student>();
		
		String readAll = "SELECT * FROM UTeQueDB.Students";
		Student copyStudent = new Student(); // Used to set data from database
		try {
			Statement statement = dbConn.createStatement();
			ResultSet result = statement.executeQuery(readAll);
			
			while(result.next()) {
				copyStudent.setType(result.getString(1));
				copyStudent.setID(result.getString(2));
				copyStudent.setPassword(result.getString(3));
				copyStudent.setFname(result.getString(4));
				copyStudent.setLname(result.getString(5));
				copyStudent.setGender(result.getString(6));
				copyStudent.setEmail(result.getString(7));
				copyStudent.setDob(result.getDate(8));
				copyStudent.setPhone(result.getString(9));

				student.add(copyStudent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(student.size() != 0) {
			//display(student);
		}
			
		if(student.size()==0) {
			System.out.println("---No Student Record found..\n");
		}
		
		return student;
	}
	
	//Services Table
	//--Insert Statement
	public void insertServices(Users services) {
		try {
			String insertSql = "INSERT INTO UTeQueDB.Services (type, id, password, firstname, lastname, gender, email, dob, phone) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = dbConn.prepareStatement(insertSql);
			statement.setString(1, services.getType());
			statement.setString(2, services.getID());
			statement.setString(3, services.getPassword());
			statement.setString(4, services.getFname());
			statement.setString(5, services.getLname());
			statement.setString(6, services.getGender());
			statement.setString(7, services.getEmail());
			statement.setDate(8, (Date) services.getDob());
			statement.setString(9, services.getPhone());
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---User inserted successfully!");
			}
			
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	//--Update Statement
	public void updateServices(Users services) {
		if(checkExistingServices(services.getID())) {
			String updateSql = "UPDATE UTeQueDB.Services SET type=?, id=?, password=?, firstname=?, lastname=?, "
					+ "gender=?, email=?, dob=?, phone=? WHERE id=?";
			try {
				PreparedStatement statement = dbConn.prepareStatement(updateSql);
				statement.setString(1, services.getType());
				statement.setString(2, services.getID());
				statement.setString(3, services.getPassword());
				statement.setString(4, services.getFname());
				statement.setString(5, services.getLname());
				statement.setString(6, services.getGender());
				statement.setString(7, services.getEmail());
				statement.setDate(8, (Date) services.getDob());
				statement.setString(9, services.getPhone());
				
				int rowsUpdated = statement.executeUpdate();
				if(rowsUpdated > 0) 
					System.out.println("---Existing user updated successfully !");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			System.out.println("---"+services.getID() +" "+services.getFname() +" "+ services.getLname() + " was not found.");
	}
	//--Delete Statement
	public void deleteServices(Users services) {
		if(checkExistingServices(services.getID())) {
			String deleteSql = "DELETE from UTeQueDB.Services WHERE id=?";
			
			try {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, services.getID());
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("---User was deleted successfully!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}else
			System.out.println("---Student was not found.");
	}
	//--Read Statement
	public ArrayList<Users> readServices() {

			ArrayList<Users> service = new ArrayList<Users>();
			
			String readAll = "SELECT * FROM UTeQueDB.Services";
			Users copyService = new Users(); // Used to set data from database
			try {
				Statement statement = dbConn.createStatement();
				ResultSet result = statement.executeQuery(readAll);
				
				while(result.next()) {
					copyService.setType(result.getString(1));
					copyService.setID(result.getString(2));
					copyService.setPassword(result.getString(3));
					copyService.setFname(result.getString(4));
					copyService.setLname(result.getString(5));
					copyService.setGender(result.getString(6));
					copyService.setEmail(result.getString(7));
					copyService.setDob(result.getDate(8));
					copyService.setPhone(result.getString(9));

					service.add(copyService);
				}
			} catch (SQLException e) {
				e.printStackTrace();
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
			
			int rowsInserted = statement.executeUpdate();
			
			if (rowsInserted > 0) {
			    System.out.println("---Issue was inserted successfully!");
			}
			
		} catch(SQLException e) {
			System.out.println("SQL Exception Thrown: " + e.getMessage());
		}
	}
	//--Update Statement
	public void updateIssue(Issue issue) {
		if(checkExistingIssue(issue.getIssueId())) {
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
				
				int rowsUpdated = statement.executeUpdate();
				if(rowsUpdated > 0) 
					System.out.println("---Existing Issue was updated !");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
			System.out.println("---"+issue.getIssueId() + " was not found.");
	}
	//--Delete Statement
	public void deleteIssue(Issue issue) {
		if(checkExistingIssue(issue.getIssueId())) {
			String deleteSql = "DELETE from UTeQueDB.Issue WHERE issueId=?";
			
			try {
				PreparedStatement statement = dbConn.prepareStatement(deleteSql);
				statement.setString(1, issue.getIssueId());
				int rowsDeleted = statement.executeUpdate();
				if (rowsDeleted > 0) {
				    System.out.println("---Issue was deleted successfully!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}else
			System.out.println("---Issue was not found.");
	}
	//--Read Statement
	public ArrayList<Issue> readIssue() {

			ArrayList<Issue> issue = new ArrayList<Issue>();
			
			String readAll = "SELECT * FROM UTeQueDB.Issue";
			Issue copyIssue = new Issue(); // Used to set data from database
			try {
				Statement statement = dbConn.createStatement();
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(issue.size() != 0) {
				//display(student);
			}
				
			if(issue.size()==0) {
				System.out.println("---No Record found..\n");
			}
			
			return issue;
	}
		
	
	//checkExisting 
	public Boolean checkExistingStudent(String id) {
		String selectStudent = "SELECT count(*) FROM UTeQueDB.Students WHERE id=?";
		
		try {
			PreparedStatement statement = dbConn.prepareStatement(selectStudent);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				final int count = result.getInt(1);
				if(count == 1) {
					System.out.println("---STUDENT EXIST");
					return true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("---Student does not exist");
		return false;
	}
	public Boolean checkExistingServices(String id) {
		String selectServices = "SELECT count(*) FROM UTeQueDB.Services WHERE id=?";
		
		try {
			PreparedStatement statement = dbConn.prepareStatement(selectServices);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				final int count = result.getInt(1);
				if(count == 1) {
					System.out.println("---SERVICE EMPLOYEE EXIST");
					return true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("---Service does not exist");
		return false;
	}
	public Boolean checkExistingIssue(String id) {
		String selectIssue = "SELECT count(*) FROM UTeQueDB.Issue WHERE issueId=?";
		
		try {
			PreparedStatement statement = dbConn.prepareStatement(selectIssue);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();

			while(result.next()) {
				final int count = result.getInt(1);
				if(count == 1) {
					System.out.println("---ISSUE EXIST");
					return true;
				}
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("---Issue does not exist");
		return false;
	}

}
