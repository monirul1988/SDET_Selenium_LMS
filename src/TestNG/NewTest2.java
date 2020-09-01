package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Initialize;

public class NewTest2  extends Initialize {
	

	@Test(priority = 5)
	public void MyaccountLoginVerify() throws InterruptedException {

		String expectedmyaccount = driver
				.findElement(By.xpath("//div[@class='main-navigation']/ul[@id='primary-menu']/li[5]")).getText();
		System.out.println(expectedmyaccount);
		Assert.assertEquals("My Account", expectedmyaccount);
	}

	@Test(dependsOnMethods={"MyaccountLoginVerify"})
	public void MyaccountloginAccessVerify() throws InterruptedException {

		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@class='main-navigation']/ul[@id='primary-menu']/li[5]")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//a[@href='#login']")).click();
		driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
		driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		boolean b = driver.findElement(By.xpath("//a[@class='ld-profile-edit-link']")).isDisplayed();

		Thread.sleep(5000);

		Assert.assertEquals(true, b);
	}
}
