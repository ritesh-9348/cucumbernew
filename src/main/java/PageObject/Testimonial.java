package PageObject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.TestimonialUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testimonial {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public Testimonial() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	
	@Given("user opens the browser {string}")
	public void user_opens_the_browser(String string) {
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

	@Then("go to footer and click on Testiminol")
	public void go_to_footer_and_click_on_testiminol() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(TestimonialUi.click).click();
	    log.info("Successfully opened the testiminol page");
	    
	}

	@Then("Print the text of the customer review")
	public void print_the_text_of_the_customer_review() {
	    // Write code here that turns the phrase above into concrete actions
		String parent=driver.getWindowHandle();
		   Set<String> handles=driver.getWindowHandles();
		   for(String handle:handles) {
		   	if(!parent.equals(handle))
		   		driver.switchTo().window(handle);
		   }
		String text=driver.findElement(TestimonialUi.text).getText();
	  log.info(text);
	  driver.quit();
	}

}
