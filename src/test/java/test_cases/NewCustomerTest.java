package test_cases;

import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Base.TestBase;
import TestUtility.ExcelRead;
import pages.CustomerRegistrationPage;
import pages.DeletePage;
import pages.HomePage;
import pages.NewCustomerCreationPage;

@Listeners(TestUtility.ExtentListener.class)

public class NewCustomerTest extends TestBase {

	NewCustomerCreationPage newCustomer;

	HomePage homepage;

	DeletePage deletepage;

	CustomerRegistrationPage customerdetails;

	public static DataFormatter formatter = new DataFormatter();

	@BeforeMethod

	public void setUp() {

		newCustomer = new NewCustomerCreationPage(driver);

		homepage = new HomePage(driver);

		deletepage = new DeletePage(driver);

		customerdetails = new CustomerRegistrationPage(driver);

	}

	@DataProvider

	public static Object[][] readExcel() throws IOException {

		return ExcelRead.excelData();

	}

	@Test(dataProvider = "readExcel", priority = 2)

	public void enterCustomerDataHere(String Customer_Name, String DOB, String Address, String City, String State,
			String PIN, String Mobile_Num, String Email, String Password) throws InterruptedException {

		logger.info("Enter Customer Detail");

		newCustomer.enterCustomerData(Customer_Name, DOB, Address, City, State, PIN, Mobile_Num, Email, Password);

		newCustomer.clickOnSubmit();

		String status = driver.findElement(By.cssSelector("p.heading3")).getText();

		Assert.assertEquals(status, "Customer Registered Successfully!!!");

		String Cust_ID = customerdetails.getCustomerID();

		logger.info("Customer created" + " " + Cust_ID);
		homepage.selectDeleteCustomer();

		deletepage.deleteCustomer(Cust_ID);

		Thread.sleep(500);

		logger.info("Customer deleted" + " " + Cust_ID);

		homepage.selectnewCustomer();

	}

}
