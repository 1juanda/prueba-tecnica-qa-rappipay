package com.rappipay.api.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import com.rappipay.api.utils.ApiConstants;

public class Hooks {

    public static Actor user;

    @Before
    public void setUp() {
        user = Actor.named("JUAN");
        user.can(CallAnApi.at(ApiConstants.BASE_URL));
    }
}
