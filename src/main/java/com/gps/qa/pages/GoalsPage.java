package com.gps.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gps.qa.base.TestBase;

public class GoalsPage extends TestBase {

	@FindBy(xpath="//input[@value='Saumyas']")
	@CacheLookup
	WebElement goalUser;
	
	@FindBy(xpath="//span[text()='Goals']")
	WebElement goalLink;
	
	@FindBy(id="dgGoals_ctl02_chkStatus")
	WebElement goalCheck1;
	
	@FindBy(id="ucAddGoal_txtAddGoal")
	WebElement addGoalTextArea;
	
	//initialize
	public GoalsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String checkTitle(){
		//System.out.println(driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean userValidate() {
		return goalUser.isDisplayed();
	}
	
	public GoalsPage navigateToGoals() {
		goalLink.click();
		return new GoalsPage();
	}
	
	public void updateGoals() {
		goalCheck1.click();
	}
	
	public void addingGoalDesc(String desc, String topic) {
		addGoalTextArea.clear();
		addGoalTextArea.click();
		addGoalTextArea.sendKeys(desc, topic);
	}
}
