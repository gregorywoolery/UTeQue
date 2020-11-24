package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;

/**
 * import org.apache.logging.log4j.LogManager;
 * import org.apache.logging.log4j.Logger;
 */


public class UTeQueServer {
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
			
			System.out.println("Server is listening on port " + port);
			/**
			 * Listen for incoming client requests
			 */
			while(true) {
				socketConnection = serverSocket.accept();
				System.out.println(serverStartDateTime + " Server has started");
				
				new ClientHandler(socketConnection).run();
				System.out.println("USER THREADS: " + totalConnectedClients);
				++totalConnectedClients;
				
			}			
		} catch (IOException ioex) {
			
			System.out.println(ioex.getMessage() 
					+ "\nAT: " + ioex.getStackTrace());		
		}


	}
	
	public static class ClientHandler implements Runnable{
		Socket socketConnection = null;
		
		public ClientHandler(Socket socket) {
			socketConnection = socket;
		}
		
		@Override
		public void run() {
			try(
					DataOutputStream os = new DataOutputStream(socketConnection.getOutputStream());
					DataInputStream is = new DataInputStream(socketConnection.getInputStream())
			){
				while(!socketConnection.isClosed()) {
					Double radius, area;
					radius = is.readDouble();
					
					area = 3.17 * (radius * radius);
					

					
					os.writeDouble(area);
					
					socketConnection.close();
										
					System.out.println("\nRadius: " + radius);
					System.out.println("Area  : " + area);
				}
			}catch(IOException ioex){
				System.out.println("SERVER ERROR - " + ioex.getMessage() 
						+ "\nAT: " + ioex.getStackTrace());
			}	
		}
	}
}