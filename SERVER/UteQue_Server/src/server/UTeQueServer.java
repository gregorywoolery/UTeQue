package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Issue;
import com.model.StudentServicesRep;
import com.model.User;
import com.services.IssueOperation;
import com.services.LoginAuthentication;
import com.services.ServiceOperation;
import com.services.UserOperation;

public class UTeQueServer {
	private static final Logger logger = LogManager.getLogger(UTeQueServer.class);
	private int port = 3309;
	private Socket socketConnection;
	
	//Number of client connect - threads created
	private static int totalConnectedClients = 0;
	
    LocalDateTime startDateTime = LocalDateTime.now();
    DateTimeFormatter startDateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String serverStartDateTime = startDateTime.format(startDateTimeFormat);
	
	/**
	 * Creates a server socket that is bound to the port number 3306. 
	 * The maximum number of queued incoming connections is set to 60 
	 * (when the queue is full, new connections are refused).
	 */
	public UTeQueServer() {
		try (ServerSocket serverSocket = new ServerSocket(port, 60)){
			socketConnection = new Socket();
			
			logger.info("Server is listening on port " + port);
			/**
			 * Listen for incoming client requests
			 */
			while(true) {
				socketConnection = serverSocket.accept();
				logger.info(serverStartDateTime + " Server has started");

				new ClientHandler(socketConnection).run();
				++totalConnectedClients;
				logger.info("USER THREADS: " + totalConnectedClients);
			}			
		} catch (IOException ioex) {
			logger.error(ioex.getMessage() 
					+ "\nAT: " + ioex.getStackTrace());		
		}
	}
	
	public static class ClientHandler extends Thread implements Runnable{
		Socket socketConnection = null;
		String operation = "", studentID = "", issueID= "", type= "", repID = "";
		Date issuedAt = null;
		boolean success = false;
		int[] stats = new int[3];
		StudentServicesRep studentServicesRep = null;
		int serviceID=0;
		User user;
		
		public ClientHandler(Socket socket) {
			logger.info("Socket connection recieved by server thread");
			socketConnection = socket;
		}
		
		@Override
		public void run() {
			logger.info("Executing server thread");
			try(
					ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
					ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream())
			){
				while(!socketConnection.isClosed()) {
					
					operation = (String) is.readObject();
					
					switch(operation) {						
						case "AUTHENTICATE":
							User userAuth = (User) is.readObject();
							success = LoginAuthentication.authLoginUser(userAuth);
							os.writeObject(success);
							break;
							
						case "ADD-ISSUE":
							Issue issue = (Issue) is.readObject();
							success = IssueOperation.insertIssue(issue);
							os.writeBoolean(success);
							break;
							
						case "GET-STUDENT-ISSUE-STATS":
							studentID = (String) is.readObject();							
							stats = IssueOperation.getUserIssueStats(studentID);
							os.writeObject(stats);
							break;
							
						case "GET-STUDENT-ISSUES":
							studentID = (String) is.readObject();
							os.writeObject(IssueOperation.getAllIssuesForStudent(studentID));
							break;
							
						case "GET-ALL-SERVICES":
							os.writeObject(ServiceOperation.getAllServices());
							break;	
							
						case "GET-CURRENT-USER":
							user = (User) is.readObject();
							os.writeObject(UserOperation.getUserInfo(user.getID(), user.getType()));
							break;
						
						case "GET-STUDENT-ISSUES-BY-SERVICE":
							studentID = (String) is.readObject();
							serviceID = (int) is.readObject();
							os.writeObject(IssueOperation.getIssueByService(studentID, serviceID));
							break;
						
						case "GET-ISSUE":
							issueID = (String) is.readObject();
							os.writeObject(IssueOperation.getIssue(issueID));
							break;
							
						case "DELETE-ISSUE":
							issueID = (String) is.readObject();
							success =  IssueOperation.deleteIssue(issueID);
							os.writeBoolean(success);
							break;
							
						case "GET-STUDENT-SEARCH ISSUES":
							Issue searchIssue = (Issue) is.readObject();
							System.out.println("UTeQueServer:" + searchIssue.toString());
							os.writeObject(IssueOperation.getAllSearchIssuesForStudent(searchIssue));
							break;
						
						case "GET-REPS":
							os.writeObject(UserOperation.getStudentServiceReps());
							break;
							
						case "ASSIGN-REP":
							issueID = (String) is.readObject();
							repID = (String) is.readObject();
							os.writeObject(IssueOperation.assignRepresentative(issueID, repID));
							break;
							
						case "ISSUE-RESPONSE":
							issueID = (String) is.readObject();
							os.writeObject(IssueOperation.getIssueRepStudent(issueID));
							break;
							
					}
					
					os.flush();
					socketConnection.close();
					
				}
			}catch(IOException ioex){
				System.out.println("SERVER ERROR - " + ioex.getMessage() 
						+ "\nAT: " + ioex.getStackTrace());
				
			} catch (ClassNotFoundException cnfex) {
				System.out.println("SERVER ERROR - " + cnfex.getMessage() 
				+ "\nAT: " + cnfex.getStackTrace());
			}	
		}
	}
}