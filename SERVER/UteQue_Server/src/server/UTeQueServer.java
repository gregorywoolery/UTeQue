package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


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
				logger.info(" Server has started - " + serverStartDateTime );

				ClientHandler client = new ClientHandler(socketConnection);
				client.start();
				
				++totalConnectedClients;
				logger.info("USER THREADS: " + totalConnectedClients);
			}			
		} catch (IOException ioex) {
			logger.error(ioex.getMessage() 
					+ "\nAT: " + ioex.getStackTrace());		
		}
	}
}