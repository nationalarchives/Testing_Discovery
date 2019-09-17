package ViewMoreCollections;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class AllResearchGuidesA_Z  extends Wrapper_methods {

    @Test

    public void FirstWorldWar() throws IOException, InterruptedException{
        launchDriver("http://test.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=family-history","chrome");
        // select All Research guide (A-Z) from the Refine results
        Select sortedBy = new Select(driver.findElementById("research-category"));
        sortedBy.selectByIndex(0);
        Thread.sleep(3000);
        // Verify the results
        String actual = driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual);
        Assert.assertEquals("All research guides", actual);
        driver.close();


    }


}
