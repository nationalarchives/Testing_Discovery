package ViewMoreCollections;

import groovy.json.internal.IO;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class SecondWorldWar extends Wrapper_methods {

    @Test
    public void SecondWorldWar() throws IOException, InterruptedException{
        launchDriver("http://test.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=family-history","chrome");
        // select First world war from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));

        sortedBy.selectByIndex(3);
        Thread.sleep(3000);
        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("Second World War", actual1);
        driver.close();

    }
}
