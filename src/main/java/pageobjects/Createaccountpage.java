package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class Createaccountpage extends Utility {
	public Createaccountpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);		
	}

	@FindBy(xpath="//span[text()='Account']")
	WebElement account;
	
	@FindBy(xpath="//a[text()='Create Account']")
	WebElement createAccount;
	
	@FindBy(id="firstName")
	WebElement firstName;
	
	@FindBy(id="lastName")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(xpath="//div[text()='Show Passwords']")
	WebElement showpassword;
	
	@FindBy(xpath="//input[@id='fld-p1']")
	WebElement Password;
	
	@FindBy(id="reenterPassword")
	WebElement reenterpassword;
	
	@FindBy(id="phone")
	WebElement phone;
	
	@FindBy(id="is-recovery-phone")
	WebElement accountRecoveryCheckbox;
	
	@FindBy(xpath="//button[text()='Create an Account']")
	WebElement createAnAccount;
	
	@FindBy(xpath="//div[@class='cia-create__signin']/a")
	WebElement signingIn;
	
	@FindBy(xpath="//div[@class='c-alert-content rounded-r-100 flex-fill v-bg-pure-white p-200 pl-none']/strong/div/div/strong[text()='Sorry, there was a problem creating your account.']")
	WebElement actualmsg;
	
	
	public void clickonaccount() {
		account.click();
	}
	
	public void createanaccount(String firstname,String lastname,String email, String password, String mobilenumber) throws Exception {
		initializevisibilitywait(createAccount);
		createAccount.click();
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		driver.navigate().refresh();
		Thread.sleep(5000);
		initializewait(firstName);
		firstName.sendKeys(firstname);
		
		Thread.sleep(2000);
		initializewait(lastName);
		lastName.sendKeys(lastname);
		
		Thread.sleep(2000);
		initializewait(Email);
		Email.sendKeys(email);
		
		Thread.sleep(2000);
		initializewait(showpassword);
		showpassword.click();
		
		Thread.sleep(2000);
		initializewait(Password);
		Password.sendKeys(password);
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		initializewait(reenterpassword);
		reenterpassword.sendKeys(password);
		
		Thread.sleep(2000);
		initializewait(phone);
		phone.sendKeys(mobilenumber);
		
		Thread.sleep(2000);
		initializewait(accountRecoveryCheckbox);
		accountRecoveryCheckbox.click();
		
		Thread.sleep(2000);
		initializewait(createAnAccount);
		createAnAccount.click();
		
		//String actMsg=actualmsg.getText();
		//return actMsg;
	}
	
}
