package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {

	WebDriver driver;

	public DeletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='cusid']")

	WebElement enterCustomerIDToBeDeleted;
	
	@FindBy(xpath = "//input[@name='AccSubmit']")

	WebElement deleteSubmit;

	public void deleteCustomer(String customerID) {

		enterCustomerIDToBeDeleted.sendKeys(customerID);
		
		deleteSubmit.click();
		
		Alert confirm = driver.switchTo().alert();

		confirm.accept();

		Alert succ = driver.switchTo().alert();

		succ.accept();
		
		}

}
