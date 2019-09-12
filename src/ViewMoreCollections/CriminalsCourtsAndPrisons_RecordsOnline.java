package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class CriminalsCourtsAndPrisons_RecordsOnline extends Wrapper_methods {
    @Test
    public void CriminalsCourtsAndPrisons_RecordsOnline() throws InterruptedException, IOException{

        launchDriver("http://www.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=online","chrome");
        // select Criminals courts and prisons from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));

        sortedBy.selectByIndex(6);
        Thread.sleep(3000);
        // click on show only guides with all records online
        driver.findElementByXPath("//*[@id=\"online-only\"]").click();

        // Verify the results
        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();

        /*String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        driver.findElementByXPath("//a[@id='goTop']").click();
*/
       String actual1 = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[2]/div/ul/li[1]/span[7]").getText();
        String actual2 = driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual2);
        Assert.assertEquals("Criminals courts and prisons", actual2);

        driver.close();
    }
}