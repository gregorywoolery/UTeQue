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
}