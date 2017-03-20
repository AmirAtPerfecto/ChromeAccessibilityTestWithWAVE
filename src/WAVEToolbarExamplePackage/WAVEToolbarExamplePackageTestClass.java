package WAVEToolbarExamplePackage;

import org.testng.annotations.Test;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class WAVEToolbarExamplePackageTestClass {
	RemoteWebDriver driver;
	String accessibiltyReport;

	// Create Remote WebDriver based on testng.xml configuration
	@Parameters({ "platformName", "platformVersion", "browserName", "browserVersion", "screenResolution" })
	@BeforeTest
	public void beforeTest(String platformName, String platformVersion, String browserName, String browserVersion, String screenResolution) throws MalformedURLException {
		driver = Utils.getRemoteWebDriver(platformName, platformVersion, browserName, browserVersion, screenResolution);        
	} 

	@Test 
	public void testLogin() throws InterruptedException {
		driver.get("http://www.united.com");
		PerfectoUtils.ocrTextCheck(driver, "book", 99, 20);
		WAVEAccessibilityHelper.activateWAVE(driver);
		accessibiltyReport = WAVEAccessibilityHelper.handleWAVEErrors(driver);
		PerfectoUtils.comment(driver, accessibiltyReport);
			
	}
	@AfterTest
	public void afterTest() throws IOException {
		String reportURL = (String)driver.getCapabilities().getCapability("testGridReportUrl");
		System.out.println("########### ========>>>>>>>> Report URL: "+ reportURL); 
		System.out.println("########### ========>>>>>>>> ACCESSIBILITY Report: "+ accessibiltyReport); 
		
		// Abort test in case of an unexpected error.
		driver.close();
		driver.quit();	

	}	

}
