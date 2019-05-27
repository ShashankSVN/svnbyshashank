package core.java.util.logging;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FilterLoggingDemo {
	static Logger logger=Logger.getLogger(FilterLoggingDemo.class.getName());

	static public void init(){
		Filter filter=new Filter() {
			@Override
			public boolean isLoggable(LogRecord record) {
				return true;
			}
		};
		logger.setFilter(filter);
		logger.entering("Looging", "Entering..");
		logger.log(Level.FINE,"Fine captured");//default Console handler ignore this to log
		logger.log(Level.INFO,"info captured");
		try{
			throw new Exception();
		}catch(Exception e)
		{
			logger.log(Level.SEVERE,"Something bad happen",e);
		}
		logger.exiting("Logging", "Exiting..");
	}

	public static void main(String[] args) {
		
		FilterLoggingDemo.init();

	}
}
