package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RollOver {

	final static Logger logger = LogManager.getLogger(RollOver.class);

	public static void main(String[] args) {
		run("test");
	}

	private static void run(String string) {
		String parameter;

		for (int i = 0; i < 10000; i++) {
			parameter = string + i;
			System.out.println("log iteration : " + i);
			if (logger.isDebugEnabled()) {
				for (int x = 0; x < 1000; x++) {
					logger.debug("Debug : {}", parameter);
				}
			}
			if (logger.isInfoEnabled()) {
				for (int x = 0; x < 1000; x++) {
					logger.debug("Info : {}", parameter);
				}
			}
			logger.warn("This is warn : {}", parameter);
			logger.error("This is error : {}", parameter);
			logger.fatal("This is fatal : {}", parameter);

			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
