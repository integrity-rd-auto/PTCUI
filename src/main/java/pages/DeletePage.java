package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helper.AlertHelper;

public class DeletePage {

	private static Logger log = Logger.getLogger(DeletePage.class);

	public static WebDriver driver;

	public DeletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='cusid']")

	WebElement enterCustomerIDToBeDeleted;

	@FindBy(xpath = "//input[@name='AccSubmit']")

	WebElement deleteSubmit;

	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public static String getAlertText() {
		String text = driver.switchTo().alert().getText();
		log.info("alert text: " + text);
		return text;
	}

	public void deleteCustomer(String customerID) {

		enterCustomerIDToBeDeleted.sendKeys(customerID);

		deleteSubmit.click();
		//getAlertText();
		acceptAlert();
		//getAlertText();
		acceptAlert();

	}

}
