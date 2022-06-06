package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.NRIUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NRI {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public NRI() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("User open the browser and enter {string}")
	public void user_open_the_browser_and_enter(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-6");
	    log.info("Browser launched successfully");
	}

	@When("user clcik on No broker NRI")
	public void user_clcik_on_no_broker_nri() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(NRIUi.click).click();
		log.info("Successfully clciked on Website");
	}

	@Then("Enter all the required details")
	public void enter_all_the_required_details() {
	    // Write code here that turns the phrase above into concrete actions
		String parent=driver.getWindowHandle();
		   Set<String> handles=driver.getWindowHandles();
		   for(String handle:handles) {
		   	if(!parent.equals(handle))
		   		driver.switchTo().window(handle);
		   }
		driver.findElement(NRIUi.name).sendKeys("saikumar");
	    driver.findElement(NRIUi.mail).sendKeys("saikumar876@gmail.com");
	    driver.findElement(NRIUi.mobile).sendKeys("7788838923");
	    driver.findElement(NRIUi.city).click();
	    driver.findElement(NRIUi.select).click();
	    driver.findElement(NRIUi.type).click();
	    driver.findElement(NRIUi.selecttype).click();
	    log.info("Successfully entered all the details");
	}

	@Then("Clikc on get in touch")
	public void clikc_on_get_in_touch() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(NRIUi.touch).click();
	    driver.quit();
	}
}
