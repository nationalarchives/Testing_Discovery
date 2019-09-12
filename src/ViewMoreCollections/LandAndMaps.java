package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class LandAndMaps extends Wrapper_methods {
    @Test
    public void LandAndMaps() throws InterruptedException, IOException{
        launchDriver("http://www.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=family-history","chrome");
        // select Land and maps from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));
        sortedBy.selectByIndex(9);
        Thread.sleep(3000);

        // Verify the results

        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("Land and maps", actual1);
        driver.close();
    }
}
