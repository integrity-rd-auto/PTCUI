package TestUtility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadingDataFromExcel {

	public static WebDriver driver = null;

	
	 public static void main(String[] args) throws IOException { readExcel(); }
	 
	public static void readExcel() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.demo.guru99.com/V4/");

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr249314");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tUgErAh");

		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'New Customer')]")).click();

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Demo");
		int noOfRows = sheet.getLastRowNum();

		for (int row = 1; row < 3; row++) {
			XSSFRow current_row = sheet.getRow(row);
			String Customer_name = current_row.getCell(0).getStringCellValue();
			String dob = current_row.getCell(1).getStringCellValue();
			String Address = current_row.getCell(2).getStringCellValue();
			String City = current_row.getCell(3).getStringCellValue();
			String State = current_row.getCell(4).getStringCellValue();
			String PIN = current_row.getCell(5).getStringCellValue();
			String Mobile_Num = current_row.getCell(6).getStringCellValue();
			String Email = current_row.getCell(7).getStringCellValue();
			String Password = current_row.getCell(7).getStringCellValue();

			System.out.println(dob);

			System.out.println(Password);

			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Customer_name);
			driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);
			driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(Address);
			driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(dob);
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(City);
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(State);
			driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(PIN);
			driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(Mobile_Num);
			driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);

			driver.findElement(By.xpath("//input[@name='sub']")).click();

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

}
