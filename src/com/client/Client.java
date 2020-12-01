package com.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Client {
	private static final Logger logger = LogManager.getLogger(Client.class);
	
	private final int serverPort = 3309;
	private InetAddress hostName;
	private Socket socketConnection;
	private ObjectOutputStream os;
	private ObjectInputStream is;
	
	public Client(InetAddress hostName) {
		this.hostName = hostName;
	}
	
	private void connect() {
		try {
			socketConnection = new Socket(hostName, serverPort);
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
}
