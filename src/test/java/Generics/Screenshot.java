package Generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Constant.BaseTest;

public class Screenshot extends BaseTest{

	
	public String getScreenshot(String Screenshot) throws IOException
	{
        //object of take screenshot, we can't take object of an interface so typecast the webdriver instance.
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		 //which will capture the screenshot
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir")+"//Screenshots//"+ Screenshot + timestamp() + ".png";
		
		File finaldestination = new File(destination);
		//FileUtils.copyDirectory(source, new File(destination));
		FileUtils.copyFile(source, finaldestination);
		
		return destination;	
	}
	
	public String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		
	}

}
