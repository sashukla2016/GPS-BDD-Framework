package com.gps.qa.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class LoginStepDefiniton {

	WebDriver driver=Hooks.driver;

	@Given("^launch the browser and open the application$")
	public void launch_the_browser_and_open_the_application() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		driver.get("http://www.ourgoalplan.com");
		
	}


	@When("^user enters the credentials$") 
	public void user_enters_the_credentials() {
		driver.findElement(By.id("txtName")).sendKeys("saumyas");
		driver.findElement(By.id("txtPassword")).sendKeys("Saumya@12"); }


	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws InterruptedException {
		
		driver.findElement(By.id("btnLogin")).click();
	}

}
