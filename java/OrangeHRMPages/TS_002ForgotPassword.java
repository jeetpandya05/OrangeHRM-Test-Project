package OrangeHRMPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TS_002ForgotPassword extends BaseClass {
	
	@Test
	public void TC05() throws IOException {
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user1"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//h6[text()='Reset Password link sent successfully']")).isDisplayed();
	}
	
	
	@Test
	public void TC06() {
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user2"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Required']")).isDisplayed();
	}
	
	@Test
	public void TC07() {
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user3"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Required']")).isDisplayed();
	}
	
	@Test
	public void TC08() {
		
		driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
		
		driver.findElement(By.name("username")).sendKeys(forgotpassprop.getProperty("user4"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Required']")).isDisplayed();
	}
}
