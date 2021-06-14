package com.shashank.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.shashank.utils.ConfigsReader;
import com.shashank.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * This method will create a driver and return it
	 * 
	 * @return WebDriver driver
	 */
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		
		switch(ConfigsReader.getProperty("browser").toLowerCase()){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported!");
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));

		// we initialize all the page elements of the classes in package com.neotech.pages
		PageInitializer.initialize();

		return driver;
	}

	/**
	 * This method will quit the browser
	 */
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}