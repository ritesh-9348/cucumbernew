package PageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reusable.Webdriverhelper;
import UiStore.MenuUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Menu {
	public	WebDriver driver;
	Webdriverhelper web;
	ExtentTest test;
	SignUp sign;
	Logs logs;
	Logger log;
	ExtentReports reports;
	public Menu() {
	driver=StartBrowser.driver;
	test=StartBrowser.test;
	sign=new SignUp();
	logs=new Logs();
	web=new Webdriverhelper();
	reports=StartBrowser.report;
		}
	@Given("Open browser and enter {string}")
	public void open_browser_and_enter(String string) {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(string);
	    log=logs.createlog();
	    log.info("TestCase-5");
	    log.info("Browser launched successfully");  
	}

	@Then("Go to main menu and click on Refer&Earn")
	public void go_to_main_menu_and_click_on_refer_earn() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElement(MenuUi.click).click();
	   log.info("Successfully clciked on main menu");
	   driver.findElement(MenuUi.refer).click();
	   log.info("Successfully clciked on main menu");
	}

	@Then("Print the text of the refer amount")
	public void print_the_text_of_the_refer_amount() {
	    // Write code here that turns the phrase above into concrete actions
	    String text=driver.findElement(MenuUi.text).getText();
	    log.info(text);
	    driver.quit();
	}
}
