package com.gps.qa.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{
	public static WebDriver driver;
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("before hook");
	}
	
	@After
	public void closeBrowser() /* throws Exception */{
		/*
		 * if(driver==null) { return; }
		 */
		driver.close();
		//driver=null;
	}
}
