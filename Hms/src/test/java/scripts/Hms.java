package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Hms {
		@Test
		public void launchbrowser() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://localhost:3000/");
			driver.findElement(By.id("inputEmailOrMobile")).sendKeys("balamurugan@example.com");

			driver.findElement(By.id("inputPassword")).sendKeys("bala");
			
			driver.findElement(By.xpath("//*[name()='svg'and@stroke=\"currentColor\"]")).click();
			
			driver.findElement(By.id("signin-btn-1")).click();
	
			driver.findElement(By.xpath("//div[text()='Total Patients']")).click();
			
			WebElement search= driver.findElement(By.xpath("//input[@type='search']"));
			
			search.sendKeys("sanjay");
			
			search.click();
			driver.findElement(By.xpath("//img[@alt='Details Icon']")).click();
			//driver.findElement(By.xpath("//*[@id=\"contentToExport\"]/div/div/table/tbody/tr/td[7]/div")).click();
			Thread.sleep(2000);
			// Perform an action to navigate to the new page
			//driver.findElement(By.id("nextPageLink")).click();

			// Get the page source
			//String pageSource = driver.getPageSource();

			// Validate if certain text exists in the page source
			//Assert.assertTrue(pageSource.contains("Patients Details"));
			
			driver.findElement(By.xpath("//button[text()='Edit details']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Add Patient fingerprint']")).click();
			/*
			 * WebElement check=
			 * driver.findElement(By.xpath("//h1[text()='Verification']")); check.getText();
			 * check.getTagName();
			 */
		
	
			
			
			//driver.quit();

		}
	}
