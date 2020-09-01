package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Initialize {

	public static WebDriver driver;

	@BeforeTest

	public void initializeDriver() throws IOException {

		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir"));
		FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		prop.load(path);

		// System.out.println(System.getProperty("user.dir")+"\\config.properties");
		String broswer = prop.getProperty("broswer");

		System.out.println(broswer);

		if (broswer == "firefox") {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		driver.get(prop.getProperty("URL"));

	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
