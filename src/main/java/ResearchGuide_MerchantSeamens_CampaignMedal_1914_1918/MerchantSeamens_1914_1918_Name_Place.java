package ResearchGuide_MerchantSeamens_CampaignMedal_1914_1918;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import wrappers.Wrapper_methods;

import java.io.IOException;

public class MerchantSeamens_1914_1918_Name_Place extends Wrapper_methods {
    @Test
    public void MerchantSeamens_1914_1918_Name_Place() throws IOException, InterruptedException{
        launchDriver("https://test.nationalarchives.gov.uk/help-with-your-research/research-guides/merchant-seamens-campaign-medal-records-1914-1918/","chrome");

        ((JavascriptExecutor) driver).executeScript("scroll(0,900)");

        // enter first name
        driver.findElementByXPath("//*[@id=\"firstname\"]").sendKeys("John");

        // enter place of birth
        driver.findElementByXPath("//*[@id=\"placeofbirth\"]").sendKeys("Jersey");

        // click on search
        clickbyXpath("//*[@id=\"dolSearch\"]/div/input");

        ((JavascriptExecutor) driver).executeScript("scroll(0,1200)");

        // check the fourth record contains John and Jersey
        String actual = driver.findElementByXPath("//*[@id=\"search-results\"]/li[4]/a").getText();


       // driver.quit();
    }
}
