package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Menuvalidation;

public class Menuvalidation_Test extends Baseclass {
	@Test
	public void homepagemenus() throws IOException, InterruptedException {
		
		Countryselectionpage country=new Countryselectionpage(driver);
		country.select_US();
		
		Menuvalidation menuvalidation=new Menuvalidation(driver);
		menuvalidation.menu_validate();
		
}
}

