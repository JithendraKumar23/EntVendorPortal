package Constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {


	public long timeout;
	public String configFile;
	public WebDriver driver;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//configFile=AutomationConstant.CONFIG_PATH+AutomationConstant.CONFIG_FILE;
		//timeout=Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));
	}

	public void waitTillTheElementVisible(WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}	

	public void waitTillElementIsClickable(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void invisibleOfElementForLoader(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void visibilityOfElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

	//Loader Handling
	public boolean isElementDisplayed(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.isDisplayed();
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

	public void loaderHandling(WebElement ele1, WebElement ele2)
	{
		if (isElementDisplayed(ele1)) 
		{
			new WebDriverWait(driver, 60).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(ele1)));
		}
		else
		{
			waitTillTheElementVisible(ele2);
		}
	}



}
