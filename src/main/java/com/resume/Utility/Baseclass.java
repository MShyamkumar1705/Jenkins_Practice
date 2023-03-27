package com.resume.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.resume.PageObject.LogOutPage;
import com.resume.PageObject.LoginPage;
import com.resume.PageObject.Upload;

public class Baseclass {
	public WebDriverUtility wLib=new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriver driver;
	@BeforeClass
	public void launchbrowser() throws Throwable {
		 
		String browser = fLib.propertyFile("Browser");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			String url = fLib.propertyFile("url");
			 driver=new ChromeDriver();
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			 driver=new FirefoxDriver();
		}
		else {
			 driver=new InternetExplorerDriver();
		}
		
	}
	@BeforeMethod
	public void login() throws Throwable {
		
		wLib.maximizeWindow(driver);
		wLib.forPageLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.loginPage(fLib);
		Upload uP=new Upload(driver);
		uP.uploadResume();
		
	}
	@AfterMethod
	public void logOut() {
//		LogOutPage lp=new LogOutPage(driver);
//		lp.logOut();
	}

}
