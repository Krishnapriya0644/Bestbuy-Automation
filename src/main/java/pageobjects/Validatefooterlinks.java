package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Utility;

public class Validatefooterlinks extends Utility{
	
	public Validatefooterlinks(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
				
	}

	public void footer_Link() {
		List<WebElement> bottomLinks=driver.findElements(By.xpath("//a[@class='body-copy-sm mr-200']"));
		for(WebElement bottomLink:bottomLinks) {
			System.out.println(bottomLink.getText());
			//Validate the bottom or footer link in HomePage
			String url = bottomLink.getAttribute("href");
			String expectedurl=driver.getCurrentUrl();
			if (url != null && !url.isEmpty()) {
				System.out.println("Link URL: " + url + " Page Title: " + driver.getTitle());
			} else {
				System.out.println("Link URL is either not configured or empty");
			}
		
		}
	
}
}
