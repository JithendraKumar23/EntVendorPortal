package TestCases;

import org.testng.annotations.Test;

import Constant.BaseTest;
import Pages.PlansPage;
import Pages.SideMenu;

public class PlansTest extends BaseTest {
	
	@Test(enabled = true)
	public void plans() throws InterruptedException{
		
		SideMenu sidemenu = new SideMenu(driver);
		PlansPage planspage = new PlansPage(driver);
		
		sidemenu.clickOnPlansMenu();
		planspage.EnterBasicInfoOnPlanPage();
		planspage.CreateMonthlyPrice();
		planspage.CreateYearlyPrice();
		planspage.CreateMonthlyDiscountedPrice();
		planspage.CreateYearlyDiscountedPrice();
		planspage.clickOnCreateButton();
		planspage.planStatusVerification();
		planspage.changigThePlanStatusFromActiveToInactive();
	}
	

}
