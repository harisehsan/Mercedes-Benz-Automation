package runConfig;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/** This is the test class is used to run the test by providing the tag name of cucumber scenario. it is also used to execute the test
 * NOTE: As per framework design, This class can only contains the hardcoded data items. it cannot be avoided **/

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/GherkinFiles", /** path of the featutre file **/
		tags="@mercedesAutomation", /** cucumber tage name to run the test**/
		glue = {"stepdefinitions"}, /** link the cucumber feature file with the step definition **/
		plugin = { /** plugins required by cucumber**/
				"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/json-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun-reports/rerun.txt"
		}

)
public class RunTest {

}
