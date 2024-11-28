package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileutility.ExcelUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class AddPatientTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Replace with your URL
	}

	@Test(dataProvider = "patientData")
	public void addNewPatient(String firstName, String lastName, String gender, String mobile, String email, String dob,
			String bloodGroup, String hospitalNumber, String schemeDetails, String patientType, String dialysisCount,
			String currentCycle, String status, String adharId, String attenderName, String diseased,
			String relationship, String attenderMobile, String healthID) throws InterruptedException {
		// Fill in the form
		driver.get("http://localhost:3000/addpatients");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Your first name']")).sendKeys(firstName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Enter last name']")).sendKeys(lastName);

		Select genderSelect = new Select(
				driver.findElement(By.xpath("//select[@class='form-select select-form  mt-2']")));
		genderSelect.selectByVisibleText(gender);

		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys(mobile);

		driver.findElement(By.xpath("//input[@placeholder='Enter email address']")).sendKeys(email);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Select date']")).sendKeys(dob);

		Select bloodGroupSelect = new Select(
				driver.findElement(By.xpath("//select[@class='form-select select-form  mt-2']/following::select[1]")));
		bloodGroupSelect.selectByVisibleText(bloodGroup);

		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']")).sendKeys(hospitalNumber);

		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[1]"))
				.sendKeys(schemeDetails);

		Select patientTypeSelect = new Select(
				driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[2]")));

		patientTypeSelect.selectByVisibleText(patientType);

		Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[3]"))
				.sendKeys(dialysisCount);
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[4]"))
				.sendKeys(currentCycle);

		Select statusSelect = new Select(
				driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[5]")));
		statusSelect.selectByVisibleText(status);

		// driver.findElement(By.xpath("//input[@placeholder='Enter Hospital
		// Number']/following::select[5]")).sendKeys(status);
		driver.findElement(By.xpath("//input[@placeholder='Enter aadhaar Number']")).sendKeys(adharId);
		driver.findElement(By.xpath("//input[@placeholder='Enter Attender name']")).sendKeys(attenderName);
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[6]"))
				.sendKeys(diseased);
		driver.findElement(By.xpath("//input[@placeholder='Enter Hospital Number']/following::select[7]"))
				.sendKeys(relationship);
		Thread.sleep(9000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Attender Mobile Number']")).sendKeys(attenderMobile);

		driver.findElement(By.xpath("//input[@placeholder='Enter Aadhaar Health id']")).sendKeys(healthID);
		driver.findElement(By.id("patient-save")).click();

		Thread.sleep(9000);

		// Submit the form
		// driver.findElement(By.id("submit_button")).click();

		// Add validation here to confirm that the patient was added successfully
	}

	@DataProvider(name = "patientData")
	public Object[][] getPatientData() throws IOException {
		String filePath = "./src/test/resources/patientData.xlsx";
		ExcelUtils.setExcelFile(filePath, "Sheet1");

		int rowCount = ExcelUtils.getRowCount();
		Object[][] data = new Object[rowCount - 1][19];

		for (int i = 1; i < rowCount; i++) {
			data[i - 1][0] = ExcelUtils.getCellData(i, 0); // First Name
			data[i - 1][1] = ExcelUtils.getCellData(i, 1); // Last Name
			data[i - 1][2] = ExcelUtils.getCellData(i, 2); // Gender
			data[i - 1][3] = ExcelUtils.getCellData(i, 3); // Mobile Number
			data[i - 1][4] = ExcelUtils.getCellData(i, 4); // Email
			data[i - 1][5] = ExcelUtils.getCellData(i, 5); // Date of Birth
			data[i - 1][6] = ExcelUtils.getCellData(i, 6); // Blood Group
			data[i - 1][7] = ExcelUtils.getCellData(i, 7); // Hospital Number
			data[i - 1][8] = ExcelUtils.getCellData(i, 8); // Scheme Details
			data[i - 1][9] = ExcelUtils.getCellData(i, 9); // Patient Type
			data[i - 1][10] = ExcelUtils.getCellData(i, 10); // dialysisCount
			data[i - 1][11] = ExcelUtils.getCellData(i, 11); // currentCycle
			data[i - 1][12] = ExcelUtils.getCellData(i, 12); // status
			data[i - 1][13] = ExcelUtils.getCellData(i, 13); // adharId
			data[i - 1][14] = ExcelUtils.getCellData(i, 14); // attenderName
			data[i - 1][15] = ExcelUtils.getCellData(i, 15); // diseased
			data[i - 1][16] = ExcelUtils.getCellData(i, 16); // relationship
			data[i - 1][17] = ExcelUtils.getCellData(i, 17); // attenderMobile
			data[i - 1][18] = ExcelUtils.getCellData(i, 18); // healthID

		}
		return data;
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
