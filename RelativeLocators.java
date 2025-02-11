package advanced_selenium_practice;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLocators {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\patil\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// relative locators

		WebElement nameEditBox = driver.findElement(By.xpath("//input[@name='name']"));

		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement DateOFBirth = driver.findElement(By.xpath("//label[@for='dateofBirth']"));

		driver.findElement(with(By.tagName("input")).above(DateOFBirth)).click();

		WebElement StudentRadio = driver.findElement(By.xpath("//label[@for='inlineRadio1']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(StudentRadio)).click();

		WebElement CheckBox = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(CheckBox)).click();

		WebElement rdb = driver.findElement(By.id("inlineRadio1"));

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());

		WebElement PasswordField = driver.findElement(By.xpath("//label[text()='Email']"));
		driver.findElement(with(By.tagName("input")).below(PasswordField)).sendKeys("ERTYU@gmail.com");

	}

}
