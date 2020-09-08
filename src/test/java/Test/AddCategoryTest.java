package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.AddCategoryPage;
import Util.BasePage;
import Util.BrowserFactory;
import Util.ExcelReader;

public class AddCategoryTest {

	WebDriver driver;
	AddCategoryPage addCategoryPage;
	
	ExcelReader reader = new ExcelReader(".\\data\\websitedata.xlsx");
	String expectedAddCategory = reader.getCellData("stringTestData", "expectedAddCategory", 5);
	
	@Test
	public void addCategory() {
	driver = BrowserFactory.lunchWebsite();
	addCategoryPage = PageFactory.initElements(driver, AddCategoryPage.class);	
	addCategoryPage.ADD_CATEGORY_FIELD(expectedAddCategory);
	addCategoryPage.CLICK_ADD_CATEGORY_BUTTON();
	
	System.out.printf("Sucessfully add -- Category Name : %s\n",expectedAddCategory);
	BasePage.takeSnapshot(driver, " add_Category");
	}
	
	@Test
	public void validationAddCategory() {
	addCategoryPage.CLICK_ADDED_CATEGORY_DROPDOWN_BUTTON();
	String actualAddedCategory = addCategoryPage.readAddedCategory(driver, expectedAddCategory);
	Assert.assertEquals(actualAddedCategory, expectedAddCategory , "actual and expected category didn't match");
	BasePage.tearDown(driver);
	System.out.printf("Sucessfully validation -- Actual Category Name : %s\tExpected Category Name : %s\n",actualAddedCategory, expectedAddCategory);
	}
	
}
