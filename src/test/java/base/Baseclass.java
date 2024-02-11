package base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageobjects.Countryselectionpage;
import utilities.Utility;

public class Baseclass extends Utility {
	
	@BeforeMethod
	public void startup() throws IOException {
	launchbrowser();
		}
	
	@AfterMethod
	public void close() {
	driver.quit();
}

	

}
