package api_testing.config;

public class EnvironmentConfig {

    private static final String REQRES_API_KEY;

    static {
        REQRES_API_KEY = System.getenv("REQRES_API_KEY");

        if (REQRES_API_KEY == null || REQRES_API_KEY.isBlank()) {
            throw new RuntimeException("REQRES_API_KEY environment variable not found");
        }
    }

    public static String getReqresApiKey() {
        return REQRES_API_KEY;
    }
}
