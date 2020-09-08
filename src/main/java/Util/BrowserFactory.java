package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	
	static ExcelReader reader = new ExcelReader(".\\data\\websitedata.xlsx");
	
	static String baseUrl = reader.getCellData("Url", "baseUrl", 2);
	
	public static WebDriver lunchWebsite() {	
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		BasePage.implicitWait(driver, 10);
		return driver;		
	}

}
