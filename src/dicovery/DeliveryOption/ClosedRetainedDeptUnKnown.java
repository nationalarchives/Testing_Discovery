package dicovery.DeliveryOption;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClosedRetainedDeptUnKnown {

	@Test
	public void closedRetainedDeptUnKnown() throws Exception {

		File src = new File("./data/ALLOptions.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);

		String deliveryOptionType = sheet.getRow(0).getCell(24).getStringCellValue();
		String iaid = sheet.getRow(1).getCell(24).getStringCellValue();
		String expectedValeStaff = sheet.getRow(2).getCell(24).getStringCellValue();

		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get(iaid);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML"));
		System.out.println(driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getText());

		String Staffcheck = driver.findElementByXPath("(//div[@class='order-option-wrapper'])").getAttribute("innerHTML");

		Assert.assertTrue(Staffcheck.contains("StaffIn"));

		Assert.assertTrue(Staffcheck.contains("ClosedRetainedDeptUnKnown"));

		String actualDO = driver.findElementByXPath("//div[@class='order-option-wrapper']").getText();

		System.out.println(actualDO);

		Assert.assertEquals(expectedValeStaff, actualDO);
		Thread.sleep(3000);

		driver.quit();

	}

}
