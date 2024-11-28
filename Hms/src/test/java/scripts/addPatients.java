package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class addPatients {
	@Test
	public  void patients() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/addpatients");
		driver.findElement(By.xpath("//input[@placeholder='Your first name']")).sendKeys("sanjay ");//firstnmae
	
		driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys("kumar");//lastname
		
		 WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-select select-form  mt-2']"));//gender
	      Select s = new Select( dropdownElement );
	    s.selectByVisibleText("Male");

	//	driver.findElement(By.xpath("//option[text()='Male']")).sendKeys("Male");
		
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("9790948567");//mobilenumber
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys("sanjay970fficial@gmail.com");//emailid
		driver.findElement(By.xpath("//input[@placeholder='Select date']")).sendKeys("03/11/1997");//dob
		
		Thread.sleep(9000);
		 WebElement bloodG = driver.findElement(By.xpath("//select[@class='form-select select-form  mt-2']/following::select[1]"));
	      Select s1 = new Select( bloodG  );
	    s1.selectByVisibleText("AB+");
		//driver.findElement(By.xpath("//select[@class='form-select select-form mt-1']")).sendKeys("AB+");
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']")).sendKeys("HN001");//hosptial num
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[1]")).sendKeys("PM");//schemadetails
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[2]")).sendKeys("OP");//patienttype
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[3]")).sendKeys("2");
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[4]")).sendKeys("6");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[5]")).sendKeys("Dropout");
		driver.findElement(By.xpath("//input[@placeholder='Enter aadhaar Number']")).sendKeys("123412341234");
		driver.findElement(By.xpath("//input[@placeholder='Enter Attender name']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[6]")).sendKeys("HIV");
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[7]")).sendKeys("Friend");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Attender Mobile Number']")).sendKeys("8056227769");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar Health id']")).sendKeys("AHID001");
		driver.findElement(By.id("patient-save")).click();
		
		
		
	}

}
