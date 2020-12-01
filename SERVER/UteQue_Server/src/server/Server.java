package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Server extends Thread{
	private static final Logger logger = LogManager.getLogger(Server.class);
	
	private final int serverPort;
	private ArrayList<ClientHandler> clients = new ArrayList<>();
	
	
	public Server(int serverPort) {
		this.serverPort = serverPort;
	}
	
	public List<ClientHandler> getClients(){
		return clients;
	}
	
	 @Override
	 public void run() {
		/**
		 * Creates a server socket that is bound to the port number 3306. 
		 * The maximum number of queued incoming connections is set to 60 
		 * (when the queue is full, new connections are refused).
		 */
		try (ServerSocket serverSocket = new ServerSocket(serverPort, 60)){

		    LocalDateTime startDateTime = LocalDateTime.now();
		    DateTimeFormatter startDateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String serverStartDateTime = startDateTime.format(startDateTimeFormat);
			
			Socket socketConnection = new Socket();
			
//			ExecutorService pool = Executors.newFixedThreadPool(20);
			
			logger.info("Server is listening on port " + serverPort);
			
			/**
			 * Listen for incoming client requests
			 */
			while(true) {
				socketConnection = serverSocket.accept();
				
				logger.info(" Server has started - " + serverStartDateTime );

				ClientHandler client = new ClientHandler(this, socketConnection);
				clients.add(client);
				client.start();
				
			}			
		} catch (IOException ioex) {
			logger.error(ioex.getMessage() 
					+ "\nAT: " + ioex.getStackTrace());		
		}
	 }
	 
	 public void removeClientHandler(ClientHandler client){
		 clients.remove(client);
	 }
}
