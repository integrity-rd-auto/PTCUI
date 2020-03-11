package test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import pages.HomePage;
import pages.LoginPage;

@Listeners(TestUtility.ListenerTest.class)

public class HomePageTest extends TestBase {

	HomePage homepage;
	
	@BeforeMethod

	public void setUp() {
		
		homepage = new HomePage(driver);

	}
	
	

	@Test
	public void login() {

		logger.info("########Select New Customer########");

		homepage.selectnewCustomer();

		Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");
		logger.info("########New Customer Page Loaded########");

	}

}
