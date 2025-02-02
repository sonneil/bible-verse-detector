package com.bibledetector.steps.bibleflow.impl.actions.config;

// TODO: Delete this class and inject configuration
public class GoLiveOpenLPConfig {
    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String BASE_URL = "http://localhost:4316/api/v2/";
    public static final String AUTHORIZATION_PATH = "core/login";
    public static final String LIVE_PATH = "plugins/bibles/live";
    public static final String ADD_TO_SERVICE_PATH = "plugins/bibles/add";
    public static final String OPENLP_USERNAME = "ciudadluz";
    public static final String OPENLP_PASSWORD = "ciudadluzremote";

    // CONFIRMATION
    public static final Boolean EXPECT_CONFIRMATION = true;
    public static final long CONFIRMATION_WINDOW_TIMEOUT_SECONDS = 30;
}
