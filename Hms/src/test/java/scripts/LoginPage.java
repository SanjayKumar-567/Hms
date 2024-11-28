package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {
	WebDriver driver = new ChromeDriver();
	@Test
	public void launchbrowser() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/");
	}    @Test
		public void signin() {
		driver.findElement(By.id("inputEmailOrMobile")).sendKeys("balamurugan@example.com");
		driver.findElement(By.id("inputPassword")).sendKeys("bala");
		driver.findElement(By.xpath("//*[name()='svg'and@stroke=\"currentColor\"]")).click();
		driver.findElement(By.id("forgot-password")).click();
		Alert alt =driver.switchTo().alert();
		alt.accept();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("dummy");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		
		
	}
}
