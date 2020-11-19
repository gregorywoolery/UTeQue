package com.controller;

import com.connection.DBConnectorFactory;
import com.view.UserLogin;
public class Driver {

	public static void main(String[] args) {
		DBConnectorFactory.getDatabaseConnection();
//		UserLogin login = new UserLogin();
	}

}
