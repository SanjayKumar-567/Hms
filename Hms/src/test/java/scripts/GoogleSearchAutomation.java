package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import java.util.concurrent.TimeUnit;

public class GoogleSearchAutomation {

	// Method to perform search and click the first result@
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		// Locate the search box and input the query
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.clear(); // Clear previous search
		searchBox.sendKeys("dog");
		searchBox.sendKeys(Keys.RETURN); // Press Enter

		{
			try {
				
				// Wait and click the first result
				WebElement firstResult = driver.findElement(By.xpath("//div[@id= 'atvcap']/following::a[1]"));
				firstResult.click();
//"//h3[contains(@class, 'LC20lb')]"
				// Print the navigated URL
				//System.out.println("Search Query: " + query);
				System.out.println("Navigated to: " + driver.getCurrentUrl());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}