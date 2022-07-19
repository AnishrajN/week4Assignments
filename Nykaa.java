package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	
//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
	
//		2) Click Brands and Search L'Oreal Paris
//		3) Click L'Oreal Paris
		WebElement search = driver.findElement(By.name("search-suggestions-nykaa"));
		search.sendKeys("L'Oreal Paris",Keys.ENTER);
		
//		4) Check the title contains L'Oreal Paris
		String title = driver.findElement(By.xpath("//h1[@class='page-title-search']")).getText();
		if(title.contains("L'Oreal Paris"))
			System.out.println("The Title contains 'L'Oreal Paris'");
		else
			System.err.println("The Title does not contains L'Oreal Paris");
		
//		5) Click sort By and select customer top rated
		WebElement sortBy = driver.findElement(By.xpath("//span[text()='Sort By : relevance']"));
		sortBy.click();
		WebElement topRated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
		topRated.click();
		
//		6) Click Category and click Hair->Click haircare->Shampoo
		WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
		category.click();
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		hair.click();
		WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		hairCare.click();
		WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		shampoo.click();
		
//		7) Click->Concern->Color Protection
		WebElement concern = driver.findElement(By.xpath("//span[text()='Concern']"));
		concern.click();
		WebElement colorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
		colorProtection.click();
	
//		8)check whether the Filter is applied with Shampoo
		String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		if(filter.contains("Shampoo"))
		System.out.println("the Filter is applied with Shampoo"); 
		else
			System.err.println("the Filter is not applied with Shampoo");
		
//		9) Click on L'Oreal Paris Colour Protect Shampoo
		//WebElement lpcps = driver.findElement(By.xpath("//div[@class='css-xrzmfa']"));
		//lpcps.click();
		WebElement cps = driver.findElement(By.xpath("//div[@class='css-xrzmfa']"));
		cps.click();
		
//		10) GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));
		
		
//		11) Print the MRP of the product
		WebElement mrp = driver.findElement(By.xpath("(//span[text()='₹189'])[1]"));
		System.out.println("Mrp is: "+ mrp.getText());
		
//		12) Click on ADD to BAG
		WebElement addtobag = driver.findElement(By.xpath("(//button[@class=' css-12z4fj0'])[1]"));
		addtobag.click();
		
//		13) Go to Shopping Bag
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
//		14) Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("(//div[text()='259'])[2]")).getText();
		System.out.println("Grand total amount is = "+ grandTotal);
		
//		15) Click Proceed
		//driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']")).click();
		Thread.sleep(3000);
		WebElement proceed = driver.findElement(By.xpath("//div[@class='second-col']/button"));
		proceed.click();
		
//		16) Click on Continue as Guest
		WebElement guest = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		guest.click();
		
//		17) Check if this grand total is the same in step 14
		//span[text()='259']
		String checkGrandTotal = driver.findElement(By.className("value")).getText();
		if(grandTotal.contains(checkGrandTotal)) {
			System.out.println("Grand total is equal");
		}
		else {
			System.out.println("Grand total not equal");
		}
		
//		18) Close all windows
		driver.quit();


}


}

