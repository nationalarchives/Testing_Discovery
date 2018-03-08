package discovery.Sar;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Sar_RW33FQZFoiRequest {
	
	@Test
	
		
	public void RW33FQZFoiRequest() throws InvalidFormatException, IOException, InterruptedException{
		
		File src = new File("./data/SARVerification.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(src);

		XSSFSheet sheet = book.getSheetAt(0);
		String TestcaseName = sheet.getRow(8).getCell(0).getStringCellValue();
		String Link = sheet.getRow(8).getCell(1).getStringCellValue();
		String expectedasset = sheet.getRow(8).getCell(2).getStringCellValue();
			
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver_win32/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Thread.sleep(3000);

		driver.get(Link);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		String table =driver.findElementByCssSelector("table.asset-details").getText();
		System.out.println(table);
		
		Assert.assertTrue(table.contains(expectedasset));
		
		driver.quit();
		
				
	}
		
		
	
	
	

}
