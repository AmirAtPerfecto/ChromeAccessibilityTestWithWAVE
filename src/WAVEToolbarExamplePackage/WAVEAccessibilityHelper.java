package WAVEToolbarExamplePackage;
import java.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class WAVEAccessibilityHelper {

	public static void activateWAVE(RemoteWebDriver driver) throws InterruptedException
	{
		PerfectoUtils.ocrImageSelect(driver, "PUBLIC:WaveToolbarIcon.png");
		Thread.sleep(10000);
		PerfectoUtils.ocrTextClick(driver, "cancel", 99, 20);
	}



	public static String handleWAVEErrors(RemoteWebDriver driver)
	{
		List<WebElement> waveTips = driver.findElements(By.className("wave5icon"));
        if (waveTips.isEmpty()) Assert.fail("Could not locate any WAVE validations - please ensure that WAVE is installed correctly");
        else
            PerfectoUtils.screenshot(driver);

        Iterator<WebElement> iter = waveTips.iterator();
        String waveReport = "ACCESSIBILITY REPORT >>>>>\n";
        while(iter.hasNext())
        {
        	WebElement waveTip = iter.next();
            if (!waveTip.getAttribute("alt").startsWith("ERRORS:")) continue;
        	String waveTipAlt = waveTip.getAttribute("alt");
        	WebElement parentElement = waveTip.findElement(By.xpath("./.."));
        	String parentID = parentElement.getAttribute("id");
        	if (parentID.length()<1){
        		parentElement = parentElement.findElement(By.xpath("./.."));
            	parentID = "GrandParentID: "+parentElement.getAttribute("id");
        	}
        	System.out.println(waveTipAlt);
        	waveReport += "Error: "+ waveTipAlt+ " ParentID: "+ parentID + "\n"; 
        }
        System.out.println(waveReport);
        return waveReport;
    }

}