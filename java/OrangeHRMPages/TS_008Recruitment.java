package OrangeHRMPages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_008Recruitment extends BaseClass {

	@BeforeMethod
	public void RecruitmentPage() {
		initialization();
		adminLogin();
		driver.findElement(By.xpath(recruitmentprop.getProperty("RecruitmentPage"))).click();
		driver.findElement(By.xpath(recruitmentprop.getProperty("AddButton"))).click();
	}

	@Test
	public void alphabeticName() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("FirstName")))
				.sendKeys(recruitmentprop.getProperty("fname1"));
		driver.findElement(By.xpath(recruitmentprop.getProperty("LastName")))
				.sendKeys(recruitmentprop.getProperty("lname1"));

		try {
			if (driver.findElement(By.xpath(recruitmentprop.getProperty("NameError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void alphanumericName() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("FirstName")))
				.sendKeys(recruitmentprop.getProperty("fname2"));
		driver.findElement(By.xpath(recruitmentprop.getProperty("LastName")))
				.sendKeys(recruitmentprop.getProperty("lname2"));

		if (driver.findElement(By.xpath(recruitmentprop.getProperty("NameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void numericName() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("FirstName")))
				.sendKeys(recruitmentprop.getProperty("fname3"));
		driver.findElement(By.xpath(recruitmentprop.getProperty("LastName")))
				.sendKeys(recruitmentprop.getProperty("lname3"));

		if (driver.findElement(By.xpath(recruitmentprop.getProperty("NameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void blankName() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("FirstName"))).clear();
		driver.findElement(By.xpath(recruitmentprop.getProperty("LastName"))).clear();
		driver.findElement(By.xpath(recruitmentprop.getProperty("SaveButton"))).click();

		if (driver.findElement(By.xpath(recruitmentprop.getProperty("NameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void validEmailFormat() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("Email")))
				.sendKeys(recruitmentprop.getProperty("validEmail"));

		try {
			if (driver.findElement(By.xpath(recruitmentprop.getProperty("EmailFormatError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void invalidEmailFormat() {
		driver.findElement(By.xpath(recruitmentprop.getProperty("Email")))
				.sendKeys(recruitmentprop.getProperty("invalidEmail"));

		if (driver.findElement(By.xpath(recruitmentprop.getProperty("EmailFormatError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
