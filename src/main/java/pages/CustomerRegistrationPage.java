package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerRegistrationPage {

	WebDriver driver;

	public CustomerRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")

	WebElement newCustomer;

	@FindBy(xpath = "//td[contains(text(),'Customer Name')]/following-sibling::td")

	WebElement customerName;

	@FindBy(xpath = "//td[contains(text(),'Gender')]/following-sibling::td")

	WebElement gender;
	
	@FindBy(xpath = "//td[contains(text(),'Customer ID')]/following-sibling::td")

	WebElement CustomerID;

	public String getCustomerID() {

		String name = CustomerID.getText();
        return name;
	}

	public void getGender() {

		gender.getText();

	}

}
