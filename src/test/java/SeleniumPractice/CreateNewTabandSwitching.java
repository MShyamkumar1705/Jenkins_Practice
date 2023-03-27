package SeleniumPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewTabandSwitching {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("window.open()","");
		ArrayList<String>tab=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0));
		driver.get("https://naukri.com/");
		driver.switchTo().window(tab.get(1));
		driver.navigate().to("https://amazon.in//");
		driver.quit();

		
		
		  
	}

}
