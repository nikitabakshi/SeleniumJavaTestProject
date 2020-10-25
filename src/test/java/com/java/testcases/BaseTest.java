package com.java.testcases;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.java.appconstants.Constants.ReadProperties;
import com.java.pages.Page;
import com.java.util.WebDriverFactory;

public class BaseTest {

	public WebDriverWait wait;
	public Page page;

	static Logger logger = Logger.getLogger(BaseTest.class.getName());
	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

		WebDriver driver = null;
		if (browser.toLowerCase().contains("firefox")) {
			driver = new FirefoxDriver();

		}
		if (browser.toLowerCase().contains("internet")) {
			driver = new InternetExplorerDriver();

		}
		if (browser.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikita.bakshi\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		WebDriverFactory.setWebDriver(driver);
		driver = WebDriverFactory.getDriver();
		driver.get(ReadProperties.URL);
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
		page = new Page(driver);

	}

	@AfterMethod
	public void tearDown() {

		WebDriverFactory.getDriver().close();

	}
}
