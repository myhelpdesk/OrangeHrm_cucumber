package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//Execute AdminLoginTest java class as a "Cucumber.class" using a (with the help of)  junit(@RunWith)
//@RunWith(Cucumber.class)
//this annotation configure the future file path

//glue = "stepdefinitions" means PackageName where the code is present(specify the code location)

//features = "featurefiles/adminlogin.feature" means configure the future file we want to execute

//dryRun = true means verifying the 2, features (steps scan the steps present in the future file) and glue (verify the code available in the appropriate location or not). If anything is missing, thease are the functions missing automatically displayed as a undefined exception 

//html:TestReports means html reports save in this folder

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles/adminlogin.feature",glue = "stepdefinitions",
dryRun =false,plugin = {"pretty","html:TestReports/loginresult.html"}
//if you want to use to specified tagnames("@tag1,@tag2")  will give like this
)
public class AdminLoginTest {
	

}
