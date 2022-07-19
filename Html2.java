package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.xpath("(//table)[1]"));
		
		// 2. You have to print the respective values based on given Library
	//	(hint: if the library was absolute usage, then print all its value)
	
		List<WebElement> columns = table.findElements(By.xpath("(//table)[1]//tbody//tr//td[1]"));
		
		List<String> absoluteusage = new ArrayList<String>();
	
		for (int i=1 ; i<=columns.size() ; i++)
		{	
			String text2=table.findElement(By.xpath("(//table)[1]//tbody//tr["+i+"]//td[1]")).getText();
			String text1="Absolute Usage";
		if(text1.equals(text2))
		{
			List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]//tbody//tr["+i+"]//td")) ;
			
			for(int j=2 ; j<=rows.size() ; j++)
			{
				String text = driver.findElement(By.xpath("(//table)[1]//tbody//tr["+i+"]//td["+j+"]")).getText() ;
				//driver.findElements(By.xpath("(//table)[1]//tbody//tr["+i+"]//td["+j+"]"));
				/*String word = driver.findElement(By.xpath("//td[text()='Absolute Usage']")).getText();
			if(rows.contains("Absolute Usage"))*/
			
				absoluteusage.add(text);
			
		    }
		}

	}
		System.out.println(absoluteusage);
		for (String values : absoluteusage) {
			System.out.println("Absolute Values are:"+values);
		}
		
		//System.out.println("Absolute usgae values are : "+absoluteusage);
  }
}
