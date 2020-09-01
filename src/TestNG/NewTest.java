package TestNG;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Initialize;

public class NewTest extends Initialize {

	// public WebDriver driver;

	String Expected = "Alchemy LMS – An LMS Application";
	String Heading = "Learn from Industry Experts";
	String firstInfoBoxTitle = "Actionable Training";
	String secondmostpopularcourse = "Email Marketing Strategies";
	String finalstatus = "Complete";

	@Test(priority = 1)
	public void titleVerify() throws IOException {

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String ActualTitle = driver.getTitle();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// System.out.println(driver.getTitle());
		Assert.assertEquals(ActualTitle, Expected);
	}

	@Test(priority = 2)

	public void HeadingVerify() throws IOException {
		String ExpectedHeading = driver.findElement(By.cssSelector("h1.uagb-ifb-title")).getText();
		System.out.println(ExpectedHeading);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(Heading, ExpectedHeading);

	}

	@Test(priority = 3)
	public void FirstInfoboxVerify() throws InterruptedException {

		String ExpectedFirstbox = driver.findElement(By.cssSelector(
				"#uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810 > div > div > div > div.uagb-ifb-title-wrap > h3"))
				.getText();

		Thread.sleep(5000);
		System.out.println(ExpectedFirstbox);
		Assert.assertEquals(firstInfoBoxTitle, ExpectedFirstbox);
	}

	@Test(priority = 4)
	public void SecondMostPopularcourseVerify() throws InterruptedException {

		String expectedsecondmostpopularcourse = driver
				.findElement(By
						.xpath("//*[@class='ld-course-list-items row']/div[2]/article/div[2]/h3[@class='entry-title']"))
				.getText();
		System.out.println(expectedsecondmostpopularcourse);
		Assert.assertEquals(secondmostpopularcourse, expectedsecondmostpopularcourse);
	}

	

	@Test(priority = 5)
	public void NumberOfCourseVerify() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='main-navigation']/ul[@id='primary-menu']/li[2]")).click();

		int numberofcourse = driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div")).size();

		System.out.println("Available number of course is " + numberofcourse);

	}

	

	@Test(priority = 9)
	public void SompletelessionVerify() throws InterruptedException {

		int numberofcourse = driver.findElements(By.xpath(
				"//div[@class='ld-course-list-items row']/div[@class='ld_course_grid col-sm-8 col-md-4 ']/article[contains(@id,'post')]/div[contains(@class,'ld_course_grid_price')]"))
				.size();

		System.out.println(numberofcourse);
		
		
		for (int i = 0; i < numberofcourse; i++) {
			
			String status = driver.findElement(By.xpath(
					"//div[@class='ld-course-list-items row']/div[@class='ld_course_grid col-sm-8 col-md-4 ']/article[contains(@id,'post')]/div[contains(@class,'ld_course_grid_price')]"))
					.getText();

			
			System.out.println(status);
		

			Assert.assertEquals(false, status.equals("completed"));

		}
	}
}