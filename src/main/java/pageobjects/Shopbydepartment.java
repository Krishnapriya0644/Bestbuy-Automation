package pageobjects;

import java.time.Duration;
import java.util.List;

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

public class Shopbydepartment extends Utility {
	public Actions action;
	public Shopbydepartment(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		InitializeActions();
		this.action=action;
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
		@FindBy(xpath="//div[@class='widget-navigation-dynamic']/nav/div/a")
	}) List<WebElement> products;

	@FindBy(id = "sort-by-select")
	WebElement sortby;
	
	@FindBy(xpath="(//ul[@class='facet-option-list']/li/input)[1]")
	WebElement excludeoutofstock;
	

	@FindBys({
	@FindBy(xpath="//div[@id='main-results']/ol/li[@class='sku-item']")
	}) List<WebElement> itemlist;
	
	@FindBys({
	@FindBy(xpath="//div[@class='sli-add-to-cart']")
	}) List<WebElement> addtocartenableditems;

	@FindBy(xpath="//div[@class='fulfillment-add-to-cart-button']/div/div/button[@data-button-state='ADD_TO_CART']")
	WebElement addtocart;
	
	@FindBy(xpath="//div[@class='checkout-buttons__checkout']/button")
	WebElement checkout;

	@FindBy(xpath="//div[@class='button--continue']/button")
	WebElement continuetopaymentbutton;
	
	@FindBy(xpath="//button[@class='c-button-link continue-shopping']")
	WebElement continueshopping;
	
	@FindBy(xpath="//div[@class='go-to-cart-button']/a")
	WebElement gotocart;
	
	@FindBy(xpath="//div[@class='button-wrap ']/button")
	WebElement continueasguest;
	
		public void clickonmenu() {
			initializewait(menu);
			menu.click();
		}
		
		public void shopbydepartment(String departmentoption) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(4000);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(menuanddepartmentdropdown));
		for(int i=0; i<menuanddepartmentdropdown.size(); i++) {
			String textofmenudropdown=menuanddepartmentdropdown.get(i).getText();
			Thread.sleep(5000);
			if(textofmenudropdown.contains(departmentoption)) {
				wait.until(ExpectedConditions.elementToBeClickable(menuanddepartmentdropdown.get(i)));
				menuanddepartmentdropdown.get(i).click();
				break;
			}
				
		}
		}
		//appliance
		public void departmentsubmenu(String departmentsubmenu) throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			Thread.sleep(4000);
			
			wait.until(ExpectedConditions.visibilityOfAllElements(menuanddepartmentdropdown));
			for(int i=0; i<menuanddepartmentdropdown.size(); i++) {
				String textofmenudropdown=menuanddepartmentdropdown.get(i).getText();
				Thread.sleep(5000);
				if(textofmenudropdown.contains(departmentsubmenu)) {
					wait.until(ExpectedConditions.elementToBeClickable(menuanddepartmentdropdown.get(i)));
					menuanddepartmentdropdown.get(i).click();
					break;
				}
					
			}
			}
			
		public void productoption(String productdivision) throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			Thread.sleep(4000);
			
		//	wait.until(ExpectedConditions.visibilityOfAllElements(sidecarsubmenu));
			for(int i=0; i<sidecarsubmenu.size(); i++) {
				String productoptions=sidecarsubmenu.get(i).getText();
				Thread.sleep(5000);
				if(productoptions.contains(productdivision)) {
					wait.until(ExpectedConditions.elementToBeClickable(sidecarsubmenu.get(i)));
					sidecarsubmenu.get(i).click();
					break;
				}
					
			}
			}
		
		public void productsubdivision(String productdivisionname) throws InterruptedException {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			executor.executeScript("window.scrollBy(0,600)");
			
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			Thread.sleep(2000);
			
		//	wait.until(ExpectedConditions.visibilityOfAllElements(products));
			for(int i=0; i<products.size(); i++) {
				String productoptions=products.get(i).getText();
				Thread.sleep(2000);
				if(productoptions.contains(productdivisionname)) {
					wait.until(ExpectedConditions.elementToBeClickable(products.get(i)));
					products.get(i).click();
					break;
				}
					
			}
			}
		
		
		public void sortbyoption(String sortoption) throws Exception {
			//driver.get("https://www.bestbuy.com/site/all-laptops/business-laptops/pcmcat376300050005.c?id=pcmcat376300050005");
			driver.navigate().refresh();
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", sortby);
			Thread.sleep(1000);
			Select select=new Select(sortby);
			select.selectByVisibleText(sortoption);			
		}
		
		public void excludeoutofstockitem() throws Exception {
			Thread.sleep(2000);
			excludeoutofstock.click();
		}

		
		public void selectproduct_and_addtocart() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElements(itemlist));			
			for(int i=0; i<itemlist.size(); i++) {
				String itemtext=itemlist.get(i).getText();
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
		
		public void continueasguest() {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(continueasguest));
			continueasguest.click();
			
		}

		public void continue_to_payment() throws Exception {
			JavascriptExecutor executor=(JavascriptExecutor)driver;
			Thread.sleep(5000);
			executor.executeScript("arguments[0].scrollIntoView(true);", continuetopaymentbutton);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(continuetopaymentbutton));
			continuetopaymentbutton.click();
		}

		
		public void clickon_continueshopping() throws Exception {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(continueshopping));	
			JavascriptExecutor executor=(JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", continueshopping);
			//continueshopping.click();
		}
	
	}
