package com.resume.Utility;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AbsolutePathUtility {
	public WebDriver driver;
	@Test
public void absolutePath() {
	File f=new File(iPathConstant.resume);
	String absolutePath = f.getAbsolutePath();
	driver.findElement(By.xpath("//input[@id='attachCV']")).sendKeys(absolutePath);
	
}
}
