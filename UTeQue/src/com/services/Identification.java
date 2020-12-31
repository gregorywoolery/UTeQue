package com.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Identification {
	private static String generatedIssueID, generatedResponseID;
	
	public static String getIssueId() {
		DateFormat issueFormat = new SimpleDateFormat("yyMMddhhmmss");
		generatedIssueID = issueFormat.format(new Date()).toString();	
		return generatedIssueID;
	}
	
	public static String responseID() {
		DateFormat issueFormat = new SimpleDateFormat("ssmmddMMyy");
		generatedResponseID = issueFormat.format(new Date()).toString();	
		return generatedResponseID;
	}

}
