package OrangeHRMPages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TS_001LoginPage extends BaseClass {

	
	
	@Test
	public  void TC01() throws IOException {
		
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).isDisplayed();
			
	}
	
	@Test
	public  void TC02() throws IOException {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed();
						
	}
	
	@Test
	public  void TC03() throws IOException {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed();
						
	}
	
	@Test
	public  void TC04() throws IOException {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed();
						
	}

}
