package com.controller;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class);
	private static final int port = 3309;
	
	
	public static boolean authenticate(String username, char[] password, String userType) {

		boolean authenticateSuccess = false;
		userType = userType.toUpperCase();
		
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Trying to AUTHENTICATE USER ON SYSTEM");		
			
			os.writeObject("AUTHENTICATE");
			System.out.println("In Authenticate");
			os.writeObject(new User(username, password, userType));

			authenticateSuccess = is.readBoolean();		
			System.out.println(authenticateSuccess);			
		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		}catch(InvalidClassException icex) {
			logger.error("ERROR - CLASS IS INVALID - " + icex.getMessage()
							+ icex.getStackTrace());			
		}catch(NotSerializableException nsex) {
			logger.error("ERROR - CLASS IS INVALID - " + nsex.getMessage()
							+ nsex.getStackTrace());
		}
		catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		return authenticateSuccess;
	}
	
}
