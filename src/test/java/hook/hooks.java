package hook;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import UtilityPackage.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	
    public static WebDriver driver;
	ConfigReader ConfigRead;
	
@Before
public void user_launch_google_chrome() {
	ConfigRead=new ConfigReader();
	System.setProperty("webdriver.chrome.driver",ConfigRead.getDriverPath());
	driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().getPageLoadTimeout();
	driver.manage().window().maximize();
		

	}	
	@After 
	public void teardown() {
		System.out.println("closing");
		 //driver.close();
		 driver.quit();
		}

}
