package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class interview {
	WebDriver driver;

	@Test(priority=1)
	public void patient_Information() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://sajprat.pagekite.me/gpmedgroup/generalintake?lang=en&ID=drspiresmd");
		driver.findElement(By.id("firstname")).sendKeys("sanjay");
		driver.findElement(By.id("lastname")).sendKeys("kumar");
		driver.findElement(By.id("emailAddress")).sendKeys("sanjay97official@gmail.com");
		driver.findElement(By.id("homephone")).sendKeys("9790948567");
		driver.findElement(By.id("cellphone")).sendKeys("9500112497");

		WebElement rb = driver.findElement(By.id("gender"));
		rb.click();

		driver.findElement(By.name("dob")).sendKeys("11/03/1997");
		driver.findElement(By.name("stAddress1")).sendKeys("madipakkam");
		driver.findElement(By.name("city")).sendKeys("chennai");

		WebElement dd = driver.findElement(By.id("state"));
		Select slt = new Select(dd);
		slt.selectByVisibleText("California");

		driver.findElement(By.name("zipcode")).sendKeys("600091");
		driver.findElement(By.name("city")).sendKeys("chennai");

		WebElement dd1 = driver.findElement(By.id("raceEthinicity"));
		Select slt1 = new Select(dd1);
		slt1.selectByVisibleText("Other");

		WebElement dd2 = driver.findElement(By.id("Ethinicity"));
		Select slt2 = new Select(dd2);
		slt2.selectByVisibleText("Other");

		driver.findElement(By.xpath("//input[@id='emergencyFName1']")).sendKeys("arul");
		driver.findElement(By.xpath("//input[@id='emergencyLName1']")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@id='emergencyphone1']")).sendKeys("9500112479");
		driver.findElement(By.xpath("//input[@id='emergencyphone1']//following::input[1]")).sendKeys("9790948576");
		WebElement nextbtn = driver.findElement(By.id("next1"));
		nextbtn.click();

	}

	@Test(priority=2)
	public void insurance() {

		WebElement Relationship = driver.findElement(By.id("relationshipToPatient"));
		Select slt3 = new Select(Relationship);
		slt3.selectByVisibleText("Self");

		WebElement policyHolder = driver.findElement(By.id("policyHolder"));
		Select slt4 = new Select(policyHolder);
		slt4.selectByVisibleText("Other");

		WebElement PrimaryInsurance = driver.findElement(By.id("priInsurCompName"));
		Select slt5 = new Select(PrimaryInsurance);
		slt5.selectByVisibleText("AMERIHEALTH");

		driver.findElement(By.name("priPolicyNumber")).sendKeys("760943765");
		driver.findElement(By.id("priPolicyHolderFName")).sendKeys("sanjay");
		driver.findElement(By.id("priPolicyHolderLName")).sendKeys("kumar");
		WebElement rb2 = driver
				.findElement(By.xpath("//*[text()='Do you have Secondary Insurance?']//following::input[2]"));
		rb2.click();
		driver.findElement(By.id("next2")).click();

	}

	@Test(priority=3)
	public void medicalHistoy() {
		driver.findElement(By.name("cataracts")).click();

		driver.findElement(By.name("Heartburn")).click();
		driver.findElement(By.name("LymeDiseases")).click();
		driver.findElement(By.name("UTI")).click();
		
		WebElement radiobutton=driver.findElement(By.name("anyMedication"));
		radiobutton.click();
		WebElement radiobutton1=driver.findElement(By.name("anyAllergies"));
		radiobutton1.click();
		
		WebElement radiobutton2=driver.findElement(By.name("SeeinganyDoctors"));
		radiobutton2.click();
		
		
		
		
		driver.findElement(By.id("next3")).click();
	}

	@Test(priority=4)
	public void sumbit() {
		WebElement checkBox = driver.findElement(By.name("confirmPolicyRead"));
		checkBox.click();

	}
}
