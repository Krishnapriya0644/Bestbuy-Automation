package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.Utility;

public class Paymentpage extends Utility {
	
	
	public Paymentpage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		InitializeActions();
		this.action=action;
	}
	Actions action=new Actions(driver);
	
	@FindBy(xpath="//div[@class='button-wrap ']/button")
	WebElement guestlogin;
	
	@FindBy(id="user.emailAddress")
	WebElement useremail;
	
	@FindBy(id="user.phone")
	WebElement phonenumber;
	
	@FindBy(xpath="//div[@class='button--continue']/button")
	WebElement continuetopayment;
	
	@FindBy(xpath="//input[@id='number']")
	WebElement cardnumber;
	
	@FindBy(id="expMonth")
	WebElement expirationmonth;
	
	@FindBy(id="expYear")
	WebElement expirationyear;
	
	@FindBy(id="cvv")
	WebElement cvv;
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")	
	WebElement lastname;
	
	@FindBy(id="address-input")
	WebElement address;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="state")
	WebElement state;
	
	@FindBy(id="postalCode")
	WebElement zipcode;
	
	@FindBy(xpath="//div[@class='payment__order-summary']/button")
	WebElement placeorder;
	
	@FindBy(xpath="//button[text()=\"Keep Address as Entered\"]")
	WebElement confirmaddress;
	
	@FindBy(xpath="//div[@class='error-spacing']/div/span")
	WebElement errormsg;
	
	@FindBy(id="fld-e")
	WebElement emailaddress;
	
	@FindBy(id="fld-p1")
	WebElement password;
	
	@FindBy(xpath="//div[@class='cia-form__controls ']/button")
	WebElement submitbutton;
	
	/*public void payment(String email, String Password, String cardno, String expirymonth, String expiryyear, String sendcvv, String Firstname, String Lastname, String Address, String City, String statename, String postalcode) throws Exception {
		Thread.sleep(3000);
		emailaddress.sendKeys(email);
		
		Thread.sleep(2000);
		password.sendKeys(Password);
		
		Thread.sleep(2000);
		submitbutton.click();
		
		cardnumber.sendKeys(cardno);
		
		Thread.sleep(2000);
		expirationmonth.sendKeys(expirymonth);
		
		Thread.sleep(2000);
		expirationyear.sendKeys(expiryyear);
		
		Thread.sleep(2000);
		cvv.sendKeys(sendcvv);
		
		Thread.sleep(2000);
		firstname.sendKeys(Firstname);
		
		Thread.sleep(2000);
		lastname.sendKeys(Lastname);
		
		Thread.sleep(2000);
		address.sendKeys(Address);
		
		Thread.sleep(2000);
		city.sendKeys(City);
		
		Thread.sleep(2000);
		state.click();
		Thread.sleep(1000);
		Select select=new Select(state);
		select.selectByVisibleText(statename);			
		
		Thread.sleep(2000);
		zipcode.sendKeys(postalcode);
		
		Thread.sleep(2000);
		placeorder.click();
		
		Thread.sleep(2000);
		confirmaddress.click();
		
		Thread.sleep(4000);
		action.moveToElement(placeorder).build().perform();
		
		
		/*String actualmsg="Unfortunately, we were unable to process your credit card. Please try again or use a different card to continue with your order. For questions regarding your credit card, please contact your bank.";
		String expectedmsg=errormsg.getText();
		Assert.assertEquals(actualmsg, expectedmsg); */
	

public void payment() throws Exception {
Thread.sleep(3000);
guestlogin.click();

action.moveToElement(useremail).build().perform();
useremail.sendKeys("meenakshi020423@gmail.com");

Thread.sleep(2000);
action.moveToElement(phonenumber).build().perform();
phonenumber.sendKeys("9345574859");

Thread.sleep(3000);
action.moveToElement(continuetopayment).click().build().perform();

Thread.sleep(2000);

/*emailaddress.sendKeys("meenakshi020423@gmail.com");

Thread.sleep(2000);
password.sendKeys("Meenakshi@02");

Thread.sleep(2000);
submitbutton.click(); */

action.moveToElement(cardnumber).sendKeys("3566000020000410").build().perform();

Thread.sleep(2000);
expirationmonth.click();
Thread.sleep(1000);
Select select=new Select(expirationmonth);
select.selectByVisibleText("02");			

Thread.sleep(2000);
expirationmonth.click();
Thread.sleep(1000);
Select select1=new Select(expirationmonth);
select1.selectByVisibleText("2026");

Thread.sleep(2000);
cvv.sendKeys("123");

Thread.sleep(2000);
firstname.sendKeys("Krishna");

Thread.sleep(2000);
lastname.sendKeys("Priya");

Thread.sleep(2000);
address.sendKeys("d16 aracia");

Thread.sleep(2000);
city.sendKeys("Alabama");

Thread.sleep(2000);
state.click();
Thread.sleep(1000);
Select select2=new Select(state);
select2.selectByVisibleText("AL");			

Thread.sleep(2000);
zipcode.sendKeys("35013");

Thread.sleep(2000);
placeorder.click();

Thread.sleep(2000);
confirmaddress.click();

Thread.sleep(4000);
action.moveToElement(placeorder).build().perform();


/*String actualmsg="Unfortunately, we were unable to process your credit card. Please try again or use a different card to continue with your order. For questions regarding your credit card, please contact your bank.";
String expectedmsg=errormsg.getText();
Assert.assertEquals(actualmsg, expectedmsg); */
} 


	

}