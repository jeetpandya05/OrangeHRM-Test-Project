package OrangeHRMPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_003AddNewUser extends BaseClass {
	
	
	@BeforeMethod
	public void PIMpage() {	
		initialization();
		adminLogin();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();		
	}
	
	@Test
	public void TC09() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(newuserprop.getProperty("fname1"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(newuserprop.getProperty("lname1"));	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[text()='Success']")).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void TC10() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(newuserprop.getProperty("fname2"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(newuserprop.getProperty("lname2"));		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[text()='Success']")).isDisplayed()) {
			Assert.assertTrue(false);
		}			
	}
	
	@Test
	public void TC11() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(newuserprop.getProperty("fname3"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(newuserprop.getProperty("lname3"));		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//p[text()='Success']")).isDisplayed()) {
			Assert.assertTrue(false);
		}				
	}
	
	@Test
	public void TC12() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).clear();	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if (driver.findElement(By.xpath("//span[text()='Required']")).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
