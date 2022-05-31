package PomClsses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmezonPay {
	@FindBy (xpath = "//a[text()='Amazon Pay']")
	private WebElement amezonPay;
	public AmezonPay(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void clickAmezonPay()
	{
		amezonPay.click();
	}

}
