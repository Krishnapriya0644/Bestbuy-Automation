package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Validatefooterlinks;

public class Validate_footerlinks_test  extends Baseclass{
	@Test
	public void validatefooterlinks() {
		
		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_US();
		
		
		Validatefooterlinks footerlink=new Validatefooterlinks(driver);
				footerlink.footer_Link();
			
	}

	}
