package advanced_selenium_practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.reporters.jq.Main;

public class NewWindow {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> WindowHandel = driver.getWindowHandles();

		Iterator<String> it = WindowHandel.iterator();
		String ParentID = it.next();
		String ChildID = it.next();

		driver.get("https://rahulshettyacademy.com/");
		String CourseName = driver
				.findElement(
						By.xpath("//a[text()='All-Access Membership-Complete Access to 25+ Courses (and counting!)']"))
				.getText();

		driver.switchTo().window(ParentID);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(CourseName);

		driver.quit();

	}

}
