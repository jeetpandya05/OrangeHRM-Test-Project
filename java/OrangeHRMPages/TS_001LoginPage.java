package OrangeHRMPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_001LoginPage extends BaseClass {
	
	@BeforeMethod
	public void LoginPage() {
		initialization();
	}
	@Test
	public  void TC01() {
		
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']")).isDisplayed()) {
			Assert.assertTrue(true);
		} 
			
	}
	
	@Test
	public  void TC02() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
								
	}
	
	@Test
	public  void TC03() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public  void TC04() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}

}
