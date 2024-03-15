package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="", features = {"src/test/java/Features"},
			glue={"stepDefinitions"},
			plugin= {"pretty","html:target/htmlreport.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
