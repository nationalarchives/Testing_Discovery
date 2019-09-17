package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class PoliticalAndEconomicHistory extends Wrapper_methods {

    @Test

    public void PoliticalAndEconomicHistory() throws InterruptedException, IOException{

        launchDriver("http://test.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=family-history","chrome");
        // select Political and Economic History from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));
        sortedBy.selectByIndex(7);
        Thread.sleep(3000);

        // Verify the results

        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("Political and economic history", actual1);
    }
}
