package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	//Chittorgarh:
		// 1. Launch the URL https://www.chittorgarh.com/
		//2. Click on stock market
		//3. Click on NSE bulk Deals
		//4. Get all the Security names
		//5. Ensure whether there are duplicate Security names
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.chittorgarh.com/");
		
		driver.findElement(By.id("navbtn_stockmarket")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='NSE Bulk Deals'])[1]")).click();
//		WebElement tableElement = driver.findElement(By.xpath("(//table)[2]"));
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));
	   
		 List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));
		
		List<String> securityNames  = new ArrayList<String>();
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td")); 
			for(int j=0;j<columns.size();j++)
			{
				if(j==2)
				{
					securityNames.add(columns.get(j).getText());
				}
			}
		}
		
		System.out.println(securityNames);
		Set<String> securityNamesWithoutDuplicates = new LinkedHashSet<String>();
		securityNamesWithoutDuplicates.addAll(securityNames);
		System.out.println(securityNamesWithoutDuplicates);
		 driver.close();
		
	}

}
