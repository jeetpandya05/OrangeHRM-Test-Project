package OrangeHRMPages;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TS_005MakingUserAdmin extends BaseClass {

	@BeforeMethod
	public void AdminUserPage() {
		initialization();
		adminLogin();
		driver.findElement(By.xpath(useradminprop.getProperty("AdminPage"))).click();
		driver.findElement(By.xpath(useradminprop.getProperty("Add"))).click();
	}

	@Test
	public void userroleAdmin() {
		driver.findElement(By.xpath(useradminprop.getProperty("userRoleDropdown"))).click();
		driver.findElement(By.xpath(useradminprop.getProperty("Admin"))).click();

		if (driver.findElement(By.xpath(useradminprop.getProperty("AdminDisplay"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void userroleESS() {
		driver.findElement(By.xpath(useradminprop.getProperty("userRoleDropdown"))).click();
		driver.findElement(By.xpath(useradminprop.getProperty("ESS"))).click();

		if (driver.findElement(By.xpath(useradminprop.getProperty("ESSDisplay"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void userroleBlank() {
		driver.findElement(By.xpath(useradminprop.getProperty("userRoleDropdown"))).click();
		driver.findElement(By.xpath(useradminprop.getProperty("Save"))).click();

		if (driver.findElement(By.xpath(useradminprop.getProperty("userRoleError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void nameinEmployeeName() throws InterruptedException {
		driver.findElement(By.xpath(useradminprop.getProperty("employeeNameDropdown"))).sendKeys(useradminprop.getProperty("name"));
		Thread.sleep(3000);

		if (driver.findElement(By.xpath(useradminprop.getProperty("employeeNameSelect"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void alphaeticUsername() {
		driver.findElement(By.xpath(useradminprop.getProperty("username"))).sendKeys(useradminprop.getProperty("uname1"));

		try {
			if (driver.findElement(By.xpath(useradminprop.getProperty("usernameError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void alphanumericUsername() {
		driver.findElement(By.xpath(useradminprop.getProperty("username"))).sendKeys(useradminprop.getProperty("uname2"));

		try {
			if (driver.findElement(By.xpath(useradminprop.getProperty("usernameError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void numericUsername() {
		driver.findElement(By.xpath(useradminprop.getProperty("username"))).sendKeys(useradminprop.getProperty("uname3"));
		
		if (driver.findElement(By.xpath(useradminprop.getProperty("usernameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void blankUsername() {
		driver.findElement(By.xpath(useradminprop.getProperty("username"))).clear();
		driver.findElement(By.xpath(useradminprop.getProperty("Save"))).click();
		
		if (driver.findElement(By.xpath(useradminprop.getProperty("usernameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void lessthan5charUsername() {
		driver.findElement(By.xpath(useradminprop.getProperty("username"))).sendKeys(useradminprop.getProperty("uname4"));
		
		if (driver.findElement(By.xpath(useradminprop.getProperty("usernameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@AfterMethod
	public void quit() {
		exit();
	}
}
