package ViewMoreCollections;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class FamilyHistory extends Wrapper_methods {

    @Test

public void FirstWorldWar() throws IOException, InterruptedException{

    launchDriver("http://www.nationalarchives.gov.uk/help-with-your-research/research-guides/?research-category=online","chrome");
    // select First world war from the dropdown
    Select sortedBy = new Select(driver.findElementById("research-category"));

    sortedBy.selectByIndex(1);
    Thread.sleep(3000);

    // Verify the results

    String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1= driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        // Verify the message
        Assert.assertEquals("Family history", actual1);
    driver.close();
}

}
