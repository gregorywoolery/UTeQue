package com.controller;

import com.model.Message;
import com.view.UserLogin;

public class ChatController {
	
	public static boolean sendNotificationToStudent(String staffID, String studentID, String msg) {
		boolean sendSuccess = false;

		UserLogin.client.sendNotification(new Message(staffID, studentID, msg));
		return sendSuccess;
		
	}
}
