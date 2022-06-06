package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.SaleUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sale {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public Sale() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("User launch the browser is {string}")
	public void user_launch_the_browser_is(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-9");
	    log.info("Browser launched successfully"); 
	}

	@When("User clcik on Flat sale in bottom section")
	public void user_clcik_on_flat_sale_in_bottom_section() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(SaleUi.click).click();
	    log.info("Successfully opens the Flats");
	}

	@Then("open in new page and see the price")
	public void open_in_new_page_and_see_the_price() {
	    // Write code here that turns the phrase above into concrete actions
		String parent=driver.getWindowHandle();
		   Set<String> handles=driver.getWindowHandles();
		   for(String handle:handles) {
		   	if(!parent.equals(handle))
		   		driver.switchTo().window(handle);
		   }
		String price=driver.findElement(SaleUi.price).getText();
	  log.info(price);
	}

	@Then("Print the price of the flat")
	public void print_the_price_of_the_flat() {
	    // Write code here that turns the phrase above into concrete actions
	   log.info("Successfully print the price in console");
	   driver.quit();
	}


}
