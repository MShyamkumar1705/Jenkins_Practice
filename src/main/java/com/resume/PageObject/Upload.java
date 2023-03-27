package com.resume.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.resume.Utility.AbsolutePathUtility;

public class Upload {
	@FindBy(xpath="//a[contains(text(),'Complete')]")
	private WebElement profile;
	
	@FindBy(xpath="//input[@id='attachCV']")
	private WebElement upload;

	public Upload(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getUpload() {
		return upload;
	}
	public void uploadResume() {
		profile.click();
		upload.click();
		AbsolutePathUtility aLib=new AbsolutePathUtility();
		aLib.absolutePath();
	}
}
