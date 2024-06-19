package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(
	//features = "featurefiles/employtestngfeature.feature" means configure the future file we want to execute	
	features = "featurefiles/employtestngfeature.feature",	
	//glue = "stepdefinitions" means PackageName where the code is present(specify the code location)
	glue = "stepdefinitions",
	//dryRun = true means verifying the 2, features (steps scan the steps present in the future file) and glue (verify the code available in the appropriate location or not). If anything is missing, thease are the functions missing like that automatically displayed as a undefined exception
	// or
	//dryRun = true means use to understand the find out the undefined(missing) steps.
	dryRun = false,
	//html:TestReports means html reports save in this folder
	plugin = {"pretty","html:TestReports/empreg_result.html"}
)

public class EmployeeRegistrationTest extends AbstractTestNGCucumberTests {

}
