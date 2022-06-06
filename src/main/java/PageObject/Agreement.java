package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.AgreementUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Agreement {
public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public Agreement() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("User launches the browser {string}")
	public void user_launches_the_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-3");
	    log.info("Browser launched successfully");
	}
	@When("click on Rental agreement")
	public void click_on_rental_agreement() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(AgreementUi.click).click();
	   String parent=driver.getWindowHandle();
	   Set<String> handles=driver.getWindowHandles();
	   for(String handle:handles) {
	   	if(!parent.equals(handle))
	   		driver.switchTo().window(handle);
	   }
	   log.info("Successfully clicked on Rental agreement");
	   driver.findElement(AgreementUi.city).click();
	   log.info("Successfullu selected city");
	}

	@Then("print the agreement document")
	public void print_the_agreement_document() {
	    // Write code here that turns the phrase above into concrete actions
	    String text=driver.findElement(AgreementUi.text).getText();
	    log.info(text);
	    driver.quit();
	}

}
