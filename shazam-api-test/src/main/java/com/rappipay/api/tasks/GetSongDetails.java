package com.rappipay.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import com.rappipay.api.utils.ApiConstants;

public class GetSongDetails implements Task {

    private final String songId;

    public GetSongDetails(String songId) {
        this.songId = songId;
    }

    public static GetSongDetails withId(String songId) {
        return instrumented(GetSongDetails.class, songId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ApiConstants.ENDPOINT_GET_SONG_DETAILS + "?id=" + songId + "&l=en-US")
                        .with(request -> request
                                .header("x-rapidapi-host", ApiConstants.RAPIDAPI_HOST)
                                .header("x-rapidapi-key", ApiConstants.RAPIDAPI_KEY)
                        )
        );
    }
}