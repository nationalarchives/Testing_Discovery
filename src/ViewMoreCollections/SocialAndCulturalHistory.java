package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class SocialAndCulturalHistory extends Wrapper_methods {
    @Test

    public void SocialAndCulturalHistory() throws InterruptedException, IOException{

        launchDriver("http://test.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=military-and-maritime","chrome");
        // select Social and cultural History from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));
        sortedBy.selectByIndex(5);
        Thread.sleep(3000);

        // Verify the results

        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("Social and cultural history", actual1);
    }
}
