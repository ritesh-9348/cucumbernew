package Reusable;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Webdriverhelper {
	public static WebDriver driver;
	public Webdriverhelper() {
		
	}
		
	public void clickbtn(By element) {
		driver.findElement(element).click();
	}
	public void sendtext(By element,String text) {
		driver.findElement(element).sendKeys(text);
	}
	public void hover(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	public String gettext(By element) {
		String text=driver.findElement(element).getText();
		return text;
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	public void windowhandles() {
		String parent=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String handle:handles) {
			if(!parent.equals(handle))
				driver.switchTo().window(handle);
		}
	}
	public void navigatetoweb(String str) {
		driver.get(str);
	}
}
