package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.PaintsUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Paints {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public Paints() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("Launch the chrome browser {string}")
	public void launch_the_chrome_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-4");
	    log.info("Browser launched successfully");
	}

	@When("Click on New Builder project")
	public void click_on_new_builder_project() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(PaintsUi.click).click();
	    log.info("Successfully clickced on Painting and cleaning");
	}

	@Then("Select the city")
	public void select_the_city() {
	    // Write code here that turns the phrase above into concrete actions
		String parent=driver.getWindowHandle();
		   Set<String> handles=driver.getWindowHandles();
		   for(String handle:handles) {
		   	if(!parent.equals(handle))
		   		driver.switchTo().window(handle);
		   }
		   driver.findElement(PaintsUi.city).click();
		   log.info("Successfuly selected city");
	}

	@Then("Enter the details")
	public void enter_the_details() {
	    // Write code here that turns the phrase above into concrete actions
	driver.findElement(PaintsUi.paint).click();
	   String text=driver.findElement(PaintsUi.text).getText();
	   log.info("Successfully printed the text "+text);
	}

	@Then("Submit")
	public void submit() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
