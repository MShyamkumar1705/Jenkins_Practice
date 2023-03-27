package SeleniumPractice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleSingleDropDown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.opencart.com/admin/");
		driver.findElement(By.xpath("//a[.='OpenCart']")).click();
		WebElement dropDown = driver.findElement(By.id("input-country"));
		Select sel=new Select(dropDown);
		List<WebElement> drop = sel.getOptions();
		for (WebElement option : drop) {
			if (option.equals("India")) {
				option.click();
			}
			
		}
	driver.close();
	}

}
