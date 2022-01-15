package com.example.dolgozodemo;

public final class ApiRoutes {
    private ApiRoutes(){}
    public static final String BASE_URL = "http://localhost:81";

    public static final String API_URL = BASE_URL+"/api";

    public static final class DolgozoRoutes {
        private DolgozoRoutes(){}

        public static final String GET_ALL = API_URL+"/dolgozo";
        public static final String GET_ONE = API_URL+"/dolgozo/%d";
        public static final String POST = API_URL+"/dolgozo";
        public static final String PUT = API_URL+"/dolgozo/%d";
        public static final String DELETE = API_URL+"/dolgozo/%d";
    }
}
