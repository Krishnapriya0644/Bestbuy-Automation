package pageobjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Utility;

public class Validateurl extends Utility {
	
	public Validateurl(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public void  urltovalidate() throws Exception {
		
	String url="https://www.bestbuy.com/?intl=nosplash";
	String expectedurl=driver.getCurrentUrl();
	HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
	connection.setRequestMethod("HEAD");
	connection.connect();
	int responsecode=connection.getResponseCode();
		System.out.println(responsecode);
	if(responsecode<400)
	{
		System.out.println("Link is not broken");
	}else
	{
		System.out.println("Link is broken");
	}
	Assert.assertEquals(url, expectedurl);
	
}
}