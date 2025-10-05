package com.rappipay.api.stepdefinitions;

import com.rappipay.api.questions.HttpStatus;
import com.rappipay.api.questions.JsonStringValue;
import com.rappipay.api.tasks.PostDetectSong;
import io.cucumber.java.en.*;
import com.rappipay.api.tasks.GetSongDetails;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SongStepDefinitions {

    @Given("que el usuario quiere obtener detalles de una canción")
    public void que_el_usuario_quiere_obtener_detalles_de_una_cancion() {
    }

    @When("consulta la canción con el id {string}")
    public void consulta_la_cancion_con_el_id(String id) {
        Hooks.user.attemptsTo(
                GetSongDetails.withId(id)
        );
    }

    @When("el usuario detecta la canción usando el archivo {string}")
    public void detecta_la_cancion_usando_el_archivo(String audioPath) {
        Hooks.user.attemptsTo(
                PostDetectSong.usingFile(audioPath)
        );
    }


    @Then("la respuesta debe ser exitosa {int}")
    public void la_respuesta_debe_tener_codigo(int expectedStatusCode) {
        boolean isStatusOk =  Hooks.user.asksFor(HttpStatus.isStatusCode(expectedStatusCode));
        assertThat("El código de estado no coincide", isStatusOk, is(true));
    }

    @And("el valor de {string} debe ser {string}")
    public void el_nombre_del_artista_debe_ser(String jsonPath, String expectedValue) {
        boolean result = Hooks.user.asksFor(JsonStringValue.isEqualTo(jsonPath, expectedValue));
        assertThat("El valor en la respuesta no coincide", result, is(true));
    }
}