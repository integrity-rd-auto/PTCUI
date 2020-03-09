package test_cases;

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

	@Test(priority= 1)

	public void selectNewCustomer() {

		homepage.selectnewCustomer();
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank New Customer Entry Page");

	}
	
	
	
	@Test(priority= 2)

	public void enterGender() {

		homepage.selectGender();

	}

	@Test(priority= 3)

	public void enterCustomerName() {

		homepage.enterCustomerName();

	}
	
	
	
	
	

}
