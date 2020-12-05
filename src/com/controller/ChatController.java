package com.controller;

import java.util.ArrayList;

import com.model.User;
import com.view.UserLogin;
import com.view.student.LiveChatLobby;

public class ChatController {
	
	public static boolean sendNotificationToStudent(String staffID, String studentID, String msg) {
		boolean sendSuccess = false;
		ArrayList<Object> sendDetails = new ArrayList<>();

		sendDetails.add("NOTIFY-ONILINE");
		sendDetails.add(staffID);
		sendDetails.add(studentID);
		sendDetails.add(msg);
		
		UserLogin.client.doOperation(sendDetails);
		
		return sendSuccess;
		
	}
	
	public static void sendOnlineNotification(User staff) {
		LiveChatLobby.updateAvailableTable(staff);
	}
}
