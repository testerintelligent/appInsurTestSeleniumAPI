package runner;


import io.cucumber.junit.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefenition",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)

public class TestRunner {
}
