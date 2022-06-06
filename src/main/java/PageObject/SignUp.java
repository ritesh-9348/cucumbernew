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

import Reusable.Webdriverhelper;
import UiStore.SignUpUi;
import Utilities.Logs;
import Utilities.StartBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp {
public Webdriverhelper web;
public WebDriver driver;
Logger logs;
Logs log;
public SignUp() {
	driver=StartBrowser.driver;
	web=new Webdriverhelper();
	log=new Logs();
	
}
@Given("Launch the browser {string}")
public void launch_the_browser(String string) {
    // Write code here that turns the phrase above into concrete actions
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(string);
    logs=log.createlog();
    logs.info("TestCase-1");
    logs.info("Browser launched successfully");
}

@Then("click on SignUp button")
public void click_on_sign_up_button() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(SignUpUi.signUp).click();
	logs.info("Successfully opened sign up page");
}

@Then("Enter mobile name and email of the user")
public void enter_mobile_name_and_email_of_the_user() {
    // Write code here that turns the phrase above into concrete actions
	driver.findElement(SignUpUi.mobile).sendKeys("7747733452");
	//test.log(LogStatus.PASS,"Successfully entered mobile number");
	logs.info("Successfully entered mobile number");
	driver.findElement(SignUpUi.name).sendKeys("Master");
	driver.findElement(SignUpUi.email).sendKeys("emmaster.37855@gmail.com");
	//test.log(LogStatus.PASS,"Successfully entered email and name");
	logs.info("Successfully entered email and name");
}

@Then("click on continue")
public void click_on_continue() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	this.getscrshot("SignUp");
	driver.findElement(SignUpUi.contin).click();
	logs.info("Successfully signed up into account");
	driver.quit();
}


public void getscrshot(String name) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
	File dest=new File(path);
	FileUtils.copyFile(src, dest);
}
}
