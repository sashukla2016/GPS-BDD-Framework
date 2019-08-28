package com.gps.qa.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginScenarioOutlineExample {

	WebDriver driver=Hooks.driver;

	@Given("^I am on the application login page$")
	public void i_am_on_the_application_login_page() {
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe"); driver = new ChromeDriver();
		 */	
				driver.get("http://www.ourgoalplan.com"); }


	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_the_and(String username, String password) {
		driver.findElement(By.id("txtName")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password); }


	@Then("^I should be navigated to home page$")
	public void i_should_be_navigated_to_home_page() {

		driver.findElement(By.id("btnLogin")).click(); 
		//driver.close();
		}

}
