package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.EraseAddedCategoryPage;
import Util.BasePage;
import Util.BrowserFactory;
import Util.ExcelReader;

public class EraseAddedCategoryTest {
	
	WebDriver driver;
	
	ExcelReader reader = new ExcelReader(".\\data\\websitedata.xlsx");
	String deleteCategoryName = reader.getCellData("stringTestData", "deleteCategoryName", 5);
	
	@Test
	public void deleteAddedCategory() throws InterruptedException {
		driver = BrowserFactory.lunchWebsite();
		EraseAddedCategoryPage deleteAddedCategoryPage = PageFactory.initElements(driver, EraseAddedCategoryPage.class);
		deleteAddedCategoryPage.DELETE_ADDED_CATEGORY(driver, deleteCategoryName);
		BasePage.tearDown(driver);
		System.out.println("Sucessfully delete added category");
	}
}
