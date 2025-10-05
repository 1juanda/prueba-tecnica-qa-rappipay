package com.rappipay.api.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;
import com.jayway.jsonpath.JsonPath;

public class JsonStringValue implements Question<Boolean> {

    private final String jsonPath;
    private final String expectedValue;

    public JsonStringValue(String jsonPath, String expectedValue) {
        this.jsonPath = jsonPath;
        this.expectedValue = expectedValue;
    }

    public static JsonStringValue isEqualTo(String jsonPath, String expectedValue) {
        return new JsonStringValue(jsonPath, expectedValue);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String actualValue = JsonPath.read(SerenityRest.lastResponse().getBody().asString(), jsonPath);
        return expectedValue.equals(actualValue);
    }
}
