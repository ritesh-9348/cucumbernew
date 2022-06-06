package PageObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import Reusable.Webdriverhelper;
import UiStore.AboutUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class About {
	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public About() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("User launch the browser {string}")
	public void user_launch_the_browser(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-2");
	    log.info("Browser launched successfully");
	}

	@When("Go to footer section and click on About us")
	public void go_to_footer_section_and_click_on_about_us() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(AboutUi.click).click();
	    log.info("Successfully clicked on About us");
	    this.getscrshot("About us");
	}

	@Then("Go to contact us section")
	public void go_to_contact_us_section() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(AboutUi.contact).click();
	    log.info("Successfully clciked on Contact us");
	}

	@Then("print the text of the heading")
	public void print_the_text_of_the_heading() {
	    // Write code here that turns the phrase above into concrete actions
	    String text=driver.findElement(AboutUi.text).getText();
	    log.info(text);
	    driver.quit();
	}
	public void getscrshot(String name) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
	}
}
