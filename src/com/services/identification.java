package com.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Identification {
	static DateFormat issueFormat = new SimpleDateFormat("yyMMddhhmmss");
	private static String dateString ;

	private static String generatedIssueID;
	private static int serviceId = -1;
	
	public static String getIssueId() {
	    dateString = issueFormat.format(new Date()).toString();
		generatedIssueID  = dateString;
		return generatedIssueID;
	}

}
