package core.java.util.logging;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggingExamples {

	static Logger logger = Logger.getLogger(LoggingExamples.class.getName());

	static public void init() {
		// handler use formatter
		Formatter formatter = new Formatter() {

			@Override
			public String format(LogRecord record) {
				return null;
			}
		};
		Handler[] handler = logger.getHandlers();
		System.out.println(logger.getHandlers());
		if (handler.length != 0) {
			handler[0].setFormatter(formatter);
		}
		// these are not system level properties.
		//"C:\Users\shashank.aggarwal\Desktop\newLogging.properties"
		// System.setProperty("java.util.logging.ConsoleHandler.level", "FINE");
		//for default logging.properties JVM not used below properties 
		//this property is for user provided logging properties
		System.out.println(System.getProperty("java.util.logging.config.file"));

		logger.entering("Looging", "Entering..");
		logger.log(Level.FINE, "Fine captured");
		logger.log(Level.INFO, "info captured");
		try {
			throw new Exception();
		} catch (Exception e) {
			// logger.log(Level.SEVERE,"Something bad happen",e);
		}
		logger.exiting("Logging", "Exiting..");
	}

	public static void main(String[] args) {

		LoggingExamples.init();

	}

}
