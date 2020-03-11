package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerCreationPage {

	WebDriver driver;

	public NewCustomerCreationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='name']")

	WebElement customerName;

	@FindBy(xpath = "//input[@name='rad1' and @value='m']")

	WebElement gender;

	@FindBy(xpath = "//input[@id='dob']")

	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")

	WebElement Addr;

	@FindBy(xpath = "//input[@name='city']")

	WebElement City_name;

	@FindBy(xpath = "//input[@name='state']")

	WebElement State_name;

	@FindBy(xpath = "//input[@name='pinno']")

	WebElement PIN_num;

	@FindBy(xpath = "//input[@name='telephoneno']")

	WebElement TelephoneNumber;

	@FindBy(xpath = "//input[@name='emailid']")

	WebElement Email_id;

	@FindBy(xpath = "//input[@name='password']")

	WebElement Password_p;

	@FindBy(xpath = "//input[@name='sub']")

	WebElement Submit;

	public void enterCustomerData(String Customer_Name, String DOB, String Address, String City, String State,
			String PIN, String Mobile_Num, String Email, String Password) {

		customerName.sendKeys(Customer_Name);
		dob.sendKeys(DOB);
		Addr.sendKeys(Address);
		City_name.sendKeys(City);
		State_name.sendKeys(State);
		PIN_num.sendKeys(PIN);
		TelephoneNumber.sendKeys(Mobile_Num);
		Email_id.sendKeys(Email);
		Password_p.sendKeys(Password);
			}
	
	public void clickOnSubmit() {
		Submit.click();
		
	}

}
