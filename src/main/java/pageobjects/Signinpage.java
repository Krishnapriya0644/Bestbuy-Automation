package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import utilities.Utility;

public class Signinpage extends Utility{
	public Signinpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//span[text()='Account']")
	WebElement account;
	
	@FindBy(xpath="//a[text()='Sign In']")
	WebElement signin;
	
	@FindBy(xpath="//div[@class='cia-create__signin']/a")
	WebElement signingIn;
	
	@FindBy(id="fld-e")
	WebElement signinEmail;

	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement signinPassword;
	
	@FindBy(xpath="//button[text()='Sign In']")
	WebElement signinButton;
	
	@FindBy(xpath="//div[@class='cia-form__controls ']/button[text()='Skip for now']")
	WebElement skipfornow;
	
	@FindBy(xpath="//div[@class='c-alert-content rounded-r-100 flex-fill v-bg-pure-white p-200 pl-none']")
	WebElement signinalertmsg;
	
	
	public void clickonaccount() {
		account.click();
	}
	
	
	public void clicksignin() {
		signin.click();
	}
	
	public void getsignindetails(String email, String password) throws Exception {
		
		initializewait(signinEmail);
		signinEmail.sendKeys(email);
		Thread.sleep(2000);
		
		initializewait(signinPassword);
		signinPassword.sendKeys(password);
		Thread.sleep(2000);
		
		initializewait(signinButton);
		signinButton.click();
		Thread.sleep(2000);
		
	initializewait(skipfornow);		// for account recovery phone number
		skipfornow.click();
	Thread.sleep(2000);
	}


	//public String getalertmsg() {
		//return signinalertmsg.getText();
	//}
	}

