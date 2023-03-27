package com.resume.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
@FindBy(xpath="//div[@class='nI-gNb-drawer__bars']")
private WebElement bar;

@FindBy(xpath="//a[@title='Logout']")
private WebElement logout;

public LogOutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getBar() {
	return bar;
}

public WebElement getLogout() {
	return logout;
}
public void logOut() {
	bar.click();
	logout.click();
}
}
