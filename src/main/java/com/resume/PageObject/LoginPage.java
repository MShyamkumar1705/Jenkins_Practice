 package com.resume.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.resume.Utility.FileUtility;

public class LoginPage {
	
	@FindBy (xpath="//input[@id='usernameField']")
	private WebElement user;
	
	@FindBy (xpath="//input[@id='passwordField']")
	private WebElement password;
	
	@FindBy (xpath="//button[.='Login']")
	private WebElement login;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getUser() {
		return user;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	public void loginPage(FileUtility fLib) throws Throwable {
		String un=fLib.propertyFile("emailId");
		String pwd=fLib.propertyFile("password");
		user.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
	}

}
