package com.training;

import org.apache.log4j.Logger;

public class Application {

	public static void main(String[] args) {

		// Logger log = Logger.getRootLogger();
		// Logger log = Logger.getLogger("example");
		Logger log = Logger.getLogger("second");

		// String mark = "fiftyFive";
		String mark = "55";

		try {

			double marksScored = Double.parseDouble(mark);
			log.info(marksScored);

		} catch (Exception e) {
			log.error("Invalid Number Format " + e.getMessage());
		}

	}

}
