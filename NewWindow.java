package advanced_selenium_practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.reporters.jq.Main;

import com.mongodb.MapReduceCommand.OutputType;

public class NewWindow {

	public static void main(String[] args) throws IOException {

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
		WebElement name=driver.findElement(By.cssSelector("[name='name']"));

		name.sendKeys(CourseName);

		//Screenshot

		File file=name.getScreenshotAs(org.openqa.selenium.OutputType.FILE);


		FileUtils.copyFile(file, new File("logo.png"));


		//driver.quit();


		//GEt Height & Width

		System.out.println(name.getRect().getDimension().getHeight());

		System.out.println(name.getRect().getDimension().getWidth());
		
		
//		driver.quit();

	}

}
