package OrangeHRMPages;


import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		try {
			if (driver.findElement(By.xpath(createloginprop.getProperty("unameError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void alphaNumericUsername() {
		driver.findElement(By.xpath(createloginprop.getProperty("Username"))).sendKeys(createloginprop.getProperty("uname2"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		try {
			if (driver.findElement(By.xpath(createloginprop.getProperty("unameError"))).isDisplayed()) {
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Test
	public void numericUsername() {
		driver.findElement(By.xpath(createloginprop.getProperty("Username"))).sendKeys(createloginprop.getProperty("uname3"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("unameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void blankUsername() {
		driver.findElement(By.xpath(createloginprop.getProperty("Username"))).clear();
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("unameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void lessthan5charUsername() {
		driver.findElement(By.xpath(createloginprop.getProperty("Username"))).sendKeys(createloginprop.getProperty("uname4"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("unameError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void alphabeticPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass1"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("passError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void alphaNumericPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass2"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("passError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void requiredPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass3"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		try {
			if (driver.findElement(By.xpath(createloginprop.getProperty("passError"))).isDisplayed()) {
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void blankPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).clear();
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("passError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void lessthan7charPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass4"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("passError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void blankConfirmPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("ConfirmPassword"))).clear();
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();

		if (driver.findElement(By.xpath(createloginprop.getProperty("confirmpassError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void wrongConfirmPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass3"));
		driver.findElement(By.xpath(createloginprop.getProperty("ConfirmPassword"))).sendKeys(createloginprop.getProperty("cpass1"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();
		
		if (driver.findElement(By.xpath(createloginprop.getProperty("confirmpassError"))).isDisplayed()) {
			Assert.assertTrue(true);
		}		
	}
	
	@Test
	public void rightConfirmPassword() {
		driver.findElement(By.xpath(createloginprop.getProperty("Password"))).sendKeys(createloginprop.getProperty("pass3"));
		driver.findElement(By.xpath(createloginprop.getProperty("ConfirmPassword"))).sendKeys(createloginprop.getProperty("cpass2"));
		driver.findElement(By.xpath(createloginprop.getProperty("save"))).click();
		
		try {
			if (driver.findElement(By.xpath(createloginprop.getProperty("confirmpassError"))).isDisplayed()) {
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}

	@AfterMethod
	public void quit() {
		exit();
	}
}
