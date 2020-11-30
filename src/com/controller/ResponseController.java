package com.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Response;

public class ResponseController {
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	
	
	public static Response getResponseUsingIssue(String issueID){
		Response response = new Response();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
	
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("Receving List of STUDENT from SERVER");			
			
			os.writeObject("GET-RESPONSE");
			os.flush();
			os.writeObject(issueID);
			
			response = (Response) is.readObject();
			
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
		
		return response;
	}
	
	public static boolean postResponse(Response response) {
		boolean isPosted = false;
		try(Socket socketConnection = new Socket(InetAddress.getLocalHost(), 3309);
				ObjectOutputStream os = new ObjectOutputStream(socketConnection.getOutputStream());
				ObjectInputStream is = new ObjectInputStream(socketConnection.getInputStream());
		){
			
			logger.info("POSTING RESPONSE TO ISSUE");			
			
			os.writeObject("POST-RESPONSE");
			os.flush();
			os.writeObject(response);
			
			response = (Response) is.readObject();
			
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
		
		return isPosted;
	}

}
