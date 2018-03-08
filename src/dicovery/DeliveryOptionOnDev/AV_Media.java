package dicovery.DeliveryOptionOnDev;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AV_Media {

	
	@Test
	public void AV_Media() throws Exception {

		File src = new File("./data/ALLOptionsDev.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(29).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(29).getStringCellValue();
		String expectedValeStaff = sheet.getRow(2).getCell(29).getStringCellValue();

		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get(iaid);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute(	"innerHTML"));

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));
		
		Assert.assertTrue(Staffcheck.contains("AV_Media"));

		String actual = driver.findElementByXPath("//div[@class='order-option-wrapper']").getText();
		
		System.out.println(actual);
		
		Assert.assertEquals(expectedValeStaff, actual);
				
		Thread.sleep(3000);

		driver.quit();

	}

}
