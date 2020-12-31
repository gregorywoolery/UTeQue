package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.client.Client;
import com.view.UserLogin;

public class UserDriver {
	private static final Logger logger = LogManager.getLogger(UserDriver.class);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			Client client = new Client(InetAddress.getLocalHost());
			logger.info("Connection established successfully");
				
			
			UserLogin userlogin = new UserLogin(client);			
					
		} catch (UnknownHostException e) {
			logger.error("HOST IP ERROR DETECTED. " + e.getMessage() 
			+ " AT-" + e.getStackTrace());
		}
	}
}
