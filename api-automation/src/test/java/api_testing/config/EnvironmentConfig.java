package api_testing.config;

import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentConfig {

    private static final Properties properties = new Properties();

    static {
        try {
            String filePath =
                "src/test/java/api_testing/config/config.properties";  //You won't find the config.properties file as it contains the API key, which is sensitive dat,a and you have to create your own 

            FileInputStream fis = new FileInputStream(filePath);
            properties.load(fis);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getReqresApiKey() {
        return properties.getProperty("reqres.api.key");
    }

    public static String getBaseUri() {
        return properties.getProperty("base.uri");
    }
}
