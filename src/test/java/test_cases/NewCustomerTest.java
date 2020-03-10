package test_cases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;

import pages.HomePage;

@Listeners(TestUtility.ListenerTest.class)

public class NewCustomerTest extends TestBase {

	
	HomePage homepage;

	@BeforeMethod

	public void setUp() {

		homepage = new HomePage(driver);
	}

	@Test(priority = 1)

	public void selectNewCustomer() {

		logger.info("######## New Customer ########");

		homepage.selectnewCustomer();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");
		logger.info("######## New Customer Creation Page ########");

	}

	@Test(priority = 2)

	public void enterGender() {

		logger.info("######## Select Gender ########");

		homepage.selectGender();

	}

	@Test(priority = 3)

	public void enterCustomerName() {

		logger.info("Fourth Test Case");

		homepage.enterCustomerName();

	}

}
