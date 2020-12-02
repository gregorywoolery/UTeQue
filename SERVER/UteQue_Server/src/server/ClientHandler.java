package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Date;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;

import com.model.Issue;
import com.model.Response;
import com.model.StudentServicesRep;
import com.model.User;
import com.services.IssueOperation;
import com.services.LoginAuthentication;
import com.services.ResponseOperation;
import com.services.ServiceOperation;
import com.services.UserOperation;

public class ClientHandler extends Thread{
	private static final Logger logger = LogManager.getLogger(ClientHandler.class);
	
	Socket socketConnection = null;
	String operation = "", userID = "", issueID= "", type= "";
	Date issuedAt = null;
	boolean success = false;
	int[] stats = new int[3];
	StudentServicesRep studentServicesRep = null;
	int serviceID=0;
	User user;
	Response response;
	Level loglevel;
	String logMessage, log;
	
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
				Object value = is.readObject();
				
				/**
				 * If a LOGGING EVENT was sent to the server then designate and LOG.
				 */
				if(value instanceof LogEvent) {
					LogEvent event = (LogEvent) is.readObject();
					
					loglevel = event.getLevel();
					logMessage = event.getMessage().getFormattedMessage();
					log = "CLIENT LOG - [" + event.getThreadName() + "] "+ "{" + event.getSource() + "}" + logMessage;
					
					if(loglevel.equals(Level.ERROR)) {
						logger.error(log);
					
					}else if(loglevel.equals(Level.INFO)) {
						logger.info(log);
					
					}else if(loglevel.equals(Level.WARN)) {
						logger.warn(log);
					}
				}else {
					operation = (String) value;
					
					
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
							userID = (String) is.readObject();							
							stats = IssueOperation.getUserIssueStats(userID);
							os.writeObject(stats);
							break;
							
						case "GET-STUDENT-ISSUES":
							userID = (String) is.readObject();
							os.writeObject(IssueOperation.getAllIssuesForStudent(userID));
							break;
							
						case "GET-ALL-SERVICES":
							os.writeObject(ServiceOperation.getAllServices());
							break;	
							
						case "GET-CURRENT-USER":
							user = (User) is.readObject();
							os.writeObject(UserOperation.getUserInfo(user.getID(), user.getType()));
							break;
						
						case "GET-STUDENT-ISSUES-BY-SERVICE":
							userID = (String) is.readObject();
							serviceID = (int) is.readObject();
							os.writeObject(IssueOperation.getIssueByService(userID, serviceID));
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
							userID = (String) is.readObject();
							os.writeObject(IssueOperation.assignRepresentative(issueID, userID));
							break;
							
						case "GET-STUDENT":
							userID = (String) is.readObject();
							os.writeObject(UserOperation.getStudent(userID));
							break;
							
						case "GET-RESPONSE":
							issueID = (String) is.readObject();
							os.writeObject(ResponseOperation.getResponseUsingIssue(issueID));
							break;
						case "GET-REP":
							userID = (String) is.readObject();
							os.writeObject(UserOperation.getRep(userID));
							break;
						case "POST-RESPONSE":
							response = (Response) is.readObject();
							os.writeObject(ResponseOperation.postResponse(response));
							break;
						case "UPDATE-ISSUE-STATUS":
							issueID = (String) is.readObject();
							System.out.println("Client Handler TEST****");
							os.writeObject(IssueOperation.updateStatus(issueID));
							break;
						case "UPDATE-RESPONSE-COMMENT":
							issueID = (String) is.readObject();
							String comment = (String) is.readObject();

							os.writeObject(ResponseOperation.updateComment(issueID, comment));
							break;
					}
				
				os.flush();
				socketConnection.close();
					
				}									
	
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
