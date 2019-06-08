package fluent.logger;

import java.util.HashMap;
import java.util.Map;

public class SampleLogger {
	private static FluentLoggerClient logger = FluentLoggerClient.getInstance();

	public static void main(String args[]) {
		Map<String, Object> data = new HashMap<>();
		logger.debug("test debug 1", data);
		
		logger.info("test info 2", data);
		
		logger.warn("test warn 3", data);
	}
}
