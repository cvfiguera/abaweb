package cl.aba.business.util;

import org.apache.log4j.Logger;

public class WebBusiness {
	
	protected Logger log = Logger.getLogger(getClass().getName());
	
	final protected void error(String message) {
		log.error(message);
	}

	final protected void error(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void debug(String message) {
		log.error(message);
	}

	final protected void debug(String message, Throwable t) {
		log.error(message, t);
	}

	final protected void info(String message) {
		log.info(message);
	}

}
