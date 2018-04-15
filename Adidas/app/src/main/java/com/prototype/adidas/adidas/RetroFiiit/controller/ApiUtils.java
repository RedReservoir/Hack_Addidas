package com.prototype.adidas.adidas.RetroFiiit.controller;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://206.189.23.162/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
