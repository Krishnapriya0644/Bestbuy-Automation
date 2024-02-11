package testcases;

import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;

public class Country_Selection extends Baseclass {
	
	@Test
	public void select_US() {
		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_US();
	}
	
	@Test 
	public void select_canada() {
		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_canada();
		
	}


}
