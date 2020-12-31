package com.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Message;


public class Client {
	private static final Logger logger = LogManager.getLogger(Client.class);
	
	private final int serverPort = 3309;
	private InetAddress hostName;
	private Socket socketConnection;
	private ObjectOutputStream serverOut;
	private ObjectInputStream serverIn;
	
	public Client(InetAddress hostName) {
		this.hostName = hostName;
	}
	
	public boolean startConnection() {
		try {
			this.socketConnection = new Socket(hostName, serverPort);
			this.serverOut = new ObjectOutputStream(socketConnection.getOutputStream());
			this.serverIn = new ObjectInputStream(socketConnection.getInputStream());
			
			logger.info("Sockect Connection, Input, Output Steams created");
			return true;
			
		} catch (IOException e) {
			disconnect();
			logger.error("ERROR establishing I/O Connection. - " + e.getMessage()
					+ "AT- " + e.getStackTrace());
		}
		
		logger.error("Socket Connection, Input, Output Steams not created");		
		return false;		
	}
	
	public Object doOperation(ArrayList<Object> operand) {
		Object result = null;		
		
		try {
			serverOut.writeObject(operand);
			
			result = serverIn.readObject();	
			
		}catch(IOException ioex) {
			logger.error("ERROR establishing I/O Connection. - " + ioex.getMessage()
					+ "AT- " + ioex.getStackTrace());			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR - " + e.getMessage()
					+ "AT- " + e.getStackTrace());
		}
		
		return result;
		
	}
	
	public void disconnect() {
		try {
			ArrayList<Object> sendDetails = new ArrayList<>();
			sendDetails.add("DISCONNECT");
			
			serverOut.writeObject(sendDetails);
			
			serverOut.close();
			serverIn.close();
			socketConnection.close();
			
			//logger.error("Sockect Connection, Input, Output Steams Closed");
			
		} catch (IOException e) {
			logger.error("ERROR - " + e.getMessage()
					+ "AT- " + e.getStackTrace());
		}
		
	}
	
	public void sendNotification(Message message) {
		try {
			serverOut.writeObject(message);
			
		} catch (IOException e) {
			logger.error("ERROR - " + e.getMessage()
					+ "AT- " + e.getStackTrace());
		}
	}
	
}