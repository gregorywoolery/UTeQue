package com.controller;

import java.util.ArrayList;

import com.client.Client;
import com.model.Service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ServiceController {
	private static final Logger logger = LogManager.getLogger(ServiceController.class);
	private static final int port = 3309;

	@SuppressWarnings("unchecked")
	public static ArrayList<String> getAllServies(Client client) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		ArrayList<Service> services = new ArrayList<Service>();
		ArrayList<String> serviceTypes = new ArrayList<String>();
		
		logger.info("Client Trying to connect using socket at port " + port);
			
		logger.info("Receving List of SERVICES from SERVER");			
			

		String cmd = "GET-ALL-SERVICES";
		
		sendDetails.add(cmd);
		
		services = (ArrayList<Service>) client.doOperation(sendDetails);
		
		if(services != null)
			for(Service service: services)
				serviceTypes.add(service.getType());
		
		return serviceTypes;
	} 
}
