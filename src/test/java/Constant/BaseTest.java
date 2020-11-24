package Constant;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import Generics.Property;
import Generics.Screenshot;

@Listeners(Generics.Listeners.class)
public class BaseTest implements AutomationConstant {


	public static WebDriver driver;
	public static String URL;
	public static String UN;
	public static String PW;

	public static long IMPLICIT;
	public static long EXPLICIT;

	public static long timeout;
	public static String platformname;
	public static String platFormVersion;
	public static String browserName; 

	/*ExtendReport Related*/
	public static ExtentReports report;
	public static ExtentTest test;

	//ExcelUserData package, To read the data from the config
	public static String ExcelFileName = "User_Information_Automation.xlsx";
	public static String ExcelFilePath = System.getProperty("user.dir") + "\\ExcelData\\";
	public static String Excelsheetname = "User_Data";
	public static int row = 0;
	public static int col = 0;

	public void initFrameWork() throws IOException {
		URL = Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "URL");
		//To get the data from the Config 
		UN = Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "UN");
		PW = Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "PW");

		//To get the Data form the ExcelSheet
		//UN=ExcelUserData.dataFromExcelSheet(ExcelFilePath,ExcelFileName,Excelsheetname,0,0);
		//PW=ExcelUserData.dataFromExcelSheet(ExcelFilePath,ExcelFileName,Excelsheetname,0,1);

		//timeout = Long.parseLong(Property.getPropertyValue(CONFIG_PATH + CONFI "IMPLICIT"));
		timeout = Long.parseLong(Property.getPropertyValue(CONFIG_PATH + CONFIG_FILE, "EXPLICIT"));

	}

	//@BeforeTest
	@BeforeSuite
	public void initApplication() throws Exception {
		System.setProperty(CHROME_KEY, DRIVER_PATH + CHROME_FILE);
		ChromeOptions options = new ChromeOptions();
		ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(DRIVER_PATH)).usingAnyFreePort().build();
		driver = new ChromeDriver(service, options);
		initFrameWork();
		driver.manage().window().maximize();
		driver.get(URL);
	}


	/*@AfterSuite(alwaysRun=true)
	public void CloseFramework()
	{
		driver.close();
	}*/


	@BeforeTest
	public void Extent()
	{
		report = new ExtentReports(System.getProperty("user.dir") + "\\ExtentReports\\" +"Extend_Reports.html",true,DisplayOrder.NEWEST_FIRST, NetworkMode.OFFLINE);
	}


	@AfterTest
	public void GenerareReport()
	{
		//To Generate the Extent Report 
		report.flush();
	}


	@AfterMethod
	public void TakeScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screenshot shot = new Screenshot();
			String path = shot.getScreenshot(result.getName());
			test.log(LogStatus.FAIL, test.addScreenCapture(path));
		}
	}




}
