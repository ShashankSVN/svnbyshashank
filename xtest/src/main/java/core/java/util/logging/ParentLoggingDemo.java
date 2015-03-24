package core.java.util.logging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

public class ParentLoggingDemo {

	public static void main(String[] args) {

		// if filter of child reject a message it will not proceed to parent
		// message forwarded to parent not involved in parent filter
		// message forwarding won't be possible without handler
		// Filter can be associated with Logger and handler.
		// formatter is associated with handler only

		Logger logger = Logger.getLogger("");
		System.out.println(logger.getParent());// parent of root logger is null
		Logger logger1 = Logger.getLogger("1");
		System.out.println(logger1.getParent());// parent of this is root logger
		Logger logger1_2 = Logger.getLogger("1.2");
		System.out.println(logger1_2.getParent());

		logger1.addHandler(new ConsoleHandler());
		logger1_2.addHandler(new ConsoleHandler());

		logger.info("msg:");
		logger1.info("msg: 1");
		logger1_2.info("msg: 1.2");

	}

}
