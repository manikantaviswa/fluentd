package fluent.logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.fluentd.logger.FluentLogger;

public class FluentLoggerClient {
	private static final FluentLogger LOGD = FluentLogger.getLogger("debug");
	private static final FluentLogger LOGI = FluentLogger.getLogger("info");
	private static final FluentLogger LOGW = FluentLogger.getLogger("warn");

	private static FluentLoggerClient instance;
	private static Properties prop;
	
	private FluentLoggerClient() {
		loadProps();
	}
	
	public static FluentLoggerClient getInstance() {
		if (instance == null) {
			instance = new FluentLoggerClient();
		}
		return instance;
	}
	
	private void loadProps() {
        InputStream is = null;
        try {
            prop = new Properties();
            is = getClass().getClassLoader().getResourceAsStream("fluent.properties");
            prop.load(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public Boolean debug(String label, Map<String, Object> data) {
		if (isEnabled("debug")) {
			return LOGD.log(label, data);
		} else {
			return false;
		}
	}
	
	public Boolean info(String label, Map<String, Object> data) {
		if (isEnabled("info")) {
			return LOGI.log(label, data);
		} else {
			return false;
		}
	}

	public Boolean warn(String label, Map<String, Object> data) {
		if (isEnabled("warn")) {
			return LOGW.log(label, data);
		} else {
			return false;
		}
	}
	
	private boolean isEnabled(String level) {
		return prop.getProperty("log.level").equals(level);
	}
}
