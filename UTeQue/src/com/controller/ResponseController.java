package com.controller;


import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.model.Response;
import com.view.UserLogin;


public class ResponseController {
	private static final Logger logger = LogManager.getLogger(IssueController.class);
	
	
	public static Response getResponseUsingIssue(String issueID){
		ArrayList<Object> sendDetails = new ArrayList<>();
		Response response = new Response();
		
		logger.info("Client Trying to connect using socket at port " + 3309);
		logger.info("Receving List of STUDENT from SERVER");					
		
		String cmd = "GET-RESPONSE";
		
		sendDetails.add(cmd);
		sendDetails.add(issueID);
			
		response = (Response) UserLogin.client.doOperation(sendDetails);

		return response;
	}
	
	public static boolean postResponse(Response response) {
		ArrayList<Object> sendDetails = new ArrayList<>();
		boolean isPosted = false;
		
		logger.info("POSTING RESPONSE TO ISSUE");			
			
		String cmd = "POST-RESPONSE";
		
		sendDetails.add(cmd);
		sendDetails.add(response);
					
		isPosted = (boolean) UserLogin.client.doOperation(sendDetails);
		
		return isPosted;
	}


	public static boolean updateComment(String issueID, String comment) {		
		ArrayList<Object> sendDetails = new ArrayList<>();

		boolean isPosted = false;
		logger.info("UPDATING COMMENT TO RESPONSE");			
			
		String cmd = "UPDATE-RESPONSE-COMMENT";
		
		sendDetails.add(cmd);
		sendDetails.add(issueID);
		sendDetails.add(comment);
			
		isPosted = (boolean) UserLogin.client.doOperation(sendDetails);

		return isPosted;
	}
}
