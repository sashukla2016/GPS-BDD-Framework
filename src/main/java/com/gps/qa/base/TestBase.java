/*
 * @Author Saumya Shukla
 */

package com.gps.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gps.qa.util.TestUtil;

public class TestBase {
//this is a base class
	public static WebDriver driver;
	public static Properties prop;
	//public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			
			FileInputStream ip=new FileInputStream("C:\\Users\\Saumya\\SeleniumAutomation\\GPSBDDFramework\\src"+
			"\\main\\java\\com\\gps\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			// for file input stream
			e.printStackTrace();
		} catch (IOException e) {
			// for prop.load
			e.printStackTrace();
		}
		
				
	}

	public static void init() {
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\poi-4.1.0\\WebDriver\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
}
