package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.RentUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PayRent {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public PayRent() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("user launches browser {string}")
	public void user_launches_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-8");
	    log.info("Browser launched successfully"); 
	}

	@When("user click on Pay Rent on top corner")
	public void user_click_on_pay_rent_on_top_corner() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(RentUi.click).click();
	    log.info("Successfully clicked on Pay rent");
	    String parent=driver.getWindowHandle();
		   Set<String> handles=driver.getWindowHandles();
		   for(String handle:handles) {
		   	if(!parent.equals(handle))
		   		driver.switchTo().window(handle);
		   }
	}

	@Then("Print the text in the Pay rent page")
	public void print_the_text_in_the_pay_rent_page() {
	    // Write code here that turns the phrase above into concrete actions
	   String text=driver.findElement(RentUi.text).getText();
	   log.info(text);
	   driver.quit();
	}
}
