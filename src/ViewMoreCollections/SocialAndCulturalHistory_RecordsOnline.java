package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class SocialAndCulturalHistory_RecordsOnline extends Wrapper_methods {
    @Test
    public void SocialAndCulturalHistory_RecordsOnline() throws IOException,InterruptedException{

        launchDriver("http://www.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=online","chrome");
        // select Social and cultural history from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));

        sortedBy.selectByIndex(5);
        Thread.sleep(3000);
        // click on show only guides with all records online
        driver.findElementByXPath("//*[@id=\"online-only\"]").click();

        // Verify the results
        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();

       String actual1 = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[2]/div/ul/li[1]/span[4]").getText();
        String actual2 = driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual2);
        Assert.assertEquals("Social and cultural history", actual2);
        driver.close();
    }
}
