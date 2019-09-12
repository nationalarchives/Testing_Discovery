package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RecordsForCurrentLegalPurposes extends Wrapper_methods {
    @Test
    public void RecordsForCurrentLegalPurposes() throws IOException,InterruptedException{
        launchDriver("http://www.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=family-history","chrome");
        // select Records for current legal purposes from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));
        sortedBy.selectByIndex(11);
        Thread.sleep(3000);

        // Verify the results

        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("Records for current legal purposes", actual1);
        driver.close();
    }
}