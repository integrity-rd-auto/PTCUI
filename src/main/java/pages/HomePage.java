package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")

	WebElement newCustomer;
	@FindBy(xpath = "//input[@name='name']")

	WebElement customerName;

	@FindBy(xpath = "//input[@name='rad1' and @value='m']")

	WebElement gender;

	public void selectnewCustomer() {

		newCustomer.click();

	}

	public void selectGender() {

		if (gender.isSelected()) {

			System.out.println("Aready selected");
		}

		else {
			gender.click();

		}
	}

	public void enterCustomerName() {

		customerName.sendKeys("Subhendu");

	}

}
