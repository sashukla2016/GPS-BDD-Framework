package com.gps.qa.stepDefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class AddGoalStepDefinition {
	WebDriver driver=Hooks.driver;
	String goalAdded;
	WebDriverWait wait;

	@Given("^User successfully logs in$")
	public void user_successfully_logs_in() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\poi-4.1.0\\WebDriver\\chromedriver.exe"); driver = new ChromeDriver();
		 */
		wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("http://www.ourgoalplan.com");

		driver.findElement(By.id("txtName")).sendKeys("saumyas");
		driver.findElement(By.id("txtPassword")).sendKeys("Saumya@12");

		driver.findElement(By.id("btnLogin")).click();

	}

	@When("^User navigates to GoalSheet$")
	public void user_navigates_to_GoalSheet() {
		WebElement goals=driver.findElement(By.xpath("//a[text()='Goals']"));
		goals.click();
		driver.findElement(By.xpath("//span[text()='GoalSheet of ']"));
	}

	//SCENARIO 1
	@Given("^Navigates to add goal$")
	public void navigates_to_add_goal() {
		driver.findElement(By.id("ucAddGoal_txtAddGoal")).isDisplayed();
	}

	@When("^I add a Goal$")
	public void i_add_a_Goal(DataTable goal) throws InterruptedException {


		//Data table
		/*
		 * for(Map<String, String> data: goal.asMaps(String.class, String.class)) {
		 * WebElement goalTextBox=driver.findElement(By.id("ucAddGoal_txtAddGoal"));
			goalTextBox.clear();
			goalTextBox.click();
		 * goalTextBox.sendKeys(data.get("Add Goal"));
		 * driver.findElement(By.id("ucAddGoal_btnAddGoal")).click();
		 * goalAdded=data.get("Add Goal");
		 * }
		 */
		//Data table : list as maps

		List<Map<String, String>> lData=goal.asMaps(String.class, String.class);
		for(int i=0;i<lData.size();i++) {
			Thread.sleep(3000);
			WebElement goalTextBox=driver.findElement(By.id("ucAddGoal_txtAddGoal"));
			goalTextBox.clear();
			goalTextBox.click();
			goalTextBox.sendKeys(lData.get(i).get("Add Goal"));
			driver.findElement(By.id("ucAddGoal_btnAddGoal")).click();
			goalAdded=lData.get(i).get("Add Goal");
		}

	}

	@Then("^Verify Goal is added to the GoalSheet$")
	public void verify_Goal_is_added_to_the_GoalSheet() {
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[text()='"+goalAdded+"']"));
		//driver.close();
	}

	//SCENARIO 2
	@Given("^Navigates to status$")
	public void navigates_to_status() {
		driver.findElement(By.xpath("//td[contains(text(),'Status')]")).isDisplayed();

	}

	@When("^I update a goal$")
	public void i_update_a_goal() {

		driver.findElement(By.xpath("//table[@id='dgGoals']/tbody/tr[1]/following-sibling::tr")).isDisplayed();

		List<WebElement> goalList = driver.findElements(By.xpath("//input[starts-with(@id,'dgGoals_ct') and contains(@id,'chkStatus')]")); 
		//int num=goalList.size();

		for(WebElement goal: goalList) {
			goal.click();
		}

		driver.findElement(By.id("btnUpdate")).click();
	}

	@Then("^Goal is updated successfully$")
	public void goal_is_updated_successfully()  {
		List<WebElement> goalList = driver.findElements(By.xpath("//input[starts-with(@id,'dgGoals_ct') and contains(@id,'chkStatus')]")); 
		//int num=goalList.size();

		for(WebElement goal: goalList) {
			String msg="";
			boolean status=goal.isEnabled();

			if(status==true) {
				msg="not updated successfully";
				System.out.println(msg);
				Assert.assertEquals(msg, "", msg);
			}
		}
	}

	//SCEANRIO 3
	@Given("^I am at notes section$")
	public void i_am_at_notes_section() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Notes')]")));
			driver.findElement(By.xpath("//td[contains(text(),'Notes')]")).isDisplayed();

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[@id='dgGoals']/tbody/tr[1]/following-sibling::tr")));
			driver.findElement(By.xpath("//table[@id='dgGoals']/tbody/tr[1]/following-sibling::tr")).isDisplayed();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}

	}

	@When("^I add notes against a goal$")
	public void i_add_notes_against_a_goal(DataTable notes){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[starts-with(@id,'dgGoals_ct') and contains(@id,'txtNotes')]")));
		
		List<WebElement> notesList=driver.findElements(By.xpath("//input[starts-with(@id,'dgGoals_ct') and contains(@id,'txtNotes')]"));
		for(WebElement note:notesList) {
			List<Map<String, String>> testData=notes.asMaps(String.class, String.class);
			
			for(int i=0;i<testData.size();i++) {
				note.click();
				note.clear();
				note.sendKeys(testData.get(i).get("Notes"));
			}
		}
		
	}

	@Then("^Notes are added successfully$")
	public void notes_are_added_successfully() {

	}

}
