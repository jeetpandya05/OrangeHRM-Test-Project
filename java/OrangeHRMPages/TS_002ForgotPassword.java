package OrangeHRMPages;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_002ForgotPassword extends BaseClass {
	
	
	@BeforeMethod
	public void LoginPage() {
		initialization();
	}
	
	@Test
	public void validUsername() {
		
		driver.findElement(By.xpath(forgotpassprop.getProperty("forgotPassword"))).click();
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user1"));
		driver.findElement(By.xpath(forgotpassprop.getProperty("resetbutton"))).click();
		
		if (driver.findElement(By.xpath(forgotpassprop.getProperty("resetSuccessful"))).isDisplayed()) 
		{
			Assert.assertTrue(true);
		}
	}
	
	
	@Test
	public void randomUsername() {
		
		driver.findElement(By.xpath(forgotpassprop.getProperty("forgotPassword"))).click();
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user2"));
		driver.findElement(By.xpath(forgotpassprop.getProperty("resetbutton"))).click();
		
		if (driver.findElement(By.xpath(forgotpassprop.getProperty("resetSuccessful"))).isDisplayed()) 
		{
			Assert.assertTrue(false);
		}		
	}
	
	@Test
	public void numericUsername() {
		
		driver.findElement(By.xpath(forgotpassprop.getProperty("forgotPassword"))).click();
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user3"));
		driver.findElement(By.xpath(forgotpassprop.getProperty("resetbutton"))).click();
		
		if (driver.findElement(By.xpath(forgotpassprop.getProperty("resetSuccessful"))).isDisplayed()) 
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void specialcharUsername() {
		
		driver.findElement(By.xpath(forgotpassprop.getProperty("forgotPassword"))).click();	
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user4"));
		driver.findElement(By.xpath(forgotpassprop.getProperty("resetbutton"))).click();
		
		if (driver.findElement(By.xpath(forgotpassprop.getProperty("resetSuccessful"))).isDisplayed()) 
		{
			Assert.assertTrue(false);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
