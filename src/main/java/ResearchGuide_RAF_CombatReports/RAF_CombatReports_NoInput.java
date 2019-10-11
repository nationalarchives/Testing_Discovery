package ResearchGuide_RAF_CombatReports;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_CombatReports_NoInput extends Wrapper_methods {
    @Test
    public void RAF_CombatReports_NoInput() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // click on search without entering anything
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check that third record contains Combat
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a").getText();
        Assert.assertTrue(actual.contains("Combat"));

        ((JavascriptExecutor) driver).executeScript("scroll(0,1500)");

        // check that fifth record contains combat
       String actual2 = driver.findElementByXPath("//*[@id=\"search-results\"]/li[5]/a").getText();
       Assert.assertTrue(actual2.contains("Combat"));
       driver.quit();
    }

}
