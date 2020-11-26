package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.model.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServiceController {
	private static final Logger logger = LogManager.getLogger(ServiceController.class);
	private static final int port = 3309;

	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllServies() {
		ArrayList<Service> services = new ArrayList<Service>();
		ArrayList<String> serviceTypes = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + port);
		
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), port);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receving List of SERVICES from SERVER");			
			
			os.writeObject("GET-ALL-SERVICES");
			
			services = (ArrayList<Service>) is.readObject();

		} catch (UnknownHostException e) {
			logger.error("IP ADDRESS OF HOST ERROR - " + e.getMessage()
							+ e.getStackTrace());
			
		} catch (ClassNotFoundException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
			+ e.getStackTrace());			
		} catch (IOException e) {
			logger.error("ERROR OCCURED - " + e.getMessage()
							+ e.getStackTrace());
		}
		
		if(services != null)
			for(Service service: services)
				serviceTypes.add(service.getType());
		
		return serviceTypes;
	} 
}
