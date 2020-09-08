package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import Page.AddCategoryPage;
import Page.DuplicateCategoryPage;
import Util.BasePage;
import Util.BrowserFactory;
import Util.ExcelReader;

public class DuplicateCategoryTest {

	WebDriver driver;
	AddCategoryPage addCategoryPage; 
	DuplicateCategoryPage duplicateCategoryPage;
	
	ExcelReader reader = new ExcelReader(".\\data\\websitedata.xlsx");
	String duplicateCategoryName = reader.getCellData("stringTestData", "duplicateCategoryName", 5);
	
	String expectedErrorMessage = "The category you want to add already exists:";
	
	@Test
	public void duplicateCategory() {
		driver = BrowserFactory.lunchWebsite();
		addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);
		addCategoryPage.ADD_CATEGORY_FIELD(duplicateCategoryName);
		addCategoryPage.CLICK_ADD_CATEGORY_BUTTON();
		duplicateCategoryPage = PageFactory.initElements(driver, DuplicateCategoryPage.class);
		String actualErrorMessage = duplicateCategoryPage.DUPLICATE_ADD_CATEGORY_MESSAGE();
		System.out.println(actualErrorMessage);
		BasePage.takeSnapshot(driver, " Error_Message");
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, " Didn't show duplicate category added error message");
		BasePage.tearDown(driver);
		System.out.println("Sucessfully validate, user not able to add duplicate category");
	}
}
