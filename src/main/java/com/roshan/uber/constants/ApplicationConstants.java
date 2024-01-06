package com.roshan.uber.constants;

public class ApplicationConstants {
    public static final String ADD = "add";
    public static final String LIST = "list";
    public static final String RIDER = "rider";
    public static final String DRIVER = "driver";
    public static final String TRIP = "trip";
    public static final String LOGIN = "login";
    public static final String AUTHENTICATE= "authenticate";

    public static final String[] ENDPOINTS_WHITELIST = {
            "/login/authenticate",
            "/swagger-ui/**"
    };
}
