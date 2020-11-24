package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Constant.BasePage;
import Constant.BaseTest;

public class PlansPage extends BasePage{

	public PlansPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(xpath = "//button[@class='create_btn fileUpload btn-sm table_button_link']")
	private WebElement createNewPlan;
	
	@FindBy(xpath = "//*[@id='userplancreate']/div[1]/div/input")
	private WebElement planNameField;
	
	@FindBy(id = "plantype")
	private WebElement dropdownforplanType;
	
	@FindBy(xpath = "//*[@id='plantype']/option[2]")
	private WebElement selectPREMIUMplan;
	
	@FindBy(id = "trialperiod")
	private WebElement trialPeriod;
	
	@FindBy(id = "description")
	private WebElement description;
	
	@FindBy(xpath = "//*[@id='trialperiod']/option[1]")
	private WebElement selectZeroDays;
	
	@FindBy(xpath = "//*[@id='userplancreate']/div[5]/div/input")
	private WebElement tag;
	
	@FindBy(id = "userplan-price-modal-handle")
	private WebElement pricing;

	@FindBy(id = "userplan_currency")
	private WebElement clickonCurrencyField;
	
	@FindBy(id = "userplan_quality")
	private WebElement clickonFrequencyField;
	
	@FindBy(id = "userplan_price")
	private WebElement clickonpriceField;
	
	@FindBy(id = "userplan_price_create_button")
	private WebElement clickonCreateButtonOnPlanPricePopup;
	
	@FindBy(id = "user-discount-modal-handle")
	private WebElement clickOndiscountedPriceButtonOnPlanPage;
	
	@FindBy(id = "discount_currency")
	private WebElement discountCurrency;
	
	@FindBy(id = "discount_quality")
	private WebElement discountQuality;
	
	@FindBy(id = "discount_price")
	private WebElement discountPrice;
	
	@FindBy(id = "userplan_discount_create_button")
	private WebElement discountCreateButtonOnPricePopup;
	
	@FindBy(id = "create")
	private WebElement clikOnCreateButton;
	
	@FindBy(xpath = "(//p[@class='ok'])[1]")
	private WebElement verifyTheStatusOfThePlan;
	
	@FindBy(xpath = "(//label[@class='check-toggle'])[1]")
	private WebElement clickOnToggle;
	
	@FindBy(xpath = "confirm_button")
	private WebElement clickOnYesInPopUp;
	
	@FindBy(xpath = "(//span[@class='row-status'])[1]")
	private WebElement verifyTheStatusOfThePlan1;
	
	
/*	@FindBy(xpath="//div[@class='spinner']")
	private WebElement loader;*/
	
	public void EnterBasicInfoOnPlanPage() throws InterruptedException
	{
		//loaderHandling(loader,createNewPlan);
		Thread.sleep(1000);
		visibilityOfElement(createNewPlan);
		createNewPlan.click();
		planNameField.sendKeys("Test");
		waitTillTheElementVisible(dropdownforplanType);
		dropdownforplanType.click();
		selectPREMIUMplan.click();
		description.sendKeys("{\"details\"" + ":" + "\"Test Automation\"" + "," + "\"points\"" + ":" + "\"Test1,Test2,Test3\"}");
		trialPeriod.click();
		selectZeroDays.click();
		tag.sendKeys("Premium Plan");	
	}
	
	
	public void CreateMonthlyPrice() throws InterruptedException
	{
		pricing.click();
		Thread.sleep(1000);
		visibilityOfElement(clickonCurrencyField);
		clickonCurrencyField.click();
		Select select = new Select(clickonCurrencyField);
		select.selectByVisibleText("INR");
		
		Thread.sleep(1000);	
		visibilityOfElement(clickonFrequencyField);
		Select select1 = new Select(clickonFrequencyField);
		
		Thread.sleep(1000);
		visibilityOfElement(clickonpriceField);
		select1.selectByValue("Monthlyprice");
		
		clickonpriceField.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);		
		clickonpriceField.sendKeys("100");
		visibilityOfElement(clickonCreateButtonOnPlanPricePopup);
		clickonCreateButtonOnPlanPricePopup.click();
	}
	
	
	public void CreateYearlyPrice() throws InterruptedException
	{
		Thread.sleep(2000);
		visibilityOfElement(pricing);
		pricing.click();
		Thread.sleep(1000);
		visibilityOfElement(clickonCurrencyField);
		clickonCurrencyField.click();
		Select select = new Select(clickonCurrencyField);
		select.selectByVisibleText("INR");
		
		Thread.sleep(1000);	
		visibilityOfElement(clickonFrequencyField);
		Select select1 = new Select(clickonFrequencyField);
		
		Thread.sleep(1000);
		visibilityOfElement(clickonpriceField);
		select1.selectByValue("Yearlyprice");
		clickonpriceField.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);
		clickonpriceField.sendKeys("300");
		clickonCreateButtonOnPlanPricePopup.click();
	}
	
	// DISCOUNT FLOW
	public void CreateMonthlyDiscountedPrice() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		visibilityOfElement(clickOndiscountedPriceButtonOnPlanPage);
		clickOndiscountedPriceButtonOnPlanPage.click();
		Thread.sleep(2000);
		visibilityOfElement(discountCurrency);
		discountCurrency.click();
		Select select = new Select(discountCurrency);
		select.selectByVisibleText("INR");
		
		Thread.sleep(1000);	
		visibilityOfElement(discountQuality);
		Select select1 = new Select(discountQuality);
		
		Thread.sleep(1000);
		visibilityOfElement(discountPrice);
		select1.selectByValue("monthlydiscount");
		
		discountPrice.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);		
		discountPrice.sendKeys("99");
		visibilityOfElement(discountCreateButtonOnPricePopup);
		discountCreateButtonOnPricePopup.click();
	}
	
	
	public void CreateYearlyDiscountedPrice() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		visibilityOfElement(clickOndiscountedPriceButtonOnPlanPage);
		clickOndiscountedPriceButtonOnPlanPage.click();
		Thread.sleep(1000);
		visibilityOfElement(discountCurrency);
		discountCurrency.click();
		Select select = new Select(discountCurrency);
		select.selectByVisibleText("INR");
		
		Thread.sleep(1000);	
		visibilityOfElement(discountQuality);
		Select select1 = new Select(discountQuality);
		
		Thread.sleep(1000);
		visibilityOfElement(discountPrice);
		select1.selectByValue("yearlydiscount");
		
		discountPrice.sendKeys(Keys.CONTROL,"a",Keys.BACK_SPACE);		
		discountPrice.sendKeys("299");
		visibilityOfElement(discountCreateButtonOnPricePopup);
		discountCreateButtonOnPricePopup.click();
	}
	
	public void clickOnCreateButton() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		visibilityOfElement(clikOnCreateButton);
		clikOnCreateButton.click();
	}
	
	public void planStatusVerification() throws InterruptedException
	{
		Thread.sleep(1500);
		visibilityOfElement(verifyTheStatusOfThePlan);
		System.out.println(" Plan Status = " + verifyTheStatusOfThePlan.getText());
	}
	
	public void changigThePlanStatusFromActiveToInactive() throws InterruptedException
	{
		Thread.sleep(1500);
		visibilityOfElement(clickOnToggle);
		clickOnToggle.click();
		Thread.sleep(1500);
		visibilityOfElement(clickOnYesInPopUp);
		clickOnYesInPopUp.click();
		Thread.sleep(1500);
		visibilityOfElement(verifyTheStatusOfThePlan1);
		System.out.println(" Plan Status = " + verifyTheStatusOfThePlan1.getText());
		
	}

}
