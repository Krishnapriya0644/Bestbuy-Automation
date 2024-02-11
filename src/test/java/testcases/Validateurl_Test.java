package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Validateurl;

public class Validateurl_Test extends Baseclass {
	
	@Test
	public void validateurl() throws Exception {
		

		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_US();
		
		Validateurl validatedurl=new Validateurl(driver);
		validatedurl.urltovalidate();
				
	}
}
