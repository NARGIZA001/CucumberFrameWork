package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report","pretty","json:target/cucumber.json"},
        features = "src/test/resources/uiFeatures", //okay got the path now i need the code
        glue = "stepDefs", //providing the code place where
        dryRun=false,
        tags ={"@ui", "@smokeTest"}
)
public class uiTestRunner {

}
