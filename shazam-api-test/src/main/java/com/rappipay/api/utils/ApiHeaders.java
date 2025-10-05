package com.rappipay.api.utils;

import java.util.Map;

public class ApiHeaders {

    public static Map<String, String> commonHeaders() {
        return Map.of(
                "Content-Type", "text/plain",
                "x-rapidapi-host", ApiConstants.RAPIDAPI_HOST,
                "x-rapidapi-key", ApiConstants.RAPIDAPI_KEY
        );
    }
}
