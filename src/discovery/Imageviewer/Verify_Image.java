package discovery.Imageviewer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import wrapper.Wrapper_methods;

public class Verify_Image extends Wrapper_methods{
	@Test
	public void Verify_image() throws IOException{
		
		launchDriver("http://imageviewer.tna.local/", "Chrome");
		
		//enter reference
		
		enterTextById("Reference", "4169100e-b4c7-4733-bbbe-320dae5be776");
		
		//click submit
		
		clickbyXpath("//input[@type='submit']");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		int Screenshot =1;
		FileUtils.copyFile(src, new File("Z:\\Svenkatesh\\Result\\BatchExecution\\Snapshot\\snap"+".jpeg"));
		Screenshot++;
		
		quitBrowser();
		
		
		
	}
	
	

}
