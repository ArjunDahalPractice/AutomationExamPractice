package Page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCategoryPage {

	WebDriver driver;

	public AddCategoryPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element locator
	@FindBy(how = How.CSS, using = "input[name=categorydata]")
	WebElement ADD_CATEGORY_FIELD;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement CLICK_ADD_CATEGORY_BUTTON;
	@FindBy(how = How.CSS, using = "select[name='category']")
	WebElement CLICK_ADDED_CATEGORY_DROPDOWN_BUTTON;

	// Interact with locator
	public void ADD_CATEGORY_FIELD(String categoryName) {
		ADD_CATEGORY_FIELD.sendKeys(categoryName);
	}

	public void CLICK_ADD_CATEGORY_BUTTON() {
		CLICK_ADD_CATEGORY_BUTTON.click();
	}

	public void CLICK_ADDED_CATEGORY_DROPDOWN_BUTTON() {
		CLICK_ADDED_CATEGORY_DROPDOWN_BUTTON.click();

	}
	
	public void REPLACE_COLOR_WITH_CATEGORY() {
		driver.findElement(By.xpath("/html/body/a[2]")).click();
	}

	public String readAddedCategory(WebDriver driver, String searchCategoryName) {
		String foundCategoryName = "";
		List<String> list = new LinkedList<String>();
		int elementLength = driver.findElements(By.xpath("//select[@name='category']//child::option")).size();
		for (int i = 2; i <= elementLength; i++) {
			String str = driver.findElement(By.xpath("//select[@name='category']//child::option[" + i + "]")).getText();
			list.add(str);
		}
		for (String string : list) {
			if (string.contains(searchCategoryName)) {
				foundCategoryName = string;
			} 
		}
		return foundCategoryName;
	}
	
}