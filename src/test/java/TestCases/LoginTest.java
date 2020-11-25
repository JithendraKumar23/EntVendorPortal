package TestCases;

import org.testng.annotations.Test;

import Constant.BaseTest;
import Pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test(enabled=true)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginPageClearingtheField(UN);
		loginpage.enterPassword(PW);
		loginpage.clickOnLoginButton();
}
}
