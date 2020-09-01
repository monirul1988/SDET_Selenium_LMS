package TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Initialize;

public class NewTest3 extends Initialize {
	
	@Test(priority = 1)
	public void ContactUsModuleVerify() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='main-navigation']/ul[@id='primary-menu']/li[4]")).click();

		driver.findElement(By.xpath("//form[@id='wpforms-form-8']/div/div[1]/input[@name='wpforms[fields][0]']"))
				.sendKeys("Test");

		driver.findElement(By.xpath("//form[@id='wpforms-form-8']/div/div[2]/input[@name='wpforms[fields][1]']"))
				.sendKeys("abc@gmail.com");

		driver.findElement(By.xpath("//form[@id='wpforms-form-8']/div/div[4]/textarea[@name='wpforms[fields][2]']"))
				.sendKeys("message");

		driver.findElement(By.xpath("//form[@id='wpforms-form-8']/div[3]/button[@type='submit']")).click();

		Thread.sleep(5000);

		String contactmessage = "Thanks for contacting us! We will be in touch with you shortly.";

		boolean present = driver
				.findElement(By.xpath(
						"//p[contains(text(),'Thanks for contacting us! We will be in touch with you shortly.')]"))
				.isDisplayed();

		Assert.assertEquals(true, present);

	}
}


