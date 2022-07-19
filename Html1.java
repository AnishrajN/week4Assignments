package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		WebElement table = driver.findElement(By.xpath("(//table)[1]"));
	
		
		//2. Get the count of number of rows
		 List<WebElement> rows = table.findElements(By.xpath("(//table)[1]//tbody//tr")) ;
		 System.out.println("Number of Rows are : "+rows.size());
		 
		//3. Get the count of number of columns
		List<WebElement> columns = table.findElements(By.xpath("(//table)[1]//tbody//tr//td"));
		System.out.println("Number of Columns are : "+columns.size());

	}
    
}
