package PomClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInNext {
	@FindBy (xpath = "//input[@id='ap_password']")
	private WebElement password;
	@FindBy (xpath = "//input[@id='signInSubmit']")
	private WebElement signintab;
	
	public SignInNext(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendPassword(String pass) throws InterruptedException
	{
		Thread.sleep(3000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		signintab.click();
	}

}
