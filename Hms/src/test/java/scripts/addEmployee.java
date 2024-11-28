package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class addEmployee {
	@Test
	public void patients() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://82.112.234.137:3000/addemployee");
		String PageTitle = driver.getTitle();
		System.out.println(PageTitle);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		String text = driver.findElement(By.xpath("//h1[text()='Add New Employee']")).getText();

		if (text.equals("Add New Employee")) {

			System.out.println( text+" name found so validation pass");
		} else {
			System.out.println("there is no name found like Add New Employee so " + "fail");
		}
		driver.findElement(By.id("firstName")).sendKeys("Sathish");
		driver.findElement(By.id("gender")).sendKeys("Male");
		driver.findElement(By.id("lastName")).sendKeys("T");
		driver.findElement(By.id("mobile")).sendKeys("9715565652");
		driver.findElement(By.id("email")).sendKeys("sathishchennai1994@gmail.com");
		driver.findElement(By.id("dob")).sendKeys("06/16/1994");

		WebElement nextStep = driver.findElement(By.xpath("//button[text()='NEXT STEP']"));

		String colour = nextStep.getCssValue("background-color");

		Reporter.log(colour, true);

		String size = nextStep.getCssValue("fontsize");
		Reporter.log(size, true);
		nextStep.click();
		driver.findElement(By.id("employeeId")).sendKeys("Emp001");
		driver.findElement(By.id("department")).sendKeys("dialysis");
		driver.findElement(By.xpath("//select[@id='designation']")).sendKeys("Nurse");
		Thread.sleep(3000);
		driver.findElement(By.id("//select[@id='designation']/following::select[1]")).sendKeys("Lawspet");
		driver.findElement(By.id("//button[text()='NEXT STEP']")).click();
		 driver.findElement(By.xpath("//button[text()='Home']")).click();
		 driver.findElement(By.xpath("//button[text()='Patients']")).click();
		 driver.findElement(By.xpath("//button[text()='Employee']")).click();
		 driver.findElement(By.xpath("//button[text()='View']")).click();
		 driver.findElement(By.xpath("//button[text()='Edit']")).click();
		 driver.findElement(By.id("newPassword")).sendKeys("root@123");
		 driver.findElement(By.id("confirmPassword")).sendKeys("root@123");
		 driver.findElement(By.id("/button[text()='Submit']")).click();
		

	}
}
