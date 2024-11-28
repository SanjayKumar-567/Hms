package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.name("q"));

		search.sendKeys("orage");

		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.findElement(By.id("jZ2SBf")).click();
		// driver.findElement(By.xpath("//*[text()='Apple | Official Site']")).click();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		 if (!allLinks.isEmpty()) {
			 
             allLinks.get(0).click(); // Click the first link
             System.out.println("First link clicked!");
         } else {
             System.out.println("No links found on the page.");
         }
		/*
		 * WebElement firstLink = allLinks.get(1); Thread.sleep(5000);
		 * 
		 * firstLink.click(); String url = driver.getCurrentUrl();
		 * System.out.println(url); driver.quit();
		 */
	}

}
