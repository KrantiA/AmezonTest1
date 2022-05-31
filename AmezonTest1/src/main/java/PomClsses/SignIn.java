package PomClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	@FindBy (xpath = "//input[@id='ap_email']")
	private WebElement emailormobile;
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continuetab;
	public SignIn(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendEmail(String Username) throws InterruptedException
	{
		emailormobile.sendKeys(Username);
		Thread.sleep(1000);
		continuetab.click();
	}
}
