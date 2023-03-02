package OrangeHRMPages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_001LoginPage extends BaseClass {
	
	@BeforeMethod
	public void LoginPage() {
		initialization();
	}
	
	@Test
	public  void validUservalidPass() {
		
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath(loginprop.getProperty("loginbutton"))).click();
		
		if (driver.findElement(By.xpath(loginprop.getProperty("dashboardPage"))).isDisplayed()) {
			Assert.assertTrue(true);
		} 		
	}
	
	@Test
	public  void validUserinvalidPass() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("validUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));
		driver.findElement(By.xpath(loginprop.getProperty("loginbutton"))).click();
		
		if (driver.findElement(By.xpath(loginprop.getProperty("invalidCredentials"))).isDisplayed()) {
			Assert.assertTrue(true);
		}							
	}
	
	@Test
	public  void invalidUservalidPass() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("validPass"));
		driver.findElement(By.xpath(loginprop.getProperty("loginbutton"))).click();
		
		if (driver.findElement(By.xpath(loginprop.getProperty("invalidCredentials"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public  void invalidUserinvalidPass() {
				
		driver.findElement(By.name("username")).sendKeys(loginprop.getProperty("invalidUser"));
		driver.findElement(By.name("password")).sendKeys(loginprop.getProperty("invalidPass"));		
		driver.findElement(By.xpath(loginprop.getProperty("loginbutton"))).click();
		
		if (driver.findElement(By.xpath(loginprop.getProperty("invalidCredentials"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
