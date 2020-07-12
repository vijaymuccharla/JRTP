package com.vj.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicLoggerTest {

	//get Logger Object using getLogger(-) static method.
	private static Logger logger = Logger.getLogger(BasicLoggerTest.class);

	/**
	 * Logger levels :
	 * 1. ALL
	 * 2. DEBUG
	 * 3. INFO
	 * 4. WARN
	 * 5. ERROR
	 * 6. FATAL
	 * 7. OFF
	 * 8. TRACE
	 * Priority : ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF
	 * @param args
	 */
	public static void main(String[] args) {

		//use BasicConfigurator for basic Configuration. (Usually it is not used)
		BasicConfigurator.configure();

		//log messages using deifferent Logger levels
		logger.trace("This is a TRACE log message");
		logger.debug("This is a DEBUG log message");
		logger.info("This is a INFO log message");
		logger.warn("This is a WARN log message");
		logger.error("This is a ERROR log message");
		logger.fatal("This is a FATAL log message");
		
		
	}

}
