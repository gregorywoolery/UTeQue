package com.connectionFactories.JDBC;

import com.model.Service;
import com.services.ServiceOperation;

public class InitialVauesOperation {
	
	public static void insertServices() {
		ServiceOperation.insertService(new Service("Login Issues"));
		ServiceOperation.insertService(new Service("Accounting Enquiry"));
		ServiceOperation.insertService(new Service("Online Platform Issues"));
		ServiceOperation.insertService(new Service("Module Selection"));
		ServiceOperation.insertService(new Service("Enrolment Issues"));
		ServiceOperation.insertService(new Service("Transfer of Credits"));
		ServiceOperation.insertService(new Service("Graduation"));
		ServiceOperation.insertService(new Service("Other"));
	}
}
