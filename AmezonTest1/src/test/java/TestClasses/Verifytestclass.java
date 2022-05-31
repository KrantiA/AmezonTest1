package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PomClsses.AmezonGiftcard;
import PomClsses.AmezonPay;
import PomClsses.Homepage;
import PomClsses.SignIn;
import PomClsses.SignInNext;
import browser.Base;
import utils.Utility;

public class Verifytestclass {
WebDriver driver;
Homepage homepage;
SignIn signin;
SignInNext signinnext;
AmezonPay amezonPay;
AmezonGiftcard amezongiftcard;
int row = 1;

@Parameters("browserName")
@BeforeTest
public void launchbrowser(String browser)
{
	if(browser.equals("Chrome"))
	{
		driver = Base.openChromebrowser();
	}
	if(browser.equals("Edge"))
	{
		driver = Base.openEdgebrowser();
	}
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

@BeforeClass
public void createPOMobject()
{
	homepage = new Homepage(driver);
	
	signin = new SignIn(driver);
	
	signinnext=new SignInNext(driver);
	
    amezonPay = new AmezonPay(driver);
    
    amezongiftcard = new AmezonGiftcard(driver);
}
@BeforeMethod
public void logintoApplication() throws InterruptedException, EncryptedDocumentException, IOException 
{
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	homepage.clickAccandlist();
	Thread.sleep(3000);
	//String data = Utility.getDatafromexcelsheet(1,0);
	signin.sendEmail(Utility.getDatafromexcelsheet("TestData",row,0));
	Thread.sleep(3000);
    //data = Utility.getDatafromexcelsheet(1,1);
    signinnext.sendPassword(Utility.getDatafromexcelsheet("TestData",row,1));
    
}

@Test (invocationCount = 2)
public void verifyamezonPay() 
{
	
    amezonPay.clickAmezonPay();
	String url = driver.getCurrentUrl();
	String title = driver.getTitle();
	Assert.assertEquals(url,"https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay" );
	Assert.assertEquals(title,"Amazon Pay" );
	row++;
	
}
//@Test (invocationCount = 2)
//public void verifyamezongiftcard() 
//{
//	 amezongiftcard.clickAmezongiftCard();
//	 String url = driver.getCurrentUrl();
//	 String title = driver.getTitle();
//	 Assert.assertEquals(url,"https://www.amazon.in/gift-card-store/b/?ie=UTF8&node=3704982031&ref_=nav_cs_gc" );
//	 Assert.assertEquals(title,"Gift Cards & Vouchers Online : Buy Gift Vouchers & E Gift Cards Online in India - Amazon.in" );
//}
@AfterMethod()
public void logoutfromApplication(ITestResult result) throws IOException
{
	if(ITestResult.FAILURE == result.getStatus())
	{
		 Utility.captureScreenshot(driver,101);
	}
	homepage.clicksignout();
}
@AfterClass()
public void clearobject()
{
	homepage = null;
	signin   = null;
	signinnext = null;
	amezonPay = null;
	amezongiftcard = null;
}
@AfterTest
public void closebrowser()
{
	driver.close();
	driver = null;
	System.gc();
}}








