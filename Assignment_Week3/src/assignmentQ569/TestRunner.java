package assignmentQ569;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\assignmentQ569\\Feature1.feature",
		glue={"assignmentQ569","StepDefinition.java"},
		format={"pretty","html:target/cucumber"},
		tags={"@Smoke, @Others"}
		)
public class TestRunner {
	
	

}
