package OrangeHRMPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public static WebDriver driver;
	public Properties loginprop;
	public Properties forgotpassprop;
	
	@BeforeClass
	public void userData() throws IOException {
		FileInputStream loginfile = new FileInputStream("./src/test/java/PropertiesFiles/login.properties");
		loginprop = new Properties();
		loginprop.load(loginfile);
		
		FileInputStream forgotpassfile = new FileInputStream("./src/test/java/PropertiesFiles/forgotpass.properties");
		forgotpassprop = new Properties();
		forgotpassprop.load(forgotpassfile);
	}
	
	@BeforeMethod
	public void initialization() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(loginprop.getProperty("url"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	

	@AfterMethod
	public void exit() {
		driver.quit();
	}
	
}
