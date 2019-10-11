package ResearchGuide_RAF_CombatReports;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class RAF_CombatReports_DateOfCombat_Rank_Squadron extends Wrapper_methods {
    @Test(priority = 1)
    public void RAF_CombatReports_DateOfCombat_Rank_Squadron() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter rank
        clickbyXpath("//*[@id=\"rank\"]");
        driver.findElementByXPath("//*[@id=\"rank\"]").sendKeys("Flight");

       // enter flight/squadnumber
        clickbyXpath("//*[@id=\"flightsquadronnumber\"]");
        driver.findElementByXPath("//*[@id=\"flightsquadronnumber\"]").sendKeys("19");

        //click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check third record is containing Flight and 19
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a").getText();
        Assert.assertTrue((actual.contains("Flight") )&& (actual.contains("19")));
        driver.quit();
    }
    @Test(priority = 2)
    public void RAF_CombatReports_DateOfCombat_Another_Rank_Squadron() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter rank
        clickbyXpath("//*[@id=\"rank\"]");
        driver.findElementByXPath("//*[@id=\"rank\"]").sendKeys("Serjeant");

        // enter flight/squadnumber
        clickbyXpath("//*[@id=\"flightsquadronnumber\"]");
        driver.findElementByXPath("//*[@id=\"flightsquadronnumber\"]").sendKeys("50");

        //click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check third record is containing Serjeant and 50
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a").getText();
        Assert.assertTrue((actual.contains("Serjeant") )&& (actual.contains("50")));
        driver.quit();
    }
    @Test(priority = 2)
    public void RAF_CombatReports_DateOfCombat_Name_Rank_Squadron() throws IOException, InterruptedException {
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/raf-combat-reports-1939-1945/","chrome");
        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // enter Last name
        clickbyXpath("//*[@id=\"lastname\"]");
        driver.findElementByXPath("//*[@id=\"lastname\"]").sendKeys("Lane");

        // enter rank
        clickbyXpath("//*[@id=\"rank\"]");
        driver.findElementByXPath("//*[@id=\"rank\"]").sendKeys("Serjeant");

        // enter flight/squadnumber
        clickbyXpath("//*[@id=\"flightsquadronnumber\"]");
        driver.findElementByXPath("//*[@id=\"flightsquadronnumber\"]").sendKeys("50");

        //click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");
        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // check third record is containing Serjeant and 50
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[3]/a").getText();
        Assert.assertTrue((actual.contains("Serjeant") )&& (actual.contains("50"))&& (actual.contains("Lane")));
        driver.quit();
    }
}
