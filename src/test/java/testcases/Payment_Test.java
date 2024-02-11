package testcases;

import org.testng.annotations.Test;

import base.Baseclass;
import pageobjects.Countryselectionpage;
import pageobjects.Paymentpage;

public class Payment_Test extends Baseclass{
	
	@Test
	
	public void payment() throws Exception {
	
	Shopby_Brand_Test shopbybrand=new Shopby_Brand_Test();
	shopbybrand.shop_by_brand("Brands", "Samsung", "TV and home theater", "Price Low to High");
	
	Paymentpage payment=new Paymentpage(driver);
	
//	payment.payment("3566000020000410", "02", "2026", "123", "Krishna", "Priya", "D16", "alabama", "AL", "35013");

payment.payment();
}
}

