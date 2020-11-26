package server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Issue;
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
	
	public static class ClientHandler implements Runnable{
		Socket socketConnection = null;
		String operation = "", studentID = "";
		boolean success = false;
		int[] stats = new int[3];
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
							System.out.println("Before read STATS");
							studentID = (String) is.readObject();
							System.out.println("AfterRead " + studentID);
							
							stats = IssueOperation.getUserIssueStats(studentID);
							System.out.println("ONE" + stats[0] + " " + stats[1] + " "+ stats[2]);
							os.writeObject(stats);
							break;
							
						case "GET-STUDENT-ISSUES":
							System.out.println("Before READ ALL");
							studentID = (String) is.readObject();
							System.out.println("AfterRead\n" + studentID);
							os.writeObject(IssueOperation.getAllIssuesForStudent(studentID));
							break;
							
						case "GET-ALL-SERVICES":
							os.writeObject(ServiceOperation.getAllServices());
							break;	
							
						case "GET-CURRENT-USER":
							user = (User) is.readObject();
							os.writeObject(UserOperation.getUserInfo(user.getID(), user.getType()));
							break;
						case "GET-ISSUE-RESPONSE-JOIN":
							studentID = (String) is.readObject();
//							os.writeObject(obj);
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