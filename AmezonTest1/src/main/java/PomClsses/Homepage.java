package PomClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	@FindBy (xpath = "//a[@id='nav-link-accountList']")
	private WebElement accAndlist;
	@FindBy (xpath = "(//span[text()='Sign in'])[1]")
	private WebElement signInbutton;
	@FindBy (xpath = "//span[text()='Sign Out']")
	private WebElement signout;
	public Homepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAccandlist()
	{
		Actions act = new Actions(driver);
		act.moveToElement(accAndlist).moveToElement(signInbutton).click().build().perform();
		
	}
	public void clicksignout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(accAndlist).moveToElement(signout).click().build().perform();
	}

}
