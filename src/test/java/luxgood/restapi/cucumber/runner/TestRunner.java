package luxgood.restapi.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/luxgood/restapi/cucumber/feature/",
    glue = {"luxgood.restapi.cucumber.glue"},
    plugin = {"pretty"}, 
    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}

//poczytac damian szczepanik a propos raportow