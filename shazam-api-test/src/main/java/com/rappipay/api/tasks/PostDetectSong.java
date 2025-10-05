package com.rappipay.api.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import com.rappipay.api.utils.ApiConstants;
import com.rappipay.api.utils.ApiHeaders;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostDetectSong implements Task {

    private final String audioFilePath;

    public PostDetectSong(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    public static PostDetectSong usingFile(String audioFilePath) {
        return instrumented(PostDetectSong.class, audioFilePath);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        byte[] audioBytes;
        try {
            audioBytes = Files.readAllBytes(Paths.get(audioFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading audio file: " + audioFilePath, e);
        }

        Map<String, String> headers = ApiHeaders.commonHeaders();

        actor.attemptsTo(
                Post.to(ApiConstants.ENDPOINT_DETECT_SONG)
                        .with(request -> {
                            headers.forEach(request::header);
                            return request.body(audioBytes);
                        })
        );
    }
}
