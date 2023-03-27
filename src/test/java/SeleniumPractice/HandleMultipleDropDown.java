package SeleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleMultipleDropDown {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
		WebElement jobTitle = driver.findElement(By.xpath("(//div[@tabindex='0'])[1]"));
		dropDownOption(jobTitle, "DataBase Administartor");
//		WebElement vacancy = driver.findElement(By.xpath("(//div[@tabindex='0'])[2]"));
//		dropDownOption(vacancy, "senior QA Lead");
//		WebElement manager = driver.findElement(By.xpath("(//div[@tabindex='0'])[3]"));
//		dropDownOption(manager, "Linda Anderson");
		}
	public static void dropDownOption(WebElement ele,String value) {
		Select drop=new Select(ele);
		List<WebElement> allOption = drop.getOptions();
		for (WebElement option:allOption) {
			if(option.getText().equals(value)) {
				option.click();
				
			}
			
		}
	}

}
