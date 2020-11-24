package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Constant.BasePage;
import Constant.BaseTest;

public class SideMenu extends BasePage {
	
	public SideMenu(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(BaseTest.driver, this);
	}

	@FindBy(xpath ="/html/body/div[2]/div[1]/div/ul/a[5]/li")
	private WebElement content;
	
	@FindBy(xpath="//p[@class='active-class-p']")
	private WebElement subscribers;
	
	@FindBy(xpath="//p[@class='p_style' and text()='Plans']")
	private WebElement plans;
	
	@FindBy(xpath="//div[@class='spinner']")
	private WebElement loader;
	
	
	
	public void clickOnPlansMenu() throws InterruptedException
	{
		Thread.sleep(3000);
		visibilityOfElement(plans);
		plans.click();
	}
	
	
}
