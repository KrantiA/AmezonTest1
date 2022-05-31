package PomClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmezonGiftcard {
	@FindBy (xpath = "//a[text()='Gift Cards']")
	private WebElement amezongiftcard;
	public AmezonGiftcard(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void clickAmezongiftCard()
	{
		amezongiftcard.click();
	}
}
