package ResearchGuide_RAF_RecordBooks;

import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_RecordBooks_NoInput extends Wrapper_methods {
    @Test
    public void RAF_RecordBooks_NoInput() throws IOException{

        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-operations-record-books-1939-1945/","chrome");

        // click on search without entering anything
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        // check for AIR 27 filter
        String CheckFilter = driver.findElementByXPath("//*[@id=\"search-refine\"]/ul/li[2]/span").getText();
        Assert.assertTrue(CheckFilter.contains("AIR 27"));
        driver.quit();
    }
}
