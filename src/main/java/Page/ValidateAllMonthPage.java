package Page;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ValidateAllMonthPage {

	WebDriver driver;

	public ValidateAllMonthPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "select[name='due_month']")
	WebElement CLICK_DUE_MONTH_DROPDOWN_BUTTON;

	public void CLICK_DUE_MONTH_DROPDOWN_BUTTON() {
		CLICK_DUE_MONTH_DROPDOWN_BUTTON.click();
	}

	public List<String> actualMonthList (WebDriver driver) {
		List<String> list = new LinkedList<String>();
		int elementLength = driver.findElements(By.xpath("//select[3]/option")).size();
		for (int i = 2; i <= elementLength; i++) {
			String str = driver.findElement(By.xpath("//select[3]/option[" + i + "]")).getText();
			list.add(str);
		}
		return list;
	}
}
