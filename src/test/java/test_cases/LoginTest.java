package test_cases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import pages.LoginPage;

@Listeners(TestUtility.ListenerTest.class)

public class LoginTest extends TestBase {

	LoginPage loginpage;

	@BeforeMethod

	public void setUp() {
		initialize();

		loginpage = new LoginPage(driver);

	}

	@Test
	public void login() {

		logger.info("########Login########");

		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		logger.info("########Login Done Successfully########");

	}

}
