package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class naviBar {

	@Test(invocationCount = 20)
	public void openbrowser() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/home#");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Patients']")).click();
		Thread.sleep(3000);
		Assert.assertEquals("List of Patients", "List of Patients");

		driver.findElement(By.xpath("//a[text()='Add new Patients']")).click();
		Thread.sleep(3000);
	//	driver.findElement(By.xpath("//a[text()='Add new Patients']")).click();
		driver.findElement(By.xpath("//a[text()='Employees']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Assets']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Room']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Bed']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Dialysis Machine']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Slots']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Slot Booking']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Ongoing Slot']")).click();
		Thread.sleep(3000);
	

	}

}
