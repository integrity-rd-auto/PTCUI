package test_cases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.TestBase;

import pages.NewCustomerCreationPage;

@Listeners(TestUtility.ListenerTest.class)

public class NewCustomerTest extends TestBase {

	NewCustomerCreationPage newCustomer;

	public static DataFormatter formatter = new DataFormatter();

	@BeforeMethod

	public void setUp() {

		newCustomer = new NewCustomerCreationPage(driver);

	}

	@DataProvider

	public static Object[][] readExcel() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Demo");

		XSSFRow Row = sheet.getRow(0);
		int noOfRows = sheet.getLastRowNum();

		int noOfCol = Row.getLastCellNum();

		Object Data[][] = new Object[noOfRows][noOfCol];

		for (int i = 0; i < noOfRows; i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				Data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();

				System.out.println(Data[i][k]);
			}
		}
		return Data;

	}

	@Test(dataProvider = "readExcel", priority = 2)

	public void enterCustomerDataHere(String Customer_Name, String DOB, String Address, String City, String State,
			String PIN, String Mobile_Num, String Email, String Password) {

		logger.info("Enter Customer Detail");

		newCustomer.enterCustomerData(Customer_Name, DOB, Address, City, State, PIN, Mobile_Num, Email, Password);

		newCustomer.clickOnSubmit();

		String s = driver.findElement(By.cssSelector("p.heading3")).getText();
		
		Assert.assertEquals(s, "Customer Registered Successfully!!!");

		String Cust_ID = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td"))
				.getText();

		driver.findElement(By.xpath("//ul[@class='menusubnav']//a[contains(text(),'Delete Customer')]")).click();

		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(Cust_ID);

		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();

		Alert confirm = driver.switchTo().alert();

		confirm.accept();

		Alert succ = driver.switchTo().alert();

		succ.accept();

		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();

	}

}
