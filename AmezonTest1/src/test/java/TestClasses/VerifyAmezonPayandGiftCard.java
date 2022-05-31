package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PomClsses.AmezonGiftcard;
import PomClsses.AmezonPay;
import PomClsses.Homepage;
import PomClsses.SignIn;
import PomClsses.SignInNext;

public class VerifyAmezonPayandGiftCard {
	public static void main(String[] args) throws InterruptedException {
		
	
	System.setProperty("webdriver.chrome.driver","D:\\chromeDriverexe\\chromedriver.exe");
	
    WebDriver driver = new ChromeDriver();
    
    driver.get("https://www.amazon.in/");
    
    driver.manage().window().maximize();
    Homepage homepage = new Homepage(driver); 
    homepage.clickAccandlist();
    SignIn signin = new SignIn(driver);
    
	signin.sendEmail("8888244120");
    SignInNext signinnext = new SignInNext(driver);
    signinnext.sendPassword("aaibaba"); 
    //Test case 1
    AmezonPay amezonpay = new AmezonPay(driver);
    amezonpay.clickAmezonPay();
    
    String url = driver.getCurrentUrl();
    String title = driver.getTitle();
    if(url.equals("https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay") && (title.equals("Amazon Pay")))
    		{
    	System.out.println("Pass");
    }
    else
    {
    	System.out.println("failed");
    }
    Thread.sleep(3000);
    homepage.clicksignout();
    
    //testcase 2
     driver.get("https://www.amazon.in/");
     homepage = new Homepage(driver); 
     homepage.clickAccandlist();
     signin = new SignIn(driver);
     signin.sendEmail("8888244120");
     signinnext = new SignInNext(driver);
     signinnext.sendPassword("aaibaba"); 
     
     AmezonGiftcard amezongiftcard = new AmezonGiftcard(driver);
     amezongiftcard.clickAmezongiftCard();
      url = driver.getCurrentUrl();
    title = driver.getTitle();
     if(url.equals("https://www.amazon.in/gift-card-store/b/?ie=UTF8&node=3704982031&ref_=nav_cs_gc") && (title.equals("Gift Cards & Vouchers Online : Buy Gift Vouchers & E Gift Cards Online in India - Amazon.in")))
     		{
     	System.out.println("Pass");
     }
     else
     {
     	System.out.println("failed");
     }
     Thread.sleep(3000);
     homepage.clicksignout();
    }
}
