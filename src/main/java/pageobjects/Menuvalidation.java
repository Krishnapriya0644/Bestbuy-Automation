package pageobjects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utilities.Utility;

public class Menuvalidation extends Utility {
	
	@FindBy(xpath ="//button[@aria-label='Menu']") 
	WebElement Menu;

	@FindBy(className ="hamburger-back-button-text") 
	WebElement Back;
	
	@FindBys({		
		@FindBy(xpath="//div[@class='bottom-fluid-container ']/descendant::ul[@class='bottom-nav-left lv']/li")
	})	
	List<WebElement> menuList;
	
	@FindBy(xpath="//a[.='Return to home page']")
	WebElement returnToHome;



	public Menuvalidation(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
	
	}

	//Validates the Title of each page in menu option
	
	public void menu_validate() throws IOException, InterruptedException {
		Actions action=new Actions(driver);
		for(int i = 0 ; i<menuList.size() ; i++) {
			action.moveToElement(menuList.get(i)).click().build().perform();
			Thread.sleep(2000);
			System.out.println(driver.getTitle());		
		}
		
	}

	}
