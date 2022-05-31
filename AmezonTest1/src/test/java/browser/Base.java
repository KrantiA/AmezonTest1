package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Base {
	
	public static WebDriver openChromebrowser()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browser\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static WebDriver openEdgebrowser()
	{
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\browser\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		return driver;
	}

}
