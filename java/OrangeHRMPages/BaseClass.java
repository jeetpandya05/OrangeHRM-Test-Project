package OrangeHRMPages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public Properties loginprop;
	public Properties forgotpassprop;
	public Properties newuserprop;
	public Properties createloginprop;

	@BeforeClass
	public void userData() throws IOException {
		FileInputStream loginfile = new FileInputStream("./src/test/java/PropertiesFiles/login.properties");
		loginprop = new Properties();
		loginprop.load(loginfile);

		FileInputStream forgotpassfile = new FileInputStream("./src/test/java/PropertiesFiles/forgotpass.properties");
		forgotpassprop = new Properties();
		forgotpassprop.load(forgotpassfile);

		FileInputStream newuserfile = new FileInputStream("./src/test/java/PropertiesFiles/newuser.properties");
		newuserprop = new Properties();
		newuserprop.load(newuserfile);

		FileInputStream createloginfile = new FileInputStream("./src/test/java/PropertiesFiles/createlogin.properties");
		createloginprop = new Properties();
		createloginprop.load(createloginfile);
	}
	
	public void initialization() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(loginprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void adminLogin() {
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath(loginprop.getProperty("loginbutton"))).click();
	}

	public void exit() {
		driver.quit();
	}
}
