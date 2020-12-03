package com.controller;

import java.util.ArrayList;

import com.model.Response;
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

	public static int getServiceUnresolvedCount(int serviceID) {
		int count =0;
		
		logger.info("Client Trying to connect using socket at port " + 3309);
	
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receiving COUNT for ServiceID from SERVER");			
			
			os.writeObject("GET-COUNT-UNRESOLVED-SERVICEID");
			os.flush();
			os.writeObject(serviceID);
			
			count = (int) is.readObject();
			
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
		
		return count;
	}

	public static int getServiceResolvedCount(int serviceID) {
		int count =0;
		
		logger.info("Client Trying to connect using socket at port " + 3309);
	
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receiving COUNT for ServiceID from SERVER");			
			
			os.writeObject("GET-COUNT-RESOLVED-SERVICEID");
			os.flush();
			os.writeObject(serviceID);
			
			count = (int) is.readObject();
			
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
		
		return count;
	} 
}
