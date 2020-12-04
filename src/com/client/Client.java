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
			
			return true;
			
		} catch (IOException e) {
			disconnect();
			logger.error("ERROR establishing I/O Connection. - " + e.getMessage()
					+ "AT- " + e.getStackTrace());
		}
		
		return false;		
	}
	
	public Object doOperation(ArrayList<Object> operand) {
		Object result = null;		
		String testMsg;
		
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
			serverOut.writeObject("DISCONNECT");
			
			serverOut.close();
			serverIn.close();
			socketConnection.close();
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