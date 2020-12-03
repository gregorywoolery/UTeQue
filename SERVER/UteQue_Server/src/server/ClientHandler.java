package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
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
	ObjectOutputStream os;
	ObjectInputStream is;
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
		try{
			os = new ObjectOutputStream(socketConnection.getOutputStream());
			is = new ObjectInputStream(socketConnection.getInputStream());
					
			while(!socketConnection.isClosed()) {
				logger.info("Request recieved from CLIENT");
				Object operand = is.readObject();
				
				/**
				 * If a LOGGING EVENT was sent to the server then designate and LOG.
				 */
				if(operand instanceof LogEvent)
					logEvent(operand);
				else 
					doOperation(operand);
				
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
	
	/**
	 * Accepts Command from ObjectInputStream socket's Connection and executes as stated
	 */
	public void doOperation(Object operand) 
			throws IOException, ClassNotFoundException{
		
		ArrayList<Object> receivedOp = new ArrayList<>();
		String operation = "", userID = "", issueID= "";
		String toUserID = "", message = "";
		User user;
		Response response;

		boolean success = false;
		int[] stats = new int[3];
		int serviceID = 0;
		
		logger.info("Processing request from CLIENT");
		
		receivedOp = (ArrayList<Object>) operand;
		operation = (String) receivedOp.get(0).toString();
		
		switch(operation) {						
			case "AUTHENTICATE":
				handleLogin((User) receivedOp.get(1));
				break;
				
			case "LOG-OFF":
				handleLogOff();
				break;
				
			case "DISCONNECT":
				handleLogOff();
				break;
				
			case "ADD-ISSUE":
				Issue issue = (Issue) receivedOp.get(1);
				success = IssueOperation.insertIssue(issue);
				os.writeObject(success);
				break;
				
			case "GET-STUDENT-ISSUE-STATS":
				userID = (String) receivedOp.get(1);						
				stats = IssueOperation.getUserIssueStats(userID);
				os.writeObject(stats);
				break;
				
			case "GET-STUDENT-ISSUES":
				userID = (String) receivedOp.get(1);	
				os.writeObject(IssueOperation.getAllIssuesForStudent(userID));
				break;
				
			case "GET-ALL-SERVICES":
				os.writeObject(ServiceOperation.getAllServices());
				break;	
				
			case "GET-CURRENT-USER":
				user = (User) receivedOp.get(1);	
				os.writeObject(UserOperation.getUserInfo(user.getID(), user.getType()));
				break;
			
			case "GET-STUDENT-ISSUES-BY-SERVICE":
				userID = (String) receivedOp.get(1);	
				serviceID = (int) receivedOp.get(2);	
				os.writeObject(IssueOperation.getIssueByService(userID, serviceID));
				break;
			
			case "GET-ISSUE":
				issueID = (String) receivedOp.get(1);	
				os.writeObject(IssueOperation.getIssue(issueID));
				break;
				
			case "DELETE-ISSUE":
				issueID = (String) receivedOp.get(1);	
				success =  IssueOperation.deleteIssue(issueID);
				os.writeObject(success);
				break;
				
			case "GET-STUDENT-SEARCH ISSUES":
				Issue searchIssue = (Issue) receivedOp.get(1);	
				System.out.println("UTeQueServer:" + searchIssue.toString());
				os.writeObject(IssueOperation.getAllSearchIssuesForStudent(searchIssue));
				break;
			
			case "GET-REPS":
				os.writeObject(UserOperation.getStudentServiceReps());
				break;
				
			case "ASSIGN-REP":
				issueID = (String) receivedOp.get(1);	
				userID = (String) receivedOp.get(2);	
				os.writeObject(IssueOperation.assignRepresentative(issueID, userID));
				break;
				
			case "GET-STUDENT":
				userID = (String) receivedOp.get(1);	
				os.writeObject(UserOperation.getStudent(userID));
				break;
				
			case "GET-RESPONSE":
				issueID = (String) receivedOp.get(1);	
				os.writeObject(ResponseOperation.getResponseUsingIssue(issueID));
				break;
				
			case "GET-REP":
				userID = (String) receivedOp.get(1);	
				os.writeObject(UserOperation.getRep(userID));
				break;
				
			case "POST-RESPONSE":
				response = (Response) receivedOp.get(1);	
				os.writeObject(ResponseOperation.postResponse(response));
				break;
				
			case "RECIEVE-MSG":
				toUserID = (String) receivedOp.get(1);	
				message = (String) receivedOp.get(2);	
				handleMessage(toUserID, message);
				break;

			case "UPDATE-ISSUE-STATUS":
				issueID = (String) receivedOp.get(1);	
				os.writeObject(IssueOperation.updateStatus(issueID));
				break;
				
			case "UPDATE-RESPONSE-COMMENT":
				issueID = (String) receivedOp.get(1);
				String comment = (String) receivedOp.get(2);	
				os.writeObject(ResponseOperation.updateComment(issueID, comment));
				break;

			case "GET-COUNT-RESOLVED-SERVICEID":
				serviceID = (int) receivedOp.get(1);
				os.writeObject(IssueOperation.getServiceResolvedCount(serviceID));
				break;
			
			case "GET-COUNT-UNRESOLVED-SERVICEID":
				serviceID = (int) receivedOp.get(1);
				os.writeObject(IssueOperation.getServiceUnresolvedCount(serviceID));
				break;
				
			case "GET-ONLINE-STUDENTS":
				sendOnlineStudents();				
				break;
		}
	}
	
	private void handleMessage(String toUserID, String message) 
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

	
	public void handleLogOff() throws IOException {
		List<ClientHandler> clients = server.getClients();
		ArrayList<Object> sendDetails = new ArrayList<>();

		server.removeClientHandler(this);

		String cmd = "OFFLINE";
		
		sendDetails.add(cmd);
		sendDetails.add(this.account);
		
		os.writeObject(sendDetails);
		
		try {
			socketConnection.close();
			os.close();
			is.close();
		} catch (IOException ioex) {
			logger.error("SERVER ERROR - " + ioex.getMessage() 
						+ "\nAT: " + ioex.getStackTrace());
		}
	}
	
	
	public void sendOnlineStudents() throws IOException{
		ArrayList<Object> onlineStudents = new ArrayList<>();
		
		for(int userCount = 0; userCount < server.getClients().size(); userCount++ )
			if(!server.getClients().get(userCount).account.equals(null))
				if(!server.getClients().get(userCount).account.equals(account))
					if(server.getClients().get(userCount).account.getType() == "STUDENT")
						onlineStudents.add(server.getClients().get(userCount));		

		os.writeObject(onlineStudents);
		
	}
	
	public void handleLogin(User userAuth) 
			throws ClassNotFoundException, IOException{
		boolean success = false;
		logger.info("Handling login information.");
		success = LoginAuthentication.authLoginUser(userAuth);
		os.writeObject(success);
		
		logger.info(success +" Access results sent to user.");
		if(success) {
			account = UserOperation.getUserInfo(userAuth.getID(), userAuth.getType());
		}
	}
	
	public void sendLoggedInBroadCast() throws IOException {
		for(ClientHandler client: server.getClients()) {
			if(!client.getAccount().getID().equals(account.getID()) && client.getAccount() != null) {
				os.writeObject("WHO-IS-LOGGED-ON");
				os.writeObject(client.getAccount());
			}
		}
	}
	
	
}
