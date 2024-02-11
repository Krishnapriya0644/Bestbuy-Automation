package pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Utility;

public class Shopbybrand extends Utility{
	public Shopbybrand(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		InitializeActions();		
	}
	
	@FindBy(xpath="//button[@aria-label='Menu']")
	WebElement menu;
		
	@FindBys({
				@FindBy(xpath="//ul[@class='hamburger-menu-flyout-list']/li/button")
		}) List<WebElement> menuanddepartmentdropdown;
		
		
		
	@FindBys({
				@FindBy(xpath="//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/li/a")
		}) List<WebElement> sidecarsubmenu;


		
	@FindBys({
		@FindBy(xpath="//div[@class='flex-grid']/div/div/div/a")
	}) List<WebElement> brandsuboption;
	
	@FindBy(xpath = "//div[@class='vn-header']/span/a")
	WebElement shopall;

	@FindBys({
		@FindBy(xpath="//div[@id='main-results']/ol/li[@class='sku-item']")
	}) List<WebElement> itemlist;
	

	@FindBys({
		@FindBy(xpath="//div[@class='fulfillment-add-to-cart-button']/div/div/a[text()='See Details']")
	}) List<WebElement> seedetails;

	@FindBy(xpath="//button[@data-button-state='ADD_TO_CART']")
		WebElement addtocart;
		
	@FindBy(xpath="//button[@class='c-button-link continue-shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath="//div[@class='go-to-cart-button']/a")
	WebElement gotocart;
	
	@FindBy(id = "sort-by-select")
	WebElement sortby;
	
	@FindBy(xpath="(//ul[@class='facet-option-list']/li/input)[1]")
	WebElement excludeoutofstock;
	
	@FindBys({
		@FindBy(xpath="//div[@class='sli-add-to-cart']")
		}) List<WebElement> addtocartenableditems;
	
	@FindBy(xpath="//div[@class='checkout-buttons__checkout']/button")
	WebElement checkout;

	@FindBy(xpath="//div[@class='button--continue']/button")
	WebElement continuetopaymentbutton;


public void clickonmenu() {
	initializewait(menu);
	menu.click();
}
//Brands
public void shopbybrand(String menuoption) throws InterruptedException {
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
Thread.sleep(4000);

wait.until(ExpectedConditions.visibilityOfAllElements(menuanddepartmentdropdown));
for(int i=0; i<menuanddepartmentdropdown.size(); i++) {
	String textofmenudropdown=menuanddepartmentdropdown.get(i).getText();
	Thread.sleep(5000);
	if(textofmenudropdown.contains(menuoption)) {
		wait.until(ExpectedConditions.elementToBeClickable(menuanddepartmentdropdown.get(i)));
		menuanddepartmentdropdown.get(i).click();
		break;
	}
		
}
}
//samsung
public void Select_Brand(String brandname) throws Exception {
	Actions action=new Actions(driver);
	for(int i=0; i<sidecarsubmenu.size(); i++) {
		String brandoptions=sidecarsubmenu.get(i).getText();
		Thread.sleep(2000);
		if(brandoptions.contains(brandname)) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
			wait.until(ExpectedConditions.elementToBeClickable(sidecarsubmenu.get(i)));
			action.moveToElement(sidecarsubmenu.get(i)).click().build().perform();
			break;
		}
			
	}
	}

//TV and home theater
public void Select_Product(String brandproductdivision) throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
	wait.until(ExpectedConditions.visibilityOfAllElements(brandsuboption));
	
	Actions action=new Actions(driver);
	
	JavascriptExecutor executor=(JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,600)","" );
	
	for(int i=0; i<brandsuboption.size(); i++) {
		String productoptions=brandsuboption.get(i).getText();
		if(productoptions.contains(brandproductdivision)) {
			//executor.executeScript("arguments[0].scrollIntoView(true);", (brandsuboption.get(i)));
			//wait.until(ExpectedConditions.elementToBeClickable(brandsuboption.get(i)));
			action.moveToElement(brandsuboption.get(i)).click().build().perform();
			//(brandsuboption.get(i)).click();
			break;
		}
			
	}
	}

public void excludeoutofstockitem() throws Exception {
	Thread.sleep(2000);
	excludeoutofstock.click();
}

public void sortbyoption(String sortoption) throws Exception {
	Thread.sleep(1000);	
	sortby.click();
	Thread.sleep(1000);
	Select select=new Select(sortby);
	select.selectByVisibleText(sortoption);			
}


public void selectproduct_and_addtocart() throws Exception {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
	//wait.until(ExpectedConditions.visibilityOfAllElements(itemlist));
	//JavascriptExecutor executor=(JavascriptExecutor) driver;
	//executor.executeScript("window.scrollBy(0,400)","" );
	Actions action=new Actions(driver);
	for(int i=0; i<itemlist.size(); i++) {
		String item=itemlist.get(i).getText();
		{					
			Thread.sleep(5000);
			for(int j=0; j<addtocartenableditems.size(); j++) {
				String text=addtocartenableditems.get(j).getText(); //choose the first option
				if(text.contains("Add to Cart")) {
					addtocart.click();
					break;			
				}
				break;
						
				}
				break;
		}
	}
}

public void go_to_cart() throws Exception {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	Thread.sleep(5000);
	executor.executeScript("arguments[0].scrollIntoView(true);", gotocart);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));	
	wait.until(ExpectedConditions.visibilityOf(gotocart));
	wait.until(ExpectedConditions.elementToBeClickable(gotocart));
	gotocart.click();
	
}


public void checkout() throws Exception {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	Thread.sleep(5000);
	executor.executeScript("arguments[0].scrollIntoView(true);", checkout);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(checkout));
	checkout.click();
	
}

public void continue_to_payment() throws Exception {
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	Thread.sleep(5000);
	executor.executeScript("arguments[0].scrollIntoView(true);", continuetopaymentbutton);
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.elementToBeClickable(continuetopaymentbutton));
	continuetopaymentbutton.click();
	
}

}
