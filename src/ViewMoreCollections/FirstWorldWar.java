package ViewMoreCollections;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class FirstWorldWar extends Wrapper_methods {
    @Test

    public void FirstWorldWar() throws IOException, InterruptedException{

        launchDriver("https://test.discovery.nationalarchives.gov.uk/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
        driver.findElementByXPath("//*[@id=\"more\"]/a").click();
        // select First world war from the dropdown
        Select sortedBy = new Select(driver.findElementById("research-category"));

        sortedBy.selectByIndex(2);
        Thread.sleep(3000);

        // Verify the results

        String actual = driver.findElementByXPath("//*[@id=\"reload-marker\"]/div[1]/h2/span/span").getText();
        String actual1=driver.findElementByXPath("//*[@id=\"guide-form\"]/h2").getText();
        System.out.println(actual1);
        Assert.assertEquals("First World War", actual1);
        driver.close();
    }

}
