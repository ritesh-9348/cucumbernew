package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StartBrowser {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	@BeforeClass
	public void before() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void after() {
		driver.quit();
	}
	@BeforeTest
	public void beforetest() {
		report=new ExtentReports(System.getProperty("user.dir")+"Reports/extentreport.html", true);
		
		
	}
	@AfterTest
	public void aftertest() {
		report.flush();
	}
}
