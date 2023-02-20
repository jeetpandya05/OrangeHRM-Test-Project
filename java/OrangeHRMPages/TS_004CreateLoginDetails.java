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
		driver.findElement(By.xpath(newuserprop.getProperty("PIM"))).click();
		driver.findElement(By.xpath(newuserprop.getProperty("Add"))).click();
		driver.findElement(By.xpath(newuserprop.getProperty("FirstName"))).sendKeys(newuserprop.getProperty("fname1"));
		driver.findElement(By.xpath(newuserprop.getProperty("LastName"))).sendKeys(newuserprop.getProperty("lname1"));
		driver.findElement(By.xpath(createloginprop.getProperty("createLoginSwitch"))).click();
	}

	@Test
	public void alphabeticUsername() {
		driver.findElement(By.xpath(createloginprop.getProperty("Username"))).sendKeys(createloginprop.getProperty("uname1"));

		if (driver.findElement(By.xpath(createloginprop.getProperty("error"))).isDisplayed()) {
			Assert.assertTrue(false);
		}
	}

	@AfterMethod
	public void quit() {
		exit();
	}

}
