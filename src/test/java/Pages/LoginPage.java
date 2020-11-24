package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Constant.BasePage;
import Constant.BaseTest;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(id="exampleInputEmail1")
	private WebElement emailField;
	
	@FindBy(id="exampleInputPassword")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@id='login-form']/button/strong")
	private WebElement loginButton;
	
	public void loginPageClearingtheField(String EmailID) throws InterruptedException
	{
		//Thread.sleep(5000);
		
		visibilityOfElement(emailField);
		emailField.sendKeys(EmailID);
		
	}
	
	public void enterPassword(String password)
	{
		//loaderHandling(loader,passwordField);
		passwordField.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		visibilityOfElement(loginButton);
		loginButton.click();
	}
	
	
	

}
