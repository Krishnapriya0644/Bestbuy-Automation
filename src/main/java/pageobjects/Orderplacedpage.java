package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class Orderplacedpage extends Utility {

	public Orderplacedpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);		
	}


	@FindBy(xpath = "//div[contains(text(),'Your order has been successfully placed.')]")
	public WebElement confirmationMessage;

	public void message() {
		
		if (confirmationMessage.isDisplayed()) {
			System.out.println("Order was placed successfully. Confirmation message found.");
		} else {
			System.out.println("Order confirmation message not found. Order may not have been placed successfully.");
		}
	}
}
