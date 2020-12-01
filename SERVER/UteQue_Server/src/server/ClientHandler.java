package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LogEvent;

import com.model.Issue;
import com.model.Response;
import com.model.User;
import com.services.IssueOperation;
import com.services.LoginAuthentication;
import com.services.ResponseOperation;
import com.services.ServiceOperation;
import com.services.UserOperation;

public class ClientHandler extends Thread{
	private static final Logger logger = LogManager.getLogger(ClientHandler.class);
	
	private final Server server;
	private final Socket socketConnection;
	private User account = null;
	
	public ClientHandler(Server server, Socket socket) {
		logger.info("Socket connection recieved by server thread");
		this.server = server;
		this.socketConnection = socket;
	}
	
	public User getAccount() {
		return account;
	}
	
	@Override
	public void run() {
		
		logger.info("Executing server thread");
		try(
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream())
		){
			while(!socketConnection.isClosed()) {
				logger.info("Request recieved from CLIENT");
				Object operand = is.readObject();
				
				/**
				 * If a LOGGING EVENT was sent to the server then designate and LOG.
				 */
				if(operand instanceof LogEvent)
					logEvent(operand);
				else 
					doOperation(os, is, operand);
				
				os.flush();
			}
		}catch(IOException ioex){
			logger.error("SERVER ERROR - " + ioex.getMessage() 
					+ "\nAT: " + ioex.getStackTrace());
			
		} catch (ClassNotFoundException cnfex) {
			logger.error("SERVER ERROR - " + cnfex.getMessage() 
			+ "\nAT: " + cnfex.getStackTrace());
		}	
	}
	
	public void logEvent(Object logEvent) {
		Level loglevel;
		String logMessage, log;
		
		LogEvent event = (LogEvent) logEvent;
		
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
	}
	
	public void handleLogin(ObjectOutputStream os, ObjectInputStream is, Object aperand) 
			throws ClassNotFoundException, IOException{
		boolean success = false;
		
		User userAuth = (User) is.readObject();
		success = LoginAuthentication.authLoginUser(userAuth);
		os.writeObject(success);
		
		if(success) {
			account = UserOperation.getUserInfo(userAuth.getID(), userAuth.getType());
		}
	}
	
	public void sendLoggedInBroadCast(ObjectOutputStream os) throws IOException {
		for(ClientHandler client: server.getClients()) {
			if(!client.getAccount().getID().equals(account.getID()) && client.getAccount() != null) {
				os.writeObject("WHO-IS-LOGGED-ON");
				os.writeObject(client.getAccount());
			}
		}
	}
	
	/**
	 * Accepts Command from ObjectInputStream socket's Connection and executes as stated
	 */
	public void doOperation(ObjectOutputStream os, ObjectInputStream is, Object operand) 
			throws IOException, ClassNotFoundException{
		
		String operation = "", userID = "", issueID= "";
		String toUserID = "", message = "";
		User user;
		Response response;

		boolean success = false;
		int[] stats = new int[3];
		int serviceID=0;
		
		
		operation = (String) operand;
		
		switch(operation) {						
			case "AUTHENTICATE":
				handleLogin(os, is, operand);
				break;
				
			case "LOG-OFF":
				handleLogOff(os);
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
				
			case "RECIEVE-MSG":
				toUserID = (String) is.readObject();
				message = (String) is.readObject();
				handleMessage(os, toUserID, message);
				break;
		}
	}
	
	private void handleMessage(ObjectOutputStream os, String toUserID, String message) 
			throws IOException{
		
		List<ClientHandler> clients = server.getClients();
		
		for(ClientHandler client: clients) {
			//Test if user is currently in system
			if(client.account.getID().equals(toUserID)) {
				os.writeObject("SEND-MSG");
				os.writeObject(toUserID);
				os.writeObject(message);
			}else
				os.writeObject("USER-NOT-EXIST");
				
		}
	}

	
	public void handleLogOff(ObjectOutputStream os) throws IOException {
		List<ClientHandler> clients = server.getClients();
		
		server.removeClientHandler(this);
		
		os.writeObject("OFFLINE");
		os.writeObject(this.account);
		
		try {
			socketConnection.close();
		} catch (IOException ioex) {
			logger.error("SERVER ERROR - " + ioex.getMessage() 
						+ "\nAT: " + ioex.getStackTrace());
		}
	}
}
