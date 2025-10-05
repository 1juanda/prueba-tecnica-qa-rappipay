package com.rappipay.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.rappipay.api.stepdefinitions",
        tags = "@@songFromAudio",
        plugin = {"json:target/destination/cucumber.json", "rerun:target/destination/failedrerun.txt",
        "html:target/destination/cucumber.html", "timeline:target/test-results/timeline"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
