package test_cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase {

	@Test
	public void init() throws Exception {

		// driver.get("https:// www.gmail.com");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.setEmail("mngr249314");
		//loginpage.clickOnNextButton();
		loginpage.setPassword("tUgErAh");
		loginpage.clickOnNextButton();
	}
}