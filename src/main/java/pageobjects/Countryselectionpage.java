package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class Countryselectionpage extends Utility {
	
	public Countryselectionpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//a[@class='us-link'][1]")
	WebElement unitedStates;
	
	@FindBy(xpath="(//a[@class='canada-link'])[1]")
	WebElement canada;
	
public void select_US() {
	unitedStates.click();
	
}

public void select_canada() {
	canada.click();
	
}
}

