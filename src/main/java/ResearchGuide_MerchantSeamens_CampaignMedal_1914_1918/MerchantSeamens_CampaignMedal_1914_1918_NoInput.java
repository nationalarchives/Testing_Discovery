package ResearchGuide_MerchantSeamens_CampaignMedal_1914_1918;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MerchantSeamens_CampaignMedal_1914_1918_NoInput extends Wrapper_methods {
    @Test
    public void MerchantSeamens_CampaignMedal_1914_1918_NoInput() throws IOException{
       launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/merchant-seamens-campaign-medal-records-1914-1918/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // click on search without entering anything
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // chk the fourth record contains seamen
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[4]/a").getText();
        Assert.assertTrue(actual.contains("Seamen"));
        driver.quit();
    }
}
