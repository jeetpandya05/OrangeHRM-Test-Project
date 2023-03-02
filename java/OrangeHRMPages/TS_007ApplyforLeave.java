package OrangeHRMPages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_007ApplyforLeave extends BaseClass {
	
	@BeforeMethod
	public void ApplyLeavePage() {
		initialization();
		adminLogin();
		driver.findElement(By.xpath(applyleaveprop.getProperty("ApplyLeavePage"))).click();
	}
	
	@Test
	public void leaveTypeSelect() {
		driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveTypeDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("USPersonal"))).click();
		
		if (driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveBalance"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankLeaveType() {
		driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveTypeDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("ApplyButton"))).click();
		
		if (driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void leaveDateSelect() {
		driver.findElement(By.xpath(applyleaveprop.getProperty("FromDateDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveDate"))).click();
		
		driver.findElement(By.xpath(applyleaveprop.getProperty("ToDateDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveDate"))).click();
		
		if (driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveDuration"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankLeaveDate() {
		driver.findElement(By.xpath(applyleaveprop.getProperty("FromDateDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("ToDateDropdown"))).click();
		driver.findElement(By.xpath(applyleaveprop.getProperty("ApplyButton"))).click();
		
		if (driver.findElement(By.xpath(applyleaveprop.getProperty("LeaveError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
