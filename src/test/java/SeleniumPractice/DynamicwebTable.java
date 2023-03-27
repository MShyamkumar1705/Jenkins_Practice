package SeleniumPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicwebTable {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.opencart.com/admin/");
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//button[@type='button']/ancestor::div[@id='modal-security']/descendant::div[@class='modal-content']/descendant::button[@class='btn-close']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollDown", "");
		
		String text=driver.findElement(By.xpath("//div[.='Showing 1 to 10 of 80 (8 Pages)']")).getText();
		System.out.println(text);
		
		int total_pages=Integer.valueOf(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		System.out.println(total_pages);
		
		for (int i = 1; i <total_pages; i++) {
			WebElement active_Page = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println(active_Page.getText());
			
			int row = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println(row);
			for (int j =1; j <row; j++) {
				String id = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[4]")).getText();
				String name = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[5]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[6]")).getText();
			
				System.out.println(id+ " " +name+ " " +status);
				
			}
			
			String p=Integer.toString(i+1);
			driver.findElement(By.xpath("//div[@class='col-sm-6 text-start']//li/a[.='"+p+"']")).click();
			
		}
		driver.close();
	
		}
	}


