package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ategrity {
	WebDriver driver = new ChromeDriver();

	@Test
	public void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://asiccwb-dev.esinsurancecloud.com/wbui/login.php");

	}

	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("ramprakashk@tenacitics.in");
		driver.findElement(By.id("password")).sendKeys("2");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("//*[text()='New Quote']")).click();
		driver.findElement(By.xpath("//a[text()='New Quote']//following::a[1]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("text-input")).sendKeys("sanjay kumar");
		driver.findElement(By.xpath("//*[@id=\"viewaccountid\"]/div/div[1]/div[3]/span[1]/img")).click();
		driver.findElement(By.id("ins_addr")).sendKeys("no 10 subramaniya nagar");
		driver.findElement(By.id("insured_zipcode_ga")).sendKeys("10110");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//* [@class=\"class-builder\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

//	WebElement element =
		Thread.sleep(3000);
		System.out.println("entered class code");
		driver.findElement(By.xpath("//input[@name=\"SIC_business_class\"]")).sendKeys("11212");

		System.out.println("exited class code");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='class_code']//following::li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("zip_code")).sendKeys("10001");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='zip_code']//following::li[1]"));
		Thread.sleep(2000);
		driver.findElement(By.id("test")).click();
		driver.findElement(By.xpath("//button[@aria-label=\"Copy Insured Address\"]")).click();
		driver.findElement(By.xpath("//label[text()=\"Exposure\"]//following::input[1]")).sendKeys("1000");

	}

}
