package OrangeHRMPages;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_006AssignLeavetoEmployee extends BaseClass {
	
	@BeforeMethod
	public void AssignLeavePage() {
		initialization();
		adminLogin();
		driver.findElement(By.xpath(assignleaveprop.getProperty("AssignLeavePage"))).click();
	}
	
	@Test
	public void employeeNameisShown() throws InterruptedException {
		driver.findElement(By.xpath(assignleaveprop.getProperty("employeeNameDropdown"))).sendKeys(assignleaveprop.getProperty("name"));
		Thread.sleep(3000);

		if (driver.findElement(By.xpath(assignleaveprop.getProperty("employeeNameSelect"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankEmployeeName() {
		driver.findElement(By.xpath(assignleaveprop.getProperty("employeeNameDropdown"))).clear();
		driver.findElement(By.xpath(assignleaveprop.getProperty("AssignButton"))).click();
		
		if (driver.findElement(By.xpath(assignleaveprop.getProperty("EmployeeError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void leaveTypeSelect() {
		driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveTypeDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("USPersonal"))).click();
		
		if (driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveBalance"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankLeaveType() {
		driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveTypeDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("AssignButton"))).click();
		
		if (driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void leaveDateSelect() {
		driver.findElement(By.xpath(assignleaveprop.getProperty("FromDateDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveDate"))).click();
		
		driver.findElement(By.xpath(assignleaveprop.getProperty("ToDateDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveDate"))).click();
		
		if (driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveDuration"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankLeaveDate() {
		driver.findElement(By.xpath(assignleaveprop.getProperty("FromDateDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("ToDateDropdown"))).click();
		driver.findElement(By.xpath(assignleaveprop.getProperty("AssignButton"))).click();
		
		if (driver.findElement(By.xpath(assignleaveprop.getProperty("LeaveError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
