package advanced_selenium_practice;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StreamInSelenium {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
	}

	@Test
	public void GreenKart() {

		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));

		List<String> originalList = elementList.stream().map(a -> a.getText()).collect(Collectors.toList());

		List<String> Sortedlist = originalList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalList.equals(Sortedlist));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
