package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRM {
	//this empid variable need to use other metode, because of that variable create on class level
	String empid;
	public static WebDriver driver;
	@Given("I open browser with url {string}")
	public void i_open_browser_with_url(String url) {
		
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);			
   }			
	
	
	
	@Then("I should see login page")
	public void i_should_see_login_page() {
		if(driver.findElement(By.id("btnLogin")).isDisplayed())
	    {
	    	System.out.println("System displayed Login Page");
	    }
		
	}
	@When("I enter user name as {string}")
	public void i_enter_user_name_as(String uname) {
		
		driver.findElement(By.id("txtUsername")).sendKeys(uname);
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String pword) {
		
		driver.findElement(By.id("txtPassword")).sendKeys(pword);
	}
	@When("I click login")
	public void i_click_login() {
		
		driver.findElement(By.id("btnLogin")).click();
	}
	@Then("I should see admin module or page")
	public void i_should_see_admin_module_or_page() {
		
		
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			System.out.println("System displayed Admin Module");
		}
	}
	@When("I click logout")
	public void i_click_logout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("Welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		
	}
	@When("I close browser")
	public void i_close_browser() {
		
		
		driver.close();
	}
	
	@Then("I should see error message")
	public void i_should_see_error_message() {
		
		String errmsg;
	    errmsg = driver.findElement(By.id("spanMessage")).getText().toLowerCase();
		//if error message contain invalid or error message contain empty
	    if(errmsg.contains("invalid") || errmsg.contains("empty"))
	    {
	    	System.out.println("System displayed appropriate error message");
	    }
	}
	
	
	@When("I go to add employee page")
	public void i_go_to_add_employee_page() {
		driver.findElement(By.linkText("PIM")).click();
	    driver.findElement(By.linkText("Add Employee")).click();
	}
	@When("I enter firstname as {string}")
	public void i_enter_firstname_as(String fname) {
		driver.findElement(By.id("firstName")).sendKeys(fname);
	}
	@When("I enter lastname as {string}")
	public void i_enter_lastname_as(String lname) {
		driver.findElement(By.id("lastName")).sendKeys(lname);
	}
	@When("I click save")
	public void i_click_save() {
		empid = driver.findElement(By.id("employeeId")).getAttribute("value");
		driver.findElement(By.id("btnSave")).click();
	}
	@Then("I should see registered employee in employee list")
	public void i_should_see_registered_employee_in_employee_list() {
		driver.findElement(By.linkText("Employee List")).click();
		driver.findElement(By.id("empsearch_id")).sendKeys(empid);
		driver.findElement(By.id("searchBtn")).click();
		
		WebElement emptable = driver.findElement(By.id("resultTable"));
		List<WebElement> rows = emptable.findElements(By.tagName("tr"));
		
		for(int i=1;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			if(cols.get(1).getText().equals(empid))
			{
				System.out.println("System displayed Registered Employee details in Employee List");
			}
		}
	}


}
