package fluent.logger;

import java.util.HashMap;
import java.util.Map;

import org.fluentd.logger.FluentLogger;

public class FluentLoggerTest {
	private static final FluentLogger LOG = FluentLogger.getLogger("debug");
	
	public static void main(String[] args) {
		Map<String, Object> data = new HashMap<>();
		
		data.put("key1", "val1");
		data.put("key2", "val2");
		data.put("key3", "val3");
		
		LOG.log("My data", data);
	}

}
