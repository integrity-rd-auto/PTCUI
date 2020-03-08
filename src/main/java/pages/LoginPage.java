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
  
    
    public void setEmail(String strEmail) { 
    	username.sendKeys(strEmail); 
        } 
        // This method is to set Password in the password text box 
    public void setPassword(String strPassword) { 
    	password.sendKeys(strPassword); 
        } 
        // This method is to click on Next Button 
    public void clickOnNextButton() { 
    	loginBtn.click(); 
    } 
} 