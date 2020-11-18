package com.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class identification {
	
	static DateFormat issueFormat = new SimpleDateFormat("yyMMddhhmmss");
	private static String dateString = issueFormat.format(new Date()).toString();	
	private static String issueIdString;
	private static int serviceId = -1;
	
	public static String getIssueIdString() {
		issueIdString  = dateString;
		return issueIdString;
	}

}
