package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;

	public static Properties prop;

	public static FileInputStream ip;

	public TestBase() {
		prop = new Properties();

		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Config\\config.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void initialize() {

		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		// To maximize browser
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// To open site
		driver.get(prop.getProperty("url"));
	}


	 @AfterSuite // Test cleanup 
	 public void TeardownTest()
	 {
	  TestBase.driver.quit(); 
	  }
	
}
