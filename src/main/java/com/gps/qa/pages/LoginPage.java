package com.gps.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gps.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory: OR
	@FindBy(id="txtName")
	WebElement username;
	
	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//Page Object initialization
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public GoalsPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new GoalsPage();
	}

}
