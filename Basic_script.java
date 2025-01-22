package advanced_slenium_practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Basic_script {

	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://paytm.com");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


			Actions a = new Actions(driver);

			WebElement ele1 = driver.findElement(By.xpath("//li[@class='_2Szju'][5]"));
			
					a.moveToElement(ele1).perform();
					
		    WebElement ele2 = driver.findElement(By.xpath("//a[text()='Sustainability']"));
		    
		    a.moveToElement(ele2).perform(); 
		    driver.findElement(By.linkText("ESG Profile")).click();
		    
		    
		    Set<String> windowHandles = driver.getWindowHandles();
			ArrayList<String> tabs = new ArrayList<>(windowHandles);

			// Switch to the second tab
			driver.switchTo().window(tabs.get(1)); // Index 1 is the second tab
		     
			driver.switchTo().frame(0);
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		   WebElement DropDown = driver.findElement(By.id("cmbFactor"));
		   Select sel = new Select(DropDown);
		   sel.selectByIndex(1);


			


		
		
		}
}
