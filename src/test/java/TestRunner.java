
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/technicaltest/factorial5/test"},
        plugin = {"pretty",
                "json:target/cucumber-report/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"}
)
public class TestRunner {
}

