package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DuplicateCategoryPage {

	WebDriver driver;
	public DuplicateCategoryPage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how=How.CSS, using=("body")) WebElement DUPLICATE_ADD_CATEGORY_MESSAGE;
	
	public String DUPLICATE_ADD_CATEGORY_MESSAGE() {
		String actualErrorMessage = DUPLICATE_ADD_CATEGORY_MESSAGE.getText();
		return actualErrorMessage.substring(0,44);
		}
	
	}
	
	
