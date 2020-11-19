package com.controller;

import java.util.ArrayList;

import com.model.Service;
import com.services.UTeQueDBOperations;

public class ServiceController {
	public static ArrayList<String> getAllServies() {
		ArrayList<Service> services = UTeQueDBOperations.getAllServices();
		ArrayList<String> serviceTypes = new ArrayList<String>();
		
		for(Service service: services) {
			serviceTypes.add(service.getType());
		}
		
		return serviceTypes;
		
	} 
}
