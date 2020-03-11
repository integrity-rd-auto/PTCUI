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
	
	
	@FindBy(xpath = "//ul[@class='menusubnav']//a[contains(text(),'Delete Customer')]")
	
	WebElement deleteCustomer;

	public void selectnewCustomer() {

		newCustomer.click();

	}
	
	public void selectDeleteCustomer() {

		deleteCustomer.click();

	}
	
	
	

}
