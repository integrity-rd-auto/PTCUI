package Base; 
  
import java.io.IOException; 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager; 

  
public class TestBase { 
  
    public static WebDriver driver=null; 
  
    @BeforeSuite
    public void initialize() throws IOException {
  
    	WebDriverManager.chromedriver().setup();
    
        driver = new ChromeDriver(); 
    
        // To maximize browser 
        driver.manage().window().maximize(); 
    
        // Implicit wait 
        driver.manage().timeouts().implicitlyWait( 
             10, TimeUnit.SECONDS); 
    
        // To open Gmail site 
        driver.get("http://www.demo.guru99.com/V4/"); 
    } 
  
   /* @AfterSuite
    // Test cleanup 
    public void TeardownTest() { 
        TestBase.driver.quit(); 
    } */
} 
