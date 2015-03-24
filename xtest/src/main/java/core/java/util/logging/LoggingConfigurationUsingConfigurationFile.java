package core.java.util.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingConfigurationUsingConfigurationFile {
	static Logger logger = Logger
			.getLogger(LoggingConfigurationUsingConfigurationFile.class
					.getName());

	// Set VM argument 
	//-Djava.util.logging.config.file
	//Set path to SelfLogging.properties
			
	static public void init() {

		// these are not system level properties.
		// System.setProperty("java.util.logging.ConsoleHandler.level", "FINE");
		// for default logging.properties JVM not used below properties
		// this property is for user provided logging properties
		// System.out.println(System.getProperty("java.util.logging.config.file"));

		logger.entering("Looging", "Entering..");
		logger.log(Level.FINE, "Fine captured");
		logger.log(Level.INFO, "info captured");
		logger.log(Level.SEVERE, "Something bad happen");
		logger.exiting("Logging", "Exiting..");
	}

	public static void main(String[] args) {

		LoggingExamples.init();

	}

}
