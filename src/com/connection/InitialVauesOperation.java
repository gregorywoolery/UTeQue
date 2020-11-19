package com.connection;

import com.model.Service;
import com.services.UTeQueDBOperations;

public class InitialVauesOperation {
	
	public static void insertServices() {
		UTeQueDBOperations.insertService(new Service("Login Issues"));
		UTeQueDBOperations.insertService(new Service("Accounting Enquiry"));
		UTeQueDBOperations.insertService(new Service("Online Platform Issues"));
		UTeQueDBOperations.insertService(new Service("Module Selection"));
		UTeQueDBOperations.insertService(new Service("Enrolment Issues"));
		UTeQueDBOperations.insertService(new Service("Transfer of Credits"));
		UTeQueDBOperations.insertService(new Service("Graduation"));
		UTeQueDBOperations.insertService(new Service("Other"));
	}
}
