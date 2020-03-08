package test_cases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import pages.LoginPage;

public class LoginTest extends TestBase {

	LoginPage loginpage;

	@BeforeMethod

	public void setUp() {
		initialize();

		loginpage = new LoginPage(driver);
	}

	@Test
	public void login() {

		loginpage.login("mngr249314", "tUgErAh");
		
		
	}
}