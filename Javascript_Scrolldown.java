package advanced_selenium_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;

public class Javascript_Scrolldown {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

	}

	@Test (enabled = true)
	public void SmallTable() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		// scrolldown till box
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(2000);

		// Scrolldown within box
		js.executeScript("document.querySelector(\".tableFixHead\").scrollBy(0,200)");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {

			sum = sum + (Integer.parseInt(values.get(i).getText())); // String is converted in integer

		}

		System.out.println(sum);

		String AmountCollected = driver.findElement(By.cssSelector(".totalAmount")).getText();
		// Splitting the string
		String[] parts = AmountCollected.split(":");
		String amount = parts[1].trim();

		int Total = Integer.parseInt(amount); // String is converted in integer

		org.testng.Assert.assertEquals(sum, Total); // Validate sum and total

	}

	@Test(enabled = true)
	public void Big_Table() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		Thread.sleep(2000);
		
		List<WebElement> Price = driver.findElements(By.cssSelector(".table-display td:nth-child(3)"));
		int sum =0;
		for(int i=0; i<Price.size();i++) {
			
		sum = sum + Integer.parseInt(Price.get(i).getText());
		
			
		}
		System.out.println(sum);
		
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
