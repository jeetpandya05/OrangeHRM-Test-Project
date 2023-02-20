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
		driver.findElement(By.xpath(newuserprop.getProperty("PIM"))).click();
		driver.findElement(By.xpath(newuserprop.getProperty("Add"))).click();		
	}
	
	@Test
	public void alphabeticName() {
		driver.findElement(By.xpath(newuserprop.getProperty("FirstName"))).sendKeys(newuserprop.getProperty("fname1"));
		driver.findElement(By.xpath(newuserprop.getProperty("LastName"))).sendKeys(newuserprop.getProperty("lname1"));	
		driver.findElement(By.xpath(newuserprop.getProperty("Submit"))).click();
		
		if (driver.findElement(By.xpath(newuserprop.getProperty("Success"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void alphanumericName() {
		driver.findElement(By.xpath(newuserprop.getProperty("FirstName"))).sendKeys(newuserprop.getProperty("fname2"));
		driver.findElement(By.xpath(newuserprop.getProperty("LastName"))).sendKeys(newuserprop.getProperty("lname2"));		
		driver.findElement(By.xpath(newuserprop.getProperty("Submit"))).click();
		
		if (driver.findElement(By.xpath(newuserprop.getProperty("Success"))).isDisplayed()) {
			Assert.assertTrue(false);
		}			
	}
	
	@Test
	public void numericName() {
		driver.findElement(By.xpath(newuserprop.getProperty("FirstName"))).sendKeys(newuserprop.getProperty("fname3"));
		driver.findElement(By.xpath(newuserprop.getProperty("LastName"))).sendKeys(newuserprop.getProperty("lname3"));		
		driver.findElement(By.xpath(newuserprop.getProperty("Submit"))).click();
		
		if (driver.findElement(By.xpath(newuserprop.getProperty("Success"))).isDisplayed()) {
			Assert.assertTrue(false);
		}				
	}
	
	@Test
	public void blankName() {
		driver.findElement(By.xpath(newuserprop.getProperty("FirstName"))).clear();
		driver.findElement(By.xpath(newuserprop.getProperty("LastName"))).clear();	
		driver.findElement(By.xpath(newuserprop.getProperty("Submit"))).click();
		
		if (driver.findElement(By.xpath(newuserprop.getProperty("Required"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
