package server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UTeQueServer {
	private static final Logger logger = LogManager.getLogger(UTeQueServer.class);
	private static final int port = 3309;
    
	public static void main(String[] args) {
		logger.warn("Starting server...");
	    Server server = new Server(port);
	    server.start();
	}



	// case "GET-COUNT-RESOLVED-SERVICEID":
	// 	serviceID = (int) is.readObject();
	// 	os.writeObject(IssueOperation.getServiceResolvedCount(serviceID));
	// 	break;
	// case "GET-COUNT-UNRESOLVED-SERVICEID":
	// 	serviceID = (int) is.readObject();
	// 	os.writeObject(IssueOperation.getServiceUnresolvedCount(serviceID));
	// 	break;

}

