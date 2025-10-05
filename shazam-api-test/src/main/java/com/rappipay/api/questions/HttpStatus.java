package com.rappipay.api.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import io.restassured.response.Response;

public class HttpStatus {

    public static Question<Boolean> isStatusCode(int expectedStatusCode) {

        return actor -> {
            Response response = LastResponse.received().answeredBy(actor);
            int actualStatusCode = response.getStatusCode();
            return actualStatusCode == expectedStatusCode;
        };
    }
}
