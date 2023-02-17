package OrangeHRMPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TS_004CreateLoginDetails extends BaseClass {

	@BeforeMethod
	public void PIMuserloginPage() {
		initialization();
		adminLogin();
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(newuserprop.getProperty("fname1"));
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(newuserprop.getProperty("lname1"));
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
	}

	@Test
	public void TC13() {
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(createloginprop.getProperty("uname1"));
		
		try {
			if (!driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")).isDisplayed())
			{
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			System.out.println("TC13 Fail");
		}
		
		

	}
	
	@AfterMethod
	public void quit() {
		exit();
	}

}
