package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	public WebDriver driver;
public Screenshots() {
	driver=StartBrowser.driver;
}
public void getscrshot(String name) throws IOException {
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
	File dest=new File(path);
	FileUtils.copyFile(src, dest);
}
}
