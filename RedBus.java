package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {
	/*Launch the url https://www.redbus.in/
		Enter From -Madiwala Bangalore
		Enter To Koyambedu Chennai
		Select the Date 10-Jun-2022
		Click Search buses
		Click After 6pm under Departure time
		Click Sleeper under Bus types
		Select the Primo
		Get the number of buses found
		Get the Bus fare and sort them in ascending order
		Close the application */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		1.	Launch the url https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		
//		2.	Enter From -Madiwala Bangalore
		WebElement from = driver.findElement(By.id("src"));
		from.sendKeys("Madiwala Bangalore");
		
//		3.	Enter To Koyambedu Chennai
		WebElement to = driver.findElement(By.id("dest"));
		to.sendKeys("Koyambedu Chennai");
		
//		4.	Select the Date 10-Jun-2022
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.tagName("table"));
		driver.findElement(By.xpath("//td[text()='26']")).click();
	
//		5.	Click Search buses
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
		driver.findElement(By.id("search_btn")).click();
		
//		6.	Click After 6pm under Departure time
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
	    driver.switchTo().window(list.get(0));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//li[@class='checkbox']//label[@for='dtAfter 6 pm'][2]")).click();
		//driver.findElement(By.xpath("//div[@class='details']//li[@class='checkbox'][4]")).click();
		driver.findElement(By.xpath("(//label[@for='dtAfter 6 pm'])[2]")).click();
		
		
//		7.	Click Sleeper under Bus types
		driver.findElement(By.xpath("(//label[@class='custom-checkbox'])[6]")).click();
		
//		8.	Select the Primo
		driver.findElement(By.xpath("(//li[@class='bannerTiles fl'])[1]")).click();
		
//		9.	Get the number of buses found
		String noOfBuses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();	
		System.out.println("No of buses = " +noOfBuses);
		
//		10.	Get the Bus fare and sort them in ascending order
		List<WebElement> busFare = driver.findElements(By.xpath("//span[@class='f-bold f-19']"));	
		int size = busFare.size();
		System.out.println("List of bus fare");
		for (int i = 0; i<size ; i++) {
			
			String fare = busFare.get(i).getText();	
			System.out.println(fare);
		}
		
		
//		11.	Close the application
		driver.close();
		
		
		
		
		
	}

}
