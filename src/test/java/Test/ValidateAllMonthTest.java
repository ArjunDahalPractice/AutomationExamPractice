package Test;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.ValidateAllMonthPage;
import Util.BasePage;
import Util.BrowserFactory;

public class ValidateAllMonthTest {

	WebDriver driver;
	ValidateAllMonthPage validateAllMonthPage;
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	List<String> expectedMonthList = new LinkedList<String>();

	@Test
	public void validateAllMonth() {
		driver = BrowserFactory.lunchWebsite();
		validateAllMonthPage = PageFactory.initElements(driver, ValidateAllMonthPage.class);
		for (int i = 0; i < months.length; i++) {
			expectedMonthList.add(months[i]);
		}
		validateAllMonthPage.CLICK_DUE_MONTH_DROPDOWN_BUTTON();
		BasePage.takeSnapshot(driver, " Month_List");
		List<String> actualMonthList = validateAllMonthPage.actualMonthList(driver);
		Assert.assertEquals(actualMonthList, expectedMonthList);
		BasePage.tearDown(driver);
		System.out.println("Sucessfully validate due months in dropdown where all 12 months are there");
	}

}
