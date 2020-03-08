package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='uid']")

	WebElement username;

	@FindBy(xpath = "//input[@name='password']")

	WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")

	WebElement loginBtn;

	public void login(String strEmail, String strPassword) {
		username.sendKeys(strEmail);
		password.sendKeys(strPassword);
		loginBtn.click();
	}

}