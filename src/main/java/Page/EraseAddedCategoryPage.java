package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Util.BasePage;
import Util.BrowserFactory;

public class EraseAddedCategoryPage {
	WebDriver driver;
	
	public EraseAddedCategoryPage (WebDriver driver) {
		this.driver=driver;
	}

	//@FindBy(how=How.XPATH, using=("//a[contains(text(), 'Yes')]")) WebElement CLICK_YES;
	
	
	public void DELETE_ADDED_CATEGORY(WebDriver driver, String deleteCategoryName) throws InterruptedException {
		driver = BrowserFactory.lunchWebsite();
		driver.findElement(By.xpath(String.format("//span[contains(text(),'%s')]",deleteCategoryName))).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Yes')]")).click();
		BasePage.tearDown(driver);
	}
	
}
