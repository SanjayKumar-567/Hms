package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataAnnatation {
	@DataProvider
	public Object[][] dataSupplier() {
		fileutility.ReadExcel read = new fileutility.ReadExcel();
		Object[][] data = read.readMultipleData("Sheet1");// sheet name what name we given in excel
		return data;
	}
	@Test(dataProvider = "dataSupplier")
	public void logintest(String firstName, String lastName ) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.get("http://localhost:3000/addpatients");
		driver.findElement(By.xpath("//input[@placeholder='Your first name']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lastName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();

	}//this script is working so make it as example for ddf 

}