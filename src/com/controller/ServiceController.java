package com.controller;

import java.util.ArrayList;

import com.model.Service;
import com.view.UserLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServiceController {
	private static final Logger logger = LogManager.getLogger(ServiceController.class);
	private static final int port = 3309;

	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllServies() {
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<Service> services = new ArrayList<Service>();
		ArrayList<String> serviceTypes = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Receving List of SERVICES from SERVER");			
			

		String cmd = "GET-ALL-SERVICES";
		
		sendDetails.add(cmd);
		
		services = (ArrayList<Service>) UserLogin.client.doOperation(sendDetails);
		
		if(services != null)
			for(Service service: services)
				serviceTypes.add(service.getType());
		
		return serviceTypes;
	}

	public static int[] getServiceUnresolvedCount() {
		ArrayList<Object> sendDetails = new ArrayList<>();
		int [ ] solvedCount = new int [8];
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receiving COUNT for ServiceID from SERVER");			
			
		sendDetails.add("GET-COUNT-UNRESOLVED-SERVICEID");
			
		solvedCount = (int [ ] ) UserLogin.client.doOperation(sendDetails);
		
		logger.info("COUNT for ServiceID Recieved from SERVER");	
		
		return solvedCount;
	}

	public static int[] getServiceResolvedCount() {
		ArrayList<Object> sendDetails = new ArrayList<>();
		int [ ] resolvedCount = new int [8];
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receiving COUNT for ServiceID from SERVER");			
	
		sendDetails.add("GET-COUNT-RESOLVED-SERVICEID");
			
		resolvedCount = (int [ ] ) UserLogin.client.doOperation(sendDetails);
		
		logger.info("COUNT for ServiceID from Received SERVER");
		
		return resolvedCount;
	} 
}
